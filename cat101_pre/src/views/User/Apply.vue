<template>
  <div>
    <el-page-header @back="goBack"></el-page-header>
    <div class="title">~猫咪领养申请~</div>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-image :src=(cat.curl) fit="scale-down" :preview-src-list="srcList" title="点击查看大图"></el-image>
      <el-form-item label="您的id">
        <el-input v-model="ruleForm.uid" disabled></el-input>
      </el-form-item>
      <el-form-item label="猫咪id">
        <el-input v-model="ruleForm.cid" disabled></el-input>
      </el-form-item>
      <el-form-item label="领养原因" prop="ainfo">
        <el-input v-model="ruleForm.ainfo" type="textarea" :placeholder="'您可以从爱好、经验、性格等方面阐述领养原因\n（100字以内）'"
                  rows="20" style="font-size: 16px"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交申请</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {ref} from 'vue';
import {saveAPI, updateCatAPI} from "@/api";

export default {
  name: "myApply",
  data() {
    return {
      srcList: [
          JSON.parse(localStorage.getItem('cat')).curl,
      ],
      // user:localStorage.getItem('user')?JSON.parse(localStorage.getItem('user')):{},
      //TODO:从后台获取CID和UID数据，在前端显示
      ruleForm: {
        // uid: localStorage.getItem('user').split(',')[0].split(':')[1],
        uid: localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')).uid : '',
        cid: JSON.parse(localStorage.getItem('cat')).cid,
        ainfo: '',
      },
      rules: {
        ainfo: [
          {required: true, message: '请输入领养原因', trigger: 'blur'},
          {max: 100, message: '长度在 100 字以内', trigger: 'blur'}
        ],
      },
      updateInfo: {
        cid: JSON.parse(localStorage.getItem('cat')).cid,
        cisadopt: 1,
      },
      cat: JSON.parse(localStorage.getItem('cat')),
    };
  },
  methods: {
    goBack() {
      window.history.go(-1);
    },
    submitForm(formName) {
      //点击提交表单触发    校验和提交信息到后端接口
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          // console.log(this.ruleForm);                //打印出从表单提交来的需要向后端传递的数据，用于验证编写是否成功，后续可删除这段！！！！！！！
          const json = JSON.stringify(this.ruleForm);
          const {data: res} = await saveAPI(json);    //提交表单后获取到表单数据对象ruleForm然后使用axios传递给接口函数，得到一个返回值，是promise对象
          // console.log(res.code);                                        //打印后端返回结果,用于验证编写是否成功，后续可删除这段！！！！！！！
          if (res.code === '200') {
            await updateCatAPI(JSON.stringify(this.updateInfo));
            this.$message.success("申请成功！！")                            ////后端返回成功结果，提示后端返回的错误message或者也可以自己设置提示
            this.$router.push('/layout/info');
          } else {
            this.$message.error(res.msg) //后端返回失败结果，提示后端返回的错误message或者也可以自己设置提示
          }
        } else {
          console.log('error submit!!');
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
