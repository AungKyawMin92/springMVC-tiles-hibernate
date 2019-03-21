package mm.com.proj1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mm.com.proj1.dto.ProcessResponse;
import mm.com.proj1.dto.UserDTO;
import mm.com.proj1.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/userManage",method = RequestMethod.GET)
	public String userManageForm(Model model, HttpServletRequest req){
		
		if(StringUtils.isNotBlank(req.getParameter("id")))
			model.addAttribute("userForm", userService.getById(Long.parseLong(req.getParameter("id"))));
		else		
			model.addAttribute("userForm", new UserDTO());
		model.addAttribute("roleList", userService.getAllRoleMap());
		return "admin/userManage";
	}
	@RequestMapping(value="/userManage",method = RequestMethod.POST, params = "Save")
	public String UserManage(@ModelAttribute("userForm") UserDTO userDto, Model model){
		ProcessResponse pr = userService.manageUser(userDto);
		
		model.addAttribute("userForm", userDto);
		model.addAttribute("roleList", userService.getAllRoleMap());
		return "admin/userManage";
	}
	@RequestMapping(value="/userManage",method = RequestMethod.POST, params = "Reset")
	public String UserReset(@ModelAttribute("userForm") UserDTO userDto, Model model){
		model.addAttribute("userForm", new UserDTO());
		model.addAttribute("roleList", userService.getAllRoleMap());
		return "admin/userManage";
	}
	@RequestMapping(value="/userSearch",method = RequestMethod.GET)
	public String userSearchForm(Model model){
		List<UserDTO> list=new ArrayList<>();
		model.addAttribute("userSearchForm", new UserDTO());
		model.addAttribute("roleList", userService.getAllRoleMap());
		model.addAttribute("userList", list);
		return "admin/userSearch";
	}
	@RequestMapping(value="/userSearch",method = RequestMethod.POST )
	public String userSearch(@ModelAttribute("userSearchForm") UserDTO userDto,  Model model){	
		List<UserDTO> list= userService.userSearch(userDto);
		model.addAttribute("roleList", userService.getAllRoleMap());
		model.addAttribute("userSearchForm", new UserDTO());
		model.addAttribute("userList", list);
		return "admin/userSearch";
	}
}
