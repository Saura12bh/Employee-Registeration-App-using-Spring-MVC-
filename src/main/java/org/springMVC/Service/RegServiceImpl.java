package org.springMVC.Service;

import java.util.List;

import org.springMVC.Model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("regService")
public class RegServiceImpl  implements RegService {
	
	@Autowired
	RegServiceImpl regRepo;
	@Override
	public int add(Emp e) {
		return regRepo.add(e);
	}
	@Override
	public List<Emp> viewEmp() {
		// TODO Auto-generated method stub
		return regRepo.viewEmp();
	}
	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		 regRepo.delete(name);
	}
	@Override
	public int update(Emp e) {
		// TODO Auto-generated method stub
		return regRepo.update(e);
	}

}
