<template>
  <!-- 一个头部容器，装着头部的logo和按钮 -->
  <div class="header-g">
    <!-- logo图片 -->
    <div class="logo" @click="turnIntoIndex">
      <img src="../assets/img/logo-1.png" alt="LOGO"/>
    </div>

    <!-- 右边的退出、头像注册登录按钮 -->
    <div class="block">
      <!--TODO：以下代码需要进行修改-->
      <!--登录注册按钮  注意：登录后不显示 v-if="false"-->
      <div class="login" v-if="$store.state.isLogin">
        <el-button
            size="small"
            round
            @click="$router.push('/layout/register')"
            style="margin-left: 30px"
        >注册
        </el-button>
        <el-button size="small" round @click="$router.push('/layout/login')"
        >登录
        </el-button>
      </div>
      <!-- 退出按钮"-->
      <div
          style="float: right; width: 84px; height: 40px"
          v-if="$store.state.isNew"
          @click="quit"
      >
        <!--        <el-badge :value="2" class="item" type="warning">-->
        <el-badge class="item" type="warning">
          <el-button size="large">退出</el-button>
        </el-badge>
      </div>
      <!-- 用户头像图标 -->
      <div
          style="float: right; margin-right: 30px; margin-top: -10px"
          @click="turnIntoUser"
          v-if="$store.state.isNew"
      >
        <el-avatar
            icon="el-icon-user-solid"
            :size="50"
            style="cursor: pointer"
        ></el-avatar>
        <!--        欢迎语句，TODO：注册和登录界面不展示，登录进入后展示-->
       <!-- <div class="uxname">欢迎您！{{ user.uxname }}</div> -->
       <div class="uxname">欢迎您！{{$store.state.user.uxname}}</div>
       
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "welLogo",
  data() {
    return {
      circleUrl:
          "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      squareUrl:
          "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
      sizeList: ["large", "medium", "small"],
      user: JSON.parse(localStorage.getItem('user')),
    };
  },
  methods: {
    quit() {
      localStorage.removeItem("user");
      localStorage.removeItem("cat");
      localStorage.removeItem("cats");
      localStorage.removeItem("apply");
      this.$store.commit("cisLogin");
      this.$store.commit("cisNew");
      // console.log(this.$store.state.isLogin, this.$store.state.isNew); // 测试点击退出后能否再次调用判断方法根据缓存中是否有user值来改变button的隐藏。
      this.$router.push("/layout/login");
    },
    turnIntoUser() {
      this.$router.push("/layout/self");
    },
    turnIntoIndex() {
      if (localStorage.getItem('user')) {
        this.$router.push("/layout/user");
      } else {
        this.$router.push("/layout/login");
      }
    },
  },
  created() {
    this.$store.commit("cisLogin");
    this.$store.commit("cisNew");
    // console.log(this.$store.state.isLogin, this.$store.state.isNew); //测试是否能根据缓存中是否有user键来改变button的显示隐藏
  },
};
</script>

<style>
.header-g {
  height: 140px;
  background-color: #f4eed6;
  border: 1px solid #eee;
  border-bottom: 0;
}

.logo {
  float: left;
  height: 100px;
  margin-left: 40px;
  margin-top: 10px;
  cursor: pointer;
}

.logo img {
  height: 100%;
}

.block {
  float: right;
  height: 70px;
  width: 400px;
  margin-top: 50px;
  margin-right: 40px;
}

.login {
  float: right;
  width: 152px;
  height: 32px;
  margin-top: 4px;
}

.uxname {
  font-size: 12px;
  cursor: pointer;
}
</style>
