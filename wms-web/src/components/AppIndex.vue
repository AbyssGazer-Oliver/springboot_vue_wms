<template>
  <el-container style="height: 100%; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246);height: 100%">
      <AppAside></AppAside>
    </el-aside>

    <el-container style="height: 100%">
      <el-header style="text-align: right; font-size: 12px;height: 100%">
        <AppHeader></AppHeader>
      </el-header>

      <el-main style="height: 100%">
        <AppMain></AppMain>
      </el-main>
    </el-container>
  </el-container>
</template>

<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}
.el-main{
  padding: 5px;
}
.el-aside {
  color: #333;
}
</style>

<script>
import AppAside from "@/components/AppAside.vue";
import AppHeader from "@/components/AppHeader.vue";
import AppMain from "@/components/AppMain.vue";

export default {
  name: "AppIndex",
  components:{
    AppMain,
    AppHeader,
    AppAside
  }
};
</script>