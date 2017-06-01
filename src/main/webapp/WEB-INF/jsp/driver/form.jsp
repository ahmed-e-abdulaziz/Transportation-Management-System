<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:import url="../header.jsp">
	<%-- We define a parameter that was used by header.jsp, which is title --%>
	<c:param name="title" value="Account Form"></c:param>
</c:import>
<script type="text/javascript">
	$(document).ready(function() {
		$('#pickyDate').datepicker({
			viewMode : "years",
			format : "yyyy/mm/dd",
			autoclose : true
		}).on('changeDate', function(ev) {
			if (ev.viewMode === 'days') {
				$(this).datepicker('hide');
			}
		});
		;
	});
</script>
<script type="text/javascript">
$(document)
		.ready(
				function() {
					var selection = 0;
					selection = '${driver.manager.id}';
					var driverselection =0;
					driverselection='${driver.truck.id}';
					var branchselection =0;
					branchselection='${driver.branch.id}';
					
					var managerJSONPath = 'http://localhost:8080/transporters/employee/list/only/DriversCoordinator';
					var truckJSONPath = 'http://localhost:8080/transporters/truck/list/json/available';
					var branchJSONPath = 'http://localhost:8080/transporters/branch/list/json';		
					'http://localhost:8080/transporters/truck/list/json/available';
					if(parseInt('${driver.id}')>=0){
						truckJSONPath='http://localhost:8080/transporters/truck/list/json/available/${driver.truck.id}';
						}
					$.getJSON(
							managerJSONPath,
								{
								ajax : 'true'
							},
							function(managers) {
								var html = '<option value="">--Select a manager</option>';
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
					

					$.getJSON(
							branchJSONPath,
								{
								ajax : 'true'
							},
							function(branches) {
								var html = '<option value="">--Select a branch</option>';
								var len = branches.length;
								for (var i = 0; i < len; i++) {
									if (branches[i].id == branchselection) {
										html += '<option value="'+branches[i].id+'" selected>'
												+ branches[i].name
												+ '</option>'
									} else {
										html += '<option value="'+branches[i].id+'">'
												+ branches[i].name
												+ '</option>';
									}
								}
								html += '</option>';

								$('#branch').html(html);
							});
					$.getJSON(
							truckJSONPath,
								{
								ajax : 'true'
							},
							function(trucks) {
								var html = '<option value="">--Select a truck</option>';
								var len = trucks.length;
								for (var i = 0; i < len; i++) {
									if (trucks[i].id == driverselection) {
										html += '<option value="'+trucks[i].id+'" selected>'
												+ trucks[i].plate
												+ '</option>'
									} else {
										html += '<option value="'+trucks[i].id+'">'
												+ trucks[i].plate
												+ '</option>';
									}
								}
								html += '</option>';

								$('#truck').html(html);
							});
				});
</script>
<div class="container">
	<div id="login-overlay" class="modal-dialog" style="padding-top: 20px">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">Account Form.</h4>
			</div>
			<div class=" modal-body">
				<form:form commandName="driver" id="loginForm" method="POST"
					action="${pageContext.servletContext.contextPath}/driver/form">
					<form:hidden path="id" value="${driver.id}" />
					<div class="well">
						<div class="row">
							<div class="col-xs-4 col-sm-4 col-md-4">
								<div class="form-group">
									<form:input path="firstName" type="text"
										value="${driver.firstName}" name="first_name" id="first_name"
										class="form-control input-sm" placeholder="First Name"
										required="required" />
								</div>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4">
								<div class="form-group">
									<form:input path="middleName" type="text"
										value="${driver.middleName}" name="middle_name"
										id="middle_name" class="form-control input-sm"
										placeholder="Middle Name (Father's)" required="required" />
								</div>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4">
								<div class="form-group">
									<form:input path="lastName" type="text"
										value="${driver.lastName}" name="last_name" id="last_name"
										class="form-control input-sm" placeholder="Last Name"
										required="required" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<form:input path="password" type="password" name="password"
											id="password" class="form-control input-sm"
											required="required" placeholder="Password" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="password" name="password_confirmation"
											id="password_confirmation" class="form-control input-sm"
											placeholder="Confirm Password" required="required" />
									</div>
								</div>
							</div>

							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:input path="email" value="${driver.email}" type="email"
										name="email" id="email" class="form-control input-sm"
										placeholder="Email Address" required="required" />
								</div>
							</div>
							<fmt:formatDate value="${driver.dateOfBirth}" var="dateString"
								pattern="yyyy/MM/dd" />
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:input path="dateOfBirth" type="text"
										value="${dateString}" placeholder="Choose your birthday date"
										class="form-control input-sm" id="pickyDate" readonly="true"
										required="required" />

								</div>
							</div>

							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:input path="phoneMobile" type="text"
										value="${driver.phoneMobile}" name="mobile" id="mobile"
										class="form-control input-sm" placeholder="Mobile No."
										required="required" />
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:input path="phoneLandline" type="text"
										value="${driver.phoneLandline}" name="phone" id="phone"
										class="form-control input-sm" placeholder="Phone No."
										required="required" />
								</div>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4">
								<div class="form-group">
									<form:input path="address.country" type="text"
										value="${driver.address.country}" name="country" id="country"
										class="form-control input-sm" placeholder="Country"
										required="required" />
								</div>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4">
								<div class="form-group">
									<form:input path="address.city" type="text"
										value="${driver.address.city}" name="city" id="city"
										class="form-control input-sm" placeholder="City."
										required="required" />
								</div>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4">
								<div class="form-group">
									<form:input path="address.street" type="text"
										value="${driver.address.street}" name="street" id="street"
										class="form-control input-sm" placeholder="Street Info"
										required="required" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<label>Manager</label>
									<form:select class="form-control input-sm" id="manager"
										path="manager.id">
									</form:select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<label>Branch</label>
									<form:select class="form-control input-sm" id="branch"
										path="branch.id">
									</form:select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<label>Truck</label>
									<form:select class="form-control input-sm" id="truck" 
										path="truck.id">
									</form:select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<label>Driving Card No.</label> 
									<form:input path="drivingCard" type="text"
										value="${driver.drivingCard}" name="drivingCard"
										id="drivingCard" class="form-control input-sm"
										placeholder="Driving Card" required="required" />
								</div>
							</div>
						</div>
						<input type="submit" value="Submit"
							class="btn btn-info btn-block">
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>



<c:import url="../footer.jsp"></c:import>
