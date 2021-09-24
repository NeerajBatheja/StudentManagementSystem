
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<title>Insert title here</title>
</head>
<body>



<%
    if(null!=request.getAttribute("errMessage"))
    {
       %>
    

<script type="text/javascript">
Swal.fire({
  icon: 'error',
  title: 'Oops...',
  text: '<%=request.getAttribute("errMessage")%>'   ,
  footer: '<form> <input type=\"button\" value=\"Go back!\" onclick=\"history.back()\"></form>'
})</script>
<%
    }
%>
<!-- TODO show Error Message -->
</body>
</html>