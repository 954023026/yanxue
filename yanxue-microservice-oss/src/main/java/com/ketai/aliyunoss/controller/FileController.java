package com.ketai.aliyunoss.controller;

import com.ketai.api.upload.UploadControllerApi;
import com.ketai.common.response.Result;
import com.ketai.aliyunoss.service.FileService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * "阿里云文件管理
 **/
@CrossOrigin //跨域
@RestController
@RequestMapping("/upload-controller")
public class FileController implements UploadControllerApi {
    @Autowired
    private FileService fileService;

    @PostMapping("upload")
    @Override
    public Result image(@ApiParam(name = "file", value = "文件", required = true)
                         @RequestParam("file") MultipartFile file,
                         @ApiParam(name = "host", value = "文件上传路径", required = false)
                         @RequestParam(value = "host", required = false) String host) {
        System.out.println("开始图片上传功能。。。");
        System.out.println("host:" + host);
        String uploadUrl = fileService.upload(file);
        //返回对象
        return Result.ok().message("文件上传成功").data(uploadUrl);
    }
}
