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
			var empFName = document.getElementById('empFName').value;
			var empLName = document.getElementById('empLName').value;
			$.ajax({
				  url:"http://localhost:8080/SpringHibernateProject/employee",
				  type:"POST",
				  data:"{\"fName\":\""+empFName+"\",\"lName\":\""+empLName+"\"}",
				  contentType:"application/json;",
				  success:function(data,status){
					var obj = $.parseJSON(data);
					alert(obj.data);
					$('#empform').trigger('reset');
				  }
			});
		});
	});
</script>
</head>
<body>
  	<h3>Register new Employee</h3>
	<div id="formdiv">
		<form id="empform">
		 First Name:<input type="text"id="empFName"><br>
		 Last Name:<input type="text" id="empLName"><br> <input type="submit" id="submit" value="GO">
		</form>
	</div>
	<div id="fname"></div>
	<div id="lname"></div>
</body>
</html>