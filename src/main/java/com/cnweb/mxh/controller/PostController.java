package com.cnweb.mxh.controller;

import com.cnweb.mxh.config.Configuration;
import com.cnweb.mxh.model.JsonResult;
import com.cnweb.mxh.model.Post;
import com.cnweb.mxh.service.PostService;
import com.cnweb.mxh.service.service_impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(value = Configuration.URL_API + "/post")
public class PostController extends HttpServlet {
    private JsonResult jsonResult = new JsonResult();
    private PostService postService = new PostServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        List<Post> posts = postService.findAll();
        result = posts.size() > 0 ? jsonResult.jsonSuccess(posts) : jsonResult.jsonFail("Don't have any post");
        resp.getWriter().write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        Post post = jsonResult.convertObject(new Post(), req.getReader());
        post = postService.insert(post);
        result = post == null ? jsonResult.jsonFail("Insert post fail") : jsonResult.jsonSuccess(post);
        resp.getWriter().write(result);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        Post post = jsonResult.convertObject(new Post(), req.getReader());
        post = postService.update(post);
        result = post == null ? jsonResult.jsonFail("Update User Fail") : jsonResult.jsonSuccess(post);
        resp.getWriter().write(result);
    }
}
