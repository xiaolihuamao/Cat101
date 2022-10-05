package com.example.cat101.service.impl;

import com.example.cat101.controller.dto.UserGatherDto;
import com.example.cat101.entity.Cat;
import com.example.cat101.entity.Gather;
import com.example.cat101.mapper.GatherMapper;
import com.example.cat101.service.IGatherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class GatherServiceImpl extends ServiceImpl<GatherMapper, Gather> implements IGatherService {
    @Resource
    GatherMapper gatherMapper;

    @Override
    public List<UserGatherDto> search(Integer uid) {
        return gatherMapper.search(uid);
    }
}
