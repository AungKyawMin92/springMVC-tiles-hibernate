<%@ include file="../../include/importTag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>	
<div class="wrapper">
<form:form action = "userSearch.htm" modelAttribute="userSearchForm" method = "POST" >

	 <fieldset>
	 <legend style='padding-left: 20px;'> User Search</legend>
         <table class="formTable">
         
         	<tr>
         		<td class="label">
         			<input type="submit" value="Reset" class="btn btn-primary btn-sm" name="Reset" />
         			<input type="submit" value="Search" class="btn btn-primary btn-sm" name="Search"/>
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
         			<form:input path="userName" placeholder="Name" class="form-control input-sm"/>
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
        			<form:option value="-1">-- ALL --</form:option>
					 <form:options items="${roleList}" width="100%"/>
				</form:select>
         		</td>
         		<td></td>
         	</tr>        	        
         </table> 
        </fieldset>
	</form:form>
	<div class="listTable">
	<table class="formTable" >   
		<thead style="height: 30px; background:#dcede8">      
         	<tr>
         		<td class="lbl">No</td>
         		<td class="lbl">User Name</td>
         		<td  class="lbl">Login Name</td>
         		<td  class="lbl">Password</td>
         		<td  class="lbl">Role</td>
         		<td class="lbl"> </td>
         	</tr> 
         </thead>
         <tbody>	
          <c:forEach var = "user" items = "${userList}" varStatus="status">
			<tr>
				<td>${ status.count }</td>
	            <td>${user.userName}</td>
	            <td>${user.loginName}</td>   
	            <td>${user.userPassword}</td>
	            <td>${user.userRoleDesc}</td>
	            <td><a href="userManage.htm?id=${user.userId}">View</a></td>
            </tr>
       		</c:forEach>   
       		</tbody>   	
         </table> 
         </div>
	 </div>

</body>
</html>
