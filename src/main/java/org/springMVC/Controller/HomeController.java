package org.springMVC.Controller;

import java.util.Map;

import org.springMVC.Model.Emp;
import org.springMVC.Repo.RegRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("/reg")
	public String reg()
	{
		return "reg";
	}
	@Autowired 
	RegRepoImpl regService;
	@PostMapping("/save")
	public String save(Emp e,Model m,Map<String,Emp>map)
	{
	 map.put("m",e);
	 int b=regService.add(e);
	 if(b>0)
	 {
		m.addAttribute("msg","Emp registred successfuly"); 
	 }
	 else {
			m.addAttribute("msg","Emp not registred successfuly");
	 }
		return "display";
	}
	
	
}
