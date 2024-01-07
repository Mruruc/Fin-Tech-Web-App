package com.mruruc.filters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Enumeration;

public class LogRequestWrapper extends HttpServletRequestWrapper {
    public static final Logger log= LogManager.getLogger(LogRequestWrapper.class);

    public LogRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    protected void logHeaders(){
        Enumeration<String> headerNames = super.getHeaderNames();
        log.info("==============Request Header==============");
        System.out.println();
        while (headerNames.hasMoreElements()){
            String header = headerNames.nextElement();
            String headerValue = super.getHeader(header);
            log.info(header +" : " + headerValue);
        }
        log.info("============================================");
    }
}











