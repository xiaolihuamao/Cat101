package com.example.cat101.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cat101.controller.dto.AdoptPreDto;
import com.example.cat101.entity.Adopt;
import com.example.cat101.mapper.AdoptMapper;
import com.example.cat101.service.IAdoptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author redred
 * @since 2022-10-02
 */
@Service
public class AdoptServiceImpl extends ServiceImpl<AdoptMapper, Adopt> implements IAdoptService {
    @Resource
    AdoptMapper adoptMapper;

    @Override
    public List<AdoptPreDto> searchAll(Integer uid) {
        return adoptMapper.searchAll(uid);
    }

    @Override
    public AdoptPreDto searchByAid(Integer aid) {
        return adoptMapper.searchByAid(aid);
    }
}
