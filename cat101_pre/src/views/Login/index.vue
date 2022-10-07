<template>
  <div class="register">
    <el-form
      :model="ruleForm"
      status-icon
      :rules="rules"
      ref="ruleForm"
      label-width="100px"
      class="demo-ruleForm"
    >
<!-- 账号输入框 -->
      <el-form-item label="账号" prop="Uname">
        <el-input
          v-model="ruleForm.Uname"
          autocomplete="off"
          required="true"
        ></el-input>
      </el-form-item>
<!-- 密码输入框 -->
      <el-form-item label="密码" prop="Upwd">
        <el-input
          type="password"
          v-model="ruleForm.Upwd"
          autocomplete="off"
        ></el-input>
      </el-form-item>

      <!-- <el-button type="warning" plain @click="$router.push('/layout/user')"
        >用户登录</el-button
      >
      <el-button type="warning" plain @click="$router.push('/layout/admin')"
        >管理员登录</el-button
      > -->

<!-- 选择后台登录还是前台登录 设置选中普通用户时传值为 0，管理员为 1-->
      <el-form-item label="登录角色" prop="Utype">
        <el-radio-group v-model="ruleForm.Utype" >
          <el-radio label="0" >普通用户</el-radio>
          <el-radio label="1" >管理员</el-radio>
        </el-radio-group>
      </el-form-item>
<!-- 下面是登录和重置按钮，我改变了按钮的样式 -->
      <el-form-item>
        <el-button     
          type="primary"
          @click="submitForm('ruleForm')"
          style="margin: auto;background-color: #d7cd94;
          border-color: #c2b79a;"
          >登录</el-button
        >
        <el-button @click="resetForm('ruleForm')" style="background-color: #d7cd94;border-color: #c2b79a;">重置</el-button>
<!-- 如果还没有账号，跳到登录页 -->
        <el-link type="warning" @click="$router.push('/layout/register')">没有账号？去注册</el-link>

      </el-form-item>
    </el-form>
  </div>
</template>
<script>
  import { loginAPI } from "@/api/index";    //导入调登录接口的函数
  // import { mapMutations } from "@/store/index";
export default {
  name: "myLogin",
// 数据
  data() {
//，校验函数，限制输入不能为空
    var checkUname = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("账号不能为空"));
      } else {
        callback();
      }
      // setTimeout(() => {
      //   if (!Number.isInteger(value)) {
      //     callback(new Error("请输入数字值"));
      //   } else {
      //     if (value < 18) {
      //       callback(new Error("必须年满18岁"));
      //     } else {
      //       callback();
      //     }
      //   }
      // }, 1000);
    };
//，校验函数，限制输入不能为空
    var validatePass = (rule, value, callback) => {        
      if (value === "") {
        return callback(new Error("请输入密码"));
      } else {
        callback();
      }
    };

// 具体数据
    return {
      ruleForm: {
        Uname: "",
        Upwd: "",
        Utype: "",
      },
// 校验规则对象
      rules: {
        Upwd: [{ validator: validatePass, trigger: "blur" }],
        Uname: [{ validator: checkUname, trigger: "blur" }],
        Utype: [
            { required: true, message: '请选择登录角色', trigger: 'change' }
          ],
      },
    };
  },
  methods: {
// 把store中的mutation函数映射过来
// ...mapMutations(['updataToken']),

// 登录按钮的点击事件，先调函数校验然后调接口发送请求和表单数据，后端做出处理后返回处理结果
    submitForm(formName) {
      this.$refs[formName].validate( async (valid) => {
        if (valid) {
          console.log(this.ruleForm);      //打印出从表单提交来的需要向后端传递的数据，用于验证编写是否成功，后续可删除这段！！！！！！！
          const { data:res } = await loginAPI(this.ruleForm);
          console.log(res);                //打印后端返回结果,用于验证编写是否成功，后续可删除这段！！！！！！！
          if (res.code !=0) return this.$message.error(res.message)        //后端返回失败结果，提示后端返回的错误message或者也可以自己设置提示
          this.$message.success(res.message)                              //后端返回成功结果，提示后端返回的成功message或者也可以自己设置提示
          this.updataToken(res.token)
          this.$router.push('/layout/user');                              //跳转到首页
          this.$store.state.isNew = true;                                 //让welLogin组件上的“新消息”按钮出现
          this.$store.state.isLogin = false;                              //让welLogin组件上的“登录”和“注册”按钮消失
        } else {
          console.log("登录失败!!");
          return false;
        }
      });
    },
// 重置表单
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>

<style scoped>
.register {
  width: 400px;
  height: 450px;
  margin-left: 485px;
  padding-top: 140px;
}
/* 改变重置按钮鼠标经过时的样式 */
.el-button--default:hover {
  border-color: #dbd783;
  color: #FFF;
}
.el-button--primary:hover {
  color: rgb(32, 30, 27);
}
/* 给链接文字改变样式，它向右浮动，然后字体颜色为黑色 */
.el-link {
  float: right;
  color: black;
}
</style>