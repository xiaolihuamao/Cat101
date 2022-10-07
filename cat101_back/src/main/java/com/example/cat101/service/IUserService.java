package com.example.cat101.service;

import com.example.cat101.common.Result;
import com.example.cat101.controller.dto.UserDto;
import com.example.cat101.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author redred
 * @since 2022-10-02
 */
public interface IUserService extends IService<User> {
    UserDto login(UserDto userDto);

    User register(UserDto userDTO);

}
