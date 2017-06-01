<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="../header.jsp">
	<%-- We define a parameter that was used by header.jsp, which is title --%>
	<c:param name="title" value="Branch Form"></c:param>
</c:import>
<spring:url value="/employee/list/branchmanager" var="branchmanagers" />
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var selection = 0;
						selection = '${branch.manager.id}';
						var branchManagerJSONPath = 'http://localhost:8080/transporters/employee/list/only/OtherUser';
						if (parseInt('${branch.id}') >= 0) {
							branchManagerJSONPath = 'http://localhost:8080/transporters/employee/list/only/BranchManager,OtherUser';
						}
						$
								.getJSON(
										branchManagerJSONPath,
										{
											ajax : 'true'
										},
										function(managers) {
											var html = '<option value="">--Select a branch manager</option>';
											var len = managers.length;
											for (var i = 0; i < len; i++) {
												if (managers[i].id == selection) {
													html += '<option value="'+managers[i].id+'" selected>'
															+ managers[i].firstName
															+ ' '
															+ managers[i].lastName
															+ '</option>'
												} else {
													html += '<option value="'+managers[i].id+'">'
															+ managers[i].firstName
															+ ' '
															+ managers[i].lastName
															+ '</option>';
												}
											}
											html += '</option>';

											$('#manager').html(html);
										});
					});
</script>
<div class="container">
	<div class="row">
		<div class="well col-md-2  toppad  pull-right col-md-offset-2 ">
			<A class="btn col-md-6" href="edit.html">Edit Profile</A> <A
				class="btn col-md-6" href="edit.html">Logout</A> <br>
			<p class=" text-info">May 05,2014,03:00 pm</p>
		</div>
		<div
			class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">


			<div id="login-overlay" class="modal-dialog"
				style="padding-top: 20px">
				<div class="modal-content">
					<div class="modal-header">
						<h3 class="modal-title">Branch Form</h3>
					</div>
					<div class="modal-body">
						<div class="well">
							<div class="row">
								<form:form id="contact-form" method="post"
									action="${pageContext.servletContext.contextPath}/branch/form"
									role="form" commandName="branch">
									<form:input type="hidden" path="id" value="${branch.id}" />
									<div class="controls">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label>Name</label>
													<form:input path="name" value="${branch.name}" id="to"
														type="text" name="to" class="form-control"
														placeholder="Enter the official name of the branch"
														required="required" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Manager</label>
													<form:select class="form-control" id="manager"
														path="manager.id">
													</form:select>
													<%-- 													<form:input path="manager.lastName" value="${branch.manager.lastName}" id="manager" type="text" --%>
													<%-- 														name="manager" class="form-control" --%>
													<%-- 														placeholder="Enter the name of the manager and select him/her" --%>
													<%-- 														required="required"/> --%>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Phone Landline</label>
													<form:input path="phoneLandline"
														value="${branch.phoneLandline}" id="phoneLandline"
														type="text" name="phoneLandline" class="form-control"
														placeholder="Enter the landline number"
														required="required" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Mobile Phone</label>
													<form:input path="phoneMobile"
														value="${branch.phoneMobile}" id="mobilePhone" type="text"
														name="mobilePhone" class="form-control"
														placeholder="Enter the mobile phone number"
														required="required" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Country</label>
													<form:input path="address.country"
														value="${branch.address.country}" id="country" type="text"
														name="country" class="form-control"
														placeholder="Enter the country" required="required" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>City</label>
													<form:input path="address.city"
														value="${branch.address.city}" id="city" type="text"
														name="city" class="form-control"
														placeholder="Enter the City" required="required" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Street</label>
													<form:input path="address.street"
														value="${branch.address.street}" id="street" type="text"
														name="street" class="form-control"
														placeholder="Enter Street Info" required="required" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Latitude</label>
													<form:input path="latitude"
														value="${branch.latitude}" id="latitude" type="text"
														name="latitude" class="form-control"
														placeholder="Enter latitude" required="required" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Longitude</label>
													<form:input path="longitude"
														value="${branch.longitude}" id="longitude" type="text"
														name="longitude" class="form-control"
														placeholder="Enter longitude" required="required" />
												</div>
											</div>	
											<div class="col-md-4">
												<div class="form-group">
													<label>Max Orders Per Day</label>
													<form:input path="maxOrdersPerDay"
														value="${branch.maxOrdersPerDay}" id="maxOrdersPerDay" type="number"
														name="maxOrdersPerDay" class="form-control"
														placeholder="Enter Max Orders" max="99" min="1" required="required" />
												</div>
											</div>
											<div class="col-md-12">
												<input type="submit" class="btn btn-success btn-send"
													value="Submit">
											</div>
										</div>
									</div>

								</form:form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<c:import url="../footer.jsp"></c:import>