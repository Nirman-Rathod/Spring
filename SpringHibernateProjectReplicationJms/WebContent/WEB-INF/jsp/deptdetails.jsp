<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Department details</title>
<script>
	$(document).ready(function() {
		$('#deptform').submit(function(event){
			event.preventDefault();
			var empid = document.getElementById('empid').value;
			var deptid = document.getElementById('deptid').value;
			var newdept = document.getElementById('newdept').value;
			var newloc = document.getElementById('newloc').value;
			$.ajax({
				  url:"http://localhost:8080/SpringHibernateProject/employee/"+empid+"/dept/"+deptid,
				  type:"POST",
				  data:"{\"deptName\":\""+newdept+"\",\"location\":\""+newloc+"\"}",
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
  	<h3>Update Department details</h3>
	<div id="formdiv">
		<form id="deptform">
		 Employee Id: &nbsp &nbsp &nbsp<input type="text"id="empid"><br>
		 Department Id: &nbsp &nbsp<input type="text" id="deptid"><br>
		 New Dept Name: <input type="text"id="newdept"><br>
		 New Location:  &nbsp &nbsp<input type="text" id="newloc"><br>
		 <input type="submit" id="submit" value="GO">
		</form>
	</div>
</body>
</html>