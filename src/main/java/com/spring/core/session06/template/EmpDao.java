package com.spring.core.session06.template;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.mysql.cj.protocol.Resultset;
import com.spring.core.session06.entity.Emp;

public class EmpDao {
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	//多筆查詢 I
	public List<Map<String, Object>> queryAll(){
		
		String sql = "select eid, ename, age, createtime from emp";
		List<Map<String, Object>> emps = jdbcTemplate.queryForList(sql);
		return emps;
		
	}
	//多筆查詢 II
	public List<Emp> queryAllEmps()
	{
		String sql = "select eid, ename, age, createtime for emp";
		RowMapper<Emp> rowMapper = (ResultSet rs, int rowNum) ->{
			Emp emp = new Emp();
			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setCreatetime(rs.getTimestamp("createtime"));
			return emp;
		};
		List<Emp> emps = jdbcTemplate.query(sql, rowMapper);
		return emps;
		
	}
	//多筆查詢III
	public List<Emp> queryAllEmps2(){
		String sql ="select eid, ename, age, createtime for emp";
		List<Emp> emps = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Emp.class));
		return emps;
		
	}
	//單筆新增  I
	public int addOne1(String ename, Integer age)
	{
		String sql = "insert into emp(ename, age) value(?, ?)";
		int rowcount = jdbcTemplate.update(sql, ename, age);
		return rowcount;
	}
	//單筆新增 II
	public int addOne2(String ename, Integer age)
	{
		String sql = "insert into emp(ename, age) values(:ename, :age)";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("ename", ename)
				.addValue("age", age);
		int rowCount =namedParameterJdbcTemplate.update(sql, params);
		return rowCount;
	}
	//批次多筆新增I
	public int[] batchAdd1(List<Object[]> rows)
	{
		
		String sql = "insert into emp(ename, age) value(?, ?)";
		return jdbcTemplate.batchUpdate(sql, rows); //rows 資料回傳
		
	}
	//批次多筆新增II
	public int[]  batchAdd2(List<Emp> emps)
	{
		String sql = "insert into emp(ename, age) values(?, ?)";
		BatchPreparedStatementSetter setter =new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				 //i = emps的index
				ps.setString(1, emps.get(i).getEname());
				ps.setInt(2, emps.get(i).getAge());
				
			}
			
			@Override
			public int getBatchSize() {
				 
				return emps.size();
			}
		};
		return jdbcTemplate.batchUpdate(sql, setter);
	}
	 //修改
	public int updateById(Integer eid, String ename, Integer age)
	{
		String sql = "update emp set ename=?, age=? where eid=?";
		return jdbcTemplate.update(sql, ename, age, eid);
		
	}
	//刪除
	public int deletById(Integer eid)
	{
		String sql = "delet from emp where eid=?";
		return jdbcTemplate.update(sql, eid);
	}
	//取得單筆
	//老師 getXxxx(單筆)queryXxxx(多筆)
	public Emp getEmpById( Integer eid)
	{
		String sql= "select eid, ename, age, createtime, from emp where eid=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Emp>(Emp.class), eid);
		
	}
	
}