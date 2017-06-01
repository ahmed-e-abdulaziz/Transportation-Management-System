<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../header.jsp">
	<%-- We define a parameter that was used by header.jsp, which is title --%>
	<c:param name="title" value="Customers List"></c:param>
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
				<h3 class="col-md-6">Customers</h3>

				<a href="${pageContext.servletContext.contextPath}/customer/form" class="btn btn-primary btn-xs pull-right"><b>+</b>
					Add new customer</a>
			</div>
			<table class="table table-hover ">
				<thead>
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Address</th>
						<th>Landline</th>
						<th>Mobile</th>
						<th>Credit</th>
						<th class="text-center">Action</th>
					</tr>
				</thead>
				<c:forEach  var="customer" items="${customers}">
				<tr>
					<td><a href="${pageContext.servletContext.contextPath}/customer/show/${customer.id}">${customer.firstName} ${customer.lastName}</a></td>
					<td>${customer.email}</td>
					<td>${customer.address.street}, ${customer.address.city}, ${customer.address.country}</td>
					<td>${customer.phoneMobile}</td>
					<td>${customer.phoneLandline}</td> 
					<td>${customer.credit}</td> 
					<td class="text-center"><a class='btn btn-info btn-xs'
						href="${pageContext.servletContext.contextPath}/customer/edit/${customer.id}"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a
						href="${pageContext.servletContext.contextPath}/customer/delete/${customer.id}" class="btn btn-danger btn-xs"><span
							class="glyphicon glyphicon-remove"></span> Del</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<c:import url="../footer.jsp"></c:import>