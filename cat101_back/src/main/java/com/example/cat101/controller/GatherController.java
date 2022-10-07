package com.example.cat101.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cat101.common.Result;
import com.example.cat101.controller.dto.UserGatherDto;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.cat101.service.IGatherService;
import com.example.cat101.entity.Gather;

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
@RequestMapping("/gather")
public class GatherController {

    @Resource
    private IGatherService gatherService;

    // 新增或者更新
    @PostMapping("/save")
    public Result save(@RequestBody Gather gather) {
        Date nowTime=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:sss");
        gather.setGtime(nowTime);
        gatherService.saveOrUpdate(gather);
        return Result.success();
    }
//根据猫咪的cid进行删除收藏表里的猫，单个删除时使用，前端注意发delete请求，传参写在请求行里，url直接写/gather/{待填入的cid}
    @DeleteMapping("/{cid}")
    public Result delete(@PathVariable Integer cid) {
        Map<String,Object> map=new HashMap<>();
        map.put("Cid",cid);
        gatherService.removeByMap(map);
        return Result.success();
    }
//根据用户的uid批量删除，即，删除所有的猫，前端需要传uid。注意是delete请求，注意url和上面的删除不一样，是/gather/del/batch/{待填入的uid}
    @DeleteMapping ("/del/batch/{uid}")
    public Result deleteBatch(@PathVariable Integer uid) {
        Map<String,Object> map=new HashMap<>();
        map.put("Uid",uid);
        gatherService.removeByMap(map);
        return Result.success();
    }
//打开收藏界面就应该发的请求，查询该用户所有收藏信息，返回一个猫的集合,注意要url是/gather/{uid}，
    @GetMapping("/{uid}")
    public Result findAll(@PathVariable Integer uid) {
        List<UserGatherDto>list=gatherService.search(uid);
        long nowTime=new Date().getTime();//获取当前毫秒数
        List<UserGatherDto>listnew= list.stream().map(userGatherDto -> {
            long preTime=userGatherDto.getGtime().getTime();
            int gdays=(int)((nowTime-preTime)/(1000*3600*24));
            userGatherDto.setGDays(gdays);
            return userGatherDto;
        }).collect(Collectors.toList());
        return Result.success(list);
    }
//分页的方法，不重要
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize) {
        QueryWrapper<Gather> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("Gid");
        return Result.success(gatherService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

}

