<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="value" type="java.lang.Boolean" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${value}">
		<font color="green">Passed</font>
	</c:when>
	<c:otherwise>
		<font color="red">Failed</font>
	</c:otherwise>
</c:choose>