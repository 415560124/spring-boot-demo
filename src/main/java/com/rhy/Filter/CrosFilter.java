package com.rhy.Filter;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: com.rhy.CrosFilter
 * @Version:1.0
 */
@Component
@ServletComponentScan
@WebFilter(filterName = "CrosFilter",urlPatterns = "/*")
public class CrosFilter implements Filter {
    final static org.slf4j.Logger logger =  org.slf4j.LoggerFactory.getLogger(CrosFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String origin = "*";
        if(req.getHeader("Origin")!=null){
            origin = req.getHeader("Origin");
        }
        //跨域
        res.setHeader("Access-Control-Allow-Origin", origin);
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        System.out.println("======================过滤请求======================");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
