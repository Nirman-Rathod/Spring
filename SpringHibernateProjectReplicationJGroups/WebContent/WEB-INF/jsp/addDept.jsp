<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register new Employee</title>
<script>
	$(document).ready(function() {
		$('#empform').submit(function(event){
			event.preventDefault();
			var empId = document.getElementById('empId').value;
			var deptName = document.getElementById('deptName').value;
			var deptLoc = document.getElementById('deptLoc').value;
			$.ajax({
				  url:"http://localhost:8080/SpringHibernateProject/employee/"+empId+"/dept",
				  type:"POST",
				  data:"{\"deptName\":\""+deptName+"\",\"location\":\""+deptLoc+"\"}",
				  contentType:"application/json;",
				  success:function(data){
					alert(data);
				  }
			});
		});
	});
</script>
</head>
<body>
<h3>Save Department details</h3>
	<div id="formdiv">
		<form id="empform">
			Enter employee id:<input type="text"id="empId"><br>
		    Department Name:<input type="text" id="deptName"><br> 
		    Department Location:<input type="text" id="deptLoc"><br>
		    <input type="submit" id="submit" value="GO">
		</form>
	</div>
	<div id="fname"></div>
	<div id="lname"></div>
</body>
</html>