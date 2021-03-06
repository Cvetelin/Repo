<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.0.0.min.js"></script>
		<script type="text/javascript" src="/js/jquery.blockUI.js"></script>
<script type="text/javascript">

function openPopup(execId) {
	window.open("/FailureDetails?id=" + execId,"_blank","toolbar=no, location=no, menubar=no, scrollbars=yes, resizable=yes, top=200, left=900, width=500, height=600");
}

$(document).ready(function() { 
    $('[value~=RunTest]').click(function() { 
        $.blockUI({ css: { 
            border: 'none', 
            padding: '15px', 
            backgroundColor: '#000', 
            '-webkit-border-radius': '10px', 
            '-moz-border-radius': '10px', 
            opacity: .5, 
            color: '#fff' 
        } }); 
    });  
}); 
</script>
</head>
<body>
	<div class="row tabs" id="tab">
		<ul class="nav nav-tabs ">
			<li class="active"><a href="/ShowProjectDetails?id=${project.id}">View</a></li>
			<li><a href="/ManageProject?id=${project.id}">Edit</a></li>
		</ul>
	</div>
	<%@ include file="include/UpperBody.jspf"%>	
	<div class="row" id="methods">		
		<display:table name="testInfos" id="test" class="col-md-8 table-bordered table-hover title text-center headtitle-link"
			requestURI="ShowClassDetails" defaultsort="1">			
			<display:column title="Methods in Class" property="name" paramId="id" paramProperty="id" sortable="true" />
			<display:column title="Number of runs" property="numberOfExections" sortable="true"/>
			<display:column title="Last result" sortable="true">
					<tags:yesno value="${test.lastRunStatus}"/>
				</display:column>	
			<display:column title="Last run on" property="executionDate" format="{0,date,dd.MM.yyyy HH:mm:ss}" sortable="true"/>			
			<display:column  paramId="methodId" paramProperty="id" href="/${classInfo.id}/ShowClassDetails">
				<button class="btn btn-info btn-xs active" id="listM" value="List Runs" >List Executions</button>
			</display:column>
			<display:column  paramId="methodId" paramProperty="id"  href="/runTest">	
				<c:if test="${(test.name != 'setUp') and (test.name != 'after') and (test.name != 'before')}">			
					<button class="btn btn-primary btn-xs active" id="runTheTest" value="RunTest" >Run Test</button>	
				</c:if>		
			</display:column>		
		</display:table>		
	</div>
	<br></br>	
	<div class="row" id="executions">
	<c:if test="${not empty execInfos}">
		<display:table name="execInfos" id="exec" class="col-md-8 table-bordered table-hover title text-center headtitle-link"
			requestURI="ShowClassDetails" defaultsort="1">
			<display:column title="Test method name" property="testInfo.name" paramId="id" paramProperty="testInfo.id" sortable="true"/>			
			<display:column title="Result" sortable="true">
				<tags:yesno value="${exec.status}"/>
			</display:column>
			<display:column title="Run on" property="executionDate" format="{0,date,dd.MM.yyyy HH:mm:ss}" sortable="true"/>
			<display:column title="Run time (min)"  property="runTime"  format="{0,date, mm:ss:SSS} m" sortable="true">
<%-- 				<fmt:formatDate value="${exec.runTime}" pattern="mm:ss:SSS"/> --%>
			</display:column>
			<c:if test="${not empty exec.failureReason}">		
				<display:column  maxLength="50" title="Failure reason">
						<a onclick="openPopup(${exec.id});" href="#">
							<c:out value="${exec.failureReason}"></c:out>
						</a>	
				</display:column>
			</c:if>		
		</display:table>
		</c:if>
	</div>

</body>
</html>