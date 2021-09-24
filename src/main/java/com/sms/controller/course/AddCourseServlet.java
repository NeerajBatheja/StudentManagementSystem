package com.sms.controller.course;

import java.io.IOException;

import com.sms.dao.factory.DaoFactory;
import com.sms.exception.AlreadyExistException;
import com.sms.exception.AuthenticationException;
import com.sms.exception.GeneralException;
import com.sms.exception.ValidationException;
import com.sms.model.Course;
import com.sms.model.User;
import com.sms.service.factory.*;
import com.sms.service.student.impl.CourseService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addCourse")
public class AddCourseServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String courseName = req.getParameter("course_name");
		String courseCode = req.getParameter("course_code");
		String courseDesc = req.getParameter("course_desc");

		Course course = new Course(courseName, courseCode, courseDesc);
		// CourseService courseservice = new CourseService();

		User user = (User) req.getSession().getAttribute("currentUser");

		if ((user.getType().toString() == "ADMIN" || user.getType().toString() == "admin")
				&& (courseName != null || courseName != "") && (courseCode != null || courseCode != "")
				&& (courseDesc != null || courseDesc != "")) {
			boolean flagCourse = false;
			try {
				// course = courseservice.add(course);
				flagCourse = ServiceFactory.getInstance().getService("courseservice").add(course);
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
			

		}
	}
}
