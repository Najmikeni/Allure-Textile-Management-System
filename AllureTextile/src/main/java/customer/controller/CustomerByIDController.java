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
 * Servlet implementation class CustomerByIDController
 */
@WebServlet("/CustomerByIDController")
public class CustomerByIDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private CustomerDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerByIDController() {
        super();
        dao = new CustomerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Customer customer = (Customer)session.getAttribute("sessionCustomer");
			int custID = customer.getCustomerID();
			request.setAttribute("customer", dao.getCustomerbyID(custID));
			RequestDispatcher view = request.getRequestDispatcher("ViewCustomerbyID.jsp");
			view.forward(request, response);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

}
