<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page pageEncoding="UTF-8" %>

<html>
	<table border="1">
		<thead>
			<tr>
				<td><bean:message key="memberForm.firstName" /></td>
				<td><bean:message key="memberForm.lastName" /></td>
				<td><bean:message key="memberForm.birthDate" /></td>
				<td><bean:message key="memberForm.email" /></td>
				<td><bean:message key="memberForm.position" /></td>
				<td><bean:message key="memberForm.permission"/></td>
			</tr>
		</thead>
		<tbody>
			<logic:iterate id="member" name="members" >
			<tr>
				<td><bean:write name="member" property="firstName"/></td>
				<td><bean:write name="member" property="lastName"/></td>
				<td><fmt:formatDate value="${member.birthDate}" type="date" dateStyle="short"/></td>
				<td><bean:write name="member" property="email"/></td>
				<td><bean:write name="member" property="role.name"/></td>
				<td><bean:write name="member" property="permission.type"/></td>
				<td><bean:write name="member" property="permission.type"/></td>
				<td><bean:write name="member" property="permission.deleteAllowed"/></td>
				<td><bean:write name="member" property="permission.createAllowed"/></td>
				<td><bean:write name="member" property="permission.type"/></td>
			</tr>
			</logic:iterate>
		</tbody>
	</table>
	<div>
		<display:table name="listOfTests" id="tests">
		</display:table>
	</div>
<html:link page="/addMemberForm.do">Add member</html:link>
</html>

