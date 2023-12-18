<template>
  <div>
    <div class="icon" style="font-size:20px; line-height: 60px; cursor: pointer" @click="collapse">
      <i :class="icon"></i>
    </div>
    <div class="title" style="margin-left: 450px;text-align: center;font-size: 34px;left: 50%;top: 50%">
      <span>欢迎来到仓库管理系统</span>
    </div>
    <div class="dropdown">
      <el-dropdown>
        <span>{{user.name}}</span>
        <i class="el-icon-arrow-down" style="margin-left: 5px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item @click.native="toUser">个人中心</el-dropdown-item>
          <el-dropdown-item @click.native="logOut">退出登录</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<style scoped>
  div.icon,div.title{
    float: left;
  }
</style>

<script>
export default {
  name: "AppHeader",
  data(){
    return{
      user: JSON.parse(sessionStorage.getItem('CurUser'))
    }
  },
  props:{
    icon:String
  },
  methods:{
    toUser(){
      console.log('to_user');
      alert('?');
    },
    logOut(){
      console.log('log out!');
      this.$confirm('您确定要退出登录吗？', '提示', {
        confirmButtonText: '确定',  //确认按钮的文字显示
        type: 'warning',
        center: true, //文字居中显示
      })
          .then(() => {
            this.$message({
              type:'success',
              message: '退出登录成功！'
            })
            this.$router.push('/');
            sessionStorage.clear();
          })
          .catch(() => {
            this.$message({
              type:'info',
              message: '已取消退出！'
            })
          });
    },
    collapse(){
      this.$emit('doCollapse');
    }
  }
};
</script>