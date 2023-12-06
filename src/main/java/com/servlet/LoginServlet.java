package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// cookie
		if (username.equals(password)) {
			Cookie ck = new Cookie("user", username);
			res.addCookie(ck);
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, res);

		} else {
			// invalid user
			req.setAttribute("errorMsg", "invalid cred ..");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, res);
		}
	}

}
