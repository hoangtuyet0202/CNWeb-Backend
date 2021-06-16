package com.cnweb.mxh.controller;

import com.cnweb.mxh.config.Configuration;
import com.cnweb.mxh.model.JsonResult;
import com.cnweb.mxh.model.Participant;
import com.cnweb.mxh.service.ParticipantService;
import com.cnweb.mxh.service.service_impl.ParticipantServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(value = Configuration.URL_API + "/participant")
public class ParticipantController extends HttpServlet {
    private JsonResult jsonResult = new JsonResult();
    private ParticipantService participantService = new ParticipantServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        List<Participant> participants = participantService.findAll();
        result = participants.size() > 0 ? jsonResult.jsonSuccess(participants) : jsonResult.jsonFail("Don't have any participant");
        resp.getWriter().write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "";
        Participant participant = jsonResult.convertObject(new Participant(), req.getReader());
        participant = participantService.insert(participant);
        result = participant == null ? jsonResult.jsonFail("Insert participant fail") : jsonResult.jsonSuccess(participant);
        resp.getWriter().write(result);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
