package com.example.cat101.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.cat101.controller.dto.UserDto;
import com.example.cat101.entity.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author redred
 * @since 2022-10-02
 */
public interface IUserService extends IService<User> {
    UserDto login(UserDto userDto);

    User register(UserDto userDTO);

}
