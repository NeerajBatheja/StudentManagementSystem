<%@ page import="com.sms.service.student.impl.CourseService"%>
<%@ page import="java.util.List"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="com.sms.model.Course"%>
<%@ page import="com.sms.model.User"%>
<%@ page import="com.sms.model.StudentCourse"%>
<%@ page import="com.sms.model.StudentCoursesJoin"%>
<%@ page import="com.sms.service.factory.ServiceFactory"%>



<%@ include file="sidebar.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Courses</title>
<link rel="stylesheet" href="css/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="userbuttons">
		<%
		if (user.getType().toString() == "ADMIN" || user.getType().toString() == "admin") {
		%>

		<a href="addCourse.jsp">
			<button class="button-28" role="button">Add New Course</button> <a
			href="allCourses.jsp">
				<button class="button-28" role="button">Show All Courses</button>

		</a> <a href="courseRegisteration.jsp"><button class="button-28"
					role="button">Course Registeration</button></a> <%
 } else {
 %> <a
			href="allCourses.jsp">
				<button class="button-28" role="button">Show All Courses</button>

		</a> <a href="myCourses.jsp"><button class="button-28"
					role="button">My Courses</button></a> <%
 }
 %>
		
	</div>

</body>
</html>