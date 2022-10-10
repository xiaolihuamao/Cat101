<template>
  <div>
    <el-row :gutter="20">
      <div v-for="i in applyALL" :key="i.cid">
        <el-col :span="5">
          <div class="grid-content">
            <el-image :src=(i.curl) @click="turnInto(i.cid)"></el-image>
            <div class="title">{{ i.cname }}</div>
            <div class="status">
              <div v-if="i.cisadopt==0" class="no">审核不通过</div>
              <div v-else-if="i.cisadopt==1" class="wait">审核中</div>
              <div v-else class="yes">审核通过</div>
            </div>
            <div class="content">申请原因：{{ i.ainfo }}</div>
          </div>
        </el-col>
      </div>
    </el-row>
  </div>
</template>

<script>
import {catInfoAPI, searchAPI} from "@/api";

export default {
  name: "Mine",
  data() {
    return {
      catNum: 0,
      applyALL: [{
        cname:'喵喵喵',
        cisadopt:0,
        ainfo:'我真的想要',
        curl:'http://localhost:8082/myImg/d8870490650042c69352488893d4a0ec..jpg'
      }],
    };
  },
  methods: {
    indexs: async function () {
      // TODO:来接口了就写
      // const {data: res} = await searchAPI();
      // if (res.code === '200') {
      //   this.catNum = res.data.length;
      //   this.applyALL = res.data;
      //   // console.log(this.catsALL[0].curl);
      //   // console.log(this.catsALL[0].cname);
      // } else {
      //   this.$message.error(res.msg) //后端返回失败结果，提示后端返回的错误message或者也可以自己设置提示
      // }
    },
    async turnInto(id){
      this.$router.push('/layout/applyInfo');
      // const {data: res} = await catInfoAPI(id);
      // if (res.code === '200') {
      //   localStorage.setItem('cat',JSON.stringify(res.data));
      //   this.$router.push('/layout/info');
      // } else {
      //   this.$message.error(res.msg) //后端返回失败结果，提示后端返回的错误message或者也可以自己设置提示
      // }
    }
  },
  created:async function(i) {
    //自动加载indexs方法
    this.indexs();
  }
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
  border-bottom: 1px #b6b6b6 solid;
}

.el-col:nth-child(4n+1) {
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
  border-bottom: 1px #b6b6b6 solid;
}

.status {
  font-size: 18px;
  margin-bottom: 10px;
  text-align: center;
  color: #868686;
}

.content {
  font-size: 14px;
  color: #b6b6b6;
  margin: 0 10px 10px 10px;
  /*text-indent: 2em;*/
  line-height: 20px;
}

.el-image {
  border-radius: 8%;
}

.no{
  color: darkred;
  font-weight: bold;
}

.yes{
  color: darkgreen;
  font-weight: bold;
}

.wait{
  font-weight: bold;
}
</style>
