<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="/js/jquery.blockUI.js"></script>
<script type="text/javascript">
	$(document).ready(function() { 
	    $('[value~=GenerateProject]').click(function() { 
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
	<div class="text-center">
		<display:table name="projects" id="projects" class="col-sm-10 col-md-10 col-lg-10 table-bordered text-center table-hover title headtitle-link "    
		requestURI="ShowProjects" defaultsort="1" >
			<display:column title="Project Name" property="projectName" href="/app/ShowProjectDetails" paramId="id"
				paramProperty="id" sortable="true" maxLength="20" />	
			<display:column  title="Status" sortable="true"/>	
			<display:column  title="Modified on" property ="dateModification"  format="{0,date,dd.MM.yyyy HH:mm:ss}" sortable="true"/>
			<display:column  title="Created on" property ="dateCreation"  format="{0,date,dd.MM.yyyy HH:mm:ss}" sortable="true"/>
<%-- 		<display:column  title="Last execution time" format="{0,date,dd.MM.yyyy HH:mm:ss}" sortable="true"/> --%>			
			<display:column href="/app/Generate" paramId="id" paramProperty="id">
					<button  class="btn btn-primary btn-xs" value="GenerateProject">Generate Project Tree</button>		
			</display:column>
		</display:table> 		
	</div>
</body>
</html>