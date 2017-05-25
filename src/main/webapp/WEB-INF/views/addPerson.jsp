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
            <h1>Add Person</h1>

            <p class="lead">Add Person:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/addPerson" method="post"
                   commandName="person" >
        <div class="form-group">
            <label for="firstName">First Name</label> <form:errors path="firstName" cssStyle="color: #ff0000;" />
            <form:input path="firstName" value="${person.firstName}" id="firstName" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="lastName">Last Name</label> <form:errors path="lastName" cssStyle="color: #ff0000;" />
            <form:input path="lastName" value="${person.lastName}" id="lastName" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label> <form:errors path="email" cssStyle="color: #ff0000;" />
            <form:input path="email" value="${person.email}" id="email" class="form-Control"/>
        </div>
        
        <div class="form-group">
            <label for="city">City</label> <form:errors path="address.city" cssStyle="color: #ff0000;" />
            <form:input path="address.city" value="${person.address.city}" id="city" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="state">State</label> <form:errors path="address.state" cssStyle="color: #ff0000;" />
            <form:input path="address.state" value="${person.address.state}" id="state" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="country">Country</label> <form:errors path="address.country" cssStyle="color: #ff0000;" />
            <form:input path="address.country" value="${person.address.country}" id="country" class="form-Control"/>
        </div>
		<div class="form-group">
            <label for="zipcode">ZipCode</label> <form:errors path="address.zipcode" cssStyle="color: #ff0000;" />
            <form:input path="address.zipcode" value="${person.address.zipcode}" id="zipcode" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="phone">Phone</label> <form:errors path="phone" cssStyle="color: #ff0000;" />
            <form:input path="phone" id="phone" value="${person.phone}" class="form-Control"/>
        </div>
         <div class="form-group">
            <label for="enable">Enabled</label>
            <label class="checkbox-inline"><form:radiobutton path="enable" id="enable"
                                                             value="1" />Active</label>
            <label class="checkbox-inline"><form:radiobutton path="enable" id="enable"
                                                           value="0" />Inactive</label>
        </div>
        <div class="form-group">
            <label for="password">Password</label> <form:errors path="password" cssStyle="color: #ff0000;" />
            <form:input path="password" value="${person.password}" id="password" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="role">Role</label>
            <label class="checkbox-inline"><form:radiobutton path="role" id="role"
                                                             value="ADMIN" />Admin</label>
            <label class="checkbox-inline"><form:radiobutton path="role" id="role"
                                                           value="USER" />User</label>
        </div>
        
        <br><br>
        
        <c:if test="${!empty person.firstName}">
        		<form:input type="hidden" path="id" id="id" value="${person.id}"/>

				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-pencil"></span> Update Person
				</button>
				&nbsp;&nbsp; &nbsp;				
				<button type="submit" value="Cancel" name="_cancel"
					class="btn btn-warning">Cancel</button>
			</c:if>
			<c:if test="${empty person.firstName}">

				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-eye-open"></span> Add Person
				</button>
			</c:if>
 
        </form:form>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
