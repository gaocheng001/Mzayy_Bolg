package cn.mzayy.blog.blogweb;

import cn.mzayy.blog.Controller.BlogApplication;
import cn.mzayy.blog.Mapper.BlogDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class BlogWebApplicationTests {

    @Resource
    private BlogDemo blogDemo;

    @Test
    public void contextLoads() {
        blogDemo.AddNote("aa");
    }

}
