package server;

import java.net.Socket;

public class CloseSocket {
	
	public static void close(String server){
		try {
			Socket s = main.Main.listServer.get(server);
			System.out.println(server + " vient de se deconnecter, il etait sur le port  " + s.getPort());
			s.close();
			main.Main.listServer.remove(server);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
