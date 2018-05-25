package s1;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;


import p1.DAO;
import p1.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		
		try {
			  UserBean details = DAO.isUser(userID,password);
			  
			  if(details.getRoles() != null)
			  {
			 if(details.getRoles().equalsIgnoreCase("admin"))
			 {
				 response.sendRedirect("Admin.jsp");
			 }
			 else if(details.getRoles().equalsIgnoreCase("user"))
				 response.sendRedirect("Underwriter.jsp");
			 else
				 out.println("invalid user");
			  }
			  else
				  out.println("hi");
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
