<template>
  <div>
    <el-row :gutter="20">
      <div v-for="i in catsALL" :key="i.cid">
        <el-col :span="5">
          <div class="grid-content">
            <el-image :src="src" @click="turnInto(i.cid)"></el-image>
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
      src: "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg2.doubanio.com%2Fview%2Fgroup_topic%2Fl%2Fpublic%2Fp449604943.jpg&refer=http%3A%2F%2Fimg2.doubanio.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1667854064&t=28241997be6219631810ae853138bbda",
      catNum: 0,
      catsALL: [],
    };
  },
  methods: {
    indexs: async function () {
      const {data: res} = await searchAPI();
      if (res.code === '200') {
        this.catNum = res.data.length;
        this.catsALL = res.data;
        // console.log(this.catsALL[0].cname);
      } else {
        this.$message.error(res.msg) //后端返回失败结果，提示后端返回的错误message或者也可以自己设置提示
      }
    },
    async turnInto(id){
      const {data: res} = await catInfoAPI(id);
      if (res.code === '200') {
        localStorage.setItem('cat',JSON.stringify(res.data));
        this.$router.push('/layout/info');
      } else {
        this.$message.error(res.msg) //后端返回失败结果，提示后端返回的错误message或者也可以自己设置提示
      }
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
  display: ;
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
