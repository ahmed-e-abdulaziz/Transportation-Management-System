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
<div class="container">
	<div id="login-overlay" class="modal-dialog" style="padding-top: 20px">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">Account Form.</h4>
			</div>
			<div class=" modal-body">
				<form:form commandName="customer" id="loginForm" method="POST" action="${pageContext.servletContext.contextPath}/customer/form">
					<form:hidden path="id" value="${customer.id}"/>
					<div class="well">
						<div class="row">
							<div class="col-xs-4 col-sm-4 col-md-4">
								<div class="form-group">
									<form:input path="firstName" type="text" value="${customer.firstName}"
										name="first_name" id="first_name"
										class="form-control input-sm" placeholder="First Name"
										required="required"/>
								</div>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4">
								<div class="form-group">
									<form:input path="middleName" type="text" value="${customer.middleName}"
										name="middle_name" id="middle_name"
										class="form-control input-sm"
										placeholder="Middle Name (Father's)" required="required"/>
								</div>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4">
								<div class="form-group">
									<form:input path="lastName" type="text" value="${customer.lastName}"
										name="last_name" id="last_name" class="form-control input-sm"
										placeholder="Last Name" required="required"/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<form:input path="password" type="password" name="password" id="password"
											class="form-control input-sm" required="required" placeholder="Password" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="password" name="password_confirmation"
											id="password_confirmation" class="form-control input-sm"
											placeholder="Confirm Password" required="required"/>
									</div>
								</div>
							</div>

							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:input path="email" value="${customer.email}" type="email" name="email"
										id="email" class="form-control input-sm"
										placeholder="Email Address" required="required"/>
								</div>
							</div>
							<fmt:formatDate value="${customer.dateOfBirth}" var="dateString" pattern="yyyy/MM/dd" />
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:input path="dateOfBirth" type="text" value="${dateString}"
										placeholder="Choose your birthday date"
										class="form-control input-sm" id="pickyDate" readonly="true" required="required" />

								</div>
							</div>

							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:input path="phoneMobile" type="text" value="${customer.phoneMobile}"
										name="mobile" id="mobile" class="form-control input-sm"
										placeholder="Mobile No." required="required"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<form:input path="phoneLandline" type="text" value="${customer.phoneLandline}"
										name="phone" id="phone" class="form-control input-sm"
										placeholder="Phone No." required="required"/>
								</div>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4">
								<div class="form-group">
									<form:input path="address.country" type="text" value="${customer.address.country}"
										name="country" id="country" class="form-control input-sm"
										placeholder="Country" required="required"/>
								</div>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4">
								<div class="form-group">
									<form:input path="address.city" type="text" value="${customer.address.city}" name="city"
										id="city" class="form-control input-sm" placeholder="City."
										required="required"/>
								</div>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4">
								<div class="form-group">
									<form:input path="address.street" type="text" value="${customer.address.street}"
										name="street" id="street" class="form-control input-sm"
										placeholder="Street Info" required="required"/>
								</div>
							</div>
						</div>

						<input type="submit" value="Register"
							class="btn btn-info btn-block">
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>



<c:import url="../footer.jsp"></c:import>
