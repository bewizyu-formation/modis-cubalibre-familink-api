package org.cubalibre.familink.api.web.interceptor;

import org.cubalibre.familink.api.utils.Base64Utils;
import org.cubalibre.familink.api.utils.TokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        boolean isAuthorised = false;

        String requestUri = request.getRequestURI();

        String[] parts = requestUri.split("/");

        if (request.getMethod().equals(RequestMethod.POST.toString()) && (parts[parts.length - 1].equals("user") || parts[parts.length - 1].equals("contact"))) {
            isAuthorised = true;
        } else {
            String token = request.getHeader("Authorization");

            if (token != null && !token.isEmpty()) {
                String decodedToken = null;
                try {
                    decodedToken = Base64Utils.decode(token);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                if (TokenUtils.isValidToken(decodedToken)) {
                    isAuthorised = true;
                } else {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    isAuthorised = false;
                }
            } else {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                isAuthorised = false;
            }
        }
        return isAuthorised;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
    }
}
