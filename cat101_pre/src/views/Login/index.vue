<template>
  <div style="position: absolute; left: 500px; top: 130px;">
    <div>
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <!-- <el-form-item label="用户账号" prop="pass">
        <el-input
          type="password"
          v-model="ruleForm.pass"
          autocomplete="off"
        ></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="pass">
        <el-input
          type="password"
          v-model="ruleForm.pass"
          autocomplete="off"
        ></el-input>
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input v-model.number="ruleForm.age"></el-input>
      </el-form-item> -->
        <el-tabs class="header">
          <el-tab-pane style="background:#d4ad77">
            <span slot="label" class="head">用户</span>
            <div class="log">
              用户账号
              <input type="text" name="uname" maxlength="20" required v-model="uname">
              <br>
              密码
              <input type="password" name="password" maxlength="20" required v-model="password">
              <button class="pl_login" type="warning" plain @click="$router.push('/layout/user')">登录</button>
            </div>
          </el-tab-pane>
          <el-tab-pane>
            <span slot="label" class="head">管理员</span>
            <div class="log">
              管理员账号
              <input type="text" name="admin" maxlength="20" required>
              <br>
              密码
              <input type="password" name="passwd" maxlength="20" required>

              <button class="pl_login" type="warning" plain @click="$router.push('/layout/admin')">登录</button>
            </div>
          </el-tab-pane>
        </el-tabs>
      </el-form>
    </div>
    <!-- <el-button type="warning" plain @click="$router.push('/layout/user')">用户登录</el-button>
    <el-button type="warning" plain @click="$router.push('/layout/admin')">管理员登录</el-button> -->
  </div>
</template>

<script>
export default {
  name: "myLogin",
  data() {
    // var validatePass = (rule, value, callback) => {
    //   if (value === "") {
    //     callback(new Error("请输入账号"));
    //   } else {
    //     if (this.ruleForm.checkPass !== "") {
    //       this.$refs.ruleForm.validateField("Pass");
    //     }
    //     callback();
    //   }
    // };
    // var validatePass = (rule, value, callback) => {
    //   if (value === "") {
    //     callback(new Error("请输入密码"));
    //   } else {
    //     if (this.ruleForm.checkPass !== "") {
    //       this.$refs.ruleForm.validateField("checkPass");
    //     }
    //     callback();
    //   }
    // };
    return {
      // ruleForm: {
      //   pass: "",
      //   checkPass: "",
      // },
      // rules: {
      //   pass: [{ validator: validatePass, trigger: "blur" }],
      //   checkPass: [{ validator: validatePass2, trigger: "blur" }],
      // },
      user: {}
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert("submit!");
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    login() {

    }
  },
};
</script>

<style >
.head {
  font-size: larger;
}

.el-tabs__item {
  width: 190px;
  font-size: larger;
  text-align: center;
  font-weight: bolder;
  border-radius: 50px;
}

.el-tabs__content {
  border-radius: 50px;
}
</style>
<!-- < !-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.header {
  font-size: large;
  font-weight: lighter;
  width: 380px;
  height: 350px;
  background-color: #d4ad77;
  border-radius: 50px;
  position: absolute;
  top: 0;
}

.log {
  display: flex;
  flex-flow: column wrap;
  /* justify-content: space-around; */
  height: 300px;
  width: 320px;
  position: relative;
  left: 30px;
}




.sheet {
  width: 380px;
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

.tag {
  font-size: 60px;
  font-weight: bolder;
  transition: .6s;
}

.off {
  opacity: 0.4;
}

.pl_login,
.pl_signup {
  color: aliceblue;
  font-size: large;
  width: 100px;
  height: 40px;
  background-color: #d77d1c;
  border-radius: 25px;
  align-self: center;
  position: absolute;
  bottom: 50px;
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

.button {
  width: 70px;
  height: 35px;
  /* background-color: #ce7c80; */
  background-color: rgb(193, 191, 191);
  border-radius: 20px;
  box-shadow: 4px 3px 5px inset gray;
}
</style>
  