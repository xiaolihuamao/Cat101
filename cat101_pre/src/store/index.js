 
import Vue from 'vue'
import Vuex from 'vuex'
 
Vue.use(Vuex)
 
export default new Vuex.Store({
  //数据，相当于data
  state: {
    isNew: false,
    isLogin: true,
    token:''      //用来存储登陆成功后从后台得到的 token
    
  },
  getters: {
    
  },

  //mutations里面定义方法，操作state

  // 定义一个方法更新token
  mutations: {
    updatedToken(state,newToken) {
      state.token = newToken     
    },
    
  },
  // 操作异步操作mutation
  actions: {
    
  },
  modules: {
    
  },
})