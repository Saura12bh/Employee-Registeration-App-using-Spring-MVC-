package org.springMVC.Service;

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

}
