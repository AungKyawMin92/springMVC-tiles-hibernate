<%@ include file="../../include/importTag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>	
<div>
<form:form action = "userManage.htm" modelAttribute="userForm" method = "POST">
	
	 <div class="wrapper">
	 <fieldset>
	 <legend style='padding-left: 20px;'> User Manage</legend>
         <table class="formTable">
         
         	<tr>
         		<td class="label">
         			<input type="submit" value="Reset" class="btn btn-primary btn-sm" name="Reset" />
         			<input type="submit" value="Save" class="btn btn-primary btn-sm" name="Save"/>
         			<input type="submit" value="Delete" class="btn btn-primary btn-sm" name="Delete"/>
         		</td>
         	</tr> 
         	<tr></tr>
         
         	<tr>
         		<td class="lbl">
         			<form:label path="userName">
							<spring:message text="Name " />
					</form:label>
         		</td>
         		<td class="text-box">
         			<form:input path="userName" class="form-control input-sm"/>
         		</td>
         		<td></td>
         	</tr>
         	<tr>         	
         		<td class="lbl">
         			<form:label path="loginName">
							<spring:message text="Login Name " />
					</form:label>
         		</td>
         		<td>
         			<form:input path="loginName" class="form-control input-sm"/>
         		</td>
         		<td></td>
         	</tr>  
         	<tr>         	
         		<td class="lbl">
         			<form:label path="userPassword">
							<spring:message text="Password " />
					</form:label>
         		</td>
         		<td>
         			<form:input type="password" path="userPassword" class="form-control input-sm"/>
         		</td>
         		<td></td>
         	</tr>   
         	<tr>         	
         		<td class="lbl">
         			<form:label path="userRoleId">
							<spring:message text="User Role " />
					</form:label>
         		</td>
         		<td>
        		<form:select path="userRoleId" id="roleList" width="100%" class="form-control input-sm">
					 <form:options items="${roleList}" width="95%"/>
				</form:select>
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
