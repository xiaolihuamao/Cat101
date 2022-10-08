<template>
  <el-main>
    <el-table
        :data="tableData.filter((data) =>!search || data.name.toLowerCase().includes(search.toLowerCase()))
      " style="width: 100%">
      <Scoped slot>申请书列表</Scoped>
      <el-table-column label="编号" prop="aid"></el-table-column>
      <el-table-column label="用户id" prop="uid"></el-table-column>
      <el-table-column label="猫咪id" prop="cid"></el-table-column>
      <el-table-column label="申请原因" prop="ainfo"></el-table-column>
      <el-table-column align="right">
        <template slot="header">
          操作
          <!--          申请书列表-->
          <!--          <el-input v-model="search" size="mini" placeholder="输入关键字搜索"/>-->
        </template>
        <template slot-scope="scope">
          <el-button size="mini"
                     type="danger"
                     @click="handleNO(scope.$index, scope.row)">
            驳回
          </el-button>
          <el-button
              size="mini"
              type="success"
              @click="handleYes(scope.$index, scope.row)">
            通过
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-main>
</template>
<script>
import {adoptBackAPI, adoptDeleteAPI, catInfoAPI, searchAPI} from "@/api";

export default {
  name: "myApplydb",
  data() {
    return {
      tableData: [],
      search: '',
    }
  },
  methods: {
    async handleNO(index, row) {
      console.log(index, row);
      this.$message.success("处理成功！！");
      // await adoptDeleteAPI(index+1);
    },
    async handleYes(index, row) {
      console.log(index, row);
      this.$message.success("处理成功！！");
      // await adoptDeleteAPI(index+1);
    },
    indexs: async function () {
      const {data: res} = await adoptBackAPI();
      if (res.code === '200') {
        this.tableData = res.data;
        // console.log(this.catsALL[0].cname);
      } else {
        this.$message.error(res.msg) //后端返回失败结果，提示后端返回的错误message或者也可以自己设置提示
      }
    },
  },
  created: async function () {
    //自动加载indexs方法
    this.indexs();
  },
  // activated: async function () {
  // //自动加载indexs方法
  // this.indexs();}
}
</script>
<style>
</style>
