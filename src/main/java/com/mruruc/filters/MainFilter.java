package com.mruruc.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(
        filterName = "LoggingFilter",
        urlPatterns = "/*"
)
public class MainFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;

        var reqWrapper=new LogRequestWrapper(request);
        reqWrapper.logHeaders();

        var responseSetting=new ResponseSetting(response);
        responseSetting.setResponseHeader();

        filterChain.doFilter(reqWrapper,response);
    }
}
