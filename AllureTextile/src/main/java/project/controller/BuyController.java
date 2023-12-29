package project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer.model.Customer;
import project.dao.*;
import project.model.*;

/**
 * Servlet implementation class InvoiceController
 */
@WebServlet("/BuyController")
public class BuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDAO orddao;
	private ProductDAO proddao;
	RequestDispatcher view;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyController() {
        super();
        orddao = new OrderDAO();
        proddao = new ProductDAO();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ProductID = Integer.parseInt(request.getParameter("ProductID"));
		int Quan = Integer.parseInt(request.getParameter("Quantity"));
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("sessionCustomer");
		int custID = customer.getCustomerID();
		Product product = ProductDAO.getProductById(ProductID);
		
		Orders order = new Orders();
		order.setCustomerID(custID);
		order.setProductID(product.getProductID());
		order.setProduct_name(product.getProduct_Name());
		order.setPrice(product.getProduct_Price());
		order.setQuantity(Quan);
		orddao.addOrder(order);
		proddao.updateStock(product, ProductID, Quan);
		
		
		view = request.getRequestDispatcher("CustomerHome.html");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
