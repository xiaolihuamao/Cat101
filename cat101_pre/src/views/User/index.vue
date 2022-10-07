<template>
  <div>

    <el-row :gutter="20">
      <el-col :span="6"><div class="grid-content">
        <el-image :src="src" @click="$router.push('/layout/info')"></el-image>
        <div class="title">喵喵喵</div>
        <div class="color">银渐层</div>
        <div class="content">我是一只猫喵喵喵喵喵</div>
      </div></el-col>
      <el-col :span="6"><div class="grid-content">
        <el-image :src="src" @click="$router.push('/layout/info')"></el-image>
      </div></el-col>
      <el-col :span="6"><div class="grid-content">
        <el-image :src="src" @click="$router.push('/layout/info')"></el-image>
      </div></el-col>
      <el-col :span="6"><div class="grid-content">
        <el-image :src="src" @click="$router.push('/layout/info')"></el-image>
      </div></el-col>
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
  cursor: pointer;
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
.title{
  font-size: 24px;
  margin-bottom: 10px;
  text-align: center;
}
.color{
  font-size: 18px;
  margin-bottom: 10px;
  margin-left: 30px;
  color: #333333;
}
.content{
  font-size: 14px;
  color: grey;
  margin-left: 30px;
}
</style>
