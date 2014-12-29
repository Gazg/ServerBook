package sellingBook;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import sellingBook.interfaceRMI.ILibraries;

public class Main {

	public static void main(String[] args) throws RemoteException {
		System.out.println("Lancement d'un server de books.....");
		System.setProperty("java.security.policy", "http://localhost:8080/RMIWebServices/sec.policy");
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
			}
		System.setProperty("java.rmi.server.codebase", "http://localhost:8080/RMIWebServices/bin/");
		System.setProperty("java.security.policy","sec.policy");
		System.setProperty("java.rmi.server.useCodebaseOnly ", "false");
		ILibraries lib;
		Library libServer = new Library();

		
		try {
			lib = (ILibraries) Naming.lookup("rmi://localhost/Libraries");
			System.out.println("Inscription au aupres du serveur de librairies");
			lib.subscribe(libServer);
			
		

		} catch (MalformedURLException e1) {
			System.out.println("Malformed url");
			e1.printStackTrace();
		} catch (RemoteException e1) {
			System.out.println("Remote exeption sur le lookup");
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			System.out.println("Not bound exeption");
			e1.printStackTrace();
		}

	}
}
