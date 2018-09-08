package cn.mzayy.blog.sso.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@MapperScan("cn.mzayy.blog.Mapper")
@Component("cn.mzayy.blog.sso.aop")
@SpringBootApplication
public class BlogSsoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogSsoServiceApplication.class, args);

	}
}
