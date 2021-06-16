package com.cnweb.mxh.controller;

import com.cnweb.mxh.config.Configuration;
import com.cnweb.mxh.model.Image;
import com.cnweb.mxh.model.JsonResult;
import com.cnweb.mxh.service.ImageService;
import com.cnweb.mxh.service.service_impl.ImageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = Configuration.URL_API + "/image")
public class ImageController extends HttpServlet {
    private JsonResult jsonResult = new JsonResult();
    private ImageService imageService = new ImageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        List<Image> images = imageService.findAll();
        result = images.size() > 0 ? jsonResult.jsonSuccess(images) : jsonResult.jsonFail("Don't have any image");
        resp.getWriter().write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        Image image = jsonResult.convertObject(new Image(), req.getReader());
        image = imageService.insert(image);
        result = image == null ? jsonResult.jsonFail("Insert image fail") : jsonResult.jsonSuccess(image);
        resp.getWriter().write(result);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
