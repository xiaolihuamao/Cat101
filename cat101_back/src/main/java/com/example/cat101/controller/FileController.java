package com.example.cat101.controller;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

/**
 * 文件上传的接口
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${pictureFile.path}")
    private String picturePath;

    @Value("${pictureFile.path-mapping}")
    private String picturePath_mapping;
//这个写在了配置文件中

    @PostMapping("/upload")
    public String upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        fileName =IdUtil.fastSimpleUUID() + StrUtil.DOT + suffixName;
        File dest = new File(picturePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String final_fileName = "http://localhost:8082" + picturePath_mapping + fileName;
        System.out.println(final_fileName);
        return final_fileName;
    }
}

