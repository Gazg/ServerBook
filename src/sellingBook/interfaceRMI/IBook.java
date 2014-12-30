package sellingBook.interfaceRMI;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBook extends Remote{
	public String getTitle() throws RemoteException;
	public String getAuthor() throws RemoteException;	
	public Long getISBN() throws RemoteException;
	public Double getPrice() throws RemoteException;
	public int getStock() throws RemoteException;
	public void setStock(Integer stock) throws RemoteException;
}