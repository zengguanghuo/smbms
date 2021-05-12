package com.smbms.intercepter;

import com.smbms.uiti.Constains;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SystemInterceptor  extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      //如果是登陆界面则放行

        if(request.getRequestURI().contains("login.do")){
            return true;
        }
        HttpSession session = request.getSession();
        //如果用户已登陆,也可放行
        if(session.getAttribute("suser")!=null){
            return true;
        }
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        return false;
    }
}
