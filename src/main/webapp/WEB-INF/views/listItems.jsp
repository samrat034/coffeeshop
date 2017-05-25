<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<%@ page session="true"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
   				     
            <h1>All Products for Order</h1>

            <p class="lead">Total Items: ${totalItems}</p>
            <a href="<c:url value='${request.contextPath}/user/order/submitOrder' />"
			class="btn btn-primary btn-lg"><span
			class="glyphicon glyphicon-plus"></span>&nbsp;Submit Order </a>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Product Name</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    
                    <td><a href="${pageContext.request.contextPath}/user/order/${product.id}/quantity">Select</a></td>
                    
                </tr>
            </c:forEach>
            </tbody>
        </table>


<%@include file="/WEB-INF/views/template/footer.jsp" %>
