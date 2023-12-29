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

import customer.DAO.*;

/**
 * Servlet implementation class CustomerDelete
 */
@WebServlet("/CustomerDelete")
public class CustomerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDelete() {
        super();
        dao = new CustomerDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int CustomerID = (int) session.getAttribute("CustomerID");
		try {
			dao.deleteCustomer(CustomerID);
			request.setAttribute("Customerlist", CustomerDAO.getAllCustomer());
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
