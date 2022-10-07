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
      <!-- 表头 -->
      <el-table-column label="编号" prop="cid"> </el-table-column>
      <el-table-column label="图片" prop="pic"> </el-table-column>
      <el-table-column label="备注" prop="description"> </el-table-column>
      <!-- 搜索查询框 -->
      <el-table-column align="right">
        <template slot="header" slot-scope="{}">
          流浪猫数据库
          <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />
        </template>
        <!-- 删除和编辑按钮 -->
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button
          >
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </el-main>
</template>

<script>
// import axios from 'axios';     //用于向后端交互
// import { url } from 'inspector';
// import { type } from 'os';
export default {
  name: "myCatdb",
  data() {
    return {
      tableData: [
        {
          cid: "2016-05-02",
          pic: "王小虎",
          description: "上海市普陀区金沙江路 1518 弄",
        },
        {
          cid: "2016-05-04",
          pic: "王小虎",
          description: "上海市普陀区金沙江路 1517 弄",
        },
        {
          cid: "2016-05-01",
          pic: "王小虎",
          description: "上海市普陀区金沙江路 1519 弄",
        },
        {
          cid: "2016-05-03",
          pic: "王小虎",
          description: "上海市普陀区金沙江路 1516 弄",
        },
      ],
      search: "",
    };
  },
  // methods: {
  //   handleEdit(index, row) {
  //     this.$confirm("你正在操作流浪猫数据库，将永久删除次条流浪猫的信息，是否继续操作？",
  //     "警告",
  //     {confirmButtonText:"继续",
  //     cancelButtonText:"取消",
  //     type: "warning"

  //     }).then(() => {
  //        const data = {cid:cid};      //我猜测这里要和后端数据库的字段名称相同
  //       axios
  //       .post("url",data)            //我猜测这里是要写后端给的接口地址
  //       .then(response =>{
  //         this.fetchdata();          // 删除数据后重新获取数据
  //       })
  //       .catch(() => {
  //         this.$message({
  //           type: "warning",
  //           message: "请求失败，请检查网络设置"
  //         })
  //       });
  //     }).catch(() =>{
  //      this.message({
  //         type: "info",
  //         message:"已取消删除"
  //      })

  //     })

  //     console.log(index, row);
  //   },
  //   handleDelete(index, row) {
  //     console.log(index, row);
  //   }
  // },
};
</script>
<style>
</style>