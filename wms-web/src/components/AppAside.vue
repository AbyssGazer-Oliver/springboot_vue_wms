<template>
  <el-menu background-color="#545c64"
           text-color="#fff"
           active-text-color="#ffd04b"
           style="height: 100vh;"
           :collapse="isCollapse"
           :collapse-transition="false"
           default-active="/Home">
    <el-menu-item index="/Home">
      <i class="el-icon-s-home"></i>
      <span slot="title">首页</span>
    </el-menu-item>
    <el-menu-item index="/One">
      <i class="el-icon-s-flag"></i>
      <span slot="title">导航1</span>
    </el-menu-item>
    <el-menu-item index="/Two">
      <i class="el-icon-s-opportunity"></i>
      <span slot="title">导航2</span>
    </el-menu-item>
  </el-menu>
</template>

<style scoped>

</style>

<script>
export default {
  name: "AppAside",
  data(){
    return{
      //isCollapse:false,
    }
  },
  props:{
    isCollapse:Boolean
  },
};
</script>