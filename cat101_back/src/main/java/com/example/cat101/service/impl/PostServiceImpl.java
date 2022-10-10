package com.example.cat101.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cat101.entity.Post;
import com.example.cat101.mapper.PostMapper;
import com.example.cat101.service.IPostService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author redred
 * @since 2022-10-02
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
