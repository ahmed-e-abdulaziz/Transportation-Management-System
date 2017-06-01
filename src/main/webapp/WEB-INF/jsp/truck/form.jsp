<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="../header.jsp">
	<%-- We define a parameter that was used by header.jsp, which is title --%>
	<c:param name="title" value="Truck Form"></c:param>
</c:import>
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
						<h3 class="modal-title">Truck Form</h3>
					</div>
					<div class="modal-body">
						<div class="well">
							<div class="row">
								<form:form id="contact-form" method="post"
									action="${pageContext.servletContext.contextPath}/truck/form"
									role="form" commandName="truck">
									<form:input type="hidden" path="id" value="${truck.id}" />
									<div class="controls">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label>Plate</label>
													<form:input path="Plate" value="${truck.plate}" id="plate"
														type="text" name="plate" class="form-control"
														placeholder="Enter The Registered Plate"
														required="required" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-9">
												<div class="form-group">
													<label>Status</label>
													<form:select  class="form-control" id="status" path="status.id">
													<option value="1">GOOD</option>
													<option value="2">BAD</option>
													<option value="3">SEVERE</option>
													<option value="4">FAULTY</option>
													</form:select>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Max Weight</label>
													<form:input path="maxWeight"
														value="${truck.maxWeight}" id="maxWeight"
														type="number" name="maxWeight" class="form-control"
														placeholder="No. in tons"
														required="required" min="1" max="999"/>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Max Length</label>
													<form:input path="maxLength"
														value="${truck.maxLength}" id="maxLength" type="number"
														name="maxLength" class="form-control"
														placeholder="Max Length"
														required="required" min="1" max="99"/>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Max Width</label>
													<form:input path="maxWidth"
														value="${truck.maxWidth}" id="maxWidth" type="number"
														name="maxWidth" class="form-control"
														placeholder="Max Width"
														required="required" min="1" max="30"/>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Max Height</label>
													<form:input path="maxHeight"
														value="${truck.maxHeight}" id="maxHeight" type="number"
														name="maxHeight" class="form-control"
														placeholder="Max Height"
														required="required" min="1" max="30"/>
												</div>
											</div>
										</div>
											<div class="col-md-12">
												<input type="submit" class="btn btn-success btn-send"
													value="Submit">
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