package com.cnweb.mxh.filter;

import com.cnweb.mxh.config.Configuration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(value = Configuration.URL_API + "/*")
public class ApiFilter extends HttpFilter {

    // All responses of api is json type
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        res.setContentType("application/json;charset=utf-8");
        chain.doFilter(req, res);
    }

}
