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

        <el-form-item label="备注" :label-width="formLabelWidth">
          <el-input v-model="form.cinfo" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="领养状态(0:未领养；1：以领养)" :label-width="formLabelWidth">
          <el-input v-model="form.cisadopt" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="上传图片" prop="imageUrl">
          <el-upload
            action="http://localhost:8082/file/upload"
            list-type="picture-card"
            :on-preview="handlePictureCardPreview"
            :on-success="handleAvatarSuccess"
            :on-remove="handleRemove"
          >
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible">
            <img width="100%" :src="dialogImageUrl" alt="" />
          </el-dialog>
        </el-form-item>
        <el-dialog :visible.sync="dialogVisible">
          <img width="100%" :src="dialogImageUrl" alt="" />
        </el-dialog>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitCat(form)"
          >确 定</el-button
        >
      </div>
    </el-dialog>
  </div>
</template>


<script>
import { addcatAPI } from "@/api";
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
        cisadopt: "",
      },
      formLabelWidth: "120px",
      dialogImageUrl: "",
      dialogVisible: false,
      json :"",
    };
  },
  methods: {
    // handleAvatarSuccess(file, fileList) {
    //     console.log(file,fileList)
    //     this.curl = res.data.final_fileName;
    //     // sessionStorage.setItem("curl",this.curl)
    //     alert(this.curl)
    // },
    handleAvatarSuccess(res, file) {
        console.log(res)
        this.form.curl = res
        // console.log(this.form.curl = res);
        // this.form.curl = sessionStorage.setItem("curl",this.curl)
             },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
      console.log(file.url);
    },
     
    submitCat: async function (){
      this.json = JSON.stringify(this.form),
       { data:res } = await addcatAPI(this.json);
      console.log(res.data);
       
    }
  },
};
</script>