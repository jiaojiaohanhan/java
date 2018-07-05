package com.controller;

import java.security.Timestamp;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Exam;
import com.entity.Reply;
import com.entity.Exam.stateType;
import com.entity.Task;
import com.entity.User;
import com.entity.User.identityType;
import com.entity.User.titleType;
import com.service.ExamService;
import com.service.ReplyService;
import com.service.TaskService;
import com.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private ExamService examService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private ReplyService replyService;
	
	@GetMapping("/indexADMIN")
	public void post() {}
	
	@GetMapping("/exam")
	public ModelAndView exam() {
		List<Exam> exams = new ArrayList<Exam>();
		exams = examService.allExam();
		ModelAndView mad = new ModelAndView("admin/exam");
		mad.addObject("exams", exams);
		return mad;
	}
	
	@GetMapping("/notice")
	public ModelAndView task() {
		List<Task> tasks = new ArrayList<>();
		tasks = taskService.allTask();
		ModelAndView mad = new ModelAndView("admin/notice");
		mad.addObject("tasks", tasks);
		return mad;
	}
	
	@GetMapping("/notice2")
	public ModelAndView task2() {
		List<Task> tasks = new ArrayList<>();
		tasks = taskService.allTask();
		ModelAndView mad = new ModelAndView("admin/notice2");
		mad.addObject("tasks", tasks);
		return mad;
	}
	
	@GetMapping("/notice3")
	public void task3() {
		
	}
	
	@GetMapping("/notice3/{id}")
	public String task4(@PathVariable int id,Model model) {
		List<Reply> all = replyService.allReply(id);
		model.addAttribute("replys",all);
		return "admin/notice3";
	}
	
	@GetMapping("/addNotice")
	public void addNotice(){}
	
	@GetMapping("/data")
	public void userInfo(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		String detail = user.getDetail();
		Enum<identityType> identity = user.getIdentity(); 
		String name = user.getName();
		String password = user.getPassword();
		int phone = user.getPhoneNumber();
		Enum<titleType> title = user.getTitle();
		String username = user.getUserName();
		model.addAttribute("detail", detail);
		model.addAttribute("identity", identity);
		model.addAttribute("name", name);
		model.addAttribute("password", password);
		model.addAttribute("phone", phone);
		model.addAttribute("title", title);
		model.addAttribute("username", username);
	}
	
	@GetMapping("/teachers")
	public ModelAndView teachers() {
		List<User> users = new ArrayList<User>();
		users = userService.listUser();
		ModelAndView mad = new ModelAndView("admin/teachers");
		mad.addObject("users", users);
		return mad;
	}
	
	@GetMapping("/teachers2")
	public ModelAndView teachers2() {
		List<User> users = new ArrayList<User>();
		users = userService.listUser();
		ModelAndView mad = new ModelAndView("admin/teachers2");
		mad.addObject("users", users);
		return mad;
	}
	
	@GetMapping("/change")
	public void change(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		String detail = user.getDetail();
		Enum<identityType> identity = user.getIdentity();
		String name = user.getName();
		String password = user.getPassword();
		int phone = user.getPhoneNumber();
		Enum<titleType> title = user.getTitle();
		String username = user.getUserName();
		model.addAttribute("detail", detail);
		model.addAttribute("identity",identity);
		model.addAttribute("name", name);
		model.addAttribute("password", password);
		model.addAttribute("phone", phone);
		model.addAttribute("title", title);
		model.addAttribute("username", username);
	}
	
	@GetMapping("/change2")
	public String change2(){
		return "/admin/change2";
	}
	
	@GetMapping("/change2/{id}")
	public String change2(@PathVariable int id,Model model){
		User user = userService.find(id);
		int user_id = user.getId();
		String detail = user.getDetail();
		Enum<identityType> identity = user.getIdentity();
		String name = user.getName();
		String password = user.getPassword();
		int phone = user.getPhoneNumber();
		Enum<titleType> title = user.getTitle();
		String username = user.getUserName();
		model.addAttribute("id",user_id);
		model.addAttribute("detail", detail);
		model.addAttribute("identity",identity);
		model.addAttribute("name", name);
		model.addAttribute("password", password);
		model.addAttribute("phone", phone);
		model.addAttribute("title", title);
		model.addAttribute("username", username);
		return "/admin/change2";
	}
	
	@GetMapping("/changeE")
	public String changeE(){
		return "/admin/changeE";
	}
	
	@GetMapping("/changeE2")
	public ModelAndView changeE2() {
		List<Exam> exams = new ArrayList<Exam>();
		exams = examService.allExam();
		ModelAndView mad = new ModelAndView("admin/changeE2");
		mad.addObject("exams", exams);
		return mad;
	}
	
	@GetMapping("/changeE/{id}")
	public String changeE(@PathVariable int id,Model model){
		Exam exam = examService.find(id);
		int exam_id = exam.getId();
		String name = exam.getExamName();
		String address = exam.getAddress();
		Date start = exam.getStartTime();
		Date end = exam.getEndTime();
		Enum<stateType> state = exam.getState();
		int student = exam.getStudentNumber();
		Set<User> users = exam.getUsers();
		model.addAttribute("id",exam_id);
		model.addAttribute("name", name);
		model.addAttribute("address", address);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("state", state);
		model.addAttribute("student", student);
		model.addAttribute("users",users);
		return "/admin/changeE";
	}
	
	@GetMapping("/addUser")
	public String addUser(){
		return "/admin/addUser";
	}
	
	@PostMapping("/userUpdate")
	public String userUpdate(String detail,String identity,String name,String password,Integer phone,String title,String username,HttpSession session) {
		User user = (User) session.getAttribute("user");
		user.setDetail(detail);
		user.setIdentity(identityType.valueOf(identity));
		user.setName(name);
		user.setPassword(password);
		user.setPhoneNumber(phone);
		user.setTitle(titleType.valueOf(title));
		user.setUserName(username);
		userService.updateUserInfo(user);
		User user2 = userService.find(user.getId());
		session.setAttribute("user", user2);
		return "redirect:data";
	}
	
	@PostMapping("/userUpdate2")
	public String userUpdate2(String id,String detail,String identity,String name,String password,Integer phone,String title,String username) {
		User user = userService.find(Integer.parseInt(id));
		user.setDetail(detail);
		user.setIdentity(identityType.valueOf(identity));
		user.setName(name);
		user.setPassword(password);
		user.setPhoneNumber(phone);
		user.setTitle(titleType.valueOf(title));
		user.setUserName(username);
		userService.updateUserInfo(user);
		return "redirect:teachers";
	}
	
	@PostMapping("/userUpdateE")
	public String userUpdateE(String id,String name,String address,String start,String end,String state,String student,String userId) {
		Exam exam = examService.find(Integer.parseInt(id));
		exam.setExamName(name);
		exam.setAddress(address);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Date start2 = null;
		try {
			start2 = sdf.parse(start);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exam.setStartTime(start2);
		Date end2 = null;
		try {
			end2 = sdf.parse(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exam.setEndTime(end2);
		exam.setState(stateType.valueOf(state));
		exam.setStudentNumber(Integer.parseInt(student));
		int user_id = Integer.parseInt(userId);
		Set<User> users = exam.getUsers();
		User user = userService.find(user_id);
		users.add(user);
		exam.setUsers(users);
		examService.changerExamInfo(exam);
		return "redirect:exam";
	}
	
	@PostMapping("/addN")
	public String addN(String title,String content,String kind,String start,String end,String state) {
		Task task = new Task();
		task.setName(title);
		task.setContent(content);
		task.setKind(kind);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start2 = null;
		try {
			start2 = format.parse(start);
			task.setStartTime(start2);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date end2 = null;
		try {
			end2 = format.parse(end);
			task.setEndTime(end2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		task.setState(com.entity.Task.stateType.valueOf(state));
		taskService.addTask(task);
		return "redirect:notice2";
	}
	
	@PostMapping("/addUser")
	public String addUser2(String detail,String identity,String name,String password,Integer phone,String title,String username){
		User user = new User(); 
		user.setDetail(detail);
		user.setIdentity(identityType.valueOf(identity));
		user.setName(name);
		user.setPassword(password);
		user.setPhoneNumber(phone);
		user.setTitle(titleType.valueOf(title));
		user.setUserName(username);
		userService.addUser(user);
		return "redirect:teachers2";
	}
	
	@PostMapping("/addExam")
	public String addExam(String name,String address,String start,String end,String state,String student,String userId) {
		Exam exam = new Exam();
		exam.setExamName(name);
		exam.setAddress(address);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Date start2 = null;
		try {
			start2 = sdf.parse(start);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exam.setStartTime(start2);
		Date end2 = null;
		try {
			end2 = sdf.parse(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exam.setEndTime(end2);
		exam.setState(stateType.valueOf(state));
		exam.setStudentNumber(Integer.parseInt(student));
		int user_id = Integer.parseInt(userId);
		Set<User> users = new HashSet<User>();
		User user = userService.find(user_id);
		users.add(user);
		exam.setUsers(users);
		examService.changerExamInfo(exam);
		return "redirect:changeE2";
	}
	
	@PostMapping("/changeInfo/{id}")
	public String changeInfo(@PathVariable int id) {
		return "redirect:../change2/{id}";
	}
	
	@PostMapping("/deleteInfo/{id}")
	public String deleteInfo(@PathVariable int id) {
		User user = userService.find(id);
		userService.delete(user);
		return "redirect:../teachers2";
	}
	
	@PostMapping("/changeExam/{id}")
	public String changeExam(@PathVariable int id) {
		return "redirect:../changeE/{id}";
	}
	
	@PostMapping("/deleteE/{id}")
	public String deleteE(@PathVariable int id) {
		Exam exam = examService.find(id);
		examService.delete(exam);
		return "redirect:../changeE2";
	}
	
	@PostMapping("/changeTask/{id}")
	public String changeTask(@PathVariable int id) {
		Task task = taskService.find(id);
		taskService.deleteTask(task);
		return "redirect:../notice2";
	}
}
