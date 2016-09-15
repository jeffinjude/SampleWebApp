package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDeleteDao;

/**
 * Servlet implementation class UserDeleteController
 */
@WebServlet(description = "Servlet to delete the user details", urlPatterns = { "/UserDeleteController" })
public class UserDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDeleteDao userDeleteDao = new UserDeleteDao();
		userDeleteDao.deleteUser(Integer.parseInt(request.getParameter("userId")));
		
		// Redirect to list page after user add
		response.sendRedirect("/SampleWebApp/UserList");
	}

}
