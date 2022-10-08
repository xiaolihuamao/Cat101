// 封装接口方法
import request from "@/utils/request";   //引入自定义的axios函数


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
//登录请求接口，定义登录按钮点击后，向后端发送请求的函数，参数是表单提交的数据
/**
 *
 * @param {*} Uname
 * @param {*} Upwd
 * @param {*} Utype
 * @returns 返回一个promise对象
 */

export const loginAPI = (json) => {
    return request({
        url: '/user/login',     //登录接口地址：以向该接口发送登录表单的数据，与用户信息表比较然后返回结果      跟后端沟通！！！！！！！
        method: 'POST',
        data: json
    })
}

//领养申请接口，定义申请领养按钮点击后，向后端发送请求的函数，参数是表单提交的数据
/**
 *
 * @param {*} uid
 * @param {*} cid
 * @param {*} ainfo
 * @returns 返回一个promise对象
 */

export const saveAPI = (json) => {
    return request({
        url: '/adopt/save',     //登录接口地址：以向该接口发送登录表单的数据，与用户信息表比较然后返回结果      跟后端沟通！！！！！！！
        method: 'POST',
        data: json
    })
}

export const updateCatAPI = (json) => {
    return request({
        url: '/cat/save',     //登录接口地址：以向该接口发送登录表单的数据，与用户信息表比较然后返回结果      跟后端沟通！！！！！！！
        method: 'POST',
        data: json
    })
}

export const searchAPI = () => {
    return request({
        url: '/cat',     //登录接口地址：以向该接口发送登录表单的数据，与用户信息表比较然后返回结果      跟后端沟通！！！！！！！
        method: 'GET',
    })
}

export const catInfoAPI = (id) => {
    return request({
        url: '/cat/'+id,
        method: 'GET',
    })
}

export const starAPI = (json) => {
    return request({
        url: '/gather/save',
        method: 'POST',
        data: json
    })
}

export const showStarAPI = (id) => {
    return request({
        url: '/gather/'+id,
        method: 'GET'
    })
}

export const adoptBackAPI = () => {
    return request({
        url: '/adopt',
        method: 'GET'
    })
}

export const adoptDeleteAPI = (id) => {
    return request({
        url: '/adopt/'+id+'/delete',
        method: 'GET'
    })
}


