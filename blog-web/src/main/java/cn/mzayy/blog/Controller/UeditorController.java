package cn.mzayy.blog.Controller;


import cn.mzayy.blog.ServiceAPI.BlogService;
import cn.mzayy.blog.pojo.Blog;
import cn.mzayy.blog.pojo.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UeditorController {


        @RequestMapping("/ueditor12")
        public String ueditorIndex() {
            System.out.println("aavv");
            return "controller";
        }

    @RequestMapping("/ueditor")
    public String ueditorIndex(HttpServletRequest req) {
        String path=req.getServletContext().getContextPath();
        String a=System.getProperty("user.dir");
        System.out.println("aa"+a);
        return "controller";
    }
    @RequestMapping("/addNote")
    @ResponseBody
    public String AddNote(HttpServletRequest req, HttpServletResponse res) {
        String note = req.getParameter("note");
        System.out.println("note");
        //blogService.AddNote(note);
        return "yes";
    }
    @RequestMapping("/findNote")
    @ResponseBody
    public Result a(){
        Result<Blog> re=new Result<Blog>();
        Blog b=new Blog();
        b.setNote("aaaaaaaaaaaa");
        re.list.add(b);

        System.out.println(re.list.get(0).getNote());
        return re;

    }
    @RequestMapping("/demo")
    @ResponseBody
    public String ab(){
        Result<Blog> re=new Result<Blog>();
        Blog b=new Blog();
        b.setNote("aaaaaaaaaaaa");
        re.list.add(b);
        System.out.println(re.list.get(0).getNote());
        return "abc";
    }
}
