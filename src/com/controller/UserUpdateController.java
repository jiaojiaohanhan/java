package com.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.Exam;
import com.entity.Task;
import com.entity.User;
import com.entity.User.identityType;
import com.entity.User.titleType;
import com.service.ExamService;
import com.service.ReplyService;
import com.service.TaskService;
import com.service.UserService;

@Controller
@RequestMapping("/user")
public class UserUpdateController {
	@Autowired
	private UserService userService;
	@Autowired
	private ExamService examService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private ReplyService replyService;
	
	@GetMapping("/exam")
	public ModelAndView exam(HttpSession session) {
		Set<Exam> set_exams = examService.myExam(session);
		List<Exam> exams = new ArrayList<>(set_exams);
		ModelAndView mad = new ModelAndView("user/exam");
		mad.addObject("exams", exams);
		return mad;
	}
	
	@GetMapping("/notice")
	public ModelAndView task() {
		List<Task> tasks = new ArrayList<>();
		tasks = taskService.allTask();
		ModelAndView mad = new ModelAndView("user/notice");
		mad.addObject("tasks", tasks);
		return mad;
	}
	
	@GetMapping("/userInfo")
	public void userInfo(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		String detail = user.getDetail();
		Enum<identityType> identity = user.getIdentity(); 
		String name = user.getName();
		String password = user.getPassword();
		int phone = user.getPhoneNumber();
		Enum<titleType> title = user.getTitle();
		String username = user.getUserName();
		//这里用model或者redirectAttributes都可以
//		redirectAttributes.addFlashAttribute("detail", detail);
//		redirectAttributes.addFlashAttribute("identity", identity);
//		redirectAttributes.addFlashAttribute("name", name);
//		redirectAttributes.addFlashAttribute("password", password);
//		redirectAttributes.addFlashAttribute("phone", phone);
//		redirectAttributes.addFlashAttribute("title", title);
//		redirectAttributes.addFlashAttribute("username", username);
		model.addAttribute("detail", detail);
		model.addAttribute("identity", identity);
		model.addAttribute("name", name);
		model.addAttribute("password", password);
		model.addAttribute("phone", phone);
		model.addAttribute("title", title);
		model.addAttribute("username", username);
	}
	
	@GetMapping("/change")
	public void change(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		String detail = user.getDetail();
		String name = user.getName();
		String password = user.getPassword();
		int phone = user.getPhoneNumber();
		String username = user.getUserName();
		model.addAttribute("detail", detail);
		model.addAttribute("name", name);
		model.addAttribute("password", password);
		model.addAttribute("phone", phone);
		model.addAttribute("username", username);
	}
	
	@GetMapping("/make")
	public ModelAndView task_make() {
		List<Task> tasks = new ArrayList<>();
		tasks = taskService.allTask();
		ModelAndView mad = new ModelAndView("user/make");
		mad.addObject("tasks", tasks);
		return mad;
	}
	
	@GetMapping("/make2")
	public void task_make2() {}

	@GetMapping("/make2/{id}")
	public String task_make3(@PathVariable int id,Model model) {
		model.addAttribute("id",id);
		return "user/make2";
	}
	
	@PostMapping("/userUpdate")
	public String userUpdate(String detail,String name,String password,Integer phone,String username,HttpSession session) {
		User user = (User) session.getAttribute("user");
		user.setDetail(detail);
		user.setName(name);
		user.setPassword(password);
		user.setPhoneNumber(phone);
		user.setUserName(username);
		userService.updateUserInfo(user);
		User user2 = userService.find(user.getId());
		session.setAttribute("user", user2);
		return "redirect:userInfo";
	}
	
	@PostMapping("/passwordUpdate")
	public String passwordUpdate(String userName, String password) {
		userService.updatePassword(userName, password);
		return "redirect:userInfo";
	}
	
	@PostMapping("/makeTask/{id}")
	public String makeTask(@PathVariable int id) {
		return "redirect:../make2/{id}";
	}
	
	@PostMapping("/make3")
	public String make3(int id,String reply,HttpSession session,Model model) {
		Task task = taskService.find(id);
		User user = (User) session.getAttribute("user");
		if(task.getKind().toString()!="file") {
			replyService.addReply(user, task, reply);
		}else {
			model.addAttribute("alert", "这个不是回复类任务");
			return "redirect:make3";
		}
		return "redirect:make";
	}
}
