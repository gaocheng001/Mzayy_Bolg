package cn.mzayy.blog;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;



@ComponentScan("cn.mzayy.blog.Service")
@MapperScan("cn.mzayy.blog.Mapper")
@SpringBootApplication
public class BlogAppication {


    public static void main(String[] args) {

        SpringApplication.run(BlogAppication.class, args);

    }

}
