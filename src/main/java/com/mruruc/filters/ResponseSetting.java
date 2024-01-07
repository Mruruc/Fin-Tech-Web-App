package com.mruruc.filters;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.util.Locale;
public class ResponseSetting extends HttpServletResponseWrapper {
    public ResponseSetting(HttpServletResponse response) {
        super(response);
    }


    protected void setResponseHeader(){
        super.setContentType("text/html");
        super.setLocale(Locale.ENGLISH);
        super.setCharacterEncoding("UTF-8");
        super.setDateHeader("Last-Modified",System.currentTimeMillis());
        super.setDateHeader("Expires",System.currentTimeMillis()+86400000L);
        super.addHeader("Love-Bank","Stay-With-Love");
    }
}
