<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ include file="sidebar.jsp" %> 

<!DOCTYPE html>
<html>
<%

if ((user.getType().toString() == "ADMIN" || user.getType().toString() == "admin")) {
%>
<head>
   <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <title>Educational registration form</title>
     <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="css/courseStyle.css">
</head>

<body>
 
    <div class="main-block">
        <div class="left-part">
            <i class="fas fa-graduation-cap"></i>
            <h1>Add new course</h1>
            <p></p>

        </div>
        <form action="addCourse" method="POST">
            <div class="title">
                <i class="fas fa-pencil-alt"></i>
                <h2>Add New Course</h2>
            </div>
            <div class="info">
                <input class="fname" type="text" name="course_name" placeholder="Course Name*" required>
                <input type="text" name="course_code" placeholder="Course Code*" required>
                <input type="text" name="course_desc" placeholder="Course Description*" required>


            </div>

            <button type="submit" href="/">Add Course</button>
        </form>
    </div>
  
</body>
<%} %>
</html>