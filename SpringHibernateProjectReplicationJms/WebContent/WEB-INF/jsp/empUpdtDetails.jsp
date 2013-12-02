<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee details</title>
<script>
	$(document).ready(function() {
		$('#deptform').submit(function(event){
			event.preventDefault();
			var empid = document.getElementById('empid').value;
			var fname = document.getElementById('newfname').value;
			var lname = document.getElementById('newlname').value;
			$.ajax({
				  url:"http://localhost:8080/SpringHibernateProject/employee/"+empid,
				  type:"POST",
				  data:"{\"fName\":\""+fname+"\",\"lName\":\""+lname+"\"}",
				  contentType:"application/json;",
				  success:function(data,status){
				    alert(data);
				  }
			});
		});
	});
</script>
</head>
<body>
  	<h3>Update Employee details</h3>
	<div id="formdiv">
		<form id="deptform">
		 Employee Id: &nbsp &nbsp &nbsp<input type="text"id="empid"><br>
		 New First Name: <input type="text"id="newfname"><br>
		 New Last Name:  &nbsp &nbsp<input type="text" id="newlname"><br>
		 <input type="submit" id="submit" value="GO">
		</form>
	</div>
</body>
</html>