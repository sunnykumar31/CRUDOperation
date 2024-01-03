package org.sample.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sample.dao.DeleteUserDao;


/**
 * Servlet implementation class DeleteUserServlet
 */
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeleteUserDao deleteUserDao;

    public void init() {
        deleteUserDao = new DeleteUserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/list-user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("ram");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		deleteUserDao.deleteUser(id);
//		System.out.println("ram1");
		request.getRequestDispatcher("AllUserServlet").forward(request, response);
//		request.getRequestDispatcher("/list-user.jsp").forward(request, response);
	}

}
