<%@ include file="../../include/importTag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>	
<div>
	
	 <div class="wrapper">
	 <div class="page-title"> User chat chat</div>
         <table class="formTable">
         	<tr>
         		<td class="label" style="color:green;">
         			<label >To</label>
         		</td>
         		<td class="text-box">
         			<input type="text" id="to" style="width:300px; color: green;"/>
         		</td>
         		<td></td>
         	</tr>
         	<tr>         	
         		<td class="label" style="color:green;">
         			Messge
         		</td>
         		<td>
         			<input type="text" id="message" style="width:300px"/>
         		</td>
         		<td></td>
         	</tr> 
         	
         	<tr>
         		<td> <button id="btn-send" class="btn btn-primary" > send</button>
         	
         	</tr> 
         </table> 
         
         <div class="frm-panel">
			<div id="calResponse" class="frm-panel-body" style="width:600px;height:400px;"></div>
		</div>
  </div>
</div>	

<div style="display:none" id="ctxPath"><%=request.getContextPath() %></div>
<div style="display:none" id="uid"><%=request.getSession().getAttribute("logInUserName") %></div>
<div style="display:none" id="uname"><%=request.getSession().getAttribute("logInUserName") %></div>

<script src="<%=request.getContextPath()%>/resources/js/sockjs-0.3.4.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/js/stomp.js" type="text/javascript"></script>
<script type="text/javascript">
	var client = {
			stompClient : null,
			initialize : function(){
				this.connect();
				var instance = this;
				$("#btn-send").click(function(){ instance.send(); });
				$("#message").keyup(function(e){ if(e.which==13){ instance.send(); } });
			},
			connect : function(){
				var socket = new SockJS($("#ctxPath").text()+'/c_message');
				
				this.stompClient = Stomp.over(socket);
				var instance = this;
				this.stompClient.connect({}, function(frame) {
					console.log(instance);
					instance.stompClient.subscribe('/topic/msgSync/' + $("#uname").text(), function(result) { instance.showResult(JSON.parse(result.body)); });
					//instance.stompClient.send("/ws/sendMsg/"+$('#uname').text() , {}, JSON.stringify({ 'sender' : 'aa', 'message' : 'msg' }));
					
					console.log(instance);
				});
			},
			disconnect : function(){ this.stompClient.disconnect(); },
			send : function(){
				var msg = $('#message').val();
				if(msg.trim()==="") return;

			//	alert($('#to').val() +'' +$('#uname').text() +'' +msg);
				this.stompClient.send("/ws/sendMsg/"+$('#to').val() , {}, JSON.stringify({ 'sender' : $("#uname").text(), 'message' : $('#message').val() }));
				$('#message').val("");
				this.showResult({ 'sender' : 'me', 'message' : msg });
			},
			showResult : function(ret){
				if(ret.sender==="me"){
					$("#calResponse").append("<p style=\"word-wrap:'break-word';text-align:right\">"+ret.message+" : <label style=\"'font-weight':bold\">"+ret.sender+"</label></p>");
				} else {
					$("#calResponse").append("<p style=\"'word-wrap':'break-word'\"><label style=\"'font-weight':bold\">"+ret.sender+"</label> : "+ret.message+"</p>");
				}
			}
	};	
	client.initialize();
</script>

</body>
</html>
