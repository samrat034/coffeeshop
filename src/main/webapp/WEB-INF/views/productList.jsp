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
            <h1>All Products</h1>

            <p class="lead">List of Products</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Product Type</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                	<td>${product.id }</td>
                    <td>${product.productName}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <td>${product.productType}</td>
                   
                    <td><a href="${pageContext.request.contextPath}/updateProduct/${product.id}">Update</a>&nbsp; &nbsp; &nbsp; 
                    	<a href="${pageContext.request.contextPath}/deleteProduct/${product.id}">Delete</a></td>
                    
                </tr>
            </c:forEach>
            </tbody>
        </table>


<%@include file="/WEB-INF/views/template/footer.jsp" %>
