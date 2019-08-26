package com.lxh;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


//当使用通用mapper时，使用 tk.mybatis.spring.annotation.MapperScan; 进行扫描
//当使用普通mapper时，使用 org.springframework.boot.autoconfigure.SpringBootApplication;进行扫描
@SpringBootApplication
@MapperScan("com.lxh.dao")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
