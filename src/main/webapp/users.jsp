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

<a href="displayUser.jsp">
<button class="button-28" role="button">All Users</button> </a>

<button class="button-28" role="button">Registered</button>
<button class="button-28" role="button">Un-Registered</button>

</div>	


</body>
</html>