<template>
  <div class="register">
    <div >
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-tabs class="header">
          <span slot="label" class="head">用户</span>
          <div class="log">
            <!-- 账号 -->
            <el-form-item label="账号" prop="uname">
              <el-input v-model="ruleForm.uname" autocomplete="off" required="true"></el-input>
            </el-form-item>
            <!-- 密码 -->
            <el-form-item label="密码" prop="upwd">
              <el-input type="password" v-model="ruleForm.upwd" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm('ruleForm')" style="margin: auto;background-color: #d7cd94;
          border-color: #c2b79a;">登录</el-button>
              <el-button @click="resetForm('ruleForm')" style="background-color: #d7cd94;border-color: #c2b79a;">重置
              </el-button>
              <!-- 如果还没有账号，跳到登录页 -->
              <el-link type="warning" @click="$router.push('/layout/register')">没有账号？去注册</el-link>
            </el-form-item>
          </div>

        </el-tabs>
      </el-form>

    </div>

  </div>


</template>

<script>
import { loginAPI } from "@/api/index"; //导入调登录接口的函数
// import { mapMutations } from "@/store/index";
export default {
  name: "myLogin",
  // 数据
  data() {
    //，校验函数，限制输入不能为空
    var checkuname = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("账号不能为空"));
      } else {
        callback();
      }
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
        uname: "",
        upwd: ""
      },
      // 校验规则对象
      rules: {
        upwd: [{ validator: validatePass, trigger: "blur" }],
        uname: [{ validator: checkuname, trigger: "blur" }],
      },
    };
  },
  methods: {
    // 把store中的mutation函数映射过来
    // ...mapMutations(['updataToken']),

    // 登录按钮的点击事件，先调函数校验然后调接口发送请求和表单数据，后端做出处理后返回处理结果
    submitForm(formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          // console.log(this.ruleForm);
          // console.log(JSON.stringify(this.ruleForm)); //打印出从表单提交来的需要向后端传递的数据，用于验证编写是否成功，后续可删除这段！！！！！！！
          const json = JSON.stringify(this.ruleForm);
          const { data: res } = await loginAPI(json);
          // console.log(res); //打印后端返回结果,用于验证编写是否成功，后续可删除这段！！！！！！！
          if (res.code !== "200") return this.$message.error(res.msg); //后端返回失败结果，提示后端返回的错误message或者也可以自己设置提示
          this.$message.success("登录成功"); //后端返回成功结果，提示后端返回的成功message或者也可以自己设置提示
          // this.updataToken(res.token)
          localStorage.setItem("user", JSON.stringify(res.data)); // 存储用户信息到浏览器
          if (res.data.utype === 0) {
            this.$router.push("/layout/user"); //跳转到首页
            this.$store.state.isNew = true; //让welLogin组件上的“新消息”按钮出现
            this.$store.state.isLogin = false;
          }else{
            this.$router.push('/layout/admin');
            this.$store.state.isNew = true; //让welLogin组件上的“新消息”按钮出现
            this.$store.state.isLogin = false;
          }
          //让welLogin组件上的“登录”和“注册”按钮消失
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

<style >
.head {
  font-size: large;
}

.el-tabs__item {
  width: 190px;
  font-size: large;
  text-align: center;
  font-weight: bolder;
  border-radius: 50px;
}

.el-tabs__content {
  /* border-radius: 50px; */
  height: 200px;
}
</style>
<!-- < !-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.register {
  /*width: 1672px;*/
  height: 600px;
  margin: 0 auto;
  /*padding-top: 140px;*/
  position: relative;
  background-color: #e7cc9e;
  background-size:cover;
  /* /contain  */
  background-image: url(@/assets/img/bg.png);
  background-repeat: no-repeat;
}
/*.register::before{*/
/*  content: "";*/
/*  position: absolute; !* 一定要用绝对定位 *!*/
/*  width: 100%;*/
/*  height: 100%;*/
/*  backdrop-filter: blur(3px); !* 模糊半径 *!*/
/*}*/
.el-row {
  background-color: #e7cc9e;
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

.header {
  font-size: large;
  font-weight: lighter;
  width: 380px;
  height: 250px;
  background-color: #dfd6b9;
  border-radius: 40px;
  position: absolute;
  top: 150px;
  left: 50%;
  transform: translateX(-50%);
}

.log {
  display: flex;
  flex-flow: column wrap;
  /* justify-content: space-around; */
  height: 200px;
  width: 370px;
  position: relative;
  right: 28px;
  top: 35px;
}




.sheet {
  width: 300px;
  height: 500px;
  display: flex;
  flex-direction: column;
  align-content: center;
  position: absolute;
  right: 80px;
  top: 50px;
  line-height: 40px;
  justify-content: space-evenly;
}

.mid {
  width: 380px;
  height: 300px;
  background-color: #d4ad77;
  border-radius: 30px;
  position: relative;
}

.mid>div {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
  border-radius: 50px;

}

input {
  height: 35px;
  width: 270px;
  border: none;
}



.pl_login,
.pl_signup {
  color: aliceblue;
  font-size: large;
  width: 100px;
  height: 40px;
  background-color: rgb(212, 205, 143);
  border-radius: 25px;
  /* align-self: center; */
  position: absolute;
  right: 95px;
  bottom: 76px;
}


.top {
  width: 370px;
  display: flex;
  justify-content: space-evenly;
  cursor: pointer;
}



.mid>div button:hover {
  box-shadow: 1px 1px 5px white;
}

.signup {
  position: absolute;
  top: 0;
}
</style>


