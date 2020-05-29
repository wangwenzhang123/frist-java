package com.ai.ge;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * spring boot 启动识别注解
 **/
@SpringBootApplication
/** mybatis映射文件依赖扫描注解 **/
@MapperScan({"com.ai.ge.mapper"})
@ServletComponentScan
/** springboot 默认会注入数据源bean，使用下面注解可以在启动时不注入该bean*/
public class App extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }
}


