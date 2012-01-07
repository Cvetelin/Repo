<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page pageEncoding="UTF-8"%>

<html>
<div>
	<display:table name="testExecutions" id="testExecution">
		<display:column property="name" url="/showTestExecutionTime.do">
		</display:column>
	</display:table>
</div>
<html:link page="/addMemberForm.do">Add member</html:link>
</html>

