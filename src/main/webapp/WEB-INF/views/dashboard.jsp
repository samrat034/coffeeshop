<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper">
<div class="container">

<div>
		<form action="/coffeeshop/logout" method="post">
			<button type="submit" class="btn btn-danger">Log Out</button>
			<input type="hidden" name="${_csrf.parameterName}"
				   value="${_csrf.token}"/>
		</form>
 </div>
 <%@include file="/WEB-INF/views/template/footer.jsp" %>