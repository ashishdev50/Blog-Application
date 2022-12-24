package com.example.SpringPractice.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.SpringPractice.Entity.Blog;
import com.example.SpringPractice.Entity.Comments;
import com.example.SpringPractice.Entity.SendMailForBlogUpload;
import com.example.SpringPractice.Entity.User;
import com.example.SpringPractice.Services.BlogService;
import com.example.SpringPractice.Services.UserServices;
import com.example.SpringPractice.repo.CommentRepo;
import com.example.SpringPractice.repo.SubScriberepo;
import com.example.SpringPractice.repo.blogrepo;
import com.example.SpringPractice.repo.userepo;

@Controller
public class AdminController {

	public String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/images";
	@Autowired
	userepo userepo;
	@Autowired
	blogrepo blogrepo;
	@Autowired
	BlogService blogService;

	@Autowired
	UserServices userServices;
@Autowired
SubScriberepo scriberepo;
	@Autowired
	CommentRepo commentRepo;
	private List<Comments> findAll;
	@GetMapping("/admin")
	public String viewadimn(Model model) {

		System.out.println(userepo.findAll().get(0).getId());
		model.addAttribute("Admin", userepo.findAll());
	
		return "Adim";
	}

	@GetMapping("/admin/blogs")
	public String viewBlog(Model model) {
		model.addAttribute("Admin", userepo.findAll());
		model.addAttribute("blogs", blogrepo.findAll());
		return "Blog";
	}

	@GetMapping("/admin/blog/delete/{id}")
	public String deleteProduct(@PathVariable int id) {

		blogrepo.deleteById(id);
		return "redirect:/admin/blogs/";
	}

	@PostMapping("/admin/blogs/add")
	public String productAddPost(@ModelAttribute("blogss") Blog blog, @RequestParam MultipartFile file)
			throws Exception {

		String imageUUID;

		System.out.println(file.getOriginalFilename());
		String originalFilename = file.getOriginalFilename();

		if (originalFilename != null) {
			try {
				File savefile = new ClassPathResource("static/images").getFile();
				Path path = Paths.get(savefile.getAbsolutePath() + File.separator + file.getOriginalFilename());
				System.out.println(path);
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		blog.setBlogimages(file.getOriginalFilename());

		blogService.addBlog(blog);

		try {
			SendMailForBlogUpload sendMailForBlogUpload = new SendMailForBlogUpload();
			blogService.sendMailUpladBlog(sendMailForBlogUpload);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "redirect:/admin/blogs/";
	}

	@GetMapping("/admin/blogs/add")

	public String addblog(Model model) {
		model.addAttribute("Admin", userepo.findAll());
		
		return "AddBlog";
	}

	@GetMapping("/admin/blog/update/{id}")
	public String getblog(@PathVariable int id,Model model) {
		model.addAttribute("Admin", userepo.findAll());
		model.addAttribute("blog",blogrepo.findById(id).get());
		return "UpdateBlog";

	}

	@PostMapping("/admin/blog/update/{id}")
	public String UpdatgeBlog(@PathVariable int id, @ModelAttribute("blogss") Blog blog,
			@RequestParam MultipartFile file) throws Exception {

	

		Blog blog2 = blogrepo.findById(id).get();
		System.out.println(blog2.getId());
		System.out.println(file.getOriginalFilename()+"///////////////////");
		String originalFilename = file.getOriginalFilename();

		if (originalFilename != null) {
			try {
				File savefile = new ClassPathResource("static/images").getFile();
				Path path = Paths.get(savefile.getAbsolutePath() + File.separator + file.getOriginalFilename());
				System.out.println(path);
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				blog.setBlogimages(file.getOriginalFilename());
			} catch (Exception e) {
				blog.setBlogimages(blog2.getBlogimages());
				e.printStackTrace();
			}
		}
 blog2.setBlogname(blog.getBlogname());
 blog2.setBlogdecription(blog.getBlogdecription());
 blog2.setBlogimages(blog.getBlogname());
		

		blogrepo.save(blog);

		return "redirect:/admin/blog/update/{id}";
	}

	@GetMapping("/admin/adminprofile/{id}")
	public String adminProfile(@PathVariable int id, Model model) {

		

	
		model.addAttribute("user", userepo.findById(id).get());

		return "AdminProfile";

	}

	@PostMapping("/admin/adminprofile/{id}")
	public String adminaddphoto(@PathVariable int id, @ModelAttribute("photos") User user,
			@RequestBody MultipartFile file) throws Exception {
		
		User uu = userServices.getuserById(id);
		String imageUUID;
		System.out.println("dcshk");
		
		String originalFilename = file.getOriginalFilename();
System.out.println(file.getOriginalFilename()+"////////////////////////////////");
		if (originalFilename != null) {
			try {
				File savefile = new ClassPathResource("static/images").getFile();
			Path path = Paths.get(savefile.getAbsolutePath() + File.separator + file.getOriginalFilename());
				System.out.println(path);
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				user.setImage(file.getOriginalFilename());
			
			} catch (Exception e) {
				user.setImage(uu.getImage());
			
				e.printStackTrace();
			}
		


			uu.setId(id);
			uu.setImage(user.getImage());
			uu.setName(user.getName());
			uu.setEmail(user.getEmail());
			uu.setSummary(user.getSummary());
			uu.setAddress(uu.getAddress());
			uu.setPhoneno(user.getPhoneno());
	       uu.setImage(uu.getImage());
	       uu.setAbouttitle(user.getAbouttitle());
	       uu.setAboutphoto(user.getAboutphoto());
	       uu.setAboutdecription(user.getAboutdecription());
	       uu.setInsta(user.getInsta());
	       uu.setFacebook(user.getFacebook());
	       uu.setLinkdin(user.getLinkdin());
	       uu.setTweeter(user.getLinkdin());
	        user.setImage(uu.getImage());
	     
			userServices.addPhtoto(user);
		
System.out.println(user.getLinkdin());

		
	}
		return "redirect:/admin/adminprofile/{id}";
	
}
	
	
	
	@GetMapping("/admin/operation/")
	public String aapp(Model model)
	{

		 System.out.println(	commentRepo.findAll().toString());

		model.addAttribute("Commentss", commentRepo.findAll());
		model.addAttribute("Admin", userepo.findAll());
	
		return "Operation";
	}
	
	@GetMapping ("/admin/operation/{id}")
	public String deleteComment(@PathVariable int id)
	{
		
		commentRepo.deleteById(id);
		return "redirect:/admin/operation/";
	}
	
	@GetMapping ("/aaa")
	public String aa(Model model)
	{
		commentRepo.findAll();
	model.addAttribute("Com", commentRepo.findAll());
		return "aa";
	}


	@GetMapping("/admin/operation/Subcription")
	public String Sub(Model model)
	{
		model.addAttribute("subscibes",scriberepo.findAll());
		model.addAttribute("Admin", userepo.findAll());
		return "subscription";
	}
	@GetMapping ("/admin/operation/Subcription{id}")
	public String deleteSubSubcription(@PathVariable int id)
	{
		scriberepo.deleteById(id);
		
		return "redirect:/admin/operation/Subcription";
	}
	
	
	
	
	
	
	
}

