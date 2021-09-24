package com.sms.controller.user;

import java.io.IOException;

import com.sms.exception.AlreadyExistException;
import com.sms.exception.AuthenticationException;
import com.sms.exception.GeneralException;
import com.sms.exception.ValidationException;
import com.sms.model.User;
import com.sms.model.enums.UserType;
import com.sms.service.factory.ServiceFactory;
import com.sms.service.student.impl.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
public class SingupServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String accountType = req.getParameter("accountType");

		// UserType usertype;

		// UserService userService = new UserService();

		User user = new User(name, email, pass, UserType.valueOfLabel(accountType));

		if (user != null && (email != null || email != "") && (pass != null || pass != "")
				&& (name != null || name != "") && (accountType != null || accountType != "")) {
			boolean flagUser = false;
			try {
				// user = userService.add(user);
				flagUser = ServiceFactory.getInstance().getService("userservice").add(user);
			} catch (AlreadyExistException alreadyExist) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				req.setAttribute("errMessage", alreadyExist.getMessage());
				req.getRequestDispatcher("/Error.jsp").forward(req, resp);

			} catch (ValidationException valExcep) {
				// TODO Auto-generated catch block
				req.setAttribute("errMessage", valExcep.getMessage());
				req.getRequestDispatcher("/Error.jsp").forward(req, resp);
			}

			// TODO SAVE IN SESSION
			if (session != null) {
				session.setAttribute("currentUser", user);

			}
			// TODO Success response
			req.getRequestDispatcher("/Home.jsp").forward(req, resp);
		} else {
			// TODO Failure Response
			req.getRequestDispatcher("/Error.jsp").forward(req, resp);
		}

	}

}
