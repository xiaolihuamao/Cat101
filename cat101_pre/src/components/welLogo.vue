<template>
  <!-- 一个头部容器，装着头部的logo和按钮 -->
  <div class="header-g">
    <!-- logo图片 -->
    <div class="logo" @click="$router.push('/layout/user')">
      <img src="../assets/img/logo-1.png" alt="LOGO" />
    </div>
    <!-- 欢迎语
       <div>可爱的猫猫在等你抱回家哦！</div> -->

    <!-- 右边的消息和头像以及设置按钮 -->
    <div class="block">
      <!-- 登录注册按钮  注意：登录后不显示 v-if="false"-->
      <div class="login" >
        <el-button
          size="small"
          round
          @click="$router.push('/layout/register')"
          style="margin-left: 30px"
          >注册</el-button
        >
        <el-button size="small" round @click="$router.push('/layout/login')"
          >登录</el-button
        >
      </div>
      <!-- 新消息显示按钮，可跳转到另一个消息页面   注意：登录前不显示 v-if="false"-->
      <div style="float: right; width: 84px; height: 40px" >
        <el-badge :value="2" class="item" type="warning">
          <el-button size="large">新消息</el-button>
        </el-badge>
      </div>
      <!-- 用户头像图标 -->
      <div style="float: right; margin-right: 30px; margin-top: -10px">
        <el-avatar icon="el-icon-user-solid" :size="50"></el-avatar>
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
    };
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
</style>
