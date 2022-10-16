//该文件用于创建整个应用的路由器
import Vue from "vue";
import VueRouter from "vue-router";
import layOut from "../Layout/index";
import myLogin from "@/views/Login";
import myUser from "@/views/User";

//调用Vue.use()函数，把VueRouter安装为Vue的插件
Vue.use(VueRouter);

//创建路由的实例对象
const routes = [
    {
        path: "/",
        redirect: "/layout"
    },
    {
        path: "/layout",
        redirect: "/layout/login",
        component: layOut,
        children: [ 					 // 通过children配置子级路由
            {
                path: 'user',	        // 用户首页
                component: myUser,
                meta: {
                    isShow: true,
                    span: 19
                }
            },
            {
                path: 'info',           //详情页
                component: () => import ('@/views/User/Info.vue'),
                meta: {
                    isShow: true,
                    span: 19
                }
            },
            {
                path: 'apply',              //申请页面
                component: () => import ('@/views/User/Apply.vue'),
                meta: {
                    isShow: true,
                    span: 19
                }
            },
            {
                path: 'register', 		 // 这里是使用懒加载方式导入 注册组件
                component: () => import ('@/views/Register'),
                meta: {
                    isShow: false,
                    span: 24
                }
            },
            {
                path: 'login',	        //这里是登录页面
                component: myLogin,
                meta: {
                    isShow: false,
                    span: 24
                }
            },
            {
                path: 'admin',          //后台页面
                component: () => import ('@/views/Admin'),
                redirect: "/layout/admin/catdb",
                meta: {
                    isShow: false,
                    span: 24
                },
                children: [
                    {
                        path: 'catdb',
                        component: () => import ('@/views/Admin/catDb.vue'),
                    },
                    {
                        path: 'applydb',
                        component: () => import ('@/views/Admin/applyDb.vue')
                    },
                    {
                        path: 'addcat',             //添加猫猫界面
                        component: () => import ('@/views/Admin/addCat.vue'),
                    },
                ]
            },
            {
                path: 'like',	        //这里是收藏页面
                component: () => import ('@/views/User/Like.vue'),
                meta: {
                    isShow: true,
                    span: 19
                }
            },
            {
                path: 'mine',              //我的页面
                component: () => import ('@/views/User/Mine.vue'),
                meta: {
                    isShow: true,
                    span: 19,
                    needLogin: true
                }
            },
            {
                path: 'daily',              //圈子页面
                component: () => import ('@/views/User/Daily.vue'),
                meta: {
                    isShow: true,
                    span: 19
                }
            },
            {
                path: 'applyInfo',          //显示申请表具体信息界面
                component: () => import ('@/views/User/applyInfo.vue'),
                meta: {
                    isShow: true,
                    span: 19
                }
            }
        ]
    }

]

const router = new VueRouter({
    routes
})
// // 无需验证token的页面，加入到白名单
// const whiteList = ['/layout/login','/layout/register','/layout/info','/layout/user','/layout/daily']

// // 编写需要验证的路由的方法
// router.beforeEach()

export default router;

//向外共享路由的实例对象
