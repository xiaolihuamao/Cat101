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

  public User(Integer uid, String uname, String upwd, String uxname, String usex, String utel, String usite, Integer utype, String usrl, String uinfo) {
    this.uid = uid;
    this.uname = uname;
    this.upwd = upwd;
    this.uxname = uxname;
    this.usex = usex;
    this.utel = utel;
    this.usite = usite;
    this.utype = utype;
    this.usrl = usrl;
    this.uinfo = uinfo;
  }
}
