package com.example.cat101.mapper;

import com.example.cat101.controller.dto.AdoptPreDto;
import com.example.cat101.entity.Adopt;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author redred
 * @since 2022-10-02
 */
public interface AdoptMapper extends BaseMapper<Adopt> {

    List<AdoptPreDto> searchAll(Integer uid);

    AdoptPreDto searchByAid(Integer aid);
}
