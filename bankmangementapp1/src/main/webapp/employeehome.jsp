<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="bankmangementapp.*,java.util.*"%>
	<%
    ArrayList<Customerdetails> customers = (ArrayList<Customerdetails>)request.getAttribute("customers"); 
    ArrayList<Customerdetails> activecustomers = (ArrayList<Customerdetails>)request.getAttribute("activecustomers"); 

	request.setAttribute("customers", customers);
	long asset = (long) request.getAttribute("asset");
	long NoofCust = (long) request.getAttribute("NoofCust");
	float[] getAllInterestRate = (float[]) request.getAttribute("getAllInterestRate");
	Customerdetails cust = (Customerdetails) session.getAttribute("viewcustomer");
	
	String errorMessage = (String) session.getAttribute("errorMessage");
	String sucessMessage = (String) session.getAttribute("sucessMessage");
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
body {
	background-image: url("./images/cam.jpg");
	background-repeat: no-repeat;
	background-size: 100% 100%;
	overflow: hidden;
}

html {
	height: 150%
}

#rcorners2 {
	border-radius: 25px;
	padding-top: 8%;
	padding-bottom: 10%;
	padding-left: 5%;
	padding-right: 5%;
	width: 100%;
	height: 150px;
	margin-top: 80px;
}

#rcorners3 {
	border-radius: 25px;
	padding-top: 8%;
	padding-bottom: 5%;
	padding-left: 2%;
	padding-right: 2%;
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
	margin-top: -210px;
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

@import url(https://fonts.googleapis.com/css?family=Open+Sans);


.search {
  width: 100%;
  
  display: flex;
}

.searchTerm {
 align-content:center;
  border: 3px solid #00B4CC;
  border-right: none;
  padding: 5px;
  height: 20px;
  border-radius: 5px 0 0 5px;
  outline: none;
  color: #9DBFAF;
}

.searchTerm:focus{
  color: #00B4CC;
}

.searchButton {
  width: 40px;
  height: 36px;
  border: 1px solid #00B4CC;
  background: #00B4CC;
  text-align: center;
  color: #fff;
  border-radius: 0 5px 5px 0;
  cursor: pointer;
  font-size: 20px;
}

/*Resize the wrap to see the search bar change!*/
.wrap{
  width: 30%;
 
  top: 50%;
  margin-left: -30%;
  padding-bottom: 2%;

}

#rcorners4 {
	border-radius: 25px;
	padding-top: 8%;
	padding-bottom: 10%;
	padding-left: 5%;
	padding-right: 5%;
	width: 100%;
	height:600px;
	margin-top: 100px;
	overflow: scroll;
}

</style>
<title>WELCOME EMPLOYEE</title>
</head>
<body>
	<div class="sticky">
		<div class="shadow p-3 mb-5 bg-white rounded">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container">
					<a class="navbar-brand" href="#"> 
					<img src="images/logo.png"style="width: 250px; height:50px;">
					</a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarNav"
						aria-controls="navbarNav" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse justify-content-end"
						id="navbarNav">
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="#dashboard">Account</a></li>
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="employee-logOut.html">Logout</a></li>

						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>

	<div id="dashboard" >
		<div id="rcorners2">
			<div class="shadow p-3 mb-5 bg-white rounded">
				<div class="container">
					<form>
					<small style="color: red;"><%=errorMessage %></small>
					<small style="color: green;"><%=sucessMessage %></small>
						<h4 align="center" style="color: blue;">Welcome Employee</h4>

						<br> <br>

						<h5 style="margin-left: 150px;">TOTAL ASSET</h5>
						<br>
						<br>
						<br>

						<h4 style="margin-left: 150px;"><%=asset %> Rs</h4>


					</form>

				</div>

				<br>
				<br>
				<br>

				<div class="left">
					<div class="container">

						<h5 style="margin-left: 30px;">NUMBER OF CUSTOMERS</h5>
						<br>
						<br>
						<br>
						<h4 style="margin-left: 30px;"><%=NoofCust %> Satisfied Customers</h4>

					</div>

				</div>



				<!-- 	BUTTON -->

				<div align="center">
					<br>
					<br>
					<br> <a href="#pendingstatus"><button class="btn">PENDING
							STATUS</button></a> &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;  
<!-- 							<a href="#searchcustomer"><button class="btn">SEARCH CUSTOMER</button></a> &nbsp;&nbsp; 
 -->							<a
						href="#viewcustomer"><button class="btn">VIEW
							SEARCH/CUSTOMER DETAILS</button></a> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;  
<!-- 							<a href="#updatecustomer"><button class="btn">UPDATE CUSTOMER DETAILS</button></a> &nbsp;&nbsp;
 -->							 <a
						href="#updateinterest"><button class="btn">UPDATE
							INTEREST RATE</button></a> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 

				</div>
				<!-- 	BUTTON -->
			</div>
		</div>
	</div>


	<!-- PENDING STATUS -->



	<br>
	<br>
	<br>
	<div id="pendingstatus">
		<div id="rcorners3" style="padding-top: 10%">
			
	<h4 align="center" style="color: blue;">PENDING STATUS</h4>
				
	<div class="container" style="margin-right: 0%;padding-top: 8px; margin-left: 0%;padding-right: 0%;padding-left: 2%; ">
	
<table class="table table-bordered">
  <thead>
			<tr>
				<th>Customer Id</th>
				<th>Customer Name</th>
				<th>Phone Number</th>
				<th>Email Id</th>
			    <th>Pan Number</th>
				<th>Address</th>
				<th>Nominee Name</th>
				<th>Account Type</th>
				<th>Aadhaar Number</th>
				<th>Data Of Birth</th>
				<th>Approve</th>
				<th>Reject</th>
			</tr>
		</thead>
  <tbody>
		<%
		for (int I = 0; I < customers.size(); I++) {
		%>
			<tr>
				<td><%=customers.get(I).getCustomerId()%></td>
				<td><%=customers.get(I).getCustomerName()%></td>
				<td><%=customers.get(I).getPhoneNumber()%></td>
				<td><%=customers.get(I).getEmailId()%></td>
				<td><%=customers.get(I).getPanNumber()%></td>
				<td><%=customers.get(I).getAddress()%></td>
				<td><%=customers.get(I).getNomineeName()%></td>
				<td><%=customers.get(I).getAccountType()%></td>
				<td><%=customers.get(I).getAadhaar()%></td>
				<td><%=customers.get(I).getDateOfBirth()%></td>
				<td> <button type="button" class="btn btn-outline-success" onclick="window.location.href='approve-customer-status.html?emailId=<%=customers.get(I).getEmailId()%>&customerId=<%=customers.get(I).getCustomerId()%>&accountType=<%=customers.get(I).getAccountType()%>';">Approve</button></td>
				<td> <button type="button" class="btn btn-outline-danger" onclick="window.location.href='reject-customer-status.html?emailId=<%=customers.get(I).getEmailId()%>&customerId=<%=customers.get(I).getCustomerId()%>';">Reject</button></td>
				
			</tr>
			<%
		}
		%>
		</tbody>
	</table>


</div>
</div>
</div>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- PENDING STATUS -->


	<!-- SEARCH CUSTOMER -->
	<div id="searchcustomer" style="margin-top: -25px">
		<div id="rcorners4">
			<div class="shadow p-3 mb-5 bg-white rounded" >
				<div class="container">
					<form method="POST" class="register-form" id="register-form">
						<h4 align="center" style="color: blue;">
							Customer Name :
							<%=cust.getCustomerName()%></h4>
						
						<br><br>
						<div style="margin-left: 8%">
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
						<h5>
							Interest Rate :
							<%=cust.getInterestRate() %></h5>
						<br>
						
						</div>

					</form>

				</div>
				
				
			<div class="left">
				<div class="container" style="margin-top: -390px; margin-left: 8%">
				 
					<br>
					<br>
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
						<h5>
							FD Amount:
							<%=cust.getFdAmount()%></h5>
						<br>
				</div>
		
	</div>
	</div>
	</div>
	</div>
	<!-- SEARCH CUSTOMER -->

	<!-- VIEW CUSTOMER DETAILS -->




	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div id="viewcustomer">
	<div id="rcorners3">
		
			<div class="shadow p-3 mb-5 bg-white rounded" align="center">
				<h4 align="center" style="color: blue;">VIEW CUSTOMER DETAILS</h4>
				<br>
	 <form action="view-customer-details.html" method="post">			
	<div class="container" style="margin-right: 0%;padding-top: 8px; margin-left: 0%;padding-right: 0%;padding-left: 2%; ">
	<div class="wrap" >
   <div class="search">
     
      <input required="required"  name="customerId" size="85" style="height: 1%;" type="text" class="searchTerm" placeholder="enter customer id to search details.....">
      <button type="submit" class="searchButton">
       <i class="fa fa-search"></i>
     </button>
     
       
   </div>
</div>
</div>
 </form>
<table class="table table-bordered">
  <thead>
			<tr>
				<th>Customer Id</th>
				<th>Customer Name</th>
				<th>Phone Number</th>
				<th>Email Id</th>
			    <th>Pan Number</th>
				<th>Address</th>
				<th>Nominee Name</th>
				<th>Account Type</th>
				<th>Aadhaar Number</th>
				<th>Data Of Birth</th>
				<th>More</th>
			</tr>
		</thead>
  <tbody>
		<%
		for (int I = 0; I < activecustomers.size(); I++) {
		%>
			<tr>
				<td><%=activecustomers.get(I).getCustomerId()%></td>
				<td><%=activecustomers.get(I).getCustomerName()%></td>
				<td><%=activecustomers.get(I).getPhoneNumber()%></td>
				<td><%=activecustomers.get(I).getEmailId()%></td>
				<td><%=activecustomers.get(I).getPanNumber()%></td>
				<td><%=activecustomers.get(I).getAddress()%></td>
				<td><%=activecustomers.get(I).getNomineeName()%></td>
				<td><%=activecustomers.get(I).getAccountType()%></td>
				<td><%=activecustomers.get(I).getAadhaar()%></td>
				<td><%=activecustomers.get(I).getDateOfBirth()%></td>
				<td>
				<form action="view-customer-details.html" method="post">
				<input type="hidden" name="customerId" value="<%=activecustomers.get(I).getCustomerId()%>">
				<button type="submit" class="btn btn-outline-light">Details</button>
				</form>
				</td>
			</tr>
			<%
		}
		%>
		</tbody>
	</table>


</div>
				<form action="add-amount" method="post"></form>
			</div>
		</div>
	</div>
	<!-- VIEW CUSTOMER DETAILS -->


	<!-- UPDATE CUSTOMER -->



	<br>
	<br>
	<br>
	<div id="updatecustomer">
		<div id="rcorners3">
			<div class="shadow p-3 mb-5 bg-white rounded" align="center">
				<h4 align="center" style="color: blue;">UPDATE CUSTOMER</h4>
				<br>
				<br>
				<br>
				<form action="add-amount" method="post"></form>
			</div>
		</div>
	</div>


	<!-- UPDATE CUSTOMER -->


	<!-- UPDATE INTEREST RATE -->
	<br>
	<br>
	<br>
	<div id="updateinterest">
		<div id="rcorners3">
			<div class="shadow p-3 mb-5 bg-white rounded" align="center">
				<h4 align="center" style="color: blue;">UPDATE INTEREST RATE</h4>
				<br>
				
						<h5>
							Saving Interest Rate :
							<%=getAllInterestRate[0]%></h5>
						<br>
						<h5>
							Current Interest Rate :
							<%=getAllInterestRate[1]%></h5>
						<br>
						<h5>
							Fixed Interest Rate :
							<%=getAllInterestRate[2]%></h5>
						<br>
						<h5>
							Recurring Interest Rate :
							<%=getAllInterestRate[3]%></h5>
						<br>
						<br>
						
	<form action="update-interest-rate.html" method="post">
				

<div class="row">
<div class="col-1"></div>
<div class="col-5">
<input style="float: right;" type="text" size="40" placeholder="Enter Interest Rate Here.." name="interestRate" required="required">
</div>
<div class="col-1">
  <p>
  <input class="w3-radio" type="radio" name="accounType" value="saving" checked>
  <label>Saving</label></p></div>
  <div class="col-1">
  <p>
  <input class="w3-radio" type="radio" name="accounType" value="current">
  <label>Current</label></p></div>
  <div class="col-1">
  <p>
  <input class="w3-radio" type="radio" name="accounType" value="fixed">
  <label>Fixed</label></p></div>
  <div class="col-2">
  <p style="float: left;">
  <input class="w3-radio" type="radio" name="accounType" value="recurring">
  <label>Recurring</label></p></div>
  </div>

  <button style="margin-right: 13%" type="submit" class="btn btn-outline-light">Update Interest</button>
				</form>
				</div>
				
			
			</div>
		</div>
	






	<!-- UPDATE INTEREST RATE -->

</body>
</html>