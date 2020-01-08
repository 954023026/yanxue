package com.ketai.aliyunoss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *  oss springboot启动类
 **/
@SpringBootApplication
public class AliyunOssApplication {
    public static void main(String [] args){
        SpringApplication.run(AliyunOssApplication.class,args);
    }
}
