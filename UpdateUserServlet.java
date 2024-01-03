package org.sample.servlet;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sample.dao.UpdateUserDao;
import org.sample.dto.User;


public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UpdateUserDao updateUserDao;
	public void init() {
        updateUserDao = new UpdateUserDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.getRequestDispatcher("/list-user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		System.out.println("ramji");
		String msg = "";
		try {
			updateUserDao.updateUser(userObj);
			msg = "ram";
		} catch (ClassNotFoundException e) {
			msg = "";
		}
		
		request.setAttribute("msg", userObj);
		request.getRequestDispatcher("AllUserServlet").forward(request, response);
	}

}
