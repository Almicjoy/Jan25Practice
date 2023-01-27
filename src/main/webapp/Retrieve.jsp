<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "java.util.List, java.util.ArrayList, com.demo.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Employee Registration</title>
	<link href="http://localhost:8080/Jan25Practice/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<%
		List<Employee> employees = (ArrayList<Employee>) request.getAttribute("emp");
	%>
	<table class="table">
		<tr>
			<th>EMP ID</th>
			<th>Name</th>
			<th>Department</th>
			<th>Salary</th>
		</tr>
		
		
		<% for(Employee e: employees) { %>
		<tr>
			<td>&nbsp;<%= e.getId() %>&nbsp;</td>
			<td>&nbsp;<%= e.getName() %>&nbsp;</td>
			<td>&nbsp;<%= e.getDept() %>&nbsp;</td>
			<td>&nbsp;<%= e.getSalary() %>&nbsp;</td>
			
		</tr>
		<% } %>
	</table>
	</div>
	<hr>
	<div class="container">
		
		<form action="DeleteServlet" method="post" class="form-group">
			<input type="submit" value="Delete by ID"/>
			<input type="text" name="deleteId" id="deleteId" required/>
		</form>
	</div>
	<hr>
	<div class="container">
		
		<form action="UpdateSalaryServlet" method="post" class="form-group">
			<input type="submit" value="Update Salary by ID"/>
			<label>ID</label>
			<input type="text" name="updateSalaryId" id="updateSalaryId" required/>
			<label>Updated Salary</label>
			<input type="text" name="newSalary" id="newSalary" required/>
			
		</form>
	</div>
	<hr>
	<div class="container">
		<a href="EmployeeForm.jsp" class="btn btn-primary">Register Another Employee</a>
	</div>
		
</body>
</html>