<template>
  <div id="app">
    <AppIndex></AppIndex>
  </div>
</template>

<script>

import AppIndex from "@/components/AppIndex.vue";
import './assets/global.css';

export default {
  name: 'App',
  components: {
    AppIndex
  }
}
</script>

<style>
#app{
  height: 100%;
}
</style>
