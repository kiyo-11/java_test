package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UpdateService;

@WebServlet("/update")

public class UpdateController extends HttpServlet{
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{//22行目MySQLにログインする
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String blood = request.getParameter("blood");
        String old = request.getParameter("old");
        String memo = request.getParameter("memo");
        UpdateService updateservice = new UpdateService();
        updateservice.updateCustomer(email,password,name,gender,blood,old,memo,id);
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/" + "update.jsp").forward(request, response);
    }
}