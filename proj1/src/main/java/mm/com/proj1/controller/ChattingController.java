package mm.com.proj1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ChattingController {
	@Autowired
	SimpMessagingTemplate simpleMessagingTemplate;

	@MessageMapping(value = "sendMsg/{receiver}")
	public void sendMessage(@DestinationVariable String receiver, String message) {
		System.out.println("receiver"+receiver);
		simpleMessagingTemplate.convertAndSend("/topic/msgSync/" + receiver, message);
	}

	@RequestMapping(value="/chatting",method = RequestMethod.GET)
	public String chatting(Model model){
		return "admin/chatting";		
	}
}
