package com.sms.controller.course;

import java.io.IOException;

import com.sms.exception.AlreadyExistException;
import com.sms.exception.GeneralException;
import com.sms.model.StudentCourse;
import com.sms.model.User;
import com.sms.service.CourseServiceInterface;
import com.sms.service.Iservice;
import com.sms.service.factory.ServiceFactory;
import com.sms.service.student.impl.CourseService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registerCourse")
public class RegisterCourse extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		User user = (User) req.getSession().getAttribute("currentUser");
		String courseCode = req.getParameter("courseCode");

		StudentCourse studentcourse = new StudentCourse(user.getUserName(), courseCode);
		// user.getUserName();
		// Course course = (Course) req.getSession().getAttribute("course");
		// course.getCourseCode();
		// CourseService cs = new CourseService();
		boolean flagAddCourse = false;
		if (user.getType().toString().equalsIgnoreCase("STUDENT")) {
			try {
				// cs.register(sc);
				// ServiceFactory.getInstance().getCourseService("courseservice").register(studentcourse);
				Iservice service = ServiceFactory.getInstance().getService("courseservice");
				if (service instanceof CourseServiceInterface) {
					CourseServiceInterface cservice = (CourseServiceInterface) service;
					flagAddCourse = cservice.register(studentcourse);
					if(!flagAddCourse) {
						req.setAttribute("successMessage", "sucessMessage");
						req.getRequestDispatcher("/allCourses.jsp").forward(req, resp);

					}

				}
			} catch (AlreadyExistException alreadyExist) {

				req.setAttribute("errMessage", alreadyExist.getMessage());
				req.getRequestDispatcher("/Error.jsp").forward(req, resp);
			}
		}
	}
}
