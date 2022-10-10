package com.example.cat101.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.cat101.controller.dto.UserGatherDto;
import com.example.cat101.entity.Gather;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author redred
 * @since 2022-10-02
 */
public interface GatherMapper extends BaseMapper<Gather> {

    List<UserGatherDto> search(Integer uid);
}
