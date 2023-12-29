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
import project.dao.OrderDAO;
import project.model.Orders;
import java.text.*;


/**
 * Servlet implementation class OrderController
 */
@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private OrderDAO dao;
	String action ="";
    String foward="";
    RequestDispatcher view;  
    DateFormat formatter;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        dao = new OrderDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
action = request.getParameter("action");

		if(action.equalsIgnoreCase("OrderCusList")) { //view by id
			foward = "CustomerOrders.jsp";
			HttpSession session = request.getSession();
			Customer customer = (Customer)session.getAttribute("sessionCustomer");
			int custID = customer.getCustomerID();
			System.out.println("This is cus id "+custID);
			request.setAttribute("ordercuslist", OrderDAO.getAllOrderbyCusID(custID));
		}
		
		
		if(action.equalsIgnoreCase("viewOrder")) { //view by id
			foward = "viewOrder.jsp";
			int orderID = Integer.parseInt(request.getParameter("orderID"));
			request.setAttribute("order", OrderDAO.getOrderById(orderID));
		}
		if(action.equalsIgnoreCase("listOrder")) { //list order
			foward = "StaffOrderList.jsp";
			request.setAttribute("orderlist", OrderDAO.getAllOrder());
		}
		if(action.equalsIgnoreCase("deleteStaff")) { //delete order/cart
			foward = "StaffOrderList.jsp";
			int orderID = Integer.parseInt(request.getParameter("OrderID"));
			dao.deleteOrder(orderID); 
			request.setAttribute("orderlist", OrderDAO.getAllOrder());
		}
		if(action.equalsIgnoreCase("updateOrder")) { //update account
			foward = "updateOrder.jsp";
			int orderID = Integer.parseInt(request.getParameter("orderID"));
			request.setAttribute("order", OrderDAO.getOrderById(orderID));
		}	
		view = request.getRequestDispatcher(foward);
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//add order
	Orders order = new Orders();
	order.setCustomerID(Integer.parseInt(request.getParameter("customerID"))); 
	
	
	String orderID = request.getParameter("orderID");
	if(orderID == null || orderID.isEmpty()) {
		dao.addOrder(order);
	}
	else {
		order.setOrderID(Integer.parseInt(orderID));
		dao.updateOrder(order,Integer.parseInt(orderID));
	}
	//foward request
	request.setAttribute("orders", OrderDAO.getAllOrder());
	RequestDispatcher view = request.getRequestDispatcher("listOrder.jsp");
	view.forward(request,response);
	}
}
