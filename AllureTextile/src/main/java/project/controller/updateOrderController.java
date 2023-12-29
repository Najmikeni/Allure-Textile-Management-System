package project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.OrderDAO;
import project.model.Orders;

/**
 * Servlet implementation class updateOrderController
 */
@WebServlet("/updateOrderController")
public class updateOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateOrderController() {
        super();
        dao = new OrderDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int OrderID = Integer.parseInt(request.getParameter("OrderID"));
		request.setAttribute("order",OrderDAO.getOrderById(OrderID));
		RequestDispatcher view = request.getRequestDispatcher("updateOrder.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Orders order = new Orders();
		int ordid = Integer.parseInt(request.getParameter("OrderID"));
		order.setProductID(Integer.parseInt(request.getParameter("ProductID")));
		order.setProduct_name(request.getParameter("Product_name"));
		order.setQuantity(Integer.parseInt(request.getParameter("Quantity")));
		order.setPrice(Double.parseDouble(request.getParameter("Price")));
		dao.updateOrder(order,ordid);
		
		int OrderID = Integer.parseInt(request.getParameter("OrderID"));
		request.setAttribute("order",OrderDAO.getOrderById(OrderID));
		RequestDispatcher view = request.getRequestDispatcher("StaffOrderDetail.jsp");
		view.forward(request, response);
	}

}
