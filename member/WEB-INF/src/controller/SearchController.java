package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Customer;
import service.SearchService;

@WebServlet("/search")
public class SearchController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String gender = request.getParameter("gender");
		String blood = request.getParameter("blood");
		SearchService searchService = new SearchService();
		List<Customer> customerList = searchService.searchCustomer(gender, blood);
		request.setAttribute("customerList", customerList);
		ServletContext sc = getServletContext();
		sc.getRequestDispatcher("/" + "mypage.jsp").forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				String id = request.getParameter("id");
				SearchService searchService = new SearchService();
				List<Customer> customerList = searchService.searchCustomer(id);
				request.setAttribute("customerList", customerList);
				ServletContext sc = getServletContext();
				sc.getRequestDispatcher("/" + "detail.jsp").forward(request, response);
	}
}

