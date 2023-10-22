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
        <span>王小虎</span>
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
    },
    collapse(){
      this.$emit('doCollapse');
    }
  }
};
</script>