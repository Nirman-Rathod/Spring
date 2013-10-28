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
		$("p").css("font-size","15px");
		$(".abc").css("font-size","15px");
		$('#empform').submit(function(event){
			event.preventDefault();
			var empIdData = document.getElementById('empiddata').value;
			$.ajax({
				  url:"http://localhost:8080/SpringHibernateProject/employee/"+empIdData,
				  type:"GET",
				  success:function(data,status){
					$('#empid').html(data.empId);
					$('#empName').html(data.fName + " "+ data.lName);
					var table='<table border="1">';
				    table+='<th>Department Id</th><th>Department Name</th><th>Location</th>';
				    $.each(data.listOfDepts,function(i,value){
				    table+='<tr><td>'+(i+1) + '</td><td>'+ value.deptName + '</td><td>' + value.location+'</td></tr>';
					});
 				      table+='</table>';
 				      $('#tablediv').html(table);
				  }
			});
		});
	});
</script>
</head>
<body>
<h2>Employee Details</h2>
	<div id="formdiv">
		<form id="empform">
		Enter the employee id:<input type="text" id="empiddata"><br><br>
		<input type="submit" id="submit" value="GO">
		</form>
	</div>
<br>
<span class="abc">Employee Id:</span><span id="empid"></span><br>
<span class="abc">Employee Name:</span><span id="empName"></span><br>
<p>Department Details:</p>
<div id="tablediv">
</div>
</body>
</html>