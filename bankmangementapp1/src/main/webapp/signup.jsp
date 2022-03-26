<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bankmangementapp.*,java.util.*"%>
    

   
<!DOCTYPE html>
<html>
 <head> 
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css" integrity="sha384-jLKHWM3JRmfMU0A5x5AkjWkw/EYfGUAGagvnfryNV3F9VqM98XiIH7VBGVoxVSc7" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <title>BANK</title>
  
<style>
   
body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password], input[type=number], input[type=date], input[type=email] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
select,select.option {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  background-color: #6BD8E3;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}


/* Extra styles for the cancel button */
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
  position: relative;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 5px;
}

.container2 {
  padding: 90px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* The Modal (background)   LOGIN*/
.modal1 {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  padding-top: -500px;
 
}

/* SIGNUP */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  padding-top: 60px;
  }



/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 60%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
  position: absolute;
  right: 25px;
  top: 0;
  color: #000;
  font-size: 35px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: red;
  cursor: pointer;
}

li {
cursor:pointer;
}




/* Add Zoom Animation */
.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)} 
  to {-webkit-transform: scale(1)}
}
  
@keyframes animatezoom {
  from {transform: scale(0)} 
  to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}


#rcorners3 {
	border-radius: 25px;
	padding-top: 8%;
	padding-bottom: 5%;
	padding-left: 2%;
	padding-right: 2%;
	width: 70%;
	height: 620px;
	margin-top: -100px;
	margin-left: 190px;

}
</style>
</head>
<body>
<div class="shadow p-3 mb-5 bg-white rounded">
    <nav  class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
          <a class="navbar-brand" href="#">
          <img src="images/logo.png"style="width: 250px; height:50px;">
          </a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item"><a class="nav-link active" aria-current="page" href="home.jsp">Home</a></li>
<!--               <li class="nav-item" onclick="document.getElementById('id01').style.display='block'"> <a class="nav-link active" aria-current="page">Login</a></li>
 -->             
            </ul>   
          </div>
        </div>
    </nav>
    </div>
 <div id="rcorners3">   
    <div class="shadow p-3 mb-5 bg-white rounded">
<form  action="customer_signup.html" name="account_signup"  method="post">
    <div class="imgcontainer">

     	<h3 align="center">SIGNUP</h3>
     
    </div>

    <div class="container2">
      <label for="name"><b>Name</b></label>
      <input type="text" placeholder="Enter Name" name="name" required>
      
        <label for="psw"><b>Password</b></label>
      <input type="password"  title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" placeholder="Enter Password" name="password" required>
      
        
       <label for="dob"><b>Date Of Birth</b></label>
      <input type="date" placeholder="Enter Date of birth" name="dateofbirth" required>
       
      <label for="aadhar"><b>Aadhar Number</b></label>
      <input type="number" placeholder="Enter Aadhar Number" name="aadhar" required>
      
      <label for="pan"><b>Pan Card Number</b></label>
      <input type="number" placeholder="Enter Pan Card Number" name="pan" required>
      <br>
      
      <label for="address"><b>Address</b></label>
      <input type="text" placeholder="Enter Address" name="address" required>
      
      <label for="acctype"><b>Account Type</b></label>
      <select name="acctype" required="required">
  			<option value="Current">Current </option>
 			<option value="Saving">Saving</option>
	</select>
   		<br>
   		<label for="nominee"><b>Nominee Name</b></label>
      <input type="text" placeholder="Enter Nominee Name" name="nominee" required>
      
       <label for="phone"><b>Phone Number</b></label>
      <input type="number" placeholder="Enter Phone Number" name="phone" required>
      
      <label for="email"><b>E-mail</b></label>
      <input type="email" placeholder="Enter E-mail" name="email" required>
        
      <button id="myBtn" type="submit">Verify Email</button>
    </div>


  </form>
  
  </div>
 </div> 
  <div id="id01" class="modal1">
  <form class="modal-content animate" action="customer_signup.html" method="post" name="otp_form">
    <div class="imgcontainer">
    
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
     	<h3 align="center">Enter The OTP</h3>
     	
     
    </div>

    <div class="container2">
  
      <label for="otp"><b>Otp</b></label>
      <input type="number" placeholder="Enter Otp" name="otp" required="required">
           <button type="submit">SignUp</button>
     
    </div>

    
  </form>

 </div>
 
</body>
</html>