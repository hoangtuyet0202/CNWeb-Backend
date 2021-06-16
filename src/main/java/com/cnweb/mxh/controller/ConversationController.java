package com.cnweb.mxh.controller;

import com.cnweb.mxh.config.Configuration;
import com.cnweb.mxh.model.Conversation;
import com.cnweb.mxh.model.JsonResult;
import com.cnweb.mxh.service.ConversationService;
import com.cnweb.mxh.service.service_impl.ConversationServiceImpl;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = Configuration.URL_API + "/conversation")
public class ConversationController extends HttpServlet {
    private JsonResult jsonResult = new JsonResult();
    private ConversationService conversationService = new ConversationServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        Conversation conversation = jsonResult.convertObject(new Conversation(), req.getReader());
        conversation = conversationService.insert(conversation);
        result = conversation == null ? jsonResult.jsonFail("Insert conversation fail") : jsonResult.jsonSuccess(conversation);
        resp.getWriter().write(result);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
