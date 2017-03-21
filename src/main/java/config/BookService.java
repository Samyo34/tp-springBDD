package config;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {

	@Autowired SpringDAO bookDao;

	public int addNElement(int n){
		int nbElem = 0;
		for(int i = 0; i<n ;i++){
			nbElem+=this.bookDao.addBook("Titre"+i, "Author"+i, 300+i, new Date());
		}
		return nbElem;
	}
	
	
	public int addNElementWithId(int n){
		int nbElem = 0;
		for(int i = 0; i<n ;i++){
			nbElem+=this.bookDao.addBookWhithId(22,"Titre"+i, "Author"+i, 300+i, new Date());
		}
		return nbElem;
	}
	
	public List<Book> getBooks() {
		return bookDao.getBooks();
	}
}
