<template>
  <div>
    <span>王小虎</span>
    <el-dropdown>
      <i class="el-icon-arrow-down" style="margin-left: 5px"></i>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item @click.native="toUser">个人中心</el-dropdown-item>
        <el-dropdown-item @click.native="logOut">退出登录</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>

<style scoped>

</style>

<script>
export default {
  name: "AppHeader",
  methods:{
    toUser(){
      console.log('to_user');
      alert('?');
    },
    logOut(){
      console.log('log out!');
    }
  }
};
</script>