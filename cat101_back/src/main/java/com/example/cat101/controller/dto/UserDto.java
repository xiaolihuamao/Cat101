package com.example.cat101.controller.dto;

import lombok.Data;

@Data
public class UserDto {
    private  Integer uid;
    private String uname;
    private String upwd;
    private String uxname;
    private String usex;
    private String utel;
    private String usite;
    private Integer utype;//
    private String token;//
}
