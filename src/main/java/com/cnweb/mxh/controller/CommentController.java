package com.cnweb.mxh.controller;

import com.cnweb.mxh.config.Configuration;
import com.cnweb.mxh.model.Comment;
import com.cnweb.mxh.model.JsonResult;
import com.cnweb.mxh.service.CommentService;
import com.cnweb.mxh.service.service_impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = Configuration.URL_API + "/comment")
public class CommentController extends HttpServlet {
    private JsonResult jsonResult = new JsonResult();
    private CommentService commentService = new CommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        List<Comment> comments = commentService.findAll();
        result = comments.size() > 0 ? jsonResult.jsonSuccess(comments) : jsonResult.jsonFail("Don't have any comment");
        resp.getWriter().write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        Comment comment = jsonResult.convertObject(new Comment(), req.getReader());
        comment = commentService.insert(comment);
        result = comment == null ? jsonResult.jsonFail("Insert comment fail") : jsonResult.jsonSuccess(comment);
        resp.getWriter().write(result);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        Comment comment = jsonResult.convertObject(new Comment(), req.getReader());
        comment = commentService.update(comment);
        result = comment == null ? jsonResult.jsonFail("Update comment fail") : jsonResult.jsonSuccess(comment);
        resp.getWriter().write(result);
    }
}
