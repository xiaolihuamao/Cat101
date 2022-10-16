<template>
  <el-main>
    <el-table
      :data="
        tableData.filter(
          (data) =>
            !search || data.name.toLowerCase().includes(search.toLowerCase())
        )
      "
      style="width: 100%"
    >
      <!--      <Scoped slot>申请书列表</Scoped>-->
      <el-table-column label="编号" prop="aid"></el-table-column>
      <el-table-column label="用户名" prop="uname"></el-table-column>
      <el-table-column label="用户电话" prop="utel"></el-table-column>
      <el-table-column label="猫咪昵称" prop="cname"></el-table-column>
      <el-table-column label="申请原因" prop="ainfo"></el-table-column>
      <el-table-column label="申请状态" prop="cisadopt"></el-table-column>
      <el-table-column align="right">
        <template slot="header">
          操作
          <!--          申请书列表-->
          <!--          <el-input v-model="search" size="mini" placeholder="输入关键字搜索"/>-->
        </template>
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="danger"
            @click="handleNO(scope.$index, scope.row)"
          >
            驳回
          </el-button>
          <el-button
            size="mini"
            type="success"
            @click="handleYes(scope.$index, scope.row)"
          >
            通过
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-main>
</template>
<script>
import {
  adoptBackAPI,
  adoptDeleteAPI,
  catInfoAPI,
  searchAPI,
  updateCatAPI,
} from "@/api";

export default {
  name: "myApplydb",
  inject:['reload'],
  data() {
    return {
      tableData: [],
      search: "",
      updateInfo: {
        cid: "",
        cisadopt: 1,
      },
    };
  },
  methods: {
    async handleNO(index, row) {
      this.updateInfo = {
        cid: row.cid,
        cisadopt: 0,
      };
      const { data: res } = await updateCatAPI(JSON.stringify(this.updateInfo));
      if (res.code === "200") this.$message.success("驳回成功！！");
      // await adoptDeleteAPI(index+1);
      this.reload();
    },
    async handleYes(index, row) {
      this.updateInfo = {
        cid: row.cid,
        cisadopt: 2,
      };
      const { data: res } = await updateCatAPI(JSON.stringify(this.updateInfo));
      if (res.code === "200") this.$message.success("通过成功！！");
      this.reload();
    },
    indexs: async function () {
      const { data: res } = await adoptBackAPI();
      if (res.code === "200") {
        this.tableData = res.data;
        console.log(this.tableData); //测试是否拿到了领养表返回的数据
        // console.log(this.catsALL[0].cname);
        for (let i = 0;i <= this.tableData.length;i++){
          if (this.tableData[i].cisadopt == 0) {
          this.tableData[i].cisadopt = "未通过！";
        } else if (this.tableData[i].cisadopt == 1) {
          this.tableData[i].cisadopt = "审核中···";
        } else {
          this.tableData[i].cisadopt = "已通过！";
        }
        }
        
      } else {
        this.$message.error(res.msg); //后端返回失败结果，提示后端返回的错误message或者也可以自己设置提示
      }
    },
  },
  created: async function () {
    //自动加载indexs方法
    this.indexs();
  },
  activated () {      //: async function
  //自动加载indexs方法
  this.indexs();}
};
</script>
<style>
</style>
