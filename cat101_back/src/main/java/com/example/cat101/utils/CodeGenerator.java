package com.example.cat101.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;


public class CodeGenerator {

  //  public static void main(String[] args) {
     //   generate();
//    }

    private static void generate() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/pet_manage?serverTimezone=GMT%2b8", "root", "xxx868336790")
                .globalConfig(builder -> {
                    builder.author("redred") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\IDEA\\Cat101\\Cat101\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.cat101") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\IDEA\\Cat101\\Cat101\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok();

                    builder.controllerBuilder().enableHyphenStyle()  // 开启驼峰转连字符
                            .enableRestStyle();  // 开启生成@RestController 控制器
                    builder.addInclude() // 设置需要生成的表名
                            .addTablePrefix("t_", "sys_"); // 设置过滤表前缀
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
