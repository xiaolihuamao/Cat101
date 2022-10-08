<template>
  <div>
    <el-page-header @back="goBack"></el-page-header>
    <div class="info">
      <el-button type="danger" plain class="star">收藏</el-button>
      <el-image :src="src" :preview-src-list="srcList" title="点击查看大图"></el-image>
      <div class="msg">
        <el-tag type="info">姓名</el-tag>
        <div class="detail">{{ cat.cname }}</div>
        <el-tag type="info">毛色</el-tag>
        <div class="detail">{{ cat.ccolor }}</div>
        <el-tag type="info">信息描述</el-tag>
        <div class="detail">{{ cat.cinfo }}</div>
      </div>
      <div class="btn">
<!--        TODO:申请完成后，能将按钮 disabled 然后文字为：已领养-->
        <el-button type="warning" plain @click="$router.push('/layout/apply')">申请领养</el-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'myInfo',
  data() {
    return {
      src: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
      srcList: [
        'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg'
      ],
      cat: {
        cname: '喵喵喵',
        ccolor: '银渐层',
        cinfo: '这是同学们反应的，在终端101练习生大学拍到的小猫咪，已经学校里待了很久很久了，但是骨瘦如柴，每次都靠着同学们的投喂才勉强生存下来，希望好心人能够领养这只可怜的喵喵~',
      }
    };
  },
  methods: {
    goBack() {
      window.history.go(-1);
    },
  }
};
</script>

<!-- <style lang="less" scoped></style> -->
<style scoped>
.info {
  position: relative;
  width: 800px;
  margin: 0 auto;
}

.el-image {
  width: 80%;
  border-radius: 5%;
  display: block;
  margin: 30px;
}

.el-tag {
  display: block;
  font-size: 14px;
  margin-bottom: 20px;
  width: 80px;
  text-align: center;
}

.msg {
  margin-left: 50px;
  margin-bottom: 20px;
}

.detail {
  margin-left: 30px;
  margin-bottom: 20px;
  width: 560px;
  text-indent: 2em;
  line-height: 2em;
}

.btn {
  width: 250px;
  margin: 50px auto;
}

.el-button:last-child {
  font-size: 24px;
  padding: 20px 50px;
}

.el-button {
  font-size: 18px;
  letter-spacing: 3px;
}

.el-page-header {
  margin: 30px;
}

.star {
  position: absolute;
  right: 120px;
  top: -15px;
  z-index: 999;
}
</style>
