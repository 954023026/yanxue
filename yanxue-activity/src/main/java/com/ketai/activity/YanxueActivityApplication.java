package com.ketai.activity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@MapperScan("com.ketai.activity.**")
@ComponentScan(basePackages={"com.ketai.api.**","com.ketai.activity.**"})//扫描接口
public class YanxueActivityApplication {
    public static void main(String[] args) {
        SpringApplication.run(YanxueActivityApplication.class, args);
    }

}
