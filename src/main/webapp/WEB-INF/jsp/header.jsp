<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${param.title}</title>
	
	<spring:url value="/resources/bootstrap/css/landing-page.css" var="landingCSS" />
	<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapCSS" />
	<spring:url value="/resources/bootstrap/font-awesome/css/font-awesome.min.css" var="fontawesomeCSS" />
	<spring:url value="/resources/bootstrap/css/bootstrap-datetimepicker.css" var="datetimepickerCSS" />
	<spring:url value="/resources/bootstrap/css/datepicker.css" var="datepickerCSS" />
	<spring:url value="/resources/bootstrap/css/bootstrap.min2.css" var="bootstrap2CSS" />

    <!-- Custom CSS -->
    <link href="${landingCSS}" rel="stylesheet">

    <link href="${bootstrapCSS}" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="${fontawesomeCSS}" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
	    <link href="${datetimepickerCSS}" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="${datepickerCSS}" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script> 
    <!-- Bootstrap Core CSS -->
    <link href="${bootstrap2CSS}" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	<style>
	body { padding-top: 50px; }
	thead{ background: #3d3d3d;}
	</style>
</head>

<body style="background-image: url('${pageContext.request.contextPath}/resources/img/backpattern.png')">
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation" style="margin-bottom: 50px" >
        <div class="container topnav " >
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span> 
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand topnav" href="${pageContext.request.contextPath}/index">Transporters</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="${pageContext.request.contextPath}/login">Login</a>
                    </li>
                    <li>
                       <a href="${pageContext.request.contextPath}/customer/register">Register</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/customer/profile/1">Customer Profile</a>
                    </li>		
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
