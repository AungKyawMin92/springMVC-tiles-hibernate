package mm.com.proj1.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mm.com.proj1.dto.EmailDTO;
import mm.com.proj1.service.MailService;

@Controller
public class EmailController {
	
	@Autowired MailService mailService;
	
	@RequestMapping(value="/email",method = RequestMethod.GET)
	public String userManageForm(Model model, HttpServletRequest req){
		model.addAttribute("emailForm", new EmailDTO());
		return "admin/email";
	}
	
	@RequestMapping(value="/userManage",method = RequestMethod.POST, params = "Send")
	public String UserManage(@ModelAttribute("emailForm") EmailDTO emailDto, Model model){
		
		String templateFileName = "emailAlert.vm";
		InternetAddress[] toEmails = new InternetAddress[1];
		try {
			toEmails[0]=new InternetAddress(emailDto.getToEmail());
		} catch (AddressException e) {
			e.printStackTrace();
		}
		Map<String, Object> objectValueMap = new HashMap<String, Object>();
		objectValueMap.put("desc", emailDto.getDescription());
		String subject = "test email ";
		mailService.sendMail(toEmails, null, subject, objectValueMap, templateFileName, null, null, null);
	
	
		model.addAttribute("emailForm", new EmailDTO());
		return "admin/email";
	
	}
}
