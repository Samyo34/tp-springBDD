package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.reflect.*;

@Repository
public abstract class GenericDAO<T> {
	
	private JdbcTemplate jdbc;
	private String dataBaseName ="generic";
	
	@Autowired
	public void setDataSource(DataSource ds){
		this.jdbc = new JdbcTemplate(ds);	
	}
		
	public String getDataBaseName() {
		return dataBaseName;
	}

	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}
	
	public String getAttributesString(){
		return "()";
	}
	
	public String getParams(){
		return "()";
	}

//	public int create(T object){
//		String tableName = this.getDataBaseName();
//		String sql = "insert into "+tableName+" "+this.getAttributesString() + " values "+this.getParams();
//		
//	}
	
	
}
