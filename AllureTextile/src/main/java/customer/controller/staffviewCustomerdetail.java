package customer.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.model.*;
import customer.DAO.*;

/**
 * Servlet implementation class staffviewCustomerdetail
 */
@WebServlet("/staffviewCustomerdetail")
public class staffviewCustomerdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public staffviewCustomerdetail() {
        super();
        dao = new CustomerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int CustomerID = Integer.parseInt(request.getParameter("CustomerID"));
		try {
			request.setAttribute("customer", dao.getCustomerbyID(CustomerID));
			RequestDispatcher view = request.getRequestDispatcher("staffviewCustomerdetail.jsp");
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
