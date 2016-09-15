<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/header.jsp" %>
<%
	if(request.getParameter("userId") != null){
%>
	<form method="post" action="/SampleWebApp/UserEditController">
		<table class="flatTable">
			<tr class="titleTr">
				<td>Add User</td>
			</tr>
			<tr><td>Name : <input type="text" id="userName" name="userName" value="<%=request.getAttribute("userName")%>"></td></tr>
			<tr><td>Address : <input type="text" id="userAddress" name="userAddress" value="<%=request.getAttribute("userAddress")%>"></td></tr>
			<tr><td>Phone Number : <input type="text" id="phoneNumber" name="phoneNumber" value="<%=request.getAttribute("userPhone")%>"></td></tr>
			<tr><td><input type="submit" id="saveUser" class="saveUser" value="Update"></td></tr>
		</table>
		<input type="hidden" id="userId" name="userId" value="<%=request.getParameter("userId")%>">
	</form>
<%
	}
	else{
%>
	<form method="post" action="/SampleWebApp/UserAddController">
		<table class="flatTable">
			<tr class="titleTr">
				<td>Add User</td>
			</tr>
			<tr><td>Name : <input type="text" id="userName" name="userName" value=""></td></tr>
			<tr><td>Address : <input type="text" id="userAddress" name="userAddress" value=""></td></tr>
			<tr><td>Phone Number : <input type="text" id="phoneNumber" name="phoneNumber" value=""></td></tr>
			<tr><td><input type="submit" id="saveUser" class="saveUser" value="Save"></td></tr>
		</table>
	</form>
<%
	}
%>
<%@ include file="/footer.jsp" %>