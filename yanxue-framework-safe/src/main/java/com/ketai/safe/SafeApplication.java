package com.ketai.safe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.ketai.safe","com.ketai.common"})
public class SafeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SafeApplication.class,args);
    }
}
