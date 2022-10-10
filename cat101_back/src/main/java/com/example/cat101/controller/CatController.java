package com.example.cat101.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cat101.common.Result;
import com.example.cat101.entity.Adopt;
import com.example.cat101.entity.Cat;
import com.example.cat101.entity.Gather;
import com.example.cat101.service.IAdoptService;
import com.example.cat101.service.ICatService;
import com.example.cat101.service.IGatherService;
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
@RequestMapping("/cat")
public class CatController {

    @Resource
    private ICatService catService;

    @Resource
    private IAdoptService adoptService;

    @Resource
    private IGatherService gatherService;

    // 新增或者更新
    @PostMapping("/save")
    public Result save(@RequestBody Cat cat) {
        catService.saveOrUpdate(cat);
        return Result.success();
    }

    @DeleteMapping("/{cid}")
    public Result delete(@PathVariable Integer cid) {
        catService.removeById(cid);
        QueryWrapper<Gather> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("Cid", cid);
        gatherService.remove(queryWrapper1);
        QueryWrapper<Adopt> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("Cid", cid);
        adoptService.remove(queryWrapper2);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        catService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(catService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(catService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize) {
        QueryWrapper<Cat> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("Cid");
        return Result.success(catService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

}

