package com.sony.springboot.mydiary.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sony.springboot.mydiary.entity.Entries;
import com.sony.springboot.mydiary.entity.User;
import com.sony.springboot.mydiary.service.EntriesService;
import com.sony.springboot.mydiary.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	HttpSession session;
	
	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService=userService;
	}
	
	@Autowired
	private EntriesService entriesService;
	
	public EntriesService getEntriesService() {
		return entriesService;
	}
	
	public void setEntriesService(EntriesService entriesService) {
		this.entriesService=entriesService;
	}
	
	
	@GetMapping(value="/home")
	public String homePage() {
		return "homepage";
	}
	
	@GetMapping(value="/registration")
	public String registration() {
		return "registration";
	}
	
	@PostMapping(value="/saveuser")
	public String saveuser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "registrationsuccess";
	}
	
	@PostMapping(value="/authenticate")
	public String authenticateuser(@ModelAttribute("user") User user,Model model) {
		String viewname="homepage";
		User user1=userService.findByUsername(user.getUsername());
		if(user1!=null && user.getPassword().equals(user1.getPassword())) {
			viewname="authentication";
			model.addAttribute("user",user1);
			session.setAttribute("user", user1);
			List<Entries> entries=null;
		try {
			entries=entriesService.findByUserid(user1.getId());
		}catch(Exception e){
			e.printStackTrace();
		}
		    model.addAttribute("entrieslist",entries);
		}
		return viewname;
	}
	
	@GetMapping("/addentry")
	public String addentry() {
		String addentry="addentry";
		return addentry;
	}
	
	@PostMapping("/saveentry")
	public String saveentry(@ModelAttribute("entry") Entries entry,Model model) {
		String viewname="authentication";
		entriesService.saveEntries(entry);
		User user1=(User)session.getAttribute("user");
		List<Entries> entries=null;
		try {
			entries=entriesService.findByUserid(user1.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("entrieslist",entries);
		return viewname;
	}
	
	@GetMapping("/viewentry")
	public String viewentry(@RequestParam("id") int id,Model model) {
		String viewname="displayentry";
		Entries entry=entriesService.findById(id);
		model.addAttribute("Entries",entry);
		return viewname;
	}
	
	@GetMapping("/authentication")
	public String userhomepage(Model model) {
		String viewname="authentication";
		User user1=(User)session.getAttribute("user");
		List<Entries> entry=null;
		try {
			entry=entriesService.findByUserid(user1.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("entrieslist",entry);
		return viewname;
	}
	
	@GetMapping("/updateentry")
	public String updateEntry(@RequestParam("id") int id,Model model) {
		String viewname="displayupdateentry";
		Entries entry=entriesService.findById(id);
		model.addAttribute("entry",entry);
		User user1=(User)session.getAttribute("user");
		if(user1==null) {
			viewname="homepage";
		}
		return viewname;
	}
	
	@PostMapping("/processentryupdate")
	public String processentryupdate(@ModelAttribute("entry") Entries entry,Model model) {
		String viewname="authentication";
		entriesService.updateEntries(entry);
		User user1=(User)session.getAttribute("user");//check why it returns null here okay Can I run Again will it work
		List<Entries> entries=null;
		try {
			entries=entriesService.findByUserid(entry.getUserid());//try now okay
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("entrieslist",entries);
		return viewname;
	}
	
	@GetMapping("/deleteentry")
	public String deleteentry(@RequestParam("id") int id,Model model) {
		String viewname="authentication";
		User user1=(User)session.getAttribute("user");
		Entries entry=entriesService.findById(id);
		if(user1==null) {
			viewname="authentication";
		}
		else {
			entriesService.deleteEntries(entry);
		}
		List<Entries> entries=null;
		try {
			entries=entriesService.findByUserid(user1.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("entrieslist",entries);
		
		return viewname;
	}
	
	@GetMapping("/signout")
	public String signoutpage() {
		String viewname="homepage";
		session.invalidate();
		
		return viewname;
	}
	
}
