package project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.dao.UserDAO;
import project.model.User;
import customer.DAO.*;
import customer.model.Customer;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO dao;
    private CustomerDAO cusDAO;
    HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        dao=new UserDAO();
        cusDAO=new CustomerDAO();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			User user = new User();
			//retrieve and set email and password
			user.setEmail(request.getParameter("Email"));
			user.setPassword(request.getParameter("Password"));

			user = UserDAO.login(user);
			//set user session if user is valid
			if(user.isValid()){
				session = request.getSession(true);
				session.setAttribute("sessionId", user.getId());
				int id = user.getId();
				System.out.println(user.getId());
				session.setAttribute("sessionEmail", user.getEmail());  
				session.setAttribute("sessionRole", user.getRole()); 
				
				if(user.getRole().equalsIgnoreCase("staff")) {
					request.setAttribute("user", UserDAO.getUserByUname(user.getEmail()));  
					RequestDispatcher view = request.getRequestDispatcher("mainPageStaff.jsp");
					view.forward(request, response);
					/*request.setAttribute("prods", StaffDAO.getSupplierProducts());
					RequestDispatcher view = request.getRequestDispatcher("staff/listAll.jsp"); 
					view.forward(request, response);	*/
				}
				else {
					System.out.println(id);
					Customer customer = new Customer();
					customer = cusDAO.getCustUserID(id);
					System.out.println(customer.getID());
					session.setAttribute("sessionCustomer",customer);
					request.setAttribute("user", UserDAO.getUserByUname(user.getEmail()));					
					//request.setAttribute("cust", CustomerDAO.getCustomerId(user.getId()));					
					RequestDispatcher view = request.getRequestDispatcher("CustomerHome.html"); 	 
					view.forward(request, response);	
				}
				
							
			}
			else{
				response.sendRedirect("invalidLogin.jsp");
			}		
		}

		catch (Throwable ex) {
			System.out.println(ex);
		}
	}

}