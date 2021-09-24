<%@ page import="com.sms.service.student.impl.CourseService"%>
<%@ page import="com.sms.service.student.impl.UserService"%>
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
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<meta charset="ISO-8859-1">
<title>Courses</title>
<link rel="stylesheet" href="css/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
</head>
<body>

	

	<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 50%;
	margin: auto;
	border: 3px solid white;
	padding: 1000px;
}

td, th {
	border: 1px solid white;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: BLACK;
}
</style>

	<div class="courses">


		<h2>All Courses</h2>

	</div>
	<div class="allCourses">
		<table>
			<tr>
				<th>Name</th>
				<th>Username</th>
				<th>Account Type</th>
				<th>Show Details</th>

			</tr>
			<%
			//	User user = (User) request.getSession().getAttribute("currentUser");
			UserService  userservice = new UserService();
			List<User> usersList = userservice.getAll();

			for (User eachUser : usersList) {
			%>


			<tr>
				<td><%=eachUser.getName()%></td>
				<td><%=eachUser.getUserName()%></td>
				<td><%=eachUser.getType()%></td>
				<td><a
					href="userDetails.jsp?username=<%=eachUser.getUserName()%>">Show Details</a>
				</td>
			</tr>

			<%
			}
			%>
		</table>

	</div>


	
</body>
</html>