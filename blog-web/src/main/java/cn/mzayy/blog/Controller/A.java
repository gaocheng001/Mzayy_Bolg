package cn.mzayy.blog.Controller;


import com.alibaba.dubbo.config.annotation.Reference;

import com.demo.service.DemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A {
    @Reference
    private DemoService demoService;
    @RequestMapping("/a")
    public String abc(){
        System.out.println(demoService);
        return "a";
    }
}
