package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserAddEditDao;

/**
 * Servlet implementation class UserEditController
 */
@WebServlet(description = "Edit the details of a user", urlPatterns = { "/UserEditController" })
public class UserEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserAddEditDao userEditDaoObj = new UserAddEditDao();
		
		try {
			userEditDaoObj.editUser(request.getParameter("userName"), request.getParameter("userAddress"), request.getParameter("phoneNumber"),Integer.parseInt(request.getParameter("userId")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Redirect to list page after user add
		response.sendRedirect("/SampleWebApp/UserList");
	}

}
