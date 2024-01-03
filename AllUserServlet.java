package org.sample.servlet;

import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sample.dao.AllUserDao;
//import org.sample.dao.UserLoginDao;
import org.sample.dto.User;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class AllUserServlet
 */
public class AllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AllUserDao alluserDao;

    public void init() {
        alluserDao = new AllUserDao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/list-user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		List<User> userList = alluserDao.selectAllUsers();
		request.setAttribute("listUser", userList);
		request.getRequestDispatcher("/list-user.jsp").forward(request, response);
	}

}
