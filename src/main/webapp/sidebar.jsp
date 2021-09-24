<%@ page import="com.sms.model.User"%>
<%@ page import="com.sms.model.enums.UserType"%>
<%@ page session="true" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en" dir="ltr">

<head>
<meta charset="utf-8">

<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
</head>

<body>

	</div>

	<input type="checkbox" id="check">
	<label for="check"> <i class="fas fa-bars" id="btn"></i> <i
		class="fas fa-times" id="cancel"></i>
	</label>
	<div class="sidebar">
		<header>SMS</header>
		<a href="Home.jsp" class="active"> <i class="fas fa-qrcode"></i> <span>Dashboard</span>
		</a>
		<%
		User user = (User) request.getSession().getAttribute("currentUser");
		if (user != null) {
			if (user.getType() == UserType.ADMIN) {
		%>

		<a href="users.jsp"> <i class="far fa-envelope"></i> <span>Users</span>
		</a>

		<%
		}
		} else {

		request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		%>



		<a href="showCourses.jsp"> <i class="fas fa-link"></i> <span>Courses</span>
		</a> <a href="#"> <i class="fas fa-stream"></i> <span>Attendance</span>
		</a> <a href="#"> <i class="fas fa-calendar"></i> <span>Marks</span>
		</a> <a href="#"> <i class="far fa-question-circle"></i> <span>Transcript</span>
		</a> <a href="fee.jsp"> <i class="fas fa-sliders-h"></i> <span>Fee</span>
		</a>

		<form action="logout" method="POST">



			<input type="submit" value="logout" class="fas fa-sign-out-alt fa-lg">

		</form>

	</div>
</body>

</html>