package com.d;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PreparedStatement pst = null;
	Connection conection=null;
	String uname,country,gender;
	String pass;
	String query="SELECT uname,password FROM logindetails where uname=? AND password=?";
	String generatedPassword = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter writer = response.getWriter();
		
		///ResultSet rs = null;
		
		//boolean flag;
		uname = request.getParameter("uname");
		System.out.println("Username"+uname);
		pass = request.getParameter("pass");
		System.out.println("Password"+pass);
		String passwordToHash = pass;
        
		
		
		try {
			conection = Dbutil.getConnection();
			System.out.println(conection);
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
			
		
			try {
				
				
	        MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
			
            
			pst = conection.prepareStatement(query);
            pst.setString(1,uname);
			pst.setString(2, generatedPassword);
			ResultSet rs = pst.executeQuery();
			//System.out.println(rs);
			if(rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("uname", uname);
				System.out.println("Logged in Successfully!!");
				/*RequestDispatcher rd = request.getRequestDispatcher("WelcomeJSP.jsp");
				rd.include(request, response);*/
				response.sendRedirect("welcome");
			}
			else
			{
				response.setContentType("text/html");
				writer.print("<script>alert('Login failed! try again');</script>");
				request.setAttribute("error", "Incorrect username or password");
				RequestDispatcher rd = request.getRequestDispatcher("LoginJSP.jsp");
				rd.forward(request, response);
			}
				
			}	
			 catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		finally {	
			/*if(connection!=null)
			Dbutil.closeConnection();
			System.out.println(conection);*/
			
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conection!=null) {
				try {
					conection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			
		}
	
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/LoginJSP.jsp");
		rd.forward(req, resp);
	}
}
