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
      <el-table-column label="编号" prop="cid"></el-table-column>
      <el-table-column label="昵称" prop="cname"></el-table-column>
      <el-table-column label="花色" prop="ccolor"></el-table-column>
      <el-table-column label="图片" prop="curl"></el-table-column>
      <el-table-column label="描述" prop="cinfo"></el-table-column>
      <el-table-column label="领养状态" prop="cisadopt"></el-table-column>

      <!-- 搜索查询框 -->
      <el-table-column align="right">
        <template slot="header" slot-scope="{}">
          <!--          <el-link target="_blank" @click="$router.push('/layout/admin/addcat')" class="link">点击新增猫数据</el-link>-->
          <!--          <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />-->
          操作
        </template>
        <!-- 删除和编辑按钮 -->
        <template slot-scope="scope">
          <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.row)"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-main>
</template>

<script>
import {catAPI, deleteCatAPI} from "@/api";
//用于向后端交互
export default {
  name: "myCatdb",
  inject: ['reload'],
  data() {
    return {
      tableData: [], //catList
      search: "",
    };
  },
  created() {
    this.getCat();
  },
  methods: {
    getCat: async function () {
      const {data: res} = await catAPI();
      this.tableData = res.data;
      // console.log(res.data);
    },
    async handleDelete(cat) {
      const {data: res} = await deleteCatAPI(cat.cid);
      if (res.code === '200') {
        this.$message.success("删除猫咪成功！");
        this.reload();
      }
    }
  },
  activated() {
    this.getCat();
  }
};
</script>
<style>
.el-link.el-link--default {
  color: #ff8800;
  text-decoration: underline 1px;
}
</style>
