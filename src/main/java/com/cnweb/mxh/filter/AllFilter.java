package com.cnweb.mxh.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/*")
public class AllFilter extends HttpFilter {

    // Config for all requests and responses

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        HttpServletResponse response = (HttpServletResponse) res;
        // allow access from any other site
        response.setHeader("Access-Control-Allow-Origin", "*");
        chain.doFilter(req, response);
    }
}
