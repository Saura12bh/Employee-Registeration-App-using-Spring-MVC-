package org.springMVC.Repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springMVC.Model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("regRepo")
public class RegRepoImpl implements RegRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int add(Emp e) {
		return jdbcTemplate.update("insert into reg1 values(?,?,?)",new Object[] {e.getName(),e.getEmail(),e.getPassword()});
	}

	@Override
	public List<Emp> viewEmp() {
		
		List<Emp> list=jdbcTemplate.query("select * from reg1", new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp e=new Emp();
				e.setName(rs.getString(1));
				e.setEmail(rs.getString(2));
				e.setPassword(rs.getString(3));
				return e;
			}
		});
		return list;
	}

	@Override
	public void delete(String name) {
		int v=jdbcTemplate.update("delete from reg1 where name=?",new Object[] {name});
	}

	@Override
	public int update(Emp e) {
		return jdbcTemplate.update("update reg1 set email=?,password=? where name=?",new Object[] {e.getEmail(),e.getPassword(),e.getName()});
	}

}
