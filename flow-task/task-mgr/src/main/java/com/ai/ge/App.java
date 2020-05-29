package com.ai.ge;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * spring boot 启动识别注解
 **/
@SpringBootApplication
/** mybatis映射文件依赖扫描注解 **/
@MapperScan({"com.al.ec.common",  "com.al.ec.dao"})
/** springboot 默认会注入数据源bean，使用下面注解可以在启动时不注入该bean*/
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//取消spring security的认证
//@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
/**
 * 启动找不到页面问题：资源文件最好是用 working directory 的相关路径，或者用主流操作系统都支持的用户路径。
 */
public class App extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }
}

