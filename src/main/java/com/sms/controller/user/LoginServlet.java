package com.sms.controller.user;

import java.io.IOException;

import com.sms.exception.AuthenticationException;
import com.sms.exception.ValidationException;
import com.sms.model.User;
import com.sms.service.factory.*;
import com.sms.service.student.impl.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

		User user = new User(email, pass);

		// TODO Authentication

		// UserService userService = new UserService();

		try {
			// user = userService.authenticate(user);
			user = (User) ServiceFactory.getInstance().getUserService("userservice").authenticate(user);
		} catch (ValidationException valExcep) {
			// TODO Auto-generated catch block
			req.setAttribute("errMessage", valExcep.getMessage());
			req.getRequestDispatcher("/Error.jsp").forward(req, resp);
		} catch (AuthenticationException authExcep) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			req.setAttribute("errMessage", authExcep.getMessage());
			req.getRequestDispatcher("/Error.jsp").forward(req, resp);

		}
		// TODO SAVE IN SESSION
		if (session != null) {
			session.setAttribute("currentUser", user);

		}
		// TODO Success response
		req.getRequestDispatcher("/Home.jsp").forward(req, resp);

	}

}
