package customer.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer.DAO.CustomerDAO;
import customer.model.Customer;


/**
 * Servlet implementation class updateCustomer
 */
@WebServlet("/updateCustomer")
public class updateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerDAO dao;   
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateCustomer() {
        super();
       dao = new CustomerDAO();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("sessionCustomer");
		RequestDispatcher view = request.getRequestDispatcher("updateCustomer.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("sessionCustomer");
		String email = (String)session.getAttribute("sessionEmail");
				
		int cusid = customer.getCustomerID();
		System.out.println(cusid);
		Customer customers = new Customer();
		//assign to setter
		customers.setCustomerID(cusid);
		customers.setCust_name(request.getParameter("Cust_name"));
		customers.setCustNo(request.getParameter("CustNo"));
		customers.setAddress(request.getParameter("Address"));
		customers.setEmail(email);
		
		try {
			dao.updateCustomer(customers,cusid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher view = request.getRequestDispatcher("CustomerHome.html");
		view.forward(request, response);
	}

}
