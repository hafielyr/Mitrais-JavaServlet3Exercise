package BookPackage;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * 
 * @author trainee
 * Bean
 */
@ManagedBean
@SessionScoped
public class CrudBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<BookEntity> books;
	private BookEntity book=new BookEntity();
	private BookEntity beforeEditBook=null;
	private boolean edit;
	private boolean isbnValid=true;
	private boolean titleValid=true;
	private boolean priceValid=true;
	/**
	 * initiation
	 */
	@PostConstruct
	public void init(){
		books=new ArrayList<BookEntity>();
	}
	/**
	 * add book into list of books with validation
	 */
	public void add(){
		isbnValid=true;
		titleValid=true;
		priceValid=true;
		if(book.getISBN()==""){
		isbnValid=false;
		}
		if(book.getTitle()==""){
		titleValid=false;
		}
		if(book.getPrice()==0){
		priceValid=false;
		}
		if(book.getISBN()!="" && book.getTitle()!="" && book.getPrice()!=0){
		books.add(book);
		book=new BookEntity();
		}
		
	}
	/**
	 * reset book input field
	 */
	public void reset(){
		book=new BookEntity();
	}
	/**
	 * getter for books
	 * @return ArrayList<BookEntity> books
	 */
	public ArrayList<BookEntity> getBooks(){
		return this.books;
	}
	/**
	 * getter for book
	 * @return BookEntity book
	 */
	public BookEntity getBook(){
		return this.book;
	}
	/**
	 * delete specified book
	 * @param book
	 */
	public void delete(BookEntity book){
		books.remove(book);
	}
	/**
	 * getter for edit
	 * @return boolean edit
	 */
	public boolean isEdit(){
		return this.edit;
	}
	/**
	 * edit specified book
	 * @param book
	 */
	public void edit(BookEntity book) {
		this.beforeEditBook=this.book;
		this.book=book;
        edit = true;
    }
	/**
	 * canceling book edit
	 */
	public void cancelEdit(){
		this.book=this.beforeEditBook;
		this.book = new BookEntity();
        edit = false;
	}
	/**
	 * save edited book
	 */
	public void saveEdit(){
		this.book = new BookEntity();
        edit = false;
	}
	/**
	 * getter for isbnValid
	 * @return boolean isbnValid
	 */
	public boolean isValid_ISBN(){
		return this.isbnValid;
	}
	/**
	 * getter for titleValid
	 * @return boolean titleValid
	 */
	public boolean isValid_title(){
		return this.titleValid;
	}
	/**
	 * getter for priceValid
	 * @return boolean priceValid
	 */
	public boolean isValid_price(){
		return this.priceValid;
	}
}