package cn.mzayy.blog;

import cn.mzayy.blog.ServiceAPI.BlogService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("cn.mzayy.blog.Service")
@MapperScan("cn.mzayy.blog.Mapper")
@SpringBootApplication
public class BlogServiceAppication {
    public static void main(String[] args) {

        SpringApplication.run(BlogServiceAppication.class, args);

    }
}
