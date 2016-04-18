import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class EchoServerLauncher {

	public static void main(String[] args) {
		// if there is no security manager, start one
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			//create the registry if there isn't one
			Registry registry = LocateRegistry.getRegistry();
//			Registry registry = LocateRegistry.createRegistry(1024);

			//create the server object
			EchoServer server = new EchoServer();
//			try {
//				Naming.rebind("//localhost:1099/echo", server);
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			server.echo("hellooo");
			
			//register (bind) the server object on the registry
			// the registry may be on a different machine
			
			registry.rebind("Echo", server);
		} catch (RemoteException re) {
			re.printStackTrace();
		}
	}
}
