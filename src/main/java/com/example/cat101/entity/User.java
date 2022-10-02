package com.example.cat101.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

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
  public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "Uid", type = IdType.AUTO)
      private Integer uid;

    private String uname;

    private String upwd;

    private String uxname;

    private String usex;

    private String utel;

    private String usite;

    private Integer utype;

    private String usrl;

    private String uinfo;


}
