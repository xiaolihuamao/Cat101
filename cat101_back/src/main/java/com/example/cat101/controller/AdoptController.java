package com.example.cat101.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cat101.common.Result;
import com.example.cat101.controller.dto.AdoptPreDto;
import com.example.cat101.entity.Adopt;
import com.example.cat101.service.IAdoptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author redred
 * @since 2022-10-02
 */
@RestController
@RequestMapping("/adopt")
public class AdoptController {

    @Resource
    private IAdoptService adoptService;

    // 新增或者更新
    @PostMapping("/save")
    public Result save(@RequestBody Adopt adopt) {
        adoptService.saveOrUpdate(adopt);
        return Result.success();
    }
//删除领养信息
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        adoptService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        adoptService.removeByIds(ids);
        return Result.success();
    }
//根据用户获取所有领养信息，前台展示自己的领养列表
    @GetMapping("/{uid}")
    public Result findAll(@PathVariable Integer uid) {
        List<AdoptPreDto> list = adoptService.searchAll(uid);
        return Result.success(list);
    }
//获取所有领养信息
    @GetMapping("/find")
    public Result findAdopt(){
        List<AdoptPreDto>list=adoptService.find();
        return Result.success(list);
    }
//获取单个猫猫的领养信息
    @GetMapping("/detail/{aid}")
    public Result findOne(@PathVariable Integer aid) {
        return Result.success(adoptService.searchByAid(aid));
    }
//分页查询
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize) {
        QueryWrapper<Adopt> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("Aid");
        return Result.success(adoptService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }



}

