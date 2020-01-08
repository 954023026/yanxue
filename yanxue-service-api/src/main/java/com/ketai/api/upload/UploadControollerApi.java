package com.ketai.api.upload;

import com.ketai.common.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 **/
@Api(value = "文件管理服务", description = "阿里云文件管理中心")
public interface UploadControollerApi {

    @ApiOperation("图片上传")
    public Result image(
            @ApiParam(name = "file", value = "文件", required = true) MultipartFile file,
            @ApiParam(name = "host", value = "文件上传路径", required = false) String host
    );
}
