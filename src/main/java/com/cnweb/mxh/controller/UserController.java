package com.cnweb.mxh.controller;

import com.cnweb.mxh.config.Configuration;
import com.cnweb.mxh.model.JsonResult;
import com.cnweb.mxh.model.User;
import com.cnweb.mxh.service.UserService;
import com.cnweb.mxh.service.service_impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = Configuration.URL_API + "/user")
public class UserController extends HttpServlet {

    private JsonResult jsonResult = new JsonResult();
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        User user = jsonResult.convertObject(new User(), req.getReader());
        user = userService.insert(user);
        result = user == null ? jsonResult.jsonFail("Insert User Fail") : jsonResult.jsonSuccess(user);
        resp.getWriter().write(result);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        User user = jsonResult.convertObject(new User(), req.getReader());
        user = userService.update(user);
        result = user == null ? jsonResult.jsonFail("Update User Fail") : jsonResult.jsonSuccess(user);
        resp.getWriter().write(result);
    }

}
