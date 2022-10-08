<!-- <template>
  <div>
    Apply.vue
    <el-radio-group v-model="labelPosition" size="small">
      <el-radio-button label="left">左对齐</el-radio-button>
      <el-radio-button label="right">右对齐</el-radio-button>
      <el-radio-button label="top">顶部对齐</el-radio-button>
    </el-radio-group>
    <div style="margin: 20px"></div>
    <el-form
      :label-position="labelPosition"
      label-width="80px"
      :model="formLabelAlign"
    >
      <el-form-item label="名称">
        <el-input v-model="formLabelAlign.name"></el-input>
      </el-form-item>
      <el-form-item label="活动区域">
        <el-input v-model="formLabelAlign.region"></el-input>
      </el-form-item>
      <el-form-item label="活动形式">
        <el-input v-model="formLabelAlign.type"></el-input>
      </el-form-item>
    </el-form>
    <el-button type="warning" plain>提交申请</el-button>
    <el-button type="warning" plain @click="$router.push('/layout/user')">返回首页</el-button
    >
  </div>
</template>
  
  <script>
export default {
  name: "myApply",
  data() {
      return {
        labelPosition: 'right',
        formLabelAlign: {
          name: '',
          region: '',
          type: ''
        }
      };
    }
  }
</script>
  
  <style lang="less" scoped></style>
  <style scoped></style> -->
<template>
  <div>
    <el-page-header @back="goBack"></el-page-header>
    <div class="title">~猫咪领养申请~</div>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-image :src="src" fit="scale-down" :preview-src-list="srcList" title="点击查看大图"></el-image>
      <el-form-item label="您的id">
        <el-input v-model="ruleForm.uid" disabled></el-input>
      </el-form-item>
      <el-form-item label="猫咪id">
        <el-input v-model="ruleForm.cid" disabled></el-input>
      </el-form-item>
      <el-form-item label="领养原因" prop="reason">
        <el-input v-model="ruleForm.reason" type="textarea" :placeholder="'您可以从爱好、经验、性格等方面阐述领养原因\n（100字以内）'" rows="20"
          style="font-size: 16px"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交申请</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>

    <!--    TODO：怎么让这个提示框显示，要用到下面的函数-->
    <el-dialog title="提示" :visible.sync="dialogVisible" width="30%">
      <span>申请提交成功！</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
  
<script>
import { ref } from 'vue';

export default {
  name: "myApply",
  data() {
    return {
      src: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
      srcList: [
        'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg'
      ],
      //TODO:从后台获取CID和UID数据，在前端显示
      ruleForm: {
        uid: '',
        cid: '',
        reason: '',
      },
      rules: {
        reason: [
          { required: true, message: '请输入领养原因', trigger: 'blur' },
          { max: 100, message: '长度在 100 字以内', trigger: 'blur' }
        ],
      },
      dialogVisible: ref(false),
    };
  },
  methods: {
    goBack() {
      window.history.go(-1);
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert("提交成功！");
          this.$router.push('/layout/info');
        } else {
          // console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>
  
  <!-- <style lang="less" scoped></style> -->
<style scoped>
.title {
  text-align: center;
  font-size: 28px;
  margin: 20px;
  font-family: "微软雅黑 Light";
  letter-spacing: 3px;
  font-weight: 500;
}

.el-form {
  margin: 0 auto;
  width: 60%;
}

.el-image {
  width: 50%;
  display: block;
  margin: 50px auto;
  border-radius: 8%
}

.el-button {
  margin-left: 24px;
}


.el-form-item:last-child {
  width: 400px;
  margin: 0 auto
}

.el-page-header {
  margin: 30px;
}
</style>
  
 