package org.sample.servlet;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sample.dao.UserDao;
import org.sample.dto.User;
//import org.sample.util.ConnectionUtils;
/**
 * Servlet implementation class UserRegistration
 */
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		User userObj = new User();
		userObj.setFirstName(firstName);
		userObj.setLastName(lastName);
		userObj.setEmail(email);
		userObj.setUsername(userName);
		userObj.setPassword(password);


		try {
			int i=userDao.registerUser(userObj);
		    if (i > 0) {
		        response.sendRedirect("welcome.jsp");
		    } else {
		        response.sendRedirect("index.jsp");
		    }
		} catch (Exception e) {
		    System.out.println(e);
		}

		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
