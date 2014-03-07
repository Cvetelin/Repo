<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<html>
<head>
<link type="text/css" rel="stylesheet" href="/css/display.css">
</head>
<body class="box">
	<table border="1">
		<thead>
			<tr align="center" bgcolor="00CC66">
				<th colspan="2">SELENIUM TESTS</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td valign="top">
					<div>
						<display:table name="dirInfos" id="dirInfo" class="title">
							<display:column title="Test name">
								<html:link action="/showTestExecutionTime">
									<bean:write name="dirInfo" property="name" />
									<html:param name="name" value="${dirInfo.name}"></html:param>
									<html:param name="path" value="${dirInfo.path}"></html:param>
								</html:link>
							</display:column>
							<display:column title="Last execution Time">
								<bean:write name="dirInfo" property="executionTime" />
							</display:column>
						</display:table>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</body>
<%-- <html:link page="/addMemberForm.do">Add member</html:link> --%>
</html>
