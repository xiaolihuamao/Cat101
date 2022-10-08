<!-- <template>
  <div>
    <el-main>
      <div class="content">
        <div class="search">
          <div class="spc_search">
            <input type="text" placeholder="请输入要搜索的关键词">
            <el-button icon="el-icon-search" circle></el-button>
          </div>
          <div class="display">
            <el-col :span="8" v-for="(o,index) in 6" :key="o">
              <el-card class="card">
                <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                  class="image">
                <div style="padding: 14px;">
                  <span>好吃的汉堡</span>
                  <div class="bottom clearfix">
                    xxxxxxxxxx
                  </div>
                </div>
              </el-card>
            </el-col>
          </div>
        </div>
        <div class="shopping">
           <h2>商品</h2> 
          <p>商品</p>
          <div class="food">
            <span>猫粮</span>
            <el-carousel height="150px">
              <el-carousel-item v-for="item in 3" :key="item">
                <h3 class="small">{{ item }}</h3>
              </el-carousel-item>
            </el-carousel>
          </div>
          <br>
          <div class="toy">
            <span>玩具</span>
            <el-carousel height="150px">
              <el-carousel-item v-for="item in 3" :key="item">
                <h3 class="small">{{ item }}</h3>
              </el-carousel-item>
            </el-carousel>
          </div>
          <br>
          <div class="clothes">
            <span>服饰</span>
            <el-carousel height="150px">
              <el-carousel-item v-for="item in 3" :key="item">
                <h3 class="small">{{ item }}</h3>
              </el-carousel-item>
            </el-carousel>
          </div>
        </div>
      </div>
    </el-main>
  </div>
</template>
  
<script>
export default {
  name: "myUser",
  data() {
    return {
      src: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
    };
  },
};
</script>
   
  <style lang="less" scoped></style>
<style scoped>
.image {
  width: 190px;
  height: 160px;
}

.display>.el-col {
  display: flex;
  justify-content: space-around;
  margin-top: 15px;
}

.card {
  width: 230px;
  height: 250px;
}

.card:hover {
  box-shadow: 0 0 6px 3px rgb(247, 242, 242);
}

.shopping>div>span {
  font-size: large;
  font-weight: bold;
}

.shopping>p {
  font-size: x-large;
  font-weight: bolder;
  margin-bottom: 5px;
}

.content {
  display: flex;
  flex-flow: row nowrap;
  height: 630px;
  width: 1145px;
  justify-content: space-between;
  position: absolute;
  right: 20px;
}

.search {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}

.spc_search {
  height: 50px;
  width: 550px;
  background-color: rgba(198, 194, 194, 0.736);
  border-radius: 30px;
}

.spc_search>input {
  border: none;
  border-bottom: 3px solid rgb(137, 136, 136);
  background-color: transparent;
  outline: none;
  height: 40px;
  width: 450px;
  position: absolute;
  left: 30px;
  font-size: larger;
  line-height: 40px;
}

.spc_search>.el-button {
  font-size: larger;
  font-weight: bold;
  border: none;
  position: absolute;
  right: 597px;
  top: 10px;
}

.spc_search>.el-button:hover {
  background-color: rgba(198, 194, 194, 0.736);
  color: rgb(165, 42, 42);
  box-shadow: 3px 3px 5px inset grey;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
  align-items: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.shopping {
  height: 630px;
  width: 300px;
  background-color: rgba(198, 194, 194, 0.736);
  border-radius: 20px;
  overflow: hidden;
}

.display {
  height: 550px;
  width: 800px;
  background-color: rgba(198, 194, 194, 0.736);
  border-radius: 20px
}

.tac {
  width: 400px;
}

.msg {
  display: inline-block;
  font-size: x-large;
}

.logo {
  height: 125px;
  width: 125px;
  background: url(@/assets/img/logo.png) no-repeat center center;
  position: relative;
  top: 10px;
  left: 30px;
}


.el-header>span {
  font-size: 18px;
}

.el-aside {
  color: #333;
}

/* 111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111 */
.el-row {
  margin-bottom: 20px;

  &:last-child {
    margin-bottom: 0;
  }
}

.el-col {
  border-radius: 4px;
}

.bg-purple-dark {
  background: #99a9bf;
}

.bg-purple {
  background: #d3dce6;
}

.bg-purple-light {
  background: #e5e9f2;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>
-->
<template>
  <div>
    <el-main>
      <div class="content">
        <div class="search">
          <div class="spc_search">
            <input type="text" placeholder="请输入要搜索的关键词">
            <el-button icon="el-icon-search" circle></el-button>
          </div>
          <div class="display">
            <el-col :span="8" v-for="(o,index) in 6" :key="o">
              <el-card class="card">
                <!-- <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                  class="image"> -->
                <el-col :span="6">
                  <div class="grid-content">
                    <el-image :src="src" @click="$router.push('/layout/info')" class="image"></el-image>
                    <div class="title">喵喵喵</div>
                    <div class="color">银渐层</div>
                  </div>
                </el-col>
                <div style="padding: 14px;">
                  <span>好吃的汉堡</span>
                  <div class="bottom clearfix">
                    xxxxxxxxxx
                  </div>
                </div>
              </el-card>
            </el-col>
          </div>
        </div>
        <div class="shopping">
          <p>商品</p>
          <div class="food">
            <span>猫粮</span>
            <el-carousel height="150px">
              <el-carousel-item v-for="item in 3" :key="item">
                <h3 class="small">{{ item }}</h3>
              </el-carousel-item>
            </el-carousel>
          </div>
          <br>
          <div class="toy">
            <span>玩具</span>
            <el-carousel height="150px">
              <el-carousel-item v-for="item in 3" :key="item">
                <h3 class="small">{{ item }}</h3>
              </el-carousel-item>
            </el-carousel>
          </div>
          <br>
          <div class="clothes">
            <span>服饰</span>
            <el-carousel height="150px">
              <el-carousel-item v-for="item in 3" :key="item">
                <h3 class="small">{{ item }}</h3>
              </el-carousel-item>
            </el-carousel>
          </div>
        </div>
      </div>
    </el-main>
  </div>
</template>
<script>
export default {
  name: "myUser",
  data() {
    return {
      src: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
    };
  },
};
</script>

  
  <!-- <style lang="less" scoped></style> -->
<style scoped>
.image {
  width: 190px;
  height: 160px;
}

.display>.el-col {
  display: flex;
  justify-content: space-around;
  margin-top: 15px;
}

.card {
  width: 230px;
  height: 250px;
}

.card:hover {
  box-shadow: 0 0 6px 3px rgb(247, 242, 242);
}

.shopping>div>span {
  font-size: large;
  font-weight: bold;
}

.shopping>p {
  font-size: x-large;
  font-weight: bolder;
  margin-bottom: 5px;
}

.content {
  display: flex;
  flex-flow: row nowrap;
  height: 630px;
  width: 1145px;
  justify-content: space-between;
  position: absolute;
  right: 20px;
}

.search {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}

.spc_search {
  height: 50px;
  width: 550px;
  background-color: rgba(198, 194, 194, 0.736);
  border-radius: 30px;
}

.spc_search>input {
  border: none;
  border-bottom: 3px solid rgb(137, 136, 136);
  background-color: transparent;
  outline: none;
  height: 40px;
  width: 450px;
  position: absolute;
  left: 30px;
  font-size: larger;
  line-height: 40px;
}

.spc_search>.el-button {
  font-size: larger;
  font-weight: bold;
  border: none;
  position: absolute;
  right: 597px;
  top: 10px;
}

.spc_search>.el-button:hover {
  background-color: rgba(198, 194, 194, 0.736);
  color: rgb(165, 42, 42);
  box-shadow: 3px 3px 5px inset grey;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
  align-items: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.shopping {
  height: 630px;
  width: 300px;
  background-color: rgba(198, 194, 194, 0.736);
  border-radius: 20px;
  overflow: hidden;
}

.display {
  height: 550px;
  width: 800px;
  background-color: rgba(198, 194, 194, 0.736);
  border-radius: 20px
}

.tac {
  width: 400px;
}

.msg {
  display: inline-block;
  font-size: x-large;
}

.logo {
  height: 125px;
  width: 125px;
  background: url(@/assets/img/logo.png) no-repeat center center;
  position: relative;
  top: 10px;
  left: 30px;
}


.el-header>span {
  font-size: 18px;
}

.el-aside {
  color: #333;
}
</style>