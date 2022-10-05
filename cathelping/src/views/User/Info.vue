<template>
    <div>
      Info.vue
      <el-image :src="src" @click="$router.push('/layout/info')"></el-image>
      <el-button type="warning" plain @click="$router.push('/layout/apply')">申请领养</el-button>
    </div>
</template>
  
  <script>
  export default {
    name: 'myInfo',
    data() {
    return {
      src: "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
    };
  },
};
  </script>
  
  <!-- <style lang="less" scoped></style> -->
  <style scoped></style>
 