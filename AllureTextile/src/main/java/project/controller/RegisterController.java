package project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.model.User;
import project.dao.UserDAO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        dao = new UserDAO();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			User user = new User();
			//retrieve and set Uname and password
			user.setEmail(request.getParameter("Email"));
			user.setPassword(request.getParameter("Password"));
			user.setRole(request.getParameter("Role"));
			dao.add(user);
				if(user.getRole().equalsIgnoreCase("staff")) {
					RequestDispatcher view = request.getRequestDispatcher("login.jsp");
					view.forward(request, response);
				}
				else {				
					RequestDispatcher view = request.getRequestDispatcher("login.jsp"); 	 
					view.forward(request, response);	
				}		
		}

		catch (Throwable ex) {
			System.out.println(ex);
		}
	}

}
