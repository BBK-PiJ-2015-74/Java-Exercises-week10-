import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EchoServer extends UnicastRemoteObject implements EchoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EchoServer() throws RemoteException {
		// Nothing to initialise in the constructor
		// must have a constructor that throws RemoteException
	}

	@Override
	public String echo(String s) throws RemoteException {
		// This println is not necessary, but helps verify whether or not
		// the server has received the call or not on the remote machine
		System.out.println("Replied to some client saying '"+ s + "'");
		return s;
	}
}
