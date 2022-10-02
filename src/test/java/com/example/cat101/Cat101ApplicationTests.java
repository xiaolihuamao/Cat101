package com.example.cat101;

import com.example.cat101.controller.CatController;
import com.example.cat101.entity.Cat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Cat101ApplicationTests {
    @Resource
    CatController catController;
    @Test
    void contextLoads() {
        catController.save(new Cat(1,"小紫","黄色","d:/files","可爱的小猫",1));
    }

}
