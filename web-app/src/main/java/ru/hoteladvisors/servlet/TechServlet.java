package ru.hoteladvisors.servlet;

import jakarta.inject.Inject;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ru.hoteladvisors.entity.CompanyEntity;
import ru.hoteladvisors.service.TechService;

import java.io.IOException;

@WebServlet(name = "TechServlet", value = "/tech")
public class TechServlet extends HttpServlet {

    @Inject
    protected TechService techService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CompanyEntity company = techService.generateFakeCompany();
        JsonbConfig config = new JsonbConfig()
                .withFormatting(true);

        Jsonb jsonb = JsonbBuilder.create(config);

        jsonb.toJson(company, response.getWriter());

        response.setContentType("application/json");
        response.setStatus(200);
    }
}
