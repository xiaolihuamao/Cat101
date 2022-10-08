<template>
  <div class="register">
    <div class="inset">

      <!-- <el-button type="warning" plain @click="$router.push('/layout/login')">已注册，去登录</el-button> -->
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <!-- 账号 -->
        <el-form-item label="账号" prop="uname">
          <el-input v-model="ruleForm.uname" autocomplete="off" required="true"></el-input>
        </el-form-item>
        <!-- 密码 -->
        <el-form-item label="密码" prop="upwd">
          <el-input type="password" v-model="ruleForm.upwd" autocomplete="off"></el-input>
        </el-form-item>
        <!-- 确认密码 -->
        <el-form-item label="确认密码" prop="checkPass">
          <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
        </el-form-item>
        <!-- 下面是提交和重置按钮，我改变了按钮的样式 -->
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')" style="margin: auto;background-color: #d7cd94;
          border-color: #c2b79a;">提交</el-button>
          <!-- 重置 -->
          <el-button @click="resetForm('ruleForm')" style="background-color: #d7cd94;border-color: #c2b79a;">重置
          </el-button>
          <!-- 前往登录 -->
          <el-link type="warning" @click="$router.push('/layout/login')">已注册？前往登录</el-link>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>


<script>
import { registerAPI } from "@/api/index";
export default {
  name: "myRegister",
  // 数据
  data() {
    var checkUname = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("账号不能为空"));
      } else {
        callback();
      }
    };
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.ruleForm.checkPass !== "") {
          this.$refs.ruleForm.validateField("checkPass");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.ruleForm.upwd) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        uname: "",
        upwd: "",
        uxname: "胡图图",
        usex: "男",
        utel: "13412345678",
        usite: "翻斗大街翻斗花园二号楼1001室",
        utype: "0",
        usrl: "https://www.qqkw.com/d/file/p/2022/04-18/c17d85a851e9444d7cf11a2fe491cdcb.jpg",
        uinfo: "信息介绍",
        checkPass: "",

      },
      rules: {
        upwd: [{ validator: validatePass, trigger: "blur" }],
        checkPass: [{ validator: validatePass2, trigger: "blur" }],
        uname: [{ validator: checkUname, trigger: "blur" }],
      },
    };
  },

  // 方法
  methods: {
    //点击提交表单触发    校验和提交信息到后端接口
    submitForm(formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          console.log(this.ruleForm);                //打印出从表单提交来的需要向后端传递的数据，用于验证编写是否成功，后续可删除这段！！！！！！！
          const json = JSON.stringify(this.ruleForm);
          const res = await registerAPI(json);    //提交表单后获取到表单数据对象ruleForm然后使用axios传递给接口函数，得到一个返回值，是promise对象
          console.log(res);                                         //打印后端返回结果,用于验证编写是否成功，后续可删除这段！！！！！！！
          if (res.code !== 200) return this.$message.error(res.message)     ////后端返回失败结果，提示后端返回的错误message或者也可以自己设置提示
          this.$message.success(res.message)                            ////后端返回成功结果，提示后端返回的错误message或者也可以自己设置提示
          this.$router.push('/layout/login')
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>

<style scoped>
.inset {
  width: 400px;
  height: 200px;
  background-color: #dfd6b9;
  position: absolute;
  top: 100px;
  padding: 80px;
  padding-left: 50px;
  border-radius: 30px;
}

.register {
  width: 400px;
  height: 450px;
  margin-left: 485px;
  padding-top: 140px;
}

/* 给链接文字改变样式，它向右浮动，然后字体颜色为黑色 */
.el-link {
  float: right;
  color: black;
}

/* 改变重置按钮鼠标经过时的样式 */
.el-button--default:hover {
  border-color: #dbd783;
  color: #FFF;
}

.el-button--primary:hover {
  color: rgb(32, 30, 27);
}
</style>