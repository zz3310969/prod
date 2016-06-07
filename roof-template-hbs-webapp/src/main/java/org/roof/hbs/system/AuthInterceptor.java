package org.roof.hbs.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AuthInterceptor extends HandlerInterceptorAdapter {

    public static final String GLOBAL_CURRENT_USER = "GLOBAL_CURRENT_USER";
    public static final String GLOBAL_CURRENT_USER_ROLES = "GLOBAL_CURRENT_USER_ROLES";
    public static final String GLOBAL_CURRENT_TEAM = "GLOBAL_CURRENT_TEAM";
    public static final String GLOBAL_CURRENT_ROLE= "GLOBAL_CURRENT_ROLE";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	final String uri = request.getRequestURI();
      
        return super.preHandle(request, response, handler);
    }


    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        //要放在最后一个拦截器
        String uri = request.getRequestURI();
        /**
         * for fix:javax.servlet.ServletException: Cannot expose request attribute 'GLOBAL_CURRENT_USER' because of an existing model object of the same name
         */
    }

    private boolean isNotNeedVerifySession(HttpServletRequest request){
        String uri = request.getRequestURI();
        return true;
    }
}
