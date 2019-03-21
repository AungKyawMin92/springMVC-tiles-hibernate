<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
         	<fieldset>
 	<legend align="center" style="background-color: #CCC;">Login:</legend>
 	
        	<s:form action="logincheck" theme="simple">
        	<h2 >Please Login to System </h2>
        	<s:actionerror/>
        	<table class="loginFormTable">
        		<tr>
        		<td align='center'>
        			<label class="control-label" for="inputusername"><s:text name="User Name :"></s:text> </label>
        		</td>
        			<td><s:textfield placeholder="User Name" name="userDto.loginName" id="inputusername" class="form-control input-sm" ></s:textfield></td>
        			<td><s:fielderror fieldName="userDto.loginName"></s:fielderror></td>
        	</tr>         	
        	<tr>         	
        		<td align='center'>
        			<label class="control-label" for="inputpassword">Password :</label>
        		</td>
        			<td><s:password placeholder="Password" name="userDto.userPassword" id="inputpassword" class="form-control input-sm" ></s:password></td>
        			<td><s:fielderror fieldName="userDto.userPassword"></s:fielderror></td>
        	</tr> 
        	<tr>
        		<td class="label">
        		</td>
        		<td>         			
        			<input type="submit" class="btn btn-primary btn-sm" value="Login" name="Login"/>
        		</td>
        	</tr>
        	
        	
        	
        		
        	</table>
        	</s:form>
        	
        	</fieldset>
        	
   
 
