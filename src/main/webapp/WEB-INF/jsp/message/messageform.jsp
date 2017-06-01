<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp">
	<%-- We define a parameter that was used by header.jsp, which is title --%>
	<c:param name="title" value="Message Form"></c:param>
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
						<h3 class="modal-title">Send a Message</h3>
					</div>
					<div class="modal-body">
						<div class="well">
							<div class="row">
									<form id="contact-form" method="post" action="/Messages" role="form">

										<div class="controls">

											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<label>To</label> <input
															id="to" type="text" name="to"
															class="form-control"
															placeholder="Enter the username"
															required>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12">
													<div class="form-group">
														<label>Subject</label> <input
															id="subject" type="text" name="subject"
															class="form-control"
															placeholder="Enter the main subject of the message"
															required>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12">
													<div class="form-group">
														<label for="form_message">Message</label>
														<textarea id="form_message" name="message"
															class="form-control" placeholder="Message content."
															rows="4" required></textarea> 
													</div>
												</div>
												<div class="col-md-12">
													<input type="submit" class="btn btn-success btn-send"
														value="Send message">
												</div>
											</div>
										</div>

									</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<c:import url="footer.jsp"></c:import>