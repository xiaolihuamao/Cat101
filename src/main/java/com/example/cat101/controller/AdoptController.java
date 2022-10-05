package com.example.cat101.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cat101.common.Result;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.cat101.service.IAdoptService;
import com.example.cat101.entity.Adopt;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
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
    @PostMapping
    public Result save(@RequestBody Adopt adopt) {
        adoptService.saveOrUpdate(adopt);
        return Result.success();
    }

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

    @GetMapping
    public Result findAll() {
        return Result.success(adoptService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(adoptService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize) {
        QueryWrapper<Adopt> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("Aid");
        return Result.success(adoptService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

}

