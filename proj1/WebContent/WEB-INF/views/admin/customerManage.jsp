<%@ include file="../../include/importTag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>	
<div>
<form:form action = "customerManage.htm" modelAttribute="customerForm" method = "POST">
	
	 <div class="wrapper">
	 <div class="page-title"> User Manage</div>
         <table class="formTable">
         
         	<tr>
         		<td class="label">
         			<input type="submit" value="Reset" class="red-btn" name="Reset" />
         			<input type="submit" value="Save" class="red-btn" name="Save"/>
         			<input type="submit" value="Delete" class="red-btn" name="Delete"/>
         		</td>
         	</tr> 
         	<tr></tr>
         
         	<tr>
         		<td class="label">
         			<form:label path="userName">
							<spring:message text="Name " />
					</form:label>
         		</td>
         		<td class="text-box">
         			<form:input path="userName" placeholder="Name"/>
         		</td>
         		<td></td>
         	</tr>
         	<tr>         	
         		<td class="label">
         			<form:label path="phNo">
							<spring:message text="Ph No." />
					</form:label>
         		</td>
         		<td>
         			<form:input path="phNo" placeholder="Ph No."/>
         		</td>
         		<td></td>
         	</tr>  
         	<tr>         	
         		<td class="label">
         			<form:label path="address">
							<spring:message text="Address " />
					</form:label>
         		</td>
         		<td>
         			<form:input path="address" placeholder="Address"/>
         		</td>
         		<td></td>
         	</tr>   
         	<tr>         	
         		<td class="label">
         			<form:label path="userType">
							<spring:message text="User Type " />
					</form:label>
         		</td>
         		<td>
        			<c:choose>
                   			<c:when test="${frmCustomerDto.customerId==null || empty frmCustomerDto.customerId  }">
                   					<input type="checkbox" name="newCustomerTypeDTOList[${status.count-1}].customerTypeId"
	                   			 value="${type.customerTypeId }" >&nbsp;${type.customerTypeName }</input>
                   				</c:when>
                   				<c:when test="${frmCustomerDto.customerId==type.customerId}">
                   					<input type="checkbox" name="newCustomerTypeDTOList[${status.count-1}].customerTypeId"
	                   			 value="${type.customerTypeId }" checked >&nbsp;${type.customerTypeName }</input>
                   				</c:when>
	                   			<c:otherwise>
                   					<input type="checkbox" name="newCustomerTypeDTOList[${status.count-1}].customerTypeId"
	                   			 value="${type.customerTypeId }" >&nbsp;${type.customerTypeName }</input>
                   				</c:otherwise>	
                   	</c:choose>
         		</td>
         		<td></td>
         	</tr>        	        
         </table> 
         </div>
	</form:form>
</div>	
</body>
</html>
