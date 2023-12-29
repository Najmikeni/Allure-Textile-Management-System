package project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.StaffDAO;
import project.dao.SupplierDAO;
import project.model.Supplier;

/**
 * Servlet implementation class SupplierController
 */
@WebServlet("/SupplierController")
public class SupplierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private SupplierDAO dao;
       String action ="";
       String forward="";
       RequestDispatcher view;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierController() {
        super();
        dao = new SupplierDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("viewSupplier")) {
			forward="viewSupplier.jsp";
			int SupplierID = Integer.parseInt(request.getParameter("SupplierID"));
			request.setAttribute("supplier", SupplierDAO.getSupplierById(SupplierID));
		}
		if(action.equalsIgnoreCase("listSupplier")) {
			forward="listSupplier.jsp";
			request.setAttribute("suppliers",SupplierDAO.getAllSuppliers());
		}
		if(action.equalsIgnoreCase("deleteSupplier")) {
			forward="listSupplier.jsp";
			int SupplierID = Integer.parseInt(request.getParameter("SupplierID"));
			dao.deleteSupplier(SupplierID);
			request.setAttribute("suppliers", SupplierDAO.getAllSuppliers());
		}
		if(action.equalsIgnoreCase("updateSupplier")) {
			forward="updateSupplier.jsp";
			int SupplierID = Integer.parseInt(request.getParameter("SupplierID"));
			request.setAttribute("supplier",SupplierDAO.getSupplierById(SupplierID));
		}
		if(action.equalsIgnoreCase("addSupplier")) {
			forward="addSupplier.jsp";
			request.setAttribute("staffs", StaffDAO.getAllStaffs());
		}
		
		view=request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Supplier supplier = new Supplier();
		supplier.setSupplier_Name(request.getParameter("Supplier_Name"));
		supplier.setAddress(request.getParameter("Address"));
		supplier.setEmail(request.getParameter("Email"));
		supplier.setNoPhone(request.getParameter("NoPhone"));
		supplier.setStaffID(Integer.parseInt(request.getParameter("StaffID")));
		
		String SupplierID = request.getParameter("SupplierID");
		if(SupplierID==null || SupplierID.isEmpty()) {
			dao.addSupplier(supplier);
		}
		else {
			supplier.setSupplierID(Integer.parseInt(SupplierID));
			dao.updateSupplier(supplier);
		}
		
		//forward request
		request.setAttribute("suppliers",SupplierDAO.getAllSuppliers());
		view = request.getRequestDispatcher("listSupplier.jsp");
		view.forward(request, response);
	}

}
