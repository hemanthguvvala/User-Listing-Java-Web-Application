<%@ include file="includes/header.jsp"%>
<%@page import="com.hkgroups.entity.ImageDataModel"%>
<%@page import="java.util.List"%>

<Table class="table">
<tr>
	<th>Image Id</th>
	<th>Image Name</th>
	<th>Lable</th>
	<th>Description</th>
</tr>
<%
List<ImageDataModel> imagelist = (List) request.getAttribute("imagelist");

for (int i = 0; i < imagelist.size(); i++) {
	out.print("<tr>");
	out.print("<td> <img class='img-fluid' src="+imagelist.get(i).getImagename()+"></td>");
	out.print("<td>"+imagelist.get(i).getImageid()+"</td>");
	out.print("</tr>");
}
%>
</Table>
<%@ include file="includes/footer.jsp"%>