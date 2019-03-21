<%@ include file="../../include/importTag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>	
<div>
<form:form action = "userManage.htm" modelAttribute="emailForm" method = "POST">
	
	 <div class="wrapper">
	 <fieldset>
	 <legend style='padding-left: 20px;'> Chatting</legend>
         <table class="formTable">
         
         	<tr>
         		<td class="label">
         			<input type="submit" value="Reset" class="btn btn-primary btn-sm" name="Reset" />
         			<input type="submit" value="Save" class="btn btn-primary btn-sm" name="Send"/>
         			<input type="submit" value="Delete" class="btn btn-primary btn-sm" name="Delete"/>
         		</td>
         	</tr> 
         	<tr></tr>
         
         	<tr>
         		<td class="lbl">
         			<form:label path="toEmail">
							<spring:message text="To Email " />
					</form:label>
         		</td>
         		<td class="text-box">
         			<form:input path="toEmail" class="form-control input-sm"/>
         		</td>
         		<td></td>
         	</tr>
         	<tr>
         		<td class="lbl">
         			<form:label path="toEmail">
							<spring:message text="Description" />
					</form:label>
         		</td>
         		<td class="text-box">
         			<form:textarea path="description" class="form-control input-sm"/>
         		</td>
         		<td></td>
         	</tr>
         	 
         </table> 
         </fieldset>
         </div>
	</form:form>
</div>	
</body>
</html>
