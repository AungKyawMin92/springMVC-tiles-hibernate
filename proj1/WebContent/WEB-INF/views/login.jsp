<%@ include file="../include/importTag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<%-- <spring:message text="Minin"/>
	HELLO ${name},<br/>
	WELCOME FROM SPRING MVC PROJECT TEAM --%>
	
<form:form action = "userLogin.htm" modelAttribute="loginForm" method = "POST">
 <div class="logInBox">
 	<fieldset>
 	<legend align="center" style="background-color: #CCC;">Login:</legend>
	<table class="loginFormTable">
        	<tr>
        		<td align='center'>
        			<form:label path="loginName">
						<spring:message text="Name " />
				</form:label>
        		</td>
        		<td class="text-box">
        			<form:input path="loginName" class="form-control input-sm" />
        			<form:errors path="loginName" cssStyle="color : red;"/>
        		</td>
        	</tr>         	
        	<tr>         	
        		<td align='center'>
        			<form:label path="userPassword">
						<spring:message text="Password " />
				</form:label>
        		</td>
        		<td>
        			<form:input type="password" path="userPassword" class="form-control  input-sm" />
        			<form:errors path="userPassword" cssStyle="color : red;"/>
        		</td>
        	</tr> 
        	<tr>
        		<td class="label">
        		</td>
        		<td>         			
        			<input type="submit" class="btn btn-primary btn-sm" value="Login" name="Login"/>
        		</td>
        	</tr>         	      	        
        </table> 
        </fieldset>
</div>
</form:form>
