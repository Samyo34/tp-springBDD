package main;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.Book;
import config.BookService;
import config.JdbcConfig;

public class Main {
	public static void main(String [] args){
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		//DataSource ds = (DataSource) context.getBean("dataSource");
		
		BookService bServ = context.getBean(BookService.class);
		
		//PlatformTransactionManager tx = (PlatformTransactionManager) context.getBean("txManager");
		
		//int value =dao.getNbRow();
		//System.out.println(value);
		List<Book> books = bServ.getBooks();
		//System.out.println(books);
		//dao.addBook("lol", "autheur lol", 20, new Date());
		//books = dao.getBooks();
		//System.out.println(books);
//		dao.updateBook(2, "Mega Super Livre", "Mega Super Autheur", 305, new Date());
//		dao.deleteBook(5);
//		dao.deleteBook(6);
//		dao.deleteBook(7);
//		dao.deleteBook(8);
//		dao.deleteBook(9);
//		dao.deleteBook(10);
//		books = dao.getBooks();
//		System.out.println(books);
//		dao.addNElement(3);
		//books = dao.getBooks();
		//System.out.println(books);
		bServ.addNElementWithId(3);
		books = bServ.getBooks();
		System.out.println(books);
		
	}
}
