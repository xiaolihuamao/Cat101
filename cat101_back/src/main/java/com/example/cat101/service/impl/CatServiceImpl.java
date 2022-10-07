package com.example.cat101.service.impl;

import com.example.cat101.entity.Cat;
import com.example.cat101.mapper.CatMapper;
import com.example.cat101.service.ICatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author redred
 * @since 2022-10-02
 */
@Service
public class CatServiceImpl extends ServiceImpl<CatMapper, Cat> implements ICatService {

}
