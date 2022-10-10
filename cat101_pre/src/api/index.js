// 封装接口方法
import request from "@/utils/request";   //引入自定义的axios函数




//注册请求 接口，定义注册按钮点击后，向后端发送请求的函数，参数是表单提交的数据

//登录请求接口，定义注册按钮点击后，向后端发送请求的函数，参数是表单提交的数据

/**
 *
 * @param {*} Uname
 * @param {*} Upwd
 * @param {*} Uxname
 * @param {*} Usex
 * @param {*} Utel
 * @param {*} Usite
 * @param {*} Utype
 * @param {*} Usrl
 * @param {*} Uinfo
 * @returns
 */
//  JSON.stringify({ uname, upwd, uxname,usex,utel,usite,utype })
export const registerAPI = (json) => {     //,usrl,uinfo
    return request({
        // headers: {
        //     'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        //   },
        url: '/user/register',       //注册接口地址：以向该接口发送注册表单的数据，放入用户信息表获得返回结果           跟后端沟通！！！！！！！
        method: 'POST',
        data: json,


        // header:{
        //     'Content-Type':'application/json'  //如果写成contentType会报错
        // }


    })
}
//登录请求 接口，定义登录按钮点击后，向后端发送请求的函数，参数是表单提交的数据
/**
 *
 * @param {*} Uname
 * @param {*} Upwd
 * @param {*} Utype
 * @returns 返回一个promise对象
 */

export const loginAPI = (json) => {

    return request ({
        url:'/user/login',     //登录接口地址：以向该接口发送登录表单的数据，与用户信息表比较然后返回结果      跟后端沟通！！！！！！！
        method: 'POST',
        data: json,
    })
}

//  猫数据查询接口
export const catAPI =() => {
    return request ({
        url:'/cat',
        method: 'GET'
})
}
// 猫数据增加接口
export const addcatAPI =(json) => {
    return request ({
        url:'/cat/save',
        method: 'POST',
        data: json,
})
}
//提交图片接口
// export const uploadImg =(formData) => {
//     return request ({
//         url:'/file/upload',
//         method: 'POST',
//         data: formData,
//         headers: {'Content-Type': 'multipart/form-data'},
// })
// }


//领养申请接口，定义申请领养按钮点击后，向后端发送请求的函数，参数是表单提交的数据
/**
 *
 * @param {*} uid
 * @param {*} cid
 * @param {*} ainfo
 * @returns 返回一个promise对象
 */
//添加申请
export const saveAPI = (json) => {
    return request({
        url: '/adopt/save',     //登录接口地址：以向该接口发送登录表单的数据，与用户信息表比较然后返回结果      跟后端沟通！！！！！！！
        method: 'POST',
        data: json
    })
}
//更新猫咪信息
export const updateCatAPI = (json) => {
    return request({
        url: '/cat/save',     //登录接口地址：以向该接口发送登录表单的数据，与用户信息表比较然后返回结果      跟后端沟通！！！！！！！
        method: 'POST',
        data: json
    })
}
//查找所有猫猫
export const searchAPI = () => {
    return request({
        url: '/cat',     //登录接口地址：以向该接口发送登录表单的数据，与用户信息表比较然后返回结果      跟后端沟通！！！！！！！
        method: 'GET',
    })
}
//查找某只猫猫信息
export const catInfoAPI = (cid) => {
    return request({
        url: '/cat/'+cid,
        method: 'GET',
    })
}
//用户收藏
export const starAPI = (json) => {
    return request({
        url: '/gather/save',
        method: 'POST',
        data: json
    })
}
//显示用户的所有收藏信息
export const showStarAPI = (uid) => {
    return request({
        url: '/gather/'+uid,
        method: 'GET'
    })
}
//后台显示所有领养信息
export const adoptBackAPI = () => {
    return request({
        url: '/adopt',
        method: 'GET'
    })
}
//用户的所有领养猫咪
export const mineAPI = (uid) => {
    return request({
        url: '/adopt/'+uid,
        method: 'GET'
    })
}
//用户的所有申请信息
export const applyInfoAPI = (uid) => {
    return request({
        url: '/adopt/detail/'+uid,
        method: 'GET'
    })
}

//删除申请
export const deleteApplyAPI = (aid) => {
    return request({
        url: '/adopt/'+aid,
        method: 'DELETE'
    })
}
//删除猫咪
export const deleteCatAPI = (cid) => {
    return request({
        url: '/cat/'+cid,
        method: 'DELETE'
    })
}

