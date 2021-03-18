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
		%>
		<td><a href="">Update</a></td>
		<td><a href="">Delete</a></td>
		<%
		}
		%>
		</tr>
	</table>
</div>
<%@ include file="includes/footer.jsp"%>