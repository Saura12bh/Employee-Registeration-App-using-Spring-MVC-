package org.springMVC.Controller;

import java.util.List;
import java.util.Map;

import org.springMVC.Model.Emp;
import org.springMVC.Repo.RegRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
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
		map.put("m", e);
		int b = regService.add(e);
		if (b > 0) {
			m.addAttribute("msg", "Emp registred successfuly");
		} else {
			m.addAttribute("msg", "Emp not registred successfuly");
		}
		return "display";
	}

	@GetMapping("/view")
	public String view(Model m) {
		List<Emp> list = regService.viewEmp();
		m.addAttribute("m", list);
		return "view";
	}

	@GetMapping("/delete")
	public String del(@RequestParam("name") String name) {
		regService.delete(name);
		return "redirect:/view";
	}
	@GetMapping("/update")
	public String Up(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("password") String password  ,Map<String,Object>map) {
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
}
