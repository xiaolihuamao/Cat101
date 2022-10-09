package com.example.cat101.service;

import com.example.cat101.controller.dto.AdoptPreDto;
import com.example.cat101.entity.Adopt;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author redred
 * @since 2022-10-02
 */
public interface IAdoptService extends IService<Adopt> {

    List<AdoptPreDto> searchAll(Integer uid);

    AdoptPreDto searchByAid(Integer aid);
}
