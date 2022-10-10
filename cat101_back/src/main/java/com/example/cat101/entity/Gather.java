package com.example.cat101.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

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
public class Gather implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Gid", type = IdType.AUTO)
    private Integer gid;

    private Integer uid;

    private Integer cid;

    private Integer pid;

    private Integer gnum;

    private Date gtime;


}
