<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>struts</title>
</head>
<body>

	<tiles:importAttribute name="Bootstrapcss"/>
	<tiles:importAttribute name="stylecss"/>
	<tiles:importAttribute name="formStylecss"/>
	<tiles:importAttribute name="accorcss"/>
	<tiles:importAttribute name="jqcss"/>
	
	
	<tiles:importAttribute name="jqjs"/>
	<tiles:importAttribute name="jquijs"/>
	<tiles:importAttribute name="customjs"/>
	<tiles:importAttribute name="bootminjs"/>
	<tiles:importAttribute name="accorjs"/>
	
	
	 <link href="<%=request.getContextPath()%>/${Bootstrapcss}" rel="stylesheet">
	  <link href="<%=request.getContextPath()%>/${stylecss}" rel="stylesheet">
	   <link href="<%=request.getContextPath()%>/${formStylecss}" rel="stylesheet">
	   <link href="<%=request.getContextPath()%>/${accorcss}" rel="stylesheet">
	   <link href="<%=request.getContextPath()%>/${jqcss}" rel="stylesheet">

<script src="<%=request.getContextPath()%>/${jqjs}"></script>
<script src="<%=request.getContextPath()%>/${jquijs}"></script>
<script src="<%=request.getContextPath()%>/${customjs}"></script>
<script src="<%=request.getContextPath()%>/${bootminjs}"></script>
<script src="<%=request.getContextPath()%>/${accorjs}"></script>	

<tiles:insertAttribute name="footer" />
	<tiles:insertAttribute name="body" />	
</body>
</html>