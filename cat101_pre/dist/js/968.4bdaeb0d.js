"use strict";(self["webpackChunkcat101_pre"]=self["webpackChunkcat101_pre"]||[]).push([[968],{1968:function(t,a,s){s.r(a),s.d(a,{default:function(){return d}});var e=function(){var t=this,a=t._self._c;return a("div",[a("el-row",{attrs:{gutter:20}},t._l(t.catsALL,(function(s){return a("div",{key:s.cid},[a("el-col",{attrs:{span:5}},[a("div",{staticClass:"grid-content"},[a("el-image",{attrs:{src:t.src},on:{click:function(a){return t.turnInto(s.cid)}}}),a("div",{staticClass:"title"},[t._v(t._s(s.cname))]),a("div",{staticClass:"color"},[t._v(t._s(s.ccolor))]),a("div",{staticClass:"content"},[t._v(t._s(s.cinfo))])],1)])],1)})),0)],1)},c=[],n=(s(7658),s(586)),r={name:"myUser",data(){return{src:"https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",catNum:0,catsALL:[]}},methods:{indexs:async function(){const{data:t}=await(0,n.rI)(JSON.parse(localStorage.getItem("user")).uid);"200"===t.code?(this.catNum=t.data.length,this.catsALL=t.data):this.$message.error(t.msg)},async turnInto(t){const{data:a}=await(0,n.Zf)(t);"200"===a.code?(localStorage.setItem("cat",JSON.stringify(a.data)),this.$router.push("/layout/info")):this.$message.error(a.msg)}},created:async function(t){this.indexs()}},i=r,o=s(1001),u=(0,o.Z)(i,e,c,!1,null,"282fc39c",null),d=u.exports}}]);
//# sourceMappingURL=968.4bdaeb0d.js.map