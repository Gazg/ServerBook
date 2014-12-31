package sellingBook;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

import sellingBook.interfaceRMI.IBook;

public class Book extends UnicastRemoteObject implements IBook{

	private String title;
	private String author;
	private Long isbn;
	private Double price;
	private Integer stock;
	
	
	public Book() throws RemoteException{
		super();
	}
	
	public Book(String title,String author, Long isbn, Double price, int NbExemplaire) throws RemoteException{
		super();
		this.title=title;
		this.author=author;
		this.isbn=isbn;
		this.price = price;
		this.stock = NbExemplaire;
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

	@Override
	public Integer getStock() throws RemoteException {
		return stock;
	}

	@Override
	public void setStock(Integer stock) throws RemoteException {
		this.stock = stock;
	}
	



	
	
}
