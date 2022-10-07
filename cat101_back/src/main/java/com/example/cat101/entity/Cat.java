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
  public class Cat implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "Cid", type = IdType.AUTO)
      private Integer cid;

    private String cname;

    private String ccolor;

    private String curl;

    private String cinfo;

    private Integer cisadopt;


}
