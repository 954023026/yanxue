package com.ketai.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class YanxueApiApplicationTests {

    @Test
    void contextLoads() {
        //768798564
        System.out.println("uuid"+UUID.randomUUID().hashCode());
    }
}
