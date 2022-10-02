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
  public class Adopt implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "Aid", type = IdType.AUTO)
      private Integer aid;

    private Integer uid;

    private Integer cid;

    private String ainfo;

  public Adopt(Integer aid, Integer uid, Integer cid, String ainfo) {
    this.aid = aid;
    this.uid = uid;
    this.cid = cid;
    this.ainfo = ainfo;
  }
}
