package customer.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.DAO.CustomerDAO;


/**
 * Servlet implementation class CustomerListController
 */
@WebServlet("/CustomerListController")
public class CustomerListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private CustomerDAO dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerListController() {
        super();
       dao = new CustomerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //use doget method for view
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//Send to DAO
			request.setAttribute("customerlist",CustomerDAO.getAllCustomer());
			//foward request to jsp
			RequestDispatcher view = request.getRequestDispatcher("CustomerList.jsp");
			view.forward(request,response);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
