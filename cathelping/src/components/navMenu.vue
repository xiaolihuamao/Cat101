<!-- 左侧的导航栏 -->
<template>
  <div>
    <el-menu default-active="1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" router="true">
      <!-- 点击导航栏跳转到首页 -->
      <el-menu-item index="/layout/user" default-active>
        <template slot="title">
          <i class="el-icon-s-home"></i>
          <span>首页</span>
        </template>
      </el-menu-item>

      <!-- 点击跳转导航栏 跳转到 我的-->
      <el-menu-item index="/layout/mine">
        <template slot="title">
          <i class="el-icon-user-solid"></i>
          <span>我的</span>
        </template>
      </el-menu-item>

      <!-- 点击跳转导航栏 跳转到 圈子-->
      <el-menu-item index="/layout/daily">
        <template slot="title">
          <i class="el-icon-s-opportunity"></i>
          <span>圈子</span>
        </template>
      </el-menu-item>

      <!-- 点击跳转导航栏 跳转到 收藏-->
      <el-menu-item index="/layout/like">
        <template slot="title">
          <i class="el-icon-star-off"></i>
          <span>收藏</span>
        </template>
      </el-menu-item>
    </el-menu>
  </div>
</template>
<script lang="ts">

export default {
  name: 'navMenu'
}
</script>
<style>
.el-menu-vertical-demo {
  width: 200px;
}
</style>