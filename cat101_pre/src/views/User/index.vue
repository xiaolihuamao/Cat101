<template>
  <div>
    <el-row :gutter="20">
      <div v-for="i in catsALL" :key="i.cid">
        <el-col :span="5">
          <div class="grid-content">
            <el-image :src=(i.curl) @click="turnInto(i.cid)"></el-image>
            <div v-if="i.cisadopt==0" class="status yes">待领养</div>
            <div v-else-if="i.cisadopt==1" class="status wait">有人申请中~</div>
            <div v-else-if="i.cisadopt==2" class="status no">已被领养</div>
            <div class="title">{{ i.cname }}</div>
            <div class="color">{{ i.ccolor }}</div>
            <div class="content">{{ i.cinfo }}</div>
          </div>
        </el-col>
      </div>
    </el-row>
  </div>
</template>

<script>
import {catInfoAPI, searchAPI} from "@/api";

export default {
  name: "myUser",
  data() {
    return {
      catsALL: [],
    };
  },
  methods: {
    indexs: async function () {
      const {data: res} = await searchAPI();
      if (res.code === '200') {
        this.catsALL = res.data;
      } else {
        this.$message.error(res.msg) //后端返回失败结果，提示后端返回的错误message或者也可以自己设置提示
      }
    },
    async turnInto(cid) {
      const {data: res} = await catInfoAPI(cid);
      if (res.code === '200') {
        localStorage.setItem('cat', JSON.stringify(res.data));
        this.$router.push('/layout/info');
      } else {
        this.$message.error(res.msg) //后端返回失败结果，提示后端返回的错误message或者也可以自己设置提示
      }
    }
  },
  created: async function (i) {
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
  position: relative;
  cursor: pointer;
  margin: 40px 0 0 40px;
  border-bottom: 1px #b6b6b6 solid;
}

.el-col:nth-child(4n+1) {
  margin-left: 50px;
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

.status {
  position: absolute;
  top: -10px;
  left: -2px;
  font-size: 12px;
  border-radius: 10%;
  color: #FFFFFF;
  padding: 5px;
}

.no {
  background-color: darkred;
  border: 1px darkred solid;
  font-weight: bold;
}

.yes {
  background-color: darkgreen;
  border: 1px darkgreen solid;
  font-weight: bold;
}

.wait {
  background-color: #ff8800;
  border: 1px #ff8800 solid;
  font-weight: bold;
}
</style>
