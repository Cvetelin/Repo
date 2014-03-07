<%@ page pageEncoding="Windows-1251" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
<link type="text/css" rel="stylesheet" href="/css/demo.css"> 
</head>
<body>
<html:form action="addMember" method="post"
	onsubmit="return validateMemberForm(document.forms['MemberForm'])">
	<div id="test">
	<p><html:errors /></p>
	<table>
		<tr>
			<td><bean:message key="memberForm.firstName" /></td>
			<td><html:text property="firstName" errorStyleClass="error" /></td>
		</tr>
		<tr>
			<td><bean:message key="memberForm.lastName" /></td>
			<td><html:text property="lastName" errorStyleClass="error" /></td>
		</tr>
		<tr>
			<td><bean:message key="memberForm.birthDate" /></td>
			<td><html:text property="birthDate" errorStyleClass="error" /></td>
		</tr>
		<tr>
			<td><bean:message key="memberForm.email" /> <logic:messagesPresent
				property="email">!</logic:messagesPresent></td>
			<td><html:text property="email" errorStyleClass="error" /></td>
		</tr>
		<tr>
			<td><bean:message key="memberForm.password" /></td>
			<td><html:password property="password" errorStyleClass="error" /></td>
		</tr>
		<tr>
			<td><bean:message key="memberForm.passwordAgain" /></td>
			<td><html:password property="passwordAgain"
				errorStyleClass="error" /></td>
		</tr>
		<tr>
			<td><bean:message key="memberForm.position" /></td>
			<td><html:select property="role">
					<html:options collection="roles" property="id" labelProperty="name" />
				</html:select>
			</td>
		</tr>
		<tr>
			<td><bean:message key="memberForm.permission" /></td>
			<td><html:select property="permission">
					<html:options collection="permissions" property="id" labelProperty="type" />
				</html:select>
			</td>
		</tr>
		</table>
	<html:submit value="Submit" />
	<html:button property="firstName" titleKey="memberForm.firstName" value="Cancel" altKey="memberForm.email"></html:button>
	</div>
</html:form>
</body>
</html>