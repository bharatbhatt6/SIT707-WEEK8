package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.LoginService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("passwd");
        String dob = req.getParameter("dob");

        String loginStatus = "fail";

        if (LoginService.login(username, password, dob)) {
            loginStatus = "success";
        }

        String htmlResponse = "<html>";
        htmlResponse += "<head><title>" + loginStatus + "</title></head>";
        htmlResponse += "<body>";
        htmlResponse += "<h2 id='login-status'>" + loginStatus + "</h2>";
        htmlResponse += "</body>";
        htmlResponse += "</html>";

        PrintWriter writer = resp.getWriter();
        writer.println(htmlResponse);
    }
}
