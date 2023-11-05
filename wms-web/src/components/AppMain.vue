<template>
  <div>
  <el-table :data="tableData"
            :header-cell-style="{backgroundColor:'#f2f5fc',color:'#555'}"
            border
  >
    <el-table-column prop="id" label="ID" width="60">
    </el-table-column>
    <el-table-column prop="no" label="账号" width="180">
    </el-table-column>
    <el-table-column prop="name" label="姓名" width="180">
    </el-table-column>
    <el-table-column prop="age" label="年龄" width="120">
    </el-table-column>
    <el-table-column prop="sex" label="性别" width="60">
      <template slot-scope="scope">
        <el-tag
            :type="scope.row.sex === 1 ? 'primary' : 'success'"
            disable-transitions>{{scope.row.sex === 1 ? '男' : '女'}}
        </el-tag>
      </template>
    </el-table-column>
    <el-table-column prop="roleId" label="角色" width="120">
      <template slot-scope="scope">
        <el-tag
            :type="scope.row.roleId === 0 ? 'danger' : (scope.row.roleId === 1 ? 'primary' :'success')"
            disable-transitions>{{scope.row.roleId === 0 ? '超级管理员'
                                : (scope.row.roleId === 1 ? '管理员' :'用户')}}
        </el-tag>
      </template>
    </el-table-column>
    <el-table-column prop="phone" label="电话" width="280">
    </el-table-column>
    <el-table-column prop="operate" label="操作">
      <el-button type="success">编辑</el-button>
      <el-button type="danger">删除</el-button>
    </el-table-column>
  </el-table>
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pageNum"
        :page-sizes="[5, 10, 20, 30]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="totalNum">
    </el-pagination>
  </div>
</template>

<style scoped>

</style>

<script>
export default {
  name: "AppMain",
  data() {
    return {
      tableData:[],
      pageNum:1,
      pageSize:10,
      totalNum:0
    }
  },
  methods:{
    loadGet(){
      this.$axios.get(this.$httpUrl+'/user/list').then(res=>res.data).then(res=>{
        console.log(res);
      });
    },
    loadPost(){
      // 设置分页查询
      this.$axios.post(this.$httpUrl+'/user/listPageC',{
        pageSize:this.pageSize,
        pageNum:this.pageNum
      }).then(res=>res.data).then(res=>{
        console.log(res);
        if(res.code==200){
          this.tableData=res.data;
          this.totalNum=res.total;
        }else{
          alert("获取用户信息失败！");
        }
      });
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.pageNum=1;
      this.pageSize=val;
      this.loadPost();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.pageNum=val;
      this.loadPost();
    }
  },
  beforeMount() {
    //this.loadGet();
    this.loadPost()
  }
};
</script>