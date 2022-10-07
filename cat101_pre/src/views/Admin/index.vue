<template>
    <div id="app">
      <!-- 外层容器-->
      <el-container
        style="height: 600px; border: 1px solid #eee; border-bottom: 0"
      >
        <el-aside width="200px" >
          <el-menu
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            background-color="#f4eed6"
            text-color="#442804"
            active-text-color="#442804"
            router= ture
          >
            <el-menu-item index="/layout/admin/catdb">
                <i class="el-icon-s-grid"></i>
                <span slot="title">流浪猫数据库</span>
            </el-menu-item>
            <el-menu-item index="/layout/admin/applydb" >
              <i class="el-icon-s-open"></i>
              <span slot="title">申请书列表</span>
            </el-menu-item>
            <!-- <el-menu-item index="/layout/admin/catdb">
              <i class="el-icon-setting"></i>
              <span slot="title">退出登录</span>
            </el-menu-item> -->
          </el-menu>
        </el-aside>
        <!-- 中间路由组件区 -->
        <router-view></router-view>
      </el-container>
    </div>
  </template>
  
  <script>
  export default {
    name: "myAdmin",
  };
  </script>
  <style>
  .el-header {
    background-color: #b3c0d1;
    color: #333;
    line-height: 60px;
  }
  
  .el-aside {
    color: #333;
    background-color: #f4eed6;
  }
  </style>