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
      <Scoped slot >申请书列表</Scoped>
      <el-table-column label="编号" prop="cid"> </el-table-column>
      <el-table-column label="照片" prop="pic"> </el-table-column>
      <el-table-column label="描述" prop="description"> </el-table-column>
      <el-table-column align="right">
        <template slot="header">
            申请书列表
          <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />
        </template>
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button
          >
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
            >Delete</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </el-main>
</template>
<script>
export default {
  name: "myApplydb",
    data() {
      return {
        tableData: [{
          cid: '2016-05-02',
          pic: '王小虎',
          description: '上海市普陀区金沙江路 1518 弄'
        }, {
          cid: '2016-05-04',
          pic: '王小虎',
          description: '上海市普陀区金沙江路 1517 弄'
        }, {
          cid: '2016-05-01',
          pic: '王小虎',
          description: '上海市普陀区金沙江路 1519 弄'
        }, {
          cid: '2016-05-03',
          pic: '王小虎',
          description: '上海市普陀区金沙江路 1516 弄'
        }],
        search: '',
      }
     
    },
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      }
    },
  }
</script>
<style></style>