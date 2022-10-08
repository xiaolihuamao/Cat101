<template>
  <div>

    <el-row :gutter="20">
      <el-col :span="5">
        <div class="grid-content" :model="cats">
          <el-image :src="src" @click="$router.push('/layout/info')"></el-image>
          <div class="title">{{ cats.cname }}</div>
          <div class="color">{{ cats.ccolor }}</div>
          <div class="content">{{ cats.cinfo }}</div>
        </div>
      </el-col>
      <el-col :span="5">
        <div class="grid-content">
          <el-image :src="src" @click="$router.push('/layout/info')"></el-image>
        </div>
      </el-col>
      <el-col :span="5">
        <div class="grid-content">
          <el-image :src="src" @click="$router.push('/layout/info')"></el-image>
        </div>
      </el-col>
      <el-col :span="5">
        <div class="grid-content">
          <el-image :src="src" @click="$router.push('/layout/info')"></el-image>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "myUser",
  data() {
    return {
      src: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
      cats:{
        cname:'喵喵喵',
        ccolor:'银渐层',
        cinfo:'这是同学们反应的，在终端101练习生大学拍到的小猫咪，已经学校里待了很久很久了，但是骨瘦如柴，每次都靠着同学们的投喂才勉强生存下来，希望好心人能够领养这只可怜的喵喵~'
      },
    };
  },
};
</script>

<!-- <style lang="less" scoped></style> -->
<style scoped>
.el-row {
  margin-bottom: 20px;
}

.el-col {
  cursor: pointer;
  margin: 40px 0 0 40px;
  border-bottom: 1px #b6b6b6 solid ;
}

.el-col:nth-child(4n+1){
  margin-left: 80px;
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

.title {
  font-size: 24px;
  margin: 10px 0;
  padding-bottom: 10px;
  text-align: center;
  color: #ff8800;
  font-weight: bold;
  letter-spacing: 2px;
  border-bottom: 1px #b6b6b6 solid ;
}

.color {
  font-size: 18px;
  margin-bottom: 10px;
  text-align: center;
  color: #868686;
}

.content {
  font-size: 14px;
  color: #b6b6b6;
  margin: 0 10px 10px 10px;
  text-indent: 2em;
  line-height: 20px;
}

.el-image {
  border-radius: 8%;
}
</style>
