package com.example.cat101.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 *
 * </p>
 *
 * @author redred
 * @since 2022-10-02
 */
@Getter
@Setter
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Pid", type = IdType.AUTO)
    private Integer pid;

    private String purl;

    private String pinfo;

    private LocalDate ptime;

    private String psite;

    private Integer pnum;


}
