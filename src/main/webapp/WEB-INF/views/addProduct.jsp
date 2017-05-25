<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/template/header.jsp" %>


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
            <h1>Add Product</h1>

            <p class="lead">Add Product:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/addProduct" method="post"
                   commandName="product" >
        <div class="form-group">
            <label for="productName">Product Name</label> <form:errors path="productName" cssStyle="color: #ff0000;" />
            <form:input path="productName" value="${product.productName}" id="productName" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="description">Description</label> <form:errors path="description" cssStyle="color: #ff0000;" />
            <form:input path="description" value="${product.description}" id="description" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="price">Price</label> <form:errors path="price" cssStyle="color: #ff0000;" />
            <form:input path="price" value="${product.price}" id="price" class="form-Control"/>
        </div>
        
        <div class="form-group">
            <label for="condition">Product Type</label>
            <label class="checkbox-inline"><form:radiobutton path="productType" id="productType"
                                                             value="BREAKFAST" />BREAKFAST</label>
            <label class="checkbox-inline"><form:radiobutton path="productType" id="productType"
                                                             value="LUNCH" />LUNCH</label>
            <label class="checkbox-inline"><form:radiobutton path="productType" id="productType"
                                                             value="DINNER" />DINNER</label>
        </div>
        <br><br>
        
        <c:if test="${!empty product.productName}">
        		<form:input type="hidden" path="id" id="id" value="${product.id}"/>

				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-pencil"></span> Update Product
				</button>
				&nbsp;&nbsp; &nbsp;				
				<button type="submit" value="Cancel" name="_cancel"
					class="btn btn-warning">Cancel</button>
			</c:if>
			<c:if test="${empty product.productName}">

				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-eye-open"></span> Add Product
				</button>
			</c:if>
 
        </form:form>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
