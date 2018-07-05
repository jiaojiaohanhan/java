package com.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;
import com.service.UserService;
import com.util.FileUtils;

@Controller
//@RequestMapping("/com")
public class LoginController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public void login() {}
	
	@GetMapping("/register")
	public void register() {}
	
	@GetMapping("/indexUSER")
	public void welcomeUser() {}
	
	@PostMapping("/register")
	public String register(String user_name,String user_psw) {
		String str = user_psw;
		@SuppressWarnings("static-access")
		String smi = userService.convertMD5(str);
		User user = new User();
		user.setUserName(user_name);
		user.setPassword(smi);
		userService.addUser(user);
		return "redirect:login";
	}
		
	@PostMapping("/login")
	public String login(String userName,String psw,HttpSession session) {
		@SuppressWarnings("static-access")
		String password=userService.convertMD5(psw);
		User user = userService.getUser(userName, password);
		if(user!=null) {
			session.setAttribute("user", user);
			return "redirect:indexUSER";		
		}else {
			return "redirect:login";
		}
	}
	
	@GetMapping("/file-up-down")
	public ModelAndView file(HttpSession session) {
		String directoryPath = "E://test//";
		Boolean isAddDirectory = false;
		List<String> files = new ArrayList<String>();
		files = FileUtils.getAllFile(directoryPath,isAddDirectory);
		User user = (User) session.getAttribute("user");
		String ident = user.getIdentity().toString();
		ModelAndView mad = new ModelAndView("file-up-down");
		mad.addObject("files", files);
		mad.addObject("ident", ident);
		return mad;
	}
}
		


