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
		return map.get(ISBN);
	}

	@Override
	public IBook removeBook(Long ISBN) throws RemoteException {
		return map.remove(ISBN);
	}

	@Override
	public List<IBook> getBooksByAuthor(String author) throws RemoteException {
		ArrayList<IBook> books = new ArrayList<IBook>();
		for(Entry <Long, IBook> entry : map.entrySet()) {
			IBook b = entry.getValue();
			if (b.getAuthor().equals(author))
				books.add(b);
		}
		return books;
	}

	@Override
	public void addBooks(List<IBook> books) throws RemoteException {
		for(IBook book: books){
			map.put(book.getISBN(), book);
		}

	}

	@Override
	public void addBook(IBook book) throws RemoteException {
		map.put(book.getISBN(), book);

	}

	@Override
	public void addBook(Long isbn, String title, String author, Double price)
			throws RemoteException {
		map.put(isbn,new Book(title,author,isbn,price));

	}

	@Override
	public List<IBook> getAllBooks() throws RemoteException {
		return (List<IBook>) map.values();
	}



	@Override
	public IBook getBook(String title) throws RemoteException {
		for(Entry <Long, IBook> entry : map.entrySet()) {
			Long isbn = entry.getKey();
			IBook b = entry.getValue();
			if (b.getTitle().equals(title))
				return b;
		}
		return null;
	}

	@Override
	public List<IBook> getBooksThatContain(String title) throws RemoteException {
		ArrayList<IBook> books = new ArrayList<IBook>();
		for(Entry <Long, IBook> entry : map.entrySet()) {
			Long isbn = entry.getKey();
			IBook b = entry.getValue();
			if (b.getTitle().contains(title))
				books.add(b);
		}
		return books;
	}




}
