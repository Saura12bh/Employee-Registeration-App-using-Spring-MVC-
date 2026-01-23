package org.springMVC.Repo;

import org.springMVC.Model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("regRepo")
public class RegRepoImpl implements RegRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int add(Emp e) {
		return jdbcTemplate.update("insert into reg1 values(?,?,?)",new Object[] {e.getName(),e.getEmail(),e.getPassword()});
	}

}
