<template>
  <div>
    <el-button type="text" @click="dialogFormVisible = true"
      >点击新增猫数据</el-button
    >

    <el-dialog title="新增猫数据" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="猫昵称" :label-width="formLabelWidth">
          <el-input v-model="form.cname" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="猫花色" :label-width="formLabelWidth">
          <el-input v-model="form.ccolor" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="描述信息" :label-width="formLabelWidth">
          <el-input v-model="form.cinfo" autocomplete="off"></el-input>
        </el-form-item>

<!--        <el-form-item label="领养状态" :label-width="formLabelWidth">-->
<!--          <el-select v-model="form.isadopt" placeholder="请选择">-->
<!--            <el-option label="已领养" value="4"></el-option>-->
<!--            <el-option label="待领养" value="0"></el-option>-->
<!--            <el-option label="待领养" value="0"></el-option>-->
<!--            <el-option label="待领养" value="0"></el-option>-->
<!--            <el-option label="待领养" value="0"></el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
        <el-form-item label="上传图片" prop="imageUrl">
          <el-upload
            class="avatar-uploader"
            action="/file/upload"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload"
          >
            <img v-if="imageUrl != ''" :src="imageUrl" class="avatar" />
            <i v-else class="el-icon-plus avatar-uploader-icon">上传图片</i>
          </el-upload>
        </el-form-item>
        <el-upload
          action="/file/upload"
          list-type="picture-card"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
        >
          <i class="el-icon-plus"></i>
        </el-upload>
        <el-dialog :visible.sync="dialogVisible">
          <img width="100%" :src="dialogImageUrl" alt="" />
        </el-dialog>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false"
          >确 定</el-button
        >
      </div>
    </el-dialog>
  </div>
</template>


<script>
export default {
  data() {
    return {
      dialogImageUrl: "",
      dialogVisible: false,
      dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        cname: "",
        ccolor: "",
        cinfo: "",
        curl: "",
        cisadopt: 0,
      },
      formLabelWidth: "120px",
    };
  },
  methods: {
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
  },
};
</script>
