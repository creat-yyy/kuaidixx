package com.kuaidixx.kuaidixx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan("com.kuaidixx.kuaidixx.dao")
public class KuaidixxApplication {

    public static void main(String[] args) {
        SpringApplication.run(KuaidixxApplication.class, args);
    }

}
