<template>
  <div>
    <el-page-header @back="goBack"></el-page-header>
    <div class="info">
      <el-image :src=(cat.curl) :preview-src-list="srcList" title="点击查看猫咪大图"></el-image>
      <div class="msg">
        <el-tag type="info">猫咪名称</el-tag>
        <div class="detail">{{ cat.cname }}</div>
        <el-tag type="info">毛色</el-tag>
        <div class="detail">{{ cat.ccolor }}</div>
        <el-tag type="info">猫咪信息</el-tag>
        <div class="detail">{{ cat.cinfo }}</div>
        <el-tag type="info">申请原因</el-tag>
        <div class="detail">{{ cat.cinfo }}</div>
        <el-tag type="info">申请状态</el-tag>
        <div class="detail">
          <div v-if="cat.cisadopt==0" class="no">审核不通过~</div>
          <div v-else-if="cat.cisadopt==1" class="wait">审核中</div>
          <div v-else class="yes">审核通过</div>
        </div>
      </div>
      <div class="btn">
        <el-button type="warning" plain @click="cancel">取消申请</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import {starAPI} from "@/api";

export default {
  name: 'applyInfo',
  data() {
    return {
      srcList: [
        JSON.parse(localStorage.getItem('cat')).curl,
      ],
      cat: {},
    };
  },
  methods: {
    goBack() {
      window.history.go(-1);
    },
    indexs: async function () {
      this.cat = JSON.parse(localStorage.getItem('cat'));
    },
    async cancel(){
      //删除贴子
    },
    async star() {
      this.form.uid = JSON.parse(localStorage.getItem('user')).uid;
      this.form.cid = this.cat.cid;
      const json = JSON.stringify(this.form);
      const {data: res} = await starAPI(json);    //提交表单后获取到表单数据对象ruleForm然后使用axios传递给接口函数，得到一个返回值，是promise对象       //打印后端返回结果,用于验证编写是否成功，后续可删除这段！！！！！！！
      if (res.code === '200') {
        this.$message.success("收藏成功！！")                            ////后端返回成功结果，提示后端返回的错误message或者也可以自己设置提示
      }
    },
  },
  created: async function (i) {
    //自动加载indexs方法
    this.indexs();
  }
};
</script>

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

.no {
  color: darkred;
  font-weight: bold;
}

.yes {
  color: darkgreen;
  font-weight: bold;
}

.wait {
  font-weight: bold;
}
</style>
