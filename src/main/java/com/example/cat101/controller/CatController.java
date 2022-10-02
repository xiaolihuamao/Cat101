package com.example.cat101.controller;


import com.example.cat101.entity.Cat;
import com.example.cat101.service.ICatService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    ICatService catService;

    public boolean save(Cat cat) {
        if (cat.getCid() == null) {
            return catService.save(cat);
        }
        return catService.updateById(cat);
    }
}

