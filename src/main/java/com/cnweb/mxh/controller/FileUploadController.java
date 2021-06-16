package com.cnweb.mxh.controller;

import com.cnweb.mxh.config.Configuration;
import com.cnweb.mxh.model.JsonResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(value = Configuration.URL_API + "/file-upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50)
public class FileUploadController extends HttpServlet {
    private JsonResult jsonResult = new JsonResult();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        List<String> listResult = new ArrayList<>();
        try {
            Collection<Part> partCollection = req.getParts();
            String saveFile = getFolderUpload() + "";

            for (Part part : partCollection){
                String fileName = getFileName(part);
                if (fileName != null && !fileName.equals("")){
                    String filePath = saveFile + File.separator + fileName;
                    System.out.println("Write file : " + filePath);
                    part.write(saveFile + File.separator + fileName);
                    // for flexible develop
                    part.write(Configuration.APP_PATH + File.separator + fileName);
                    listResult.add("resources/images/" + fileName);
                }
            }

            result = listResult.size() != 0 ? jsonResult.jsonSuccess(listResult) : jsonResult.jsonFail("No File to upload");

        }catch (Exception e){
            e.printStackTrace();
            result = jsonResult.jsonFail("Upload File Error");
        }
        resp.getWriter().write(result);
    }

    private String getFileName(Part part){
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("Content-disposition: " + contentDisp);
        String[] items = contentDisp.split(";");
        for (String s : items){
            if (s.trim().startsWith("filename")){
                String fileName = s.substring(s.indexOf("=") + 2, s.length() -1);
                fileName = fileName.replace("\\","/");
                return fileName.substring(fileName.lastIndexOf("/")+1);
            }
        }
        return null;
    }

    private File getFolderUpload(){
        File folderUpload = new File(Configuration.SERVER_PATH);
        if (!folderUpload.exists()){
            folderUpload.mkdir();
        }
        return folderUpload;
    }
}
