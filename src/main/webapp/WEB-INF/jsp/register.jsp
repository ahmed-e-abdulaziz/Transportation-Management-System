<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp">
	<%-- We define a parameter that was used by header.jsp, which is title --%>
	<c:param name="title" value="Register a new account!"></c:param>
</c:import> 
<script type="text/javascript">
    $(document).ready(function () { 
        $('#pickyDate').datepicker({ 
            viewMode: "years",
            format: "dd/mm/yyyy",
            autoclose: true
        }).on('changeDate', function(ev){
        	if (ev.viewMode === 'days') {
            $(this).datepicker('hide');
        	}
        });;
    });
</script>
<div class="container">
	<div id="login-overlay" class="modal-dialog" style="padding-top: 20px">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">Register your new
					user account.</h4>
			</div>
			<div class=" modal-body">
			<form id="loginForm" method="POST" action="/Login">
				<div class="well">
				<div class="row">
					<div class="col-xs-4 col-sm-4 col-md-4">
						<div class="form-group">
							<input type="text" name="first_name" id="first_name"
								class="form-control input-sm" placeholder="First Name" required>
						</div>
					</div>
					<div class="col-xs-4 col-sm-4 col-md-4">
						<div class="form-group">
							<input type="text" name="middle_name" id="middle_name"
								class="form-control input-sm"
								placeholder="Middle Name (Father's Name)" required>
						</div>
					</div>
					<div class="col-xs-4 col-sm-4 col-md-4">
						<div class="form-group">
							<input type="text" name="last_name" id="last_name"
								class="form-control input-sm" placeholder="Last Name" required>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="text" name="username" id="username"
									class="form-control input-sm"
									placeholder="Username to login with" required>
							</div>
						</div>
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="email" name="email" id="email"
									class="form-control input-sm" placeholder="Email Address" required>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
						<div class="form-group">
							<input type="password" name="password" id="password"
								class="form-control input-sm" placeholder="Password" required>
						</div>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6">
						<div class="form-group">
							<input type="password" name="password_confirmation"
								id="password_confirmation" class="form-control input-sm"
								placeholder="Confirm Password" required>
						</div>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-12" style="margin-bottom: 15px">
					 <input  type="text" placeholder="Choose your birthday date" class="form-control input-sm" id="pickyDate" readonly required/>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6">
						<div class="form-group">
							<input type="text" name="mobile" id="mobile"
								class="form-control input-sm" placeholder="Mobile No." required>
						</div>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6">
						<div class="form-group">
							<input type="text" name="phone" id="phone"
								class="form-control input-sm" placeholder="Phone No."required>
						</div>
					</div>
					<div class="col-xs-4 col-sm-4 col-md-4">
						<div class="form-group">
							<input type="text" name="country" id="country"
								class="form-control input-sm" placeholder="Country" required>
						</div>
					</div>
					<div class="col-xs-4 col-sm-4 col-md-4">
						<div class="form-group">
							<input type="text" name="mobile" id="mobile"
								class="form-control input-sm" placeholder="City." required>
						</div>
					</div>
					<div class="col-xs-4 col-sm-4 col-md-4">
						<div class="form-group">
							<input type="text" name="street" id="street"
								class="form-control input-sm" placeholder="Street Info" required>
						</div>
					</div>
				</div>
				
				<input type="submit" value="Register" class="btn btn-info btn-block">
			</div>
			</form>
			</div>
		</div>
	</div>
</div>



<c:import url="footer.jsp"></c:import>
