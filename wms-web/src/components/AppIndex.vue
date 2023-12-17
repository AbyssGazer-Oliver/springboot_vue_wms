<template>
  <el-container style="height: 100%; border: 1px solid #eee">
    <el-aside :width="aside_width" style="background-color: rgb(238, 241, 246);margin-left: -1px">
      <AppAside :isCollapse="isCollapse"></AppAside>
    </el-aside>

    <el-container style="height: 100%">
      <el-header style="text-align: right; font-size: 12px;height: 100%">
        <AppHeader @doCollapse="doCollapse" :icon="icon"></AppHeader>
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
    AppAside,
  },
  data(){
    return{
      isCollapse:false,
      aside_width:'200px',
      icon:'el-icon-s-fold'
    }
  },
  methods:{
    doCollapse(){
      this.isCollapse=!this.isCollapse;
      if(!this.isCollapse){
        //展开
        this.aside_width='200px';
        this.icon='el-icon-s-fold';
      }else{
        this.aside_width='64px';
        this.icon='el-icon-s-unfold'
      }
    }
  }
};
</script>