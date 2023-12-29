package project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.ProductDAO;
import project.dao.StaffDAO;
import project.dao.SupplierDAO;
import project.model.Product;
import project.model.Supplier;
import customer.DAO.CustomerDAO;
import customer.model.Customer;


/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDAO dao;   
    private CustomerDAO dao2;
    String action = "";
    String forward = "";
    RequestDispatcher view;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        dao = new ProductDAO();
        dao2 = new CustomerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("viewProduct")) {
			forward = "viewProduct.jsp";
			int ProductID = Integer.parseInt(request.getParameter("ProductID"));
			request.setAttribute("product", ProductDAO.getProductById(ProductID));	
		}
		if(action.equalsIgnoreCase("listProductStaff")) {
			forward = "listProduct.jsp";
			request.setAttribute("products", ProductDAO.getAllProducts());
		}
		if(action.equalsIgnoreCase("deleteProduct")) {
			forward = "listProduct.jsp";
			int ProductID = Integer.parseInt(request.getParameter("ProductID"));
			dao.deleteProduct(ProductID);
			request.setAttribute("products", ProductDAO.getAllProducts());
		}
		if(action.equalsIgnoreCase("updateProduct")) {
			forward = "updateProduct.jsp";
			Product product = new Product();
			int ProductID = Integer.parseInt(request.getParameter("ProductID"));
			product = ProductDAO.getProductById(ProductID);
			request.setAttribute("selectedSupplier", product.getSupplierID());	
			request.setAttribute("product", ProductDAO.getProductById(ProductID));	
			request.setAttribute("suppliers", SupplierDAO.getAllSuppliers());
		}
		if(action.equalsIgnoreCase("addProduct")) {
			forward = "addProduct.jsp";
			request.setAttribute("suppliers", SupplierDAO.getAllSuppliers());
		}
		if(action.equalsIgnoreCase("shoppingPage")) {
			forward = "shoppingPage.jsp";
			request.setAttribute("products",ProductDAO.getAllProducts());
		}
		if(action.equalsIgnoreCase("viewProductCustomer")) {
			forward = "viewProductCustomer.jsp";
			int ProductID = Integer.parseInt(request.getParameter("ProductID"));
			request.setAttribute("product", ProductDAO.getProductById(ProductID));
		}

		
		view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setProduct_Name(request.getParameter("Product_Name"));
		product.setProduct_Desc(request.getParameter("Product_Desc"));
		product.setProduct_Price(Double.parseDouble(request.getParameter("Product_Price")));
		product.setProduct_Quantity(Integer.parseInt(request.getParameter("Product_Quantity")));
		product.setSupplierID(Integer.parseInt(request.getParameter("SupplierID")));		
		
		String ProductID = request.getParameter("ProductID");
		
		
		if(ProductID == null || ProductID.isEmpty()) {
			dao.addProduct(product);
		}
		else {
			int prodid = Integer.parseInt(request.getParameter("ProductID"));
			product.setProductID(Integer.parseInt(ProductID));
			dao.updateProduct(product,prodid);
		}
			
		//forward request
		request.setAttribute("products", ProductDAO.getAllProducts());
		view = request.getRequestDispatcher("listProduct.jsp");
		view.forward(request, response);
	}

}