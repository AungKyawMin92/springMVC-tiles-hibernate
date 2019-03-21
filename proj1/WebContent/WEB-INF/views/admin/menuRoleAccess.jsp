<%@ include file="../../include/importTag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>	
<div>
<form:form action = "menuRoleAccess.htm" modelAttribute="menuRoleAccessForm" method = "POST">
	
	 <div class="wrapper">
	 <div class="page-title"> User Manage</div>
         <table class="formTable">
         
         	<tr>
         		<td class="label">
         			<input type="submit" value="Reset" class="red-btn" name="Reset" />
         			<input type="submit" value="Save" class="red-btn" name="Save"/>
         			<input type="submit" value="Delete" class="red-btn" name="Reset"/>
         		</td>
         		<td></td>
         	</tr> 
         	<tr></tr>
         
         	<tr>         	
         		<td class="label">
         			<form:label path="roleId">
							<spring:message text="User Role " />
					</form:label>
         		</td>
         		<td>
        		<form:select path="roleId" id="roleList" width="100%">
        			<form:option value="-1">-- Choose --</form:option>
					 <form:options items="${roleList}" itemValue="roleId" itemLabel="roleName"  width="100%"/>
				</form:select>
         		</td>
         		<td>
         			<input type="submit" value="Search" class="red-btn" name="Search"/>
         		</td>
         	</tr>        	        
         </table> 
         
        	
         <div class="formTableMenuRole">
         <table>        
         	
         	<tr></tr>
         	
         <c:forEach var = "menu" items = "${menuRoleAccessForm.menuList}" varStatus="status">
         	<c:choose>						
				<c:when test="${menu.parentMenuCode == '0'}">
	         	<tr><td>
	         		<form:hidden path="menuList[${status.count-1}].menuId"/>
	         		<c:choose>						
						<c:when test="${menu.roleId == 0}">
							<input type="checkbox" name="menuList[${status.count-1}].roleId" value = "${menuRoleAccessForm.roleId}" id="${menu.menuName}" class="parent" />
						</c:when>
						<c:otherwise>
						     <input type="checkbox" name="menuList[${status.count-1}].roleId" value = "${menuRoleAccessForm.roleId}"  id="${menu.menuName}" class="parent" checked/>
						</c:otherwise>
					</c:choose>
	         	${menu.menuName} 
	         	</td></tr>	         	
	         		<c:forEach var = "menuSub" items = "${menuRoleAccessForm.menuList}" varStatus="status1">
	         									     		
				     		<c:choose>						
							<c:when test="${menuSub.parentMenuCode == menu.menuCode}">
								<tr><td></td>
									<td>
										<form:hidden path="menuList[${status1.count-1}].menuId"/>
										<c:choose>						
										<c:when test="${menuSub.roleId == 0}">
											<input type="checkbox" name="menuList[${status1.count-1}].roleId" value = "${menuRoleAccessForm.roleId}" onclick="checkParent('${menu.menuName}', this)"/>
										</c:when>
										<c:otherwise>
										     <input type="checkbox" name="menuList[${status1.count-1}].roleId" value = "${menuRoleAccessForm.roleId}" onclick="checkParent('${menu.menuName}', this)" checked/>
										</c:otherwise>
										</c:choose>
										${menuSub.menuName}										
									</td>
								</tr>
							</c:when>
							</c:choose>
				     	</c:forEach>
	         	
	         </c:when>
         	</c:choose>
         </c:forEach>
         	
         	
         	
         
         	     	        
         </table> 
          </div>
     </div>    
	</form:form>
</div>	
</body>
</html>
