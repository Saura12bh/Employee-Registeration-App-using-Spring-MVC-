package org.springMVC.Repo;

import java.util.List;

import org.springMVC.Model.Emp;

public interface RegRepo {
	public int add(Emp e);
	public List<Emp> viewEmp();
	public  void delete(String name);
	public int update(Emp e);
	
}
