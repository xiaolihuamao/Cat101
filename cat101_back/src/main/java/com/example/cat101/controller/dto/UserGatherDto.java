package com.example.cat101.controller.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserGatherDto {
    private Integer uid;
    private Integer cid;
    private String cname;
    private String ccolor;
    private String curl;
    private String cinfo;
    private Integer cisadopt;
    private Date gtime;
    private Integer gDays;
    private Integer gatherNum;

    public UserGatherDto(Integer uid) {
        this.uid = uid;
    }
}
