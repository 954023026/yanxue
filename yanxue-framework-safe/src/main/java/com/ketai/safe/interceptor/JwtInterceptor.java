package com.ketai.safe.interceptor;

import com.ketai.common.constants.ResultCodeEnum;
import com.ketai.common.exception.ExceptionThrowOut;
import com.ketai.safe.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器判断token是否有效
 */
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取携带请求头中携带的token
        String authHeader = request.getHeader("pin");
        if (authHeader == null) {
            ExceptionThrowOut.cast(ResultCodeEnum.USERUNLOGIN_ERROR);
        }
        /**
         * 验证token是否有有效，无效时抛出异常
         */
        Claims claims = JwtUtil.checkToken(authHeader);
        return true;
    }
}
