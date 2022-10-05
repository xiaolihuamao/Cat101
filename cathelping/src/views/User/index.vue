<template>
  <div>
      
    <el-row :gutter="20">
      <el-col :span="6"><div class="grid-content bg-purple">
        <el-image :src="src" @click="$router.push('/layout/info')"></el-image>
      </div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple">
        用户首页.vue
      </div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
    </el-row>
  </div>
</template>
  
  <script>
export default {
  name: "myUser",
  data() {
    return {
      src: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
    };
  },
};
</script>
  
  <!-- <style lang="less" scoped></style> -->
  <style scoped>
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
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>
  