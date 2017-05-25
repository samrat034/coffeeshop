<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
	
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>

            <p class="lead">Specify Quantity</p>
        </div>

        <form:form method="post" commandName="orderLine" >
        <div class="form-group">
            <label for="quantity">Quantity: </label> <form:errors path="quantity" cssStyle="color: #ff0000;" />
            <form:input path="quantity" value="${orderLine.quantity}" id="quantity" class="form-Control"/>
        </div>

				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-pencil"></span> Add Quantity
				</button>
				&nbsp;&nbsp; &nbsp;				
				<button type="submit" value="Cancel" name="_cancel"
					class="btn btn-warning">Cancel</button>
        </form:form>
   
<%@include file="/WEB-INF/views/template/footer.jsp" %>