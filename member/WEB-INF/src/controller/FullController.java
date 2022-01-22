package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Customer;
import service.FullService;




@WebServlet("/full")
public class FullController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		FullService fullService = new FullService();
		List<Customer> customerList = fullService.fullCustomer();
		request.setAttribute("customerList", customerList);
		request.getRequestDispatcher("/" + "mypage.jsp").forward(request, response);


	}
}

