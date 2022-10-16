<template>
  <div class="register">
    <div class="inset">

      <!-- <el-button type="warning" plain @click="$router.push('/layout/login')">已注册，去登录</el-button> -->
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <!-- 账号 -->
        <el-form-item label="账号" prop="uname">
          <el-input v-model="ruleForm.uname" autocomplete="off" required="true" disabled></el-input>
        </el-form-item>
        <!-- 昵称 -->
        <button @click="uxnameIsDisabled=false" style="margin-left: 330px;">修改昵称</button>
        <el-form-item label="昵称" prop="uxname">
          <el-input type="text" v-model="ruleForm.uxname" autocomplete="off"
                    :disabled="uxnameIsDisabled"></el-input>
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
import {registerAPI, searchUserAPI, updateSelfAPI} from "@/api";

export default {
  name: "myRegister",
  inject: ["reload"],
// 数据
  data() {
    var checkUname = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("账号不能为空"));
      } else {
        callback();
      }
    };
    var checkUxname = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("昵称不能为空"));
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
    return {
      user: JSON.parse(localStorage.getItem('user')),
      ruleForm: {
        uid:"",
        uname: "",
        uxname:"",
        utel: "",
      },
      rules: {
        uname: [{validator: checkUname, trigger: "blur"}],
        uxname: [{validator: checkUxname, trigger: "blur"}],
        utel: [{validator: checkUtel, trigger: "blur"}],
      },
      isShow: false,
      uxnameIsDisabled: true,
      telIsDisabled: true,
    };
  },
  created() {
    this.indexs();
  },
  // 方法
  methods: {
    indexs() {
      if(JSON.parse(localStorage.getItem('user'))==null){
        this.$message.error("无token，请登录！") //后端返回失败结果，提示后端返回的错误message或者也可以自己设置提示
        return;
      }
      this.ruleForm.uname = this.user.uname;
      this.ruleForm.uxname = this.user.uxname;
      this.ruleForm.utel = this.user.utel;
      this.ruleForm.uid=this.user.uid;
    },
//点击提交表单触发    校验和提交信息到后端接口
    async submitForm(formName) {
      const json = JSON.stringify(this.ruleForm);
      const {data :res} = await updateSelfAPI(json);    //提交表单后获取到表单数据对象ruleForm然后使用axios传递给接口函数，得到一个返回值，是promise对象       //打印后端返回结果,用于验证编写是否成功，后续可删除这段！！！！！！！
      if(res.code === '200') {
        this.$message.success("修改成功！！")                            ////后端返回成功结果，提示后端返回的错误message或者也可以自己设置提示
        const {data :res}=await searchUserAPI(this.user.uid);
        const token=this.user.token;//取出token
        this.user=res.data;
        this.user.token=token;//添加token
        localStorage.setItem('user',JSON.stringify(this.user));
        this.reload();
      }else{
        this.$message.error(res.msg) ////后端返回失败结果，提示后端返回的错误message或者也可以自己设置提示
      }


    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
  activated() {
    this.getCat();
  },
};
</script>

<style scoped>
.inset {
  width: 400px;
  height: 235px;
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
