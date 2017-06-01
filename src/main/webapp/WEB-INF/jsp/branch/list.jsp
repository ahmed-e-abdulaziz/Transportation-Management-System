<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../header.jsp">
	<%-- We define a parameter that was used by header.jsp, which is title --%>
	<c:param name="title" value="Branches List"></c:param>
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
				<h3 class="col-md-6">Branches</h3>

				<a href="${pageContext.servletContext.contextPath}/branch/form" class="btn btn-primary btn-xs pull-right"><b>+</b>
					Add new branch</a>
			</div>
			<table class="table table-hover ">
				<thead>
					<tr>
						<th>Name</th>
						<th>Manager</th>
						<th>Address</th>
						<th>Landline</th>
						<th>Mobile</th>
						<th class="text-center">Action</th>
					</tr>
				</thead>
				<c:forEach  var="branch" items="${branches}">
				<tr>
					<td><a href="${pageContext.servletContext.contextPath}/branch/show/${branch.id}">${branch.name}</a></td>
					<td>${branch.manager.firstName} ${branch.manager.middleName} ${branch.manager.lastName}</td>
					<td>${branch.address.street},${branch.address.city},${branch.address.country}</td>
					<td>${branch.phoneMobile}</td>
					<td>${branch.phoneLandline}</td> 
					<td class="text-center"><a class='btn btn-info btn-xs'
						href="${pageContext.servletContext.contextPath}/branch/edit/${branch.id}"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a
						href="${pageContext.servletContext.contextPath}/branch/delete/${branch.id}" class="btn btn-danger btn-xs"><span
							class="glyphicon glyphicon-remove"></span> Del</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<c:import url="../footer.jsp"></c:import>