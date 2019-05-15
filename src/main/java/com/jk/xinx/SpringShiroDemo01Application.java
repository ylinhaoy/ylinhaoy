package com.jk.xinx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;




@SpringBootApplication
@MapperScan(value="com.jk.xinx.mapper")
@ComponentScan(value={"com.jk.xinx","com.jk.xinx.service.*"})
public class SpringShiroDemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringShiroDemo01Application.class, args);
    }


}
