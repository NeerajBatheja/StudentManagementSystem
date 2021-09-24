package com.sms.controller.course;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import com.sms.*;
import com.sms.model.StudentCoursesJoin;
import com.sms.model.User;
import com.sms.service.factory.ServiceFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/approveCourse")
public class ApproveCourseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String userName = req.getParameter("username");
		String courseCode = req.getParameter("courseCode");
		User user = (User) req.getSession().getAttribute("currentUser");

		StudentCoursesJoin coursereg = new StudentCoursesJoin(userName, courseCode, "Registered");
		if ((user.getType().toString() == "ADMIN" || user.getType().toString() == "admin")) {
			try {

				ServiceFactory.getInstance().getService("admincourseservice").update(coursereg, null);
			} catch (Exception e) {
				req.setAttribute("errMessage", e.getMessage());
			}
			req.getRequestDispatcher("/courseRegisteration.jsp").forward(req, resp);

		}

	}
}