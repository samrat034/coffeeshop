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
            <h1>All Orders</h1>

            <p class="lead">List of Orders</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Ticket ID</th>
                <th>Order Date</th>
                <th>Customer Name</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orders}" var="order">
                <tr>
                	<td>${order.id }</td>
                    <td>${order.orderDate}</td>
                    <td>${order.person.firstName}</td>
                    <td><a href="${pageContext.request.contextPath}/admin/order/orderDetails/${order.id}">Details</a>
                </tr>
            </c:forEach>
            </tbody>
        </table>


<%@include file="/WEB-INF/views/template/footer.jsp" %>
