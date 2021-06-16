package com.cnweb.mxh.controller;

import com.cnweb.mxh.config.Configuration;
import com.cnweb.mxh.model.JsonResult;
import com.cnweb.mxh.model.React;
import com.cnweb.mxh.service.ReactService;
import com.cnweb.mxh.service.service_impl.ReactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = Configuration.URL_API + "/react")
public class ReactController extends HttpServlet {
    private JsonResult jsonResult = new JsonResult();
    private ReactService reactService = new ReactServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        List<React> reacts = reactService.findAll();
        result = reacts.size() > 0 ? jsonResult.jsonSuccess(reacts) : jsonResult.jsonFail("Don't have any react");
        resp.getWriter().write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        React react = jsonResult.convertObject(new React(), req.getReader());
        react = reactService.insert(react);
        result = react == null ? jsonResult.jsonFail("Insert react fail") : jsonResult.jsonSuccess(react);
        resp.getWriter().write(result);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        React react = jsonResult.convertObject(new React(), req.getReader());
        react = reactService.update(react);
        result = react == null ? jsonResult.jsonFail("Update react fail") : jsonResult.jsonSuccess(react);
        resp.getWriter().write(result);
    }
}
