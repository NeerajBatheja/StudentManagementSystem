function validate()
{ 
	
     var email = document.form.email.value; 
     var pass = document.form.pass.value;

	
     if (email==null || email=="")
     { 
     alert("email cannot be blank"); 
     return false; 
     }
     else if(pass==null || pass=="")
     { 
     alert("Password cannot be blank"); 
     return false; 
     } 
}