<template>
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
    <el-table-column prop="phone" label="电话" width="180">
    </el-table-column>
    <el-table-column prop="operate" label="操作">
    </el-table-column>
  </el-table>
</template>

<style scoped>

</style>

<script>
export default {
  name: "AppMain",
  data() {
    return {
      tableData:[]
    }
  },
  methods:{
    loadGet(){
      this.$axios.get(this.$httpUrl+'/user/list').then(res=>res.data).then(res=>{
        console.log(res);
      });
    },
    loadPost(){
      this.$axios.post(this.$httpUrl+'/user/search',{}).then(res=>res.data).then(res=>{
        console.log(res);
        this.tableData=res;
      });
    }
  },
  beforeMount() {
    //this.loadGet();
    this.loadPost()
  }
};
</script>