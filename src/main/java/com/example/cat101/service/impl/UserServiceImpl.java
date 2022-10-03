package com.example.cat101.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.cat101.common.Constants;
import com.example.cat101.common.Result;
import com.example.cat101.controller.dto.UserDto;
import com.example.cat101.entity.User;
import com.example.cat101.exception.ServiceException;
import com.example.cat101.mapper.UserMapper;
import com.example.cat101.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private static final Log LOG = Log.get();

    @Override
    public UserDto login(UserDto userDto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Uname", userDto.getUname());
        queryWrapper.eq("Upwd", userDto.getUpwd());
        User one;
        try {
            one = getOne(queryWrapper);
        } catch (Exception e) {
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        if (one != null) {
            BeanUtil.copyProperties(one, userDto, true);
            return userDto;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    @Override
    public User register(UserDto userDTO) {
        User one=new User();
        BeanUtil.copyProperties(userDTO,one,true);
        save(one);
        return one;
    }
}

