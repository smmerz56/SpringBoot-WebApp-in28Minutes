<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
	<table class="table table-striped">
		<caption>Your todos are</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is it done?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">		
				<tr>
				<td>${todo.getDesc()}</td>
				<td><fmt:formatDate value="${todo.getTargetDate()}" pattern="MM/dd/yyyy"/></td>
				<td>${todo.isDone()}</td>
				<td><a type="button" class="btn btn-success" 
					href="/update-todo?id=${todo.id}">Update</a></td>
				<td><a type="button" class="btn btn-warning" 
					href="/delete-todo?id=${todo.id}">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
		
		<div><a class="button" href="/add-todo">Add a Todo</a></div>
		
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>	
<%@ include file="common/footer.jspf" %>