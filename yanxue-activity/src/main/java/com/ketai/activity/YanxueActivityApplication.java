package com.ketai.activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableDiscoveryClient
@ComponentScan(basePackages={"com.ketai.api.**","com.ketai.activity.**",
        "com.ketai.model.domain"})//扫描接口
public class YanxueActivityApplication {
    public static void main(String[] args) {
        SpringApplication.run(YanxueActivityApplication.class, args);
    }
}
