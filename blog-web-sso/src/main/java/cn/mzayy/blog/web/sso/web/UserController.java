package cn.mzayy.blog.web.sso.web;

import cn.mzayy.blog.sso.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {
    @Reference(version = "1.0.0")
    private UserService userService;
    @RequestMapping("/register")
    public String showRegister(){
        return "register.html";
    }
    @RequestMapping("/userRegister")
    public void register(){
        userService.register();
    }
    @RequestMapping("/deleteUser")
    public void deleteUser(){
        userService.deleteUser();
    }
    @RequestMapping("/modifyUser")
    public void modifyUser(){
        userService.modifyUser();
    }
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public void login(HttpServletRequest req,HttpServletResponse res) throws IOException {
        String user=req.getParameter("user");
        String password=req.getParameter("password");
        userService.login(user,password);
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLogin(Model model, String returnUrl){
        System.out.println(model+returnUrl);
        System.out.println("login-V-");
        return "login.html";
    }
    @RequestMapping("/success")
    public void showSuccess(){

    }
    //短信验证
    /*@RequestMapping("/sms")
    public String sendsms(HttpServletResponse res) throws ClientException, IOException, InterruptedException {
        Duanxin.main(null);

        return "login.html";

    }*/


}
