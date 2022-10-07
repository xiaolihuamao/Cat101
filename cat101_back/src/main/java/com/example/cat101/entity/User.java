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
      private Integer uid;//用户编号

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
