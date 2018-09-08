package cn.mzayy.blog.web.sso.web;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionIntercept implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws  Exception{
        System.out.println("aavbasdfasd");
        System.out.println(request.getRequestURI());
        if (request.getRequestURI().equals("/city/login")||request.getRequestURI().equals("/user/login_view")){
            return true;
        }
        Object obj = request.getSession().getAttribute("session_user");
        if (obj == null){
            response.sendRedirect("/user/login_view");
            return  false;
        }
        return true;
    }
}
