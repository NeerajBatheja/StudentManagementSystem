<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
     <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Document</title>
    <link rel="stylesheet" href="css/style.css">
<script src="js/main.js"></script>

</head>

<body>
    <div class="introText">Student Management System</div>
    <div class="login-page">

        <div class="form" >
            <div class="loginMessage">Please Login To Continue...</div>
            <form class="register-form" action="signup" method="POST">
                <input type="text" placeholder="Name" name="name"/>
               <input type="email" placeholder="Email ID" name="email"/>
                <input type="password" placeholder="Password" name="pass"/>
                 <label for="accountType">Select Account Type:</label>
                 <select name="accountType" id="accountType">
			    <option value="Student">Student</option>
   				<option value="Teacher">Teacher</option>
   			 	<option value="Admin">Admin</option>
   				</select>
   				<br>
   				<br>
                
                <button>Create</button>
                <p class="message">Already Registered? <a href="#">Login</a></p>


            </form>
            
            <form class="login-form"  action="login" method="POST" onsubmit="return validate()">
                <input type="email" placeholder="Email ID" name="email"  />
                <input type="password" placeholder="Password"  name="pass" required/>

                <button>Login</button>
                <p class="message">Not Registered? <a href="#">Register</a></p>


            </form>



        </div>

    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script>
        $('.message a').click(function() {
            $('form').animate({
                height: "toggle",
                opacity: "toggle"
            }, "slow");
        })
    </script>
    
 


</body>

</html>