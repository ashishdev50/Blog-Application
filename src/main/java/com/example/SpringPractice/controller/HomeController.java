package com.example.SpringPractice.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.example.SpringPractice.DTO.CommentDTO;
import com.example.SpringPractice.Entity.Blog;
import com.example.SpringPractice.Entity.Comments;
import com.example.SpringPractice.Entity.EmailDetails;
import com.example.SpringPractice.Entity.Subscibe;
import com.example.SpringPractice.Entity.User;
import com.example.SpringPractice.Gobal.GlobalData;
import com.example.SpringPractice.Services.BlogService;
import com.example.SpringPractice.Services.CommentServices;
import com.example.SpringPractice.Services.SubscribeServiceImpl;
import com.example.SpringPractice.repo.CommentRepo;
import com.example.SpringPractice.repo.EmailRepo;
import com.example.SpringPractice.repo.EmailService;
import com.example.SpringPractice.repo.SubScriberepo;
import com.example.SpringPractice.repo.SubscibeService;
import com.example.SpringPractice.repo.aboutrepo;
import com.example.SpringPractice.repo.blogrepo;
import com.example.SpringPractice.repo.userepo;

@Controller
public class HomeController {

	@Autowired
	userepo userepo;
	@Autowired
	blogrepo blogrepo;
	@Autowired
	aboutrepo aboutrepo;
	@Autowired
	BlogService blogService;
	@Autowired
	EmailService emailService;
	@Autowired
	SubscibeService subscibeService;
	@Autowired
	SubScriberepo subScriberepo;

	@Autowired
	EmailRepo emailRepo;

	@Autowired
	CommentDTO commentDTO1;

	@Autowired
	CommentServices commentServices;

	@Autowired
	CommentRepo commentRepo;
	static int idd;

	@GetMapping("/index")
	public String login(@ModelAttribute User user, @ModelAttribute Blog blog, BindingResult bindingResult,
			Model model) {

		model.addAttribute("blogs", blogrepo.findAll());

		model.addAttribute("users", userepo.findAll());
		System.out.println(userepo.findAll().get(0).getImage());
		// System.out.println( model.addAttribute("user", new User().getName()));
		return "index";
	}

	@PostMapping("/index")
	public String index(@ModelAttribute("index") Subscibe subscibe, Model model) {

		subScriberepo.save(subscibe);
		model.addAttribute("blogs", blogrepo.findAll());
		model.addAttribute("users", userepo.findAll());
		subscibeService.sendSubscribtions(subscibe);

		System.out.println(subscibe);
		return "index";
	}

	@GetMapping("/about")

	public String aboubt(Model model) {

		model.addAttribute("users", userepo.findAll());
		model.addAttribute("abouts", userepo.findAll());
		return "about";
	}

	@GetMapping("/contact")
	public String contact(Model model) {

		model.addAttribute("users", userepo.findAll());
		System.out.println(userepo.findAll().get(0).getAddress());
		return "contact";
	}

	@PostMapping("/contact")
	public String contact(@ModelAttribute("contact") EmailDetails details, Model model) {
		emailRepo.save(details);
		model.addAttribute("users", userepo.findAll());
		emailService.sendMailWithAttachment(details);
		System.out.println(details);
		return "/contact";
	}

	@GetMapping("/BlogDetail")
	public String Blog(Model model) {
		model.addAttribute("blogs", blogrepo.findAll());
		model.addAttribute("users", userepo.findAll());
		return "BlogDetail";
	}

	@GetMapping("BlogDetail{id}")

	public String blogDetail(@PathVariable int id, Model model) {

		Blog blog = blogrepo.findById(id).get();
		idd = blog.getId();
		System.out.println(blog.getId());

		Comments comments = new Comments();
		comments.getMessage();
		//GlobalData.cart.stream().mapToDouble(Comments::getCoid).sum())
		

	
		System.out.println(commentServices.getCommentsByPostId(idd));

		model.addAttribute("commentss", commentServices.getCommentsByPostId(idd));

		model.addAttribute("blogs", blog);
		model.addAttribute("users", userepo.findAll());
		return "BlogDetail";
	}

	@PostMapping("BlogDetail{id}/addcommment")
	public String addcoment(@ModelAttribute("comments") Comments comments, Model model) {

		Blog blog = blogrepo.findById(idd).get();

		comments.setBlog(blog);

		commentServices.sendMailWithComments(comments);
		commentServices.addommment(comments);

		// System.out.println(commentServices.addommment(comments));
		return "redirect:/index";
	}

	@GetMapping("/ig/")
	public RedirectView urlInsta() {

		String insta = userepo.findAll().get(0).getInsta();
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(insta);

		return redirectView;
	}
	
	
	@GetMapping("/tweeter/")
	public RedirectView urlTweet()
	{
		
		
	String tweeter = userepo.findAll().get(0).getTweeter();
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(tweeter);
		
		
		return redirectView;
	}
	@GetMapping("/linkdin/")
	public RedirectView urlLinkdin()
	{
		
		
	String linkdin= userepo.findAll().get(0).getLinkdin();
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(linkdin);
		
		
		return redirectView;
	}
	@GetMapping("/facebook/")
	public RedirectView urlfacebook()
	{
		
		
	String facebook= userepo.findAll().get(0).getFacebook();
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(facebook);
		
		
		return redirectView;
	}
	
}