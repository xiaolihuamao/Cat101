<template>
  <div>
    <!-- 头部欢迎页面 -->
    <welLogo></welLogo>

<!--     中间区域layout  左侧是导航栏 右侧是路由页面-->
    <el-row :gutter="0">
      <el-col :span="4" v-show="this.$route.meta.isShow"><div class="grid-content" ><navMenu></navMenu></div></el-col>
      <el-col :span="this.$route.meta.span+1"><div class="grid-content"> <router-view></router-view></div></el-col>
    </el-row>
  </div>
</template>
<script>
import welLogo from "@/components/welLogo.vue";
import navMenu from "@/components/navMenu.vue";
export default {
  name: "layOut",
  components: {
    welLogo,
    navMenu,
  },
  data(){
    return{
      xianshi:true
    };
  },
  // methods:{
  //   console.log(this.isShow)
  // },
  watch: {
    $route() {
      this.xianshi = this.$route.meta.isShow
    }
  }
}
</script>
<style>
  .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #d7cd94;
  }
  .bg-purple {
    background: #dec899;
  }
  .bg-purple-light {
    background: #c2b79a;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }</style>
