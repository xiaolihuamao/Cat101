"use strict";(self["webpackChunkcat101_pre"]=self["webpackChunkcat101_pre"]||[]).push([[433],{433:function(l,e,t){t.r(e),t.d(e,{default:function(){return m}});var i=function(){var l=this,e=l._self._c;return e("div",[e("el-button",{staticClass:"add",attrs:{type:"warning"},on:{click:function(e){l.dialogFormVisible=!0}}},[l._v("点击新增猫数据")]),e("el-dialog",{attrs:{title:"新增猫数据",visible:l.dialogFormVisible},on:{"update:visible":function(e){l.dialogFormVisible=e}}},[e("el-form",{attrs:{model:l.form}},[e("el-form-item",{attrs:{label:"猫昵称","label-width":l.formLabelWidth}},[e("el-input",{attrs:{autocomplete:"off"},model:{value:l.form.cname,callback:function(e){l.$set(l.form,"cname",e)},expression:"form.cname"}})],1),e("el-form-item",{attrs:{label:"猫花色","label-width":l.formLabelWidth}},[e("el-input",{attrs:{autocomplete:"off"},model:{value:l.form.ccolor,callback:function(e){l.$set(l.form,"ccolor",e)},expression:"form.ccolor"}})],1),e("el-form-item",{attrs:{label:"描述信息","label-width":l.formLabelWidth}},[e("el-input",{attrs:{autocomplete:"off"},model:{value:l.form.cinfo,callback:function(e){l.$set(l.form,"cinfo",e)},expression:"form.cinfo"}})],1),e("el-form-item",{attrs:{label:"上传图片",prop:"imageUrl"}},[e("el-upload",{attrs:{action:"http://39.105.141.55:8082/file/upload","list-type":"picture-card","on-preview":l.handlePictureCardPreview,"on-success":l.handleAvatarSuccess,"on-remove":l.handleRemove}},[e("i",{staticClass:"el-icon-plus"})]),e("el-dialog",{attrs:{visible:l.dialogVisible},on:{"update:visible":function(e){l.dialogVisible=e}}},[e("img",{attrs:{width:"100%",src:l.dialogImageUrl,alt:""}})])],1),e("el-dialog",{attrs:{visible:l.dialogVisible},on:{"update:visible":function(e){l.dialogVisible=e}}},[e("img",{attrs:{width:"100%",src:l.dialogImageUrl,alt:""}})])],1),e("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:function(e){l.dialogFormVisible=!1}}},[l._v("取 消")]),e("el-button",{attrs:{type:"primary"},on:{click:function(e){return l.submitCat(l.form)}}},[l._v("确 定")])],1)],1)],1)},o=[],a=(t(7658),t(586)),s={data(){return{dialogImageUrl:"",dialogVisible:!1,dialogTableVisible:!1,dialogFormVisible:!1,form:{cname:"",ccolor:"",cinfo:"",curl:"",cisadopt:0},formLabelWidth:"120px",json:"",isDisabled:!1}},methods:{handleAvatarSuccess(l,e){console.log(l),this.form.curl=l},handleRemove(l,e){console.log(l,e)},handlePictureCardPreview(l){this.dialogImageUrl=l.url,this.dialogVisible=!0,console.log(l.url)},submitCat:async function(){this.json=JSON.stringify(this.form),await(0,a.gY)(this.json),this.$message.success("猫咪添加成功！！"),this.$router.push("/layout/admin/catDb")}}},r=s,n=t(1001),c=(0,n.Z)(r,i,o,!1,null,null,null),m=c.exports}}]);
//# sourceMappingURL=433.d9fde6f6.js.map