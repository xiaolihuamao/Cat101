
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
export const registerAPI = ({ Uname, Upwd, Uxname,Usex,Utel,Usite,Utype,Usrl,Uinfo }) => {
    return request({
        url: '',       //注册接口地址：以向该接口发送注册表单的数据，放入用户信息表获得返回结果           跟后端沟通！！！！！！！
        method: 'POST',
        data: {
            Uname, 
            Upwd,
            Uxname,
            Usex,
            Utel,
            Usite,
            Utype,
            Usrl,
            Uinfo
        }
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

export const loginAPI = ({} ) => {
export const loginAPI = ({} ) => {
    return request ({
        url:'',     //登录接口地址：以向该接口发送登录表单的数据，与用户信息表比较然后返回结果      跟后端沟通！！！！！！！
        method: 'POST', 
        data: {
            Uname,
            Upwd,
            Utype
        }
    })
}

