<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
<title>
	<%
		if(request.getAttribute("title")==null){
			out.print("Lonely Developers");
		}else {
			request.getAttribute("title");
		}
	%>
</title>

<style type="text/css">
.hr1 {
	width: 90%;
}
</style>
</head>
<body style="font-family: cursive;">
	<div class="topbar topbar-dark bg-dark">
		<div class="container">
			<nav class="navbar navbar-expand-lg">
				<ul class="navbar-nav">
					<li class="nav-items" style="margin-right: 10px;">
						<i class="bi bi-building text-secondary"></i>
						 <a class="text-secondary" style="margin-left: 5px;">HK Groups</a>
					</li>
					<li class="nav-items" style="margin-right: 10px;">
						<i class="bi bi-facebook text-primary"></i> 
						<a class="text-secondary" style="margin-left: 5px;">Facebook</a>
					</li>
					<li class="nav-items" style="margin-right:10px;">
						<i class="bi bi-twitter text-info"></i> 
						<a class="text-secondary" style="margin-left: 5px;">Twitter</a>
					</li>
					<li class="nav-items" style="margin-right:10px;">
						<i class="bi bi-instagram text-danger"></i> 
						<a class="text-secondary" style="margin-left: 5px;">Instagram</a>
					</li>
					<li class="nav-items" style="margin-right:10px;">
						<i class="bi bi-github text-white"></i> 
						<a class="text-secondary" style="margin-left: 5px;">Github</a>
					</li>
				</ul>
			</nav>
		</div>
	</div>
	
	<!-- Navbar with Image -->
	
	<nav class="navbar navbar-expand-lg navbar-light">
        <a class="nav-link navbar-brand align-center" href="${pageContext.request.contextPath }/site?page=home">
        	<img src="assets/header_icon.png" width="100px" height="100px;"> 
        	<span class="align-center">Lonely Developers</span>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" 
       			 aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <ul class="navbar-nav ml-auto">
                <li class="nav-items">
                    <a class="nav-link active" href="${pageContext.request.contextPath }/site?page=home">Home</a>
                </li>
                <li class="nav-items">
                    <a class="nav-link" href="${pageContext.request.contextPath }/operations?page=userlist">Users Listing</a>
                </li>
                <li class="nav-items">
                    <a class="nav-link" href="${pageContext.request.contextPath }/operations?page=adduser">Add Users</a>
                </li>
                <li class="nav-items">
                    <a class="nav-link" href="">Images</a>
                </li>
            </ul>
            <form class="form-inline">
            	<input class="form-control" type="search" placeholder="Search here..." name="search">
            	<input class="btn btn-dark" type="submit" value="Search">
            </form>
        </div>
    </nav>
    
    <hr class="hr1">