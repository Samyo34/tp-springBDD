package config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SpringDAO {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource ds){
		this.jdbc = new JdbcTemplate(ds);	
	}
	
	public int getNbRow(){
		return this.jdbc.queryForObject("select count(*) from book",Integer.class);
	}
	
	public List<Book> getBooks(){
		return this.jdbc.query("select * from book",new RowMapperBook());
	}
	
	public int addBook(String title, String author, Integer nbPages, Date date){
		return this.jdbc.update("insert into book (title, author,nb_pages,publication_date) values (?, ?, ?, ?)",title, author,nbPages,date);
	}
	
	public int addBookWhithId(Integer id,String title, String author, Integer nbPages, Date date){
		return this.jdbc.update("insert into book (id,title, author,nb_pages,publication_date) values (?, ?, ?, ?, ?)",id, title, author,nbPages,date);
	}
	
	public int updateBook(Integer id, String newTitle, String newAuthor, Integer newNbPages, Date newDate){
		String sql = "update book set title = ?, author = ?, nb_pages = ?, publication_date = ? where id = ?";
		return this.jdbc.update(sql,newTitle, newAuthor,newNbPages,newDate,id);
	}
	
	public int deleteBook(Integer id){
		String sql =  "delete from book where id = ?";
		return this.jdbc.update(sql,id);
	}

	private static final class RowMapperBook implements RowMapper<Book> {

		public Book mapRow(ResultSet res, int arg1) throws SQLException {
			Book b = new Book();
			b.setId(res.getInt("id"));
			b.setTitle(res.getString("title"));
			b.setAuthor(res.getString("author"));
			b.setNb_pages(res.getInt("nb_pages"));
			b.setDate(res.getDate("publication_date"));

			return b;
		}

	}
	
}
