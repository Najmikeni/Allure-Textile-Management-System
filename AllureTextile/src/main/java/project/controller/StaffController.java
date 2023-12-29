package project.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project.dao.StaffDAO;
import project.dao.UserDAO;
import project.model.Staff;

/**
 * Servlet implementation class StaffController
 */
@WebServlet("/StaffController")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StaffDAO dao;
    private UserDAO daouser;
	String action ="";
    String foward="";
    RequestDispatcher view;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffController() {
        super();
        dao = new StaffDAO();
        daouser = new UserDAO();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("viewStaff")) { //view by id
			foward = "viewStaff.jsp";
			int staffID = Integer.parseInt(request.getParameter("staffID"));
			request.setAttribute("staff", StaffDAO.getStaffById(staffID));
		}
		if(action.equalsIgnoreCase("listStaff")) { //list staff
			foward = "listStaff.jsp";
			request.setAttribute("staffs", StaffDAO.getAllStaffs());
		}
		if(action.equalsIgnoreCase("deleteStaff")) { //delete account
			foward = "listStaff.jsp";
			int StaffID = Integer.parseInt(request.getParameter("staffID"));
			dao.deleteStaff(StaffID); 
			request.setAttribute("staffs", StaffDAO.getAllStaffs());
		}
		if(action.equalsIgnoreCase("updateStaff")) { //update account
			foward = "updateStaff.jsp";
			Staff staff = new Staff();
			int staffID = Integer.parseInt(request.getParameter("staffID"));
			request.setAttribute("staff", StaffDAO.getStaffById(staffID));
			request.setAttribute("selectedUser", staff.getId());			//auto selected for user id when updating
			
		}
		if(action.equalsIgnoreCase("addStaff")) { //add staff
			foward = "addStaff.jsp";
			
		}
		if(action.equalsIgnoreCase("mainPage")) { 
			foward = "mainPageStaff.jsp";
		}
		
		view = request.getRequestDispatcher(foward);
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//add or update staff
		Staff staff = new Staff();
		staff.setStaff_Name(request.getParameter("staff_Name"));
		staff.setAddress(request.getParameter("address"));
		staff.setNoPhone(request.getParameter("noPhone"));
		
		
		String staffID = request.getParameter("staffID");
		if(staffID == null || staffID.isEmpty()) {
			dao.addStaff(staff);
		}
		else {
			staff.setStaffID(Integer.parseInt(staffID));
			dao.updateStaff(staff);
		}

		request.setAttribute("staffs", StaffDAO.getAllStaffs());
		RequestDispatcher view = request.getRequestDispatcher("listStaff.jsp");
		view.forward(request,response);
	}

}
