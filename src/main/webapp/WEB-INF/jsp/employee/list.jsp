<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../header.jsp">
	<%-- We define a parameter that was used by header.jsp, which is title --%>
	<c:param name="title" value="Employees List"></c:param>
</c:import>

<div class="container">
	<div class="well col-md-2   pull-right col-md-offset-2 ">
		<A class="btn col-md-6" href="edit.html">Edit Profile</A> <A
			class="btn col-md-6" href="edit.html">Logout</A> <br>
		<p class=" text-info">May 05,2014,03:00 pm</p>
	</div>
	<div class="col-md-12">
	<div class="well">
		<div class="row col-md-12">
				<h3 class="col-md-6">Employees</h3>

				<a href="${pageContext.servletContext.contextPath}/employee/form" class="btn btn-primary btn-xs pull-right"><b>+</b>
					Add new employee</a>
			</div>
			<table class="table table-hover table-responsive ">
				<thead>
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Position</th>
						<th>Manager</th>
						<th>Branch</th>
						<th class="text-center">Action</th>
					</tr>
				</thead>
				<c:forEach  var="employee" items="${employees}">
				<tr>
					<td><a href="${pageContext.servletContext.contextPath}/employee/show/${employee.id}">${employee.firstName} ${employee.lastName}</a></td>
					<td>${employee.utype.type}</td>
					<td>${employee.address.street}, ${employee.address.city}, ${employee.address.country}</td>
					<td><c:if test="${not empty employee.manager.firstName}">${employee.manager.firstName} ${employee.manager.lastName }</c:if>
						<c:if test="${empty employee.manager.firstName}">N/A</c:if>
					</td>
					<td>${employee.branch.name}</td> 
					<td class="text-center"><a class='btn btn-info btn-xs'
						href="${pageContext.servletContext.contextPath}/employee/edit/${employee.id}"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a
						href="${pageContext.servletContext.contextPath}/employee/delete/${employee.id}" class="btn btn-danger btn-xs"><span
							class="glyphicon glyphicon-remove"></span> Del</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<c:import url="../footer.jsp"></c:import>