package com.example.cat101.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.cat101.controller.dto.UserGatherDto;
import com.example.cat101.entity.Gather;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author redred
 * @since 2022-10-02
 */
public interface IGatherService extends IService<Gather> {

    List<UserGatherDto> search(Integer uid);
}
