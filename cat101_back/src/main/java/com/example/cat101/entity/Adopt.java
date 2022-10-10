package com.example.cat101.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
public class Adopt implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Aid", type = IdType.AUTO)
    private Integer aid;

    private Integer uid;

    private Integer cid;

    private String ainfo;


}
