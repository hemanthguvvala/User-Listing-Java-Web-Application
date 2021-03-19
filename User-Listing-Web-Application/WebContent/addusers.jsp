<%@ include file="includes/header.jsp"%>
<div class="container" style="padding:15px;">
	<div class="col-mod-6">
		<form style="padding:10px;" method="post" action="${pageContext.request.contextPath}/operations">
			<div class="form-row">
				<div class="form-group col-md">
					Firstname <input class="form-control" type="text" name="userfirstname" required="required" placeholder="Enter your First Name">
				</div>
				<div class="form-group col-md">
					Lastname <input class="form-control" type="text" name="userlastname" required="required" placeholder="Enter your last Name">
				</div>
			</div>
			<div class="form-group">
				Email <input class="form-control" type="email" name="useremail" placeholder="Enter your Email" required="required">
					<div style="margin-top:10px;" >Select Gender <input type="radio" class="form-input" name="gender" value="Male">Male 
						<input  class="form-input" type="radio" name="gender" value="Female"> Female
					</div>
			</div>
				<input type="hidden" value="adduser" name="form">
			<input type="submit" value="Add User" class="btn btn-dark">
		</form>
	</div>
	
	<form action="${pageContext.request.contextPath }/imagecontroller?action=filesupload" enctype="multipart/form-data" method="post">
		<input type="file" name="files" multiple="multiple">
		<input type="submit" value="Upload Images">
	</form>
</div>
<%@ include file="includes/footer.jsp"%>