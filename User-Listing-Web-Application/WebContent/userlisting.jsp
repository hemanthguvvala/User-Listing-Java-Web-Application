<%@page import="com.hkgroups.dataresources.UsersData"%>
<%@page import="java.util.List"%>
<%@ include file="includes/header.jsp"%>
<div class="container">
	<p>Users List Goes here..</p>
	<table class="table">
		<tr>
			<th>User Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Gender</th>
			<th style="column-span: 2; text-align: center;">Operations</th>
		</tr>
		<%!String updateUrl, deleteUrl;%>
		<%
		List<UsersData> userlist = (List) request.getAttribute("userlist");
		for (int i = 0; i < userlist.size(); i++) {
			out.print("<tr>");
			out.print("<td>" + userlist.get(i).getUser_id() + "</td>");
			out.print("<td>" + userlist.get(i).getUser_first_name() + "</td>");
			out.print("<td>" + userlist.get(i).getUser_last_name() + "</td>");
			out.print("<td>" + userlist.get(i).getUser_email() + "</td>");
			out.print("<td>" + userlist.get(i).getGender() + "</td>");
			updateUrl = request.getContextPath()+"/operations?page=updateuser&userid="+userlist.get(i).getUser_id()+"&userfirstname="+userlist.get(i).getUser_first_name()+
					"&userlastname="+userlist.get(i).getUser_last_name()+"&useremail="+userlist.get(i).getUser_email();
			deleteUrl = request.getContextPath()+"/operations?page=deleteuser&userid="+userlist.get(i).getUser_id();
			out.print("<td><a href="+updateUrl+">Update</a></td>");
			out.print("<td><a onClick='if(!Confirm('Are you sure my little heart?')) return false;' href="+deleteUrl+">Delete</a></td>");
			out.print("</tr>");
		}
		%>
	</table>
</div>
<%@ include file="includes/footer.jsp"%>