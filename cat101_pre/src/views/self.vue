<template>
  <div class="register">
    <div class="inset">

      <!-- <el-button type="warning" plain @click="$router.push('/layout/login')">已注册，去登录</el-button> -->
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <!-- 账号 -->
        <el-form-item label="账号" prop="uname">
          <el-input v-model="ruleForm.uname" autocomplete="off" required="true" disabled></el-input>
        </el-form-item>
        <!-- 密码 -->
        <button @click="isShow=true;pwdIsDisabled=false" style="margin-left: 330px;">修改密码</button>
        <el-form-item label="密码" prop="upwd">
          <el-input type="password" v-model="ruleForm.upwd" autocomplete="off" :disabled="pwdIsDisabled"></el-input>
        </el-form-item>
        <!-- 确认密码 -->
        <el-form-item label="确认密码" prop="checkPass" v-show="isShow">
          <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
        </el-form-item>
        <!--电话号码-->
        <button @click="telIsDisabled=false" style="margin-left: 330px;">修改电话</button>
        <el-form-item label="电话号码" prop="utel">
          <el-input type="text" onkeyup="value=value.replace(/[^\d]/g,'')" v-model="ruleForm.utel" autocomplete="off"
                    :disabled="telIsDisabled"></el-input>
        </el-form-item>
        <!-- 下面是提交和重置按钮，我改变了按钮的样式 -->
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')" style="margin: auto;background-color: #d7cd94;
          border-color: #c2b79a;">修改
          </el-button>
          <!-- 重置 -->
          <el-button @click="resetForm('ruleForm')" style="background-color: #d7cd94;border-color: #c2b79a;">重置
          </el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>


<script>
import {registerAPI, updateSelfAPI} from "@/api";

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
    var checkUtel = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("电话号码不能为空"));
      } else if (value.length != 11) {
        callback("请输入正确的电话号码");
      } else {
        callback();
      }
    }
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
      user: JSON.parse(localStorage.getItem('user')),
      ruleForm: {
        uid:"",
        uname: "",
        upwd: "",
        utel: "",
        checkPass:""
      },
      rules: {
        upwd: [{validator: validatePass, trigger: "blur"}],
        checkPass: [{validator: validatePass2, trigger: "blur"}],
        uname: [{validator: checkUname, trigger: "blur"}],
        utel: [{validator: checkUtel, trigger: "blur"}],
      },
      isShow: false,
      pwdIsDisabled: true,
      telIsDisabled: true,
    };
  },

  // 方法
  methods: {
    indexs() {
      this.ruleForm.uname = this.user.uname;
      this.ruleForm.upwd = this.user.upwd;
      this.ruleForm.utel = this.user.utel;
      this.ruleForm.uid=this.user.uid;
    },
//点击提交表单触发    校验和提交信息到后端接口
    async submitForm(formName) {
      delete this.ruleForm.checkPass;
      if(this.pwdIsDisabled)
        delete this.ruleForm.upwd;
      else {
        if(this.ruleForm.checkPass!=this.ruleForm.upwd){
          this.$message.warning("两次密码不一致！");
          return;
        }
      }
      const json = JSON.stringify(this.ruleForm);
      const {data :res} = await updateSelfAPI(json);    //提交表单后获取到表单数据对象ruleForm然后使用axios传递给接口函数，得到一个返回值，是promise对象
      console.log(json);
      console.log(res.code);                                        //打印后端返回结果,用于验证编写是否成功，后续可删除这段！！！！！！！
      if(res.code === '200') {
        this.$message.success("修改成功！！")                            ////后端返回成功结果，提示后端返回的错误message或者也可以自己设置提示
        this.indexs();
        this.isShow=false;
        this.telIsDisabled=true;
        this.pwdIsDisabled=true;
      }else{
        this.$message.error(res.msg) ////后端返回失败结果，提示后端返回的错误message或者也可以自己设置提示
      }


    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
  created: function () {
    this.indexs();
  }
};
</script>

<style scoped>
.inset {
  width: 400px;
  height: 280px;
  background-color: #dfd6b9;
  position: absolute;
  top: 150px;
  left: 50%;
  transform: translateX(-50%);
  padding: 80px;
  padding-top: 40px;
  padding-left: 30px;
  border-radius: 30px;
}

.register {
  /*width: 1672px;*/
  width: 100%;
  height: 600px;
  margin: 0px auto;
  /*padding-top: 140px;*/
  position: relative;
}

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
