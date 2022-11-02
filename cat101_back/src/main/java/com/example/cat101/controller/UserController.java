package com.example.cat101.controller;


import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cat101.common.Constants;
import com.example.cat101.common.Result;
import com.example.cat101.controller.dto.UserDto;
import com.example.cat101.entity.User;
import com.example.cat101.service.IUserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;
//eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIiwiZXhwIjoxNjY0ODcxNzI4fQ.foLoQ5ihSURnSxDd_L8Vjtn15_2oR7tm12DMQlJ7cFA
//eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyIiwiZXhwIjoxNjY0ODk1NjAxfQ.seni_MPiZeHfpoUbs6-KX_0hV0qQ39X2efvLNYk3of4

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author redred
 * @since 2022-10-02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @Resource
    private RedisTemplate redisTemplate;
    public static final String USERS_KEY="USERS_FRONT_ALL";
    // 新增或者更新
    @PostMapping("/save")
    public Result save(@RequestBody User user) {
        userService.update();
        userService.saveOrUpdate(user);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        userService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        userService.removeByIds(ids);
        return Result.success();
    }
    @GetMapping
   // @Cacheable(value = "users" ,key = "'findAll'")
    public Result findAll() {
        List<User>list;
        String jsonStr= (String) redisTemplate.opsForValue().get(USERS_KEY);
        if (StrUtil.isBlank(jsonStr)){
            list=userService.list();
            redisTemplate.opsForValue().set(USERS_KEY,JSONUtil.toJsonStr(list),60, TimeUnit.SECONDS);
        }else {
            list=JSONUtil.toBean(jsonStr, new TypeReference<List<User>>() {
            },true);
        }
        return Result.success(list);
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(userService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("Uid");
        return Result.success(userService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserDto userDto) {
        if (StrUtil.isBlank(userDto.getUname()) || StrUtil.isBlank(userDto.getUpwd())) {
            return Result.error(Constants.CODE_400, "参数不足错误");
        }
        UserDto dto = userService.login(userDto);
        return Result.success(dto);
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserDto userDTO) {
        String username = userDTO.getUname();
        String password = userDTO.getUpwd();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            return Result.error(Constants.CODE_400, "参数不足错误");
        }
        return Result.success(userService.register(userDTO));
    }

}

