package config;

import java.util.Date;

public class Book {
	
	private Integer id;
	private String title;
	private String author;
	private Integer nb_pages;
	private Date date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getNb_pages() {
		return nb_pages;
	}
	public void setNb_pages(Integer nb_pages) {
		this.nb_pages = nb_pages;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String toString(){
		return "["+this.id+","+this.title+","+this.author+","+this.nb_pages+","+this.date+"]";
	}

}
