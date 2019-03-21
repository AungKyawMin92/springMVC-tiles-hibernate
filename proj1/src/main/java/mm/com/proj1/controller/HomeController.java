package mm.com.proj1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mm.com.proj1.dto.UserDTO;
import mm.com.proj1.service.UserService;
import mm.com.proj1.validator.LoginValidator;

@Controller
public class HomeController {
	
	@Autowired UserService userService;
	@Autowired LoginValidator loginValidator;
	
	@RequestMapping({"welcome", "/"})
	public String welcome(Model model){
		model.addAttribute("loginForm", new UserDTO());
		return "login";
	}
	
	@RequestMapping(value="/userLogin",method = RequestMethod.POST)
	public String menuRoleAccessSave(@ModelAttribute("loginForm") UserDTO loginDto,Model model, BindingResult result, HttpServletRequest req){
		loginValidator.validate(loginDto, result);
		if(result.hasErrors()){
			model.addAttribute("loginForm", loginDto);
			return "login";
		}else{
			List<UserDTO> userAuthList = userService.checkAuth(loginDto);
			if(userAuthList.size() > 0){
				req.getSession().setAttribute("uid", userAuthList.get(0).getUserId());
				req.getSession().setAttribute("logInUserName", userAuthList.get(0).getLoginName());
				return "admin/home";
			}
			else{
				model.addAttribute("loginForm", loginDto);
				return "login";
			}
		}
			
		
	}
	
}
