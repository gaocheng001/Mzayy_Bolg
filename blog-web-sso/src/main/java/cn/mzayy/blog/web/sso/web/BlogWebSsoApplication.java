package cn.mzayy.blog.web.sso.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan("cn.mzayy.blog.web.sso.aop")
@SpringBootApplication
public class BlogWebSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogWebSsoApplication.class, args);
    }
}
