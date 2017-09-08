package com.d;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=null;
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		User u = new User();
		
		String un=(String) session.getAttribute("uname");
		System.out.println(un + " jhsdsdf");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn=Dbutil.getConnection();
			String query = "select * from userdetails where uname=?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, un);
			java.sql.ResultSet i = pstmt.executeQuery();

			while (i.next()) {
				u.setUname(i.getString("uname"));
				u.setGender(i.getString("gender"));
				u.setCountry(i.getString("country"));
				u.setPass(i.getString("password"));
				u.setConfpass(i.getString("confirmPassword"));
			}
			
			request.setAttribute("user", u);
			
			RequestDispatcher r=request.getRequestDispatcher("WelcomeJSP.jsp");
			r.forward(request,response);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//Dbutil.closeConnection();
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

		
		
		
		
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
