package com.greenhouse.filter;

import com.alibaba.fastjson.JSONObject;

import com.greenhouse.bean.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class InterceptorConfig  implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(InterceptorConfig.class);
    private static final Logger log = LoggerFactory.getLogger(InterceptorConfig.class);

    /**
     * 进入controller层之前拦截请求
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {


        logger.info("----------开始进入请求地址拦截----------");
        HttpSession session = httpServletRequest.getSession();
//        if(!StringUtils.isEmpty(session.getAttribute(BusinessConstant.LOGIN_MANAGER_SESSION_KEY))){
//            return true;
//        }
//        else{
//            sendErrorMessage(httpServletResponse,"请登录");
//            return false;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("--------------处理请求完成后视图渲染之前的处理操作---------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("---------------视图渲染之后的操作-------------------------0");
    }



    private void sendErrorMessage(HttpServletResponse response, String Message) throws Exception{

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(JSONObject.toJSONString( ResponseBean.createNoLogin(Message)));
        out.close();
    }
}