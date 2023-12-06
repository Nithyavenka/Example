package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InboxServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie[] ck = req.getCookies();
		String username = null;
		if (ck != null) {
			for (Cookie c : ck) {
				if (c.getName().equals("user")) {
					username = c.getValue();
				}
			}
		}
		if (username == null || username.isEmpty()) {
			req.setAttribute("errorMsg", "Login first!!");
			RequestDispatcher r = req.getRequestDispatcher("login.jsp");
			r.forward(req, res);
		} else {
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			pw.write("<h3>Welcome to your inbox " + username + "<h3>");
			pw.write("<a href='logout'>Logout</a>");
		}
	}

}
