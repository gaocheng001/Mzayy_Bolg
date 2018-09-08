package cn.mzayy.blog.blogredis;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogRedisApplication.class, args);
        Main.main(args);
    }
}
