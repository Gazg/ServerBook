package sellingBook;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import sellingBook.interfaceRMI.IBook;
import sellingBook.interfaceRMI.ILibraries;
import sellingBook.interfaceRMI.ILibrary;

public class Library  extends UnicastRemoteObject implements ILibrary{

	private ConcurrentHashMap<Long, IBook> map ;


	protected Library() throws RemoteException {
		map = new ConcurrentHashMap<Long, IBook>();
	}



	@Override
	public IBook getBook(Long ISBN) throws RemoteException {
		System.out.println("\nGet Book ISBN: " + ISBN.toString());
		return map.get(ISBN);
	}

	@Override
	public IBook removeBook(Long ISBN) throws RemoteException {
		System.out.println("\nRemove Book ISBN: " + ISBN.toString());
		return map.remove(ISBN);
	}

	@Override
	public List<IBook> getBooksByAuthor(String author) throws RemoteException {
		System.out.println("\nGet Book by Author : " + author);
		ArrayList<IBook> books = new ArrayList<IBook>();
		for(Entry <Long, IBook> entry : map.entrySet()) {
			IBook b = entry.getValue();
			if (b.getAuthor().equals(author))
				System.out.println("Book found : " + b.getTitle());
				books.add(b);
		}
		return books;
	}

	@Override
	public void addBooks(List<IBook> books) throws RemoteException {
		System.out.println("\nAdd a list of books");
		for(IBook book: books){
			map.put(book.getISBN(), book);
		}

	}

	@Override
	public void addBook(IBook book) throws RemoteException {
		System.out.println("\nAdd a book");
		map.put(book.getISBN(), book);

	}

	@Override
	public void addBook(Long isbn, String title, String author, Double price)
			throws RemoteException {
		System.out.println("\nAdd a book");
		map.put(isbn,new Book(title,author,isbn,price));

	}

	@Override
	public List<IBook> getAllBooks() throws RemoteException {
		System.out.println("\nGet All books");
		return (List<IBook>) map.values();
	}



	@Override
	public IBook getBook(String title) throws RemoteException {
		System.out.println("\nGet Book by Title : " + title);
		for(Entry <Long, IBook> entry : map.entrySet()) {
			Long isbn = entry.getKey();
			IBook b = entry.getValue();
			if (b.getTitle().equals(title))
				System.out.println("Book found : " + b.getTitle());
				return b;
		}
		return null;
	}

	@Override
	public List<IBook> getBooksThatContain(String title) throws RemoteException {
		System.out.println("\nGet Books that contain : " + title);
		ArrayList<IBook> books = new ArrayList<IBook>();
		for(Entry <Long, IBook> entry : map.entrySet()) {
			Long isbn = entry.getKey();
			IBook b = entry.getValue();
			if (b.getTitle().contains(title))
				System.out.println("Book found : " + b.getTitle());
				books.add(b);
		}
		return books;
	}




}
