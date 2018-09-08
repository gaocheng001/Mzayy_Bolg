package cn.mzayy.blog.web.sso.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
public class BlogWebSsoApplication {

    public static void main(String[] args) {
        System.out.println("3331111");
        SpringApplication.run(BlogWebSsoApplication.class, args);
        System.out.println("124124124");
    }

}

@Configuration
class SessionConfiguraction implements WebMvcConfigurer {
    //配置拦截器
    public void addInterceptors(InterceptorRegistry registry){
        System.out.println("bbbbbbbbbbbbbb");
        //registry.addInterceptor此方法添加拦截器
        registry.addInterceptor(new SessionIntercept()).addPathPatterns("/**");
    }
}