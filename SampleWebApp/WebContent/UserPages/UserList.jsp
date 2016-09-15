<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/header.jsp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.UserDetails" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<table class="flatTable">
		<tr class="titleTr">
			<td class="titleTd">User Details</td>
			<td colspan="4"></td>
			<td class="plusTd button"></td>
		</tr>
		<tr class="headingTr">
			<td>Id</td>
			<td>Name</td>
			<td>Address</td>
			<td>Phone Number</td>
			<td>Actions</td>
		</tr>
		<%
			ArrayList<UserDetails> list = (ArrayList<UserDetails>) request.getAttribute("userList");
			for(UserDetails user : list) {
		%>
		<tr>
			<td><%=user.getUserId() %></td>
			<td><%=user.getUserName() %></td>
			<td><%=user.getUserAddress() %></td>
			<td><%=user.getUserPhone() %></td>
			<td><a href="/SampleWebApp/UserAddController?userId=<%=user.getUserId() %>">Edit</a> | <a class="deleteUser" href="/SampleWebApp/UserDeleteController?userId=<%=user.getUserId() %>">Delete</a></td>
		</tr>
		<%
		}
		%>
		
	</table>
	
	<div id="sForm" class="sForm sFormPadding">
		<span class="button close"><img
			src="http://i.imgur.com/nnzONel.png" alt="X" class="" /></span>
		<h2 class="title">Settings</h2>
		<a href="UserPages/UserAddEdit.jsp">Add New Record</a>
	</div>
<%@ include file="/footer.jsp" %>