package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserAddEditDao;
import database.Dbconnector;

/**
 * Servlet implementation class UserAddAction
 */
@WebServlet(description = "Servlet to add the user details", urlPatterns = { "/UserAddController" })
public class UserAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAddController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserAddEditDao userAddDaoObj = new UserAddEditDao();
		request.setAttribute("userName", userAddDaoObj.getUserDetails(Integer.parseInt(request.getParameter("userId"))).getUserName());
		request.setAttribute("userAddress", userAddDaoObj.getUserDetails(Integer.parseInt(request.getParameter("userId"))).getUserAddress());
		request.setAttribute("userPhone", userAddDaoObj.getUserDetails(Integer.parseInt(request.getParameter("userId"))).getUserPhone());
		
		RequestDispatcher view = request.getRequestDispatcher("UserPages/UserAddEdit.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserAddEditDao userAddDaoObj = new UserAddEditDao();
		try {
			userAddDaoObj.insertUser(request.getParameter("userName"), request.getParameter("userAddress"), request.getParameter("phoneNumber"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Redirect to list page after user add
		response.sendRedirect("/SampleWebApp/UserList");
	}
}
