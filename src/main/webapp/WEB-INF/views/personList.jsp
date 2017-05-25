<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
    		<div class="container">
   				<a href="${pageContext.request.contextPath}/admin/addProduct" class="btn btn-info" role="button">Add Product</a>
   				<a href="${pageContext.request.contextPath}/admin/listProduct" class="btn btn-info" role="button">Product List</a>
   				<a href="${pageContext.request.contextPath}/admin/addPerson" class="btn btn-info" role="button">Add Person</a>
   				<a href="${pageContext.request.contextPath}/admin/listPerson" class="btn btn-info" role="button">Person List</a>
   				<a href="${pageContext.request.contextPath}/admin/listOrders" class="btn btn-info" role="button">Order List</a>
   			</div>
        <div class="page-header">
            <h1>All Persons</h1>

            <p class="lead">List of Persons</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${persons}" var="person">
                <tr>
                	<td>${person.id }</td>
                    <td>${person.firstName}</td>
                    <td>${person.lastName}</td>
                    <td>${person.email}</td>
                    <td>${person.address.city}, ${person.address.state}, ${person.address.country}, ${person.address.zipcode}</td>
                    <td>${person.phone}</td>
                    <td><a href="${pageContext.request.contextPath}/updatePerson/${person.id}">Update</a>&nbsp; &nbsp; &nbsp; 
                    	<a href="${pageContext.request.contextPath}/deletePerson/${person.id}">Delete</a></td>
                    
                </tr>
            </c:forEach>
            </tbody>
        </table>


<%@include file="/WEB-INF/views/template/footer.jsp" %>
