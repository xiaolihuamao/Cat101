import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from "@/store";
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'

Vue.config.productionTip = false

Vue.use(ElementUI)

Vue.prototype.$axios = axios


new Vue({
  render: h => h(App),
  store,
  router,
}).$mount('#app')
