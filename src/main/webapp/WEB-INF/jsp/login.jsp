<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp">
<%-- We define a parameter that was used by header.jsp, which is title --%>
<c:param name="title" value="Login Form"></c:param>
</c:import>

    <div id="login-overlay" class="modal-dialog" style="padding-top: 20px">
      <div class="modal-content">
          <div class="modal-header">
             <h4 class="modal-title" id="myModalLabel">Login to your account.</h4>
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class="col-xs-12">
                      <div class="well">
                          <form id="loginForm" method="POST" action="/Login" >
                              <div class="form-group">
                                  <label for="username" class="control-label">Username</label>
                                  <input type="text" class="form-control" id="username" name="username" value="" required title="Please enter you username" placeholder="example@gmail.com">
                                  <span class="help-block"></span>
                              </div>
                              <div class="form-group">
                                  <label for="password" class="control-label">Password</label>
                                  <input type="password" class="form-control" id="password" name="password" value="" required title="Please enter your password">
                                  <span class="help-block"></span>
                              </div>
                              <div id="loginErrorMsg" class="alert alert-error hide">Wrong username og password</div>
                              <div class="checkbox">
                                  <label>
                                      <input type="checkbox" name="remember" id="remember"> Remember login
                                  </label>
                                  <p class="help-block">(if this is a private computer)</p>
                              </div>
                              <input type="submit" class="btn btn-success btn-block" value="Login"/>
                          </form>
                      </div>
                     <a href="/Register" class="btn btn-info btn-block">Or Register Now!</a>
                  </div>
              </div>
          </div>
      </div>
  </div>

<c:import url="footer.jsp"></c:import>
