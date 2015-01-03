package sellingBook.interfaceRMI;



import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ILibraries extends Remote {
	public void subscribe(ILibrary lib)throws RemoteException;
	public void unsubscribe(ILibrary lib) throws RemoteException;
	public IBook getBook(Long ISBN) throws RemoteException;
	public IBook getBook(String title) throws RemoteException;
	public List<IBook> getBooksThatContain(String title) throws RemoteException;
	public IBook removeBook(Long ISBN) throws RemoteException;
	public List<IBook> getBooksByAuthor(String author) throws RemoteException;
	public void addBook(IBook book) throws RemoteException;
	public void addBook(Long isbn,String title,String authour,Double price,Integer NbExemplaire) throws RemoteException;
	public List<IBook> getAllBooks() throws RemoteException;
}
