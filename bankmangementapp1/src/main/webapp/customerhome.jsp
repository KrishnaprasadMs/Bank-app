<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="bankmangementapp.*,java.util.*"%>
<%

%>
<%
Customerdetails cust = (Customerdetails) request.getAttribute("cust-obj");

String errorMessage = (String) session.getAttribute("errorMessage");
String sucessMessage = (String) session.getAttribute("sucessMessage");
ArrayList<TranslationPOJO> translations = (ArrayList<TranslationPOJO>)request.getAttribute("translations");

%>
<%
if (session.getAttribute("customerId") == null) {
	response.sendRedirect("home.jsp");
}
if(session.getAttribute("errorMessage")== null){
	errorMessage = "";
}
if(session.getAttribute("sucessMessage")== null){
	sucessMessage = "";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta http-equiv="X-UA-Compatible" content="ie=edge">

<!-- <link rel="stylesheet" href="assets/css/fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="assets/css/css/style.css"> -->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css"
	integrity="sha384-jLKHWM3JRmfMU0A5x5AkjWkw/EYfGUAGagvnfryNV3F9VqM98XiIH7VBGVoxVSc7"
	crossorigin="anonymous">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/fontawesome.css">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<style>
@import "compass/css3";
 table {
	 font-family: 'Arial';
	 margin: 25px auto;
     width: 100%;
	 border-collapse: collapse;
	 border: 1px solid #eee;
	 border-bottom: 2px solid #0cc;
	 box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.10), 0px 10px 20px rgba(0, 0, 0, 0.05), 0px 20px 20px rgba(0, 0, 0, 0.05), 0px 30px 20px rgba(0, 0, 0, 0.05);
}
 table tr:hover {
	 background: #f4f4f4;
}
 table tr:hover td {
	 color: #555;
}
 table th, table td {
	 color: #999;
	 border: 1px solid #eee;
	 padding: 12px 35px;
	 border-collapse: collapse;
}
 table th {
	 background: #0cc;
	 color: #fff;
	 text-transform: uppercase;
	 font-size: 12px;
}
 table th.last {
	 border-right: none;
	 }
html, body 
	{
	margin: 0; 
	height: 100%; 
	overflow: hidden;
	}

li {
	cursor: pointer;
}

#rcorners2 {
	border-radius: 25px;
	padding: 10%;
	width: 100%;
	height: 150px;
	/* margin-top: -160px; */
}


#rcorners {
	border-radius: 25px;
	padding: 10%;
	width: 100%;
	height: 150px;
	margin-top: 280px;
}

#rcorners3{

	border-radius: 25px;
	padding: 10%;
	width: 100%;
	
	height: 620px;
	margin-top: 700px; 
	overflow: scroll;
}


div.data {
	position: absolute;
	top: 2px;
}

div.left {
	
	margin-left: 650px;
	margin-top: -350px;
}

button.btn {
	  background-color: #04AA6D;
	  border: none;
	  color: white;
	  padding: 4px 10px;
	  text-decoration: none;
	  cursor: pointer;
}

input.btn {
	  background-color: #04AA6D;
	  border: none;
	  color: white;
	  padding: 4px 10px;
	  text-decoration: none;
	  cursor: pointer;
}

.sticky {
  position: fixed;
  top: 0;
  width: 100%;
}

</style>
<title>WELCOME....</title>
</head>
<body>
	<div class="sticky">
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
              <li class="nav-item"><a class="nav-link active" aria-current="page" href="#dashboard">Account</a></li>
              <li class="nav-item"><a class="nav-link active" aria-current="page"
              href="customer-logout.html">Logout</a></li>
             
            </ul>   
          </div>
        </div>
    </nav>
</div>
</div>	






<div id="dashboard" style="margin-top: -25px">
		
	<div id="rcorners2">
			<div class="shadow p-3 mb-5 bg-white rounded" >
				<div class="container">
					<form method="POST" class="register-form" id="register-form">
					<small style="color: red;"><%=errorMessage %></small>
					<small style="color: green;"><%=sucessMessage %></small>
						<h4 align="center" style="color: blue;">
						
							Welcome
							<%=cust.getCustomerName()%></h4>
						<br>
						
						
						<h5>
							Account Number :
							<%=cust.getAccountNumber()%></h5>
						<br>
						<h5>
							Balance :
							<%=cust.getAccountBalance()%></h5>
						<br>
						<h5>
							Email ID :
							<%=cust.getEmailId()%></h5>
						<br>
						<h5>
							Aadhar no :
							<%=cust.getAadhaar()%></h5>
						<br>
						<h5>
							Account Type :
							<%=cust.getAccountType() %></h5>
						<br>

					</form>

				</div>
				
				<br><br><br>
				
			<div class="left">
				<div class="container">
					
					    <h5>
							Address :
							<%=cust.getAddress()%></h5>
						<br>
						<h5>
							Pan Number :
							<%=cust.getPanNumber()%></h5>
						<br>
						<h5>
							Nominee Name :
							<%=cust.getNomineeName()%></h5>
						<br>
						<h5>
							Phone number :
							<%=cust.getPhoneNumber()%></h5>
						<br>
						<h5>
							Date Of Birth:
							<%=cust.getDateOfBirth()%></h5>
						<br>

				</div>

			</div>
	
	
	
<!-- 	BUTTON -->
	   <br>
			<div align="center">

					<a  href="#updateProfile"><button class= "btn">UPDATE PROFILE</button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a  href="#deposit"><button class= "btn">DEPOSIT MONEY</button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="#withdrawal"><button class= "btn">WITHDRAW MONEY</button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="#transfer"><button class= "btn">TRANSFER MONEY</button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="#statement"><button class= "btn">STATEMENT</button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="#fdrddeposit"><button class= "btn">FD/RD DEPOSIT</button></a>
				
			</div>
			
			
		</div>
	</div>			
</div>				
	
	
	
<!-- 	BUTTON -->

<!-- Update Profile -->
	<div id="updateProfile">
		<div id="rcorners">
			<div class="shadow p-3 mb-5 bg-white rounded" align="center">        	
				<h4 align="center" style="color: blue;">UPDATE PROFILE</h4> <br><br><br>
					  <form action="update-customer-profile.html" method="post" >
					  <div class="col">
						  <label for="idaddamount"> Phone number :</label>&nbsp;&nbsp;&nbsp;
						  <input required="required"  type="number" id="idaddamount" value="<%=cust.getPhoneNumber()%>" name="phoneNumber">&nbsp;&nbsp;&nbsp;
						    &nbsp;&nbsp;
						    <label for="idaddamount">Address :</label>&nbsp;&nbsp;&nbsp;
						  <input required="required"  type="text" id="idaddamount" value="<%=cust.getAddress()%>" name="address">&nbsp;&nbsp;&nbsp;
						    &nbsp;&nbsp;
						    </div>
						    <div style="margin-top: 40px">
						    <label for="idaddamount">Nominee Name :</label>&nbsp;&nbsp;&nbsp;
						  <input required="required" type="text" id="idaddamount" value="<%=cust.getNomineeName()%>" name="nomineeName">&nbsp;&nbsp;&nbsp;
						    &nbsp;&nbsp;
						    <label for="idaddamount">Email ID :</label>&nbsp;&nbsp;&nbsp;
						  <input required="required" type="email" id="idaddamount" value="<%=cust.getEmailId()%>" name="emailId">&nbsp;&nbsp;&nbsp;
						    &nbsp;&nbsp;
						    </div>
							<input style="margin-top: 40px; margin-left: 50%;width: 10%" class= "btn" type="submit" value="Update"><br>
						<br>
					  </form>	
			</div>	
		</div>
	</div>			

<!-- Update Profile -->

<!-- DEPOSIT -->
	<div id="deposit">
		<div id="rcorners">
			<div class="shadow p-3 mb-5 bg-white rounded" align="center">        	
				<h4 align="center" style="color: blue;">DEPOSIT</h4> <br><br><br>
					  <form action="add-money.html" method="post" >
						  <label for="idaddamount">Add Amount:</label>&nbsp;&nbsp;&nbsp;
						  <input required="required" type="number" id="idaddamount" name="addamount" min="100">&nbsp;&nbsp;&nbsp;
						    &nbsp;&nbsp;  
							<input class= "btn" type="submit" value="Add amount"><br>
						<br>
					  </form>	
			</div>	
		</div>
	</div>			

<!-- DEPOSIT -->

<!-- WITHDRAWAL -->
<div id="withdrawal">
	<div id="rcorners">
		<div class="shadow p-3 mb-5 bg-white rounded" align="center">        	
			<h4 align="center" style="color: blue;">WITHDRAWAL</h4> <br><br><br>	
					<form action="withdraw-money.html">
						<label for="idwithdraw">Withdraw:</label><br> <input
							type="number" id="idwithdraw" name="withdrawamount" required="required" min="100">
						&nbsp;&nbsp; 
							<input class= "btn" type="submit" value="Withdraw"><br>
						<br>
					</form>
					</div>
					</div>
		</div>		
		
<!-- WITHDRAWAL -->



<!-- FD/RDAMOUNT -->
<div id="fdrddeposit">
	<div id="rcorners">
		<div class="shadow p-3 mb-5 bg-white rounded" align="center">        	
			<h4 align="center" style="color: blue;">FIXED/RECURRING DEPOSIT</h4> <br><br><br>	
					
					<form action="fd-rd-deposit.html" method="post">
				

<div class="row">
<div class="col-2"></div>
<div class="col-4">
<input style="float: right;width: 75%;" type="number" min="1000" placeholder="Enter Amount Here.." name="addamount" required="required">
</div>
<div class="col-2">
<select style="height: 1.8em; width:100%;"  aria-label="Default select example" name="duration" required="required">
  <option value="3">3 Month</option>
  <option value="6">6 Month</option>
  <option value="9">9 Month</option>
   <option value="12">12 Month</option>
  <option value="15">15 Month</option>
  <option value="18">18 Month</option>
</select>
</div>
  <div class="col-1">
  <p>
  <input class="w3-radio" type="radio" name="fdOrRdType" value="Fd_interest_rate" checked>
  <label>Fixed</label></p></div>
  <div class="col-2">
  <p style="float: left;">
  <input class="w3-radio" type="radio" name="fdOrRdType" value="Rd_interest_rate">
  <label>Recurring</label></p></div>
  </div>
<br>
<input style="margin-right: -21%" class= "btn" type="submit" value="Add Money"><br>
						<br>
  
				</form>
					</div>
					</div>
		</div>		
		
<!-- FD/RDAMOUNT -->


<!-- TRANSFER -->
<div id="transfer">
<div id="rcorners">
		<div class="shadow p-3 mb-5 bg-white rounded" align="center">   
			<h4 align="center" style="color: blue;">TRANSFER</h4> <br><br><br>	 
				<form action="transfer-money.html">
						<label for="idtransferamount">Transfer Amount:</label>&nbsp;&nbsp;&nbsp; <input
							type="number" id="idtransferamount" name="transferAmount"
							placeholder="Enter Amount " style="margin-right: 90px;" required="required" min="100">
							<br>
						<br> <label for="idtoaccount" >Account Number:</label>&nbsp;&nbsp;&nbsp; <input
							type="number" id="idtoaccount" name="toaccountNo"
							placeholder="Enter Recipient Account number " required="required">
						    &nbsp;&nbsp; <input  class= "btn" type="submit"
							value="Transfer">
					</form>
					</div>
					</div>
		</div>		
					
<!-- TRANSFER -->

<div id="statement"  >
<div id="rcorners3" style="padding-bottom: 1%">
		<div class="shadow p-3 mb-5 bg-white rounded" align="center">   
			<h4 align="center" style="color: blue;">STATEMENT</h4> 
<table>
    <thead>
      <tr>
        <th>Date/Time</th>
        <th>Translation</th>
        <th>Amount</th>
        <th>Balance</th>
      </tr>
    </thead>
    <tbody>
    <% int i=0;
			LOOP: for (int I = (translations.size()-1); I >= 0 ; I--) {
				i++;
				if(i>10){break LOOP;}
		%>
      <tr>
        <td><%=translations.get(I).getTimeDate()%></td>
        <td><%=translations.get(I).getTranslation()%></td>
        <td><%=translations.get(I).getAmount()%></td>
        <td><%=translations.get(I).getAccountBalance()%></td>
      </tr>
       <%
		}
		%>
    </tbody>
  </table>
					</div>
					</div>
		</div>		


<script>
window.onscroll = function() {myFunction()};

var navbar = document.getElementById("navbar");
var sticky = navbar.offsetTop;

function myFunction() {
  if (window.pageYOffset >= sticky) {
    navbar.classList.add("sticky")
  } else {
    navbar.classList.remove("sticky");
  }
}
</script>



</body>
</html>