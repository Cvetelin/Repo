<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page pageEncoding="UTF-8"%>

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
				<td>
					<div>

						<display:table name="dirInfos" id="dirInfo"	class="title">
							<display:column property="name" title="Test execution time"/>
							<display:column value="Go to Gallery" href="/app/PrepareGallery" paramProperty="path" paramId="filesRoot"/>
							<display:column value="Delete" href="/app/DeleteTestExecutionTime" paramProperty="path" paramId="fileRoot"/>
						</display:table>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</body>
<a href="/app/ShowExecutedTests">Back to Tests list</a>
</html>

