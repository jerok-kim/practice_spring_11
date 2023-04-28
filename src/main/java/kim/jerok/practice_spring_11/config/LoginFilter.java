package kim.jerok.practice_spring_11.config;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if(req.getParameter("username").equals("ssar")) {
            throw new RuntimeException("username: ssar는 차단되었습니다");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
