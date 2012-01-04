<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<%@ page pageEncoding="UTF-8"%>
<%@page import="bg.ceco.demo.model.Organisation"%>

<html>
<body>
	<display:table name="requestScope.orgs" id="org">
		<display:column title="Id" property="id" />
		<display:column titleKey="organisation.name" property="nom" />
		<display:column titleKey="organisation.active" property="actif" />
		<display:column titleKey="organisation.type">
			<bean:message
				key="<%= "organisation.type." + ((Organisation)org).getType() %>" />
		</display:column>
		<display:column titleKey="organisation.department">
			<logic:equal value="S" name="org" property="type">
			<bean:write name="org" property="departement.nom" />
			</logic:equal>
		</display:column>
	</display:table>
<html:link page="/addMemberForm.do">Add member</html:link>
</body>
</html>

