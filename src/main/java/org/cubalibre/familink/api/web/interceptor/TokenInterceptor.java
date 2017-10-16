package org.cubalibre.familink.api.web.interceptor;

import org.cubalibre.familink.api.utils.Base64Utils;
import org.cubalibre.familink.api.utils.TokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        boolean isValid = false;

        String token = request.getHeader("Authorization");
        if (token != null || token.isEmpty()) {
            String decodedToken = null;
            try {
                decodedToken = Base64Utils.decode(token);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (TokenUtils.isValidToken(decodedToken)) {
               isValid = true;
            } else {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                isValid = false;
            }
        }
        return isValid;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
    }
}
