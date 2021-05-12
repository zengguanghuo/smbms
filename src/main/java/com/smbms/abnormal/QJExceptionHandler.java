package com.smbms.abnormal;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class QJExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        ModelAndView model=new ModelAndView();
        model.setViewName("500");
        if(e instanceof RuntimeException) {//运行时异常
            model.addObject("error","服务器运行时异常,请稍后重试");
        }else if(e instanceof SQLException){
            model.addObject("error","SQL运行时异常,请稍后重试");
        }else{
            model.addObject("error","出现未知错误,请及时联系客服或工作人员！！！");
        }

        return model;
    }
}
