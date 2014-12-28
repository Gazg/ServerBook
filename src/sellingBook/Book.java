package sellingBook;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

import sellingBook.interfaceRMI.IBook;

public class Book extends UnicastRemoteObject implements IBook{

	private String title;
	private String author;
	private Long isbn;
	private Double price;
	
	
	public Book() throws RemoteException{
		super();
	}
	
	public Book(String title,String author, Long isbn, Double price) throws RemoteException{
		super();
		this.title=title;
		this.author=author;
		this.isbn=isbn;
		this.price = price;
	}

	
	public String getTitle() throws RemoteException{
			return this.title;
	}
	public String getAuthor() throws RemoteException{
			return this.author;
	}	
	public Long getISBN() throws RemoteException{
		return this.isbn;
	}

	@Override
	public Double getPrice() throws RemoteException {
		return price;
	}
}
