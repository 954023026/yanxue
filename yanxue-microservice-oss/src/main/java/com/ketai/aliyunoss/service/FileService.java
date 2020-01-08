package com.ketai.aliyunoss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传服务接口
 **/
public interface FileService {
    /**
     * 文件上传到阿里云
     * @param file
     * @return
     */
    String upload(MultipartFile file);
}
