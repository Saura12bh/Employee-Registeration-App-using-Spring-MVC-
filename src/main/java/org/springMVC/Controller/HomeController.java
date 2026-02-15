package org.springMVC.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springMVC.Model.Emp;
import org.springMVC.Model.Subject;
import org.springMVC.Repo.RegRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	
	private static final Logger logger=LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String index() {
		  logger.info(" page opened");
		return "index";
	}

	@RequestMapping("/reg")
	public String reg() {
		return "reg";
	}

	@Autowired
	RegRepoImpl regService;

	@PostMapping("/save")
	public String save(Emp e, Model m, Map<String, Emp> map) {
		
		//save logger
		 logger.info("Saving employee");
		map.put("m", e);
		int b = regService.add(e);
		if (b > 0) {
			m.addAttribute("msg", "Emp registred successfuly");
		} else {
			m.addAttribute("msg", "Emp not registred successfuly");
			 logger.error("Error while saving employee");
		}
		return "display";
	}

	@GetMapping("/view")
	public String view(Model m) {
		 logger.info("Viewing employee");
		List<Emp> list = regService.viewEmp();
		m.addAttribute("m", list);
		return "view";
	}

	@GetMapping("/delete")
	public String del(@RequestParam("name") String name) {
		 logger.info("Delete EMP  employee");
		regService.delete(name);
		return "redirect:/view";
	}
	@GetMapping("/update")
	public String Up(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("password") String password ,Map<String,Object>map) {
		map.put("name",name);
		map.put("email", email);
		map.put("password", password);
		return "update";
	}
	
	
	@PostMapping("/upd")
	public String update(Emp e)
	{
		int v=regService.update(e);
		return "redirect:/view";
	}
	
	//serching name in emp
	@GetMapping("/search")
	@ResponseBody
	public List<Emp> sr(@RequestParam("name") String name)
	{
		List<Emp> list=regService.sr(name);
		return list;
	}
	//add Subject
	@GetMapping("/addSubject")
	public String addSubject(Map<String,List<Emp>>map)
	{
		List<Emp> list = regService.viewEmp();
		map.put("empList", list);
		return "subject";
	}
		
	//upload files
	@PostMapping("/saveSubject")
	public String saveSubject(Subject subject,HttpServletRequest request,Map<String,String>map) throws IllegalStateException, IOException
	{
//		String n=subject.getName();
//		int id=subject.getId();
//		MultipartFile i=subject.getImg();
//		MultipartFile p=subject.getPdf();
//		List<String> li=subject.getCourse();
//		System.out.println(n+"\t"+id+"\t"+i+" \t"+p+"\t"+li);
		        String uploadPath = request.getServletContext().getRealPath("/uploads/");
	            new File(uploadPath).mkdirs();

	            MultipartFile img = subject.getImg();
	            MultipartFile pdf = subject.getPdf();

	            String imgName = img.getOriginalFilename();
	            String pdfName = pdf.getOriginalFilename();

	            img.transferTo(new File(uploadPath + imgName));
	            pdf.transferTo(new File(uploadPath + pdfName));

	            regService.save(
	                subject.getName(),
	                "uploads/" + imgName,
	                "uploads/" + pdfName
	            );
				return "subject";

	        
	}

}
