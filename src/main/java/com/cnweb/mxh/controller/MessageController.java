package com.cnweb.mxh.controller;

import com.cnweb.mxh.config.Configuration;
import com.cnweb.mxh.model.JsonResult;
import com.cnweb.mxh.model.Message;
import com.cnweb.mxh.service.MessageService;
import com.cnweb.mxh.service.service_impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = Configuration.URL_API + "/message")
public class MessageController extends HttpServlet {
    private JsonResult jsonResult = new JsonResult();
    private MessageService messageService = new MessageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        List<Message> messages = messageService.findAll();
        result = messages.size() > 0 ? jsonResult.jsonSuccess(messages) : jsonResult.jsonFail("Don't have any message");
        resp.getWriter().write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        Message message = jsonResult.convertObject(new Message(), req.getReader());
        message = messageService.insert(message);
        result = message == null ? jsonResult.jsonFail("Insert message fail") : jsonResult.jsonSuccess(message);
        resp.getWriter().write(result);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
