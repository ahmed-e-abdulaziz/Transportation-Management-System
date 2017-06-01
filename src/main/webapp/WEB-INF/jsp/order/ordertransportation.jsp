<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp">
	<%-- We define a parameter that was used by header.jsp, which is title --%>
	<c:param name="title" value="Order a Transportation"></c:param>
</c:import>

<script>
	$(document)
			.ready(
					function() {
						var max_fields = 50; //maximum input boxes allowed
						var wrapper = $(".itemcontainer"); //Fields wrapper
						var add_button = $(".add"); //Add button ID

						var x = 1; //initlal text box count
						$(add_button).click(
										function(e) { //on add input button click
											e.preventDefault();
											if (x < max_fields) { //max input box allowed
												x++; //text box increment
												$(wrapper)
														.append(
																'<div><input type="text" name="items[]" class="form-control"  placeholder="Describe one item type with quantity" required><button type="button" id="remove" class="remove btn btn-info">-</button><div>'); //add input box
											}
										});

						$(wrapper).on("click", ".remove", function(e) { //user click on remove text
							e.preventDefault();
							$(this).parent('div').remove();
							x--;
						})
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
						<h3 class="modal-title">Order a transportation service</h3>
					</div>
					<div class="modal-body">
						<div class="well">
							<div class="row">
								<form id="orderform" method="post" action="/Order" role="form">


									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label class="pull-left col-md-1">From</label>
												<div class="col-md-11">

													<select class="form-control" id="fromcountry"
														name="fromcountry">
														<option selected="selected">Choose a country...</option>
														<option>Egypt</option>
														<option>UAE</option>
														<option>Lebanon</option>
													</select> <br> <select class="form-control" id="fromcity"
														name="fromcity">
														<option selected="selected">Choose a city...</option>
														<option>Cairo</option>
														<option>Giza</option>
														<option>Alexanderia</option>
													</select>
													<div class="form-group">
														<label for="form_message"></label>
														<textarea id="streetinfofrom" name="streetinfofrom"
															class="form-control"
															placeholder="Enter street info and describe it well"
															rows="4" required></textarea>

													</div>
												</div>
												<label class="pull-left col-md-1">To</label>
												<div class="col-md-11">

													<select class="form-control" id="tocountry"
														name="tocountry">
														<option selected="selected">Choose a country...</option>
														<option>Egypt</option>
														<option>UAE</option>
														<option>Lebanon</option>
													</select> <br> <select class="form-control" id="tocity"
														name="tocity">
														<option selected="selected">Choose a city...</option>
														<option>Cairo</option>
														<option>Giza</option>
														<option>Alexanderia</option>
													</select>
													<div class="form-group">
														<label for="form_message"></label>
														<textarea id="streetinfoto" name="streetinfoto"
															class="form-control"
															placeholder="Enter street info and describe it well"
															rows="4" required></textarea>
													</div>
												</div>
												<div class="form-group">
													<label>Weight</label> <input id="weight" type="number"
														name="weight" class="form-control"
														placeholder="Required weight in tons with a max of 250" min="1" max="250"
														required>
												</div>
												<label>Items, describe one item type in each input area, add up to 50 item</label>
												<div><input type="text" name="items[]" placeholder="Describe one item type with quantity" class="form-control" required></div>
												<button id="add" class="add btn btn-success">+</button>
												<div class="itemcontainer" id="itemcontainer"></div>
											</div>
										</div>
									</div>
									<div class="col-md-12">
										<input type="submit" class="btn btn-success col-md-12"
											value="Submit your order">
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