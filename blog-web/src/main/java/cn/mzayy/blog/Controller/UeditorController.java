package cn.mzayy.blog.Controller;


import cn.mzayy.blog.ServiceAPI.BlogService;
import cn.mzayy.blog.pojo.Blog;
import cn.mzayy.blog.pojo.Result;


import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UeditorController {
    @Reference(version = "1.0.0")
    private BlogService blogService;




    @RequestMapping("/addNote")
    @ResponseBody
    public String AddNote(HttpServletRequest req, HttpServletResponse res) {
        Blog blog=new Blog();

        blog.setTitle(req.getParameter("title"));
        blog.setFenlei(Integer.parseInt(req.getParameter("fenlei")));
        blog.setNote(req.getParameter("note"));
        blog.setDate(new Date(2018,3,1));
        blogService.AddNote(blog);
        return "yes";
    }
    //查找分类，并输出默认第一个分类的内容
    @RequestMapping("/findFenlei")
    @ResponseBody
    public Result Fenlei(HttpServletRequest req,HttpServletResponse res){
        System.out.println("aaa"+blogService);
        Map<Integer,Object> map=blogService.findFenlei();
        System.out.println("bbb");
            List<Map<Integer,Object>> list=new ArrayList<Map<Integer,Object>>();
            list.add(map);
            Result r=new Result();

            r.list=list;
            return r;
    }
    @RequestMapping("/note")
    @ResponseBody
    public String a(HttpServletRequest req,HttpServletResponse res){
        Blog b=new Blog();
        String note=blogService.findNote(Integer.parseInt(req.getParameter("id")));
        return note;

    }
    @RequestMapping("/deleteNote")
    @ResponseBody
    public String DeleteNote(HttpServletRequest req, HttpServletResponse res) {
            System.out.println("删除测试");
            blogService.deleteNote(Integer.parseInt(req.getParameter("id")));
            System.out.println("删除测试1");

        return "a";
    }
    @RequestMapping("/addFenlei")
    @ResponseBody
    public String addFenlei(HttpServletRequest req, HttpServletResponse res) {
        blogService.addFenlei(req.getParameter("fenleiName"));
        return "a";
    }
    @RequestMapping("/deleteFenlei")
    @ResponseBody
    public String deleteFenlei(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("a1aa");
        blogService.deleteFenlei(Integer.parseInt(req.getParameter("id")));
        System.out.println("bbdd");
        return "a";
    }
    @RequestMapping("/findNoteDir")
    @ResponseBody
    public Result findNoteDir(HttpServletRequest req, HttpServletResponse res) {
        System.out.println(Integer.parseInt(req.getParameter("id")));
        List<Blog> list=blogService.findNoteDir(Integer.parseInt(req.getParameter("id")));
        Result r=new Result();

        r.list=list;

        return r;

    }
}
