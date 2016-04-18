import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * An implementation of the echo service
 * Exercise to understand implementation of client-server technology
 * This is not examinable
 * 
 * @author BBK-PiJ-2015-74 lburge01
 */

public interface EchoService extends Remote {

	/**
	 * Returns the same string passed as parameter
	 * 
	 * @param s a string
	 * @return the same string passed as parameter
	 * @throws RemoteException (in case anything goes wrong with network connectivity)
	 */
	
	String echo (String s) throws RemoteException;
}
