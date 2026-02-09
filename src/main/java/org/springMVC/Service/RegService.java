package org.springMVC.Service;

import java.util.List;

import org.springMVC.Model.Emp;

public interface RegService {
	public int add(Emp e);
	public List<Emp> viewEmp();
	public  void delete(String name);
	public int update(Emp e);
	public List<Emp> sr(String name);
    void save(String name, String imgPath, String pdfPath);
}
