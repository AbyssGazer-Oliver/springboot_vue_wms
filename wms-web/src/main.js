import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';
import axios from "axios";
import VueRouter from "vue-router";
import router from "./router";

Vue.prototype.$axios=axios;
Vue.prototype.$httpUrl='http://localhost:8090';
Vue.use(ElementUI);
Vue.use(VueRouter);
new Vue({
  el: '#app',
  router,
  render: h => h(App)
});