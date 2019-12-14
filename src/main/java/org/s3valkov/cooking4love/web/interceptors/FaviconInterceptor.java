package org.s3valkov.cooking4love.web.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class FaviconInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) {

        String favicon = "https://logopond.com/logos/b529d31fbabc8bdab28745fc929c0756.png";

        if (modelAndView != null) {
            modelAndView.addObject("favicon", favicon);
        }
    }
}
