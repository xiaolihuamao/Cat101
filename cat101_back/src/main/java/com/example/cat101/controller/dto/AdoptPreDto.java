package com.example.cat101.controller.dto;

import lombok.Data;

@Data
public class AdoptPreDto {
    private Integer aid;

    private Integer uid;

    private Integer cid;

    private String ainfo;

    private String cname;

    private String ccolor;

    private String curl;

    private String cinfo;

    private Integer cisadopt;

    private String uname;//账号

    private String upwd;//密码

    private String uxname;//用户名

    private String usex;//性别

    private String utel;//电话

    private String usite;//地址

    private Integer utype;//角色类型，0是用户

    private String usrl;//头像地址

    private String uinfo;//信息介绍
}
