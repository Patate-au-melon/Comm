package server;

import java.net.Socket;

import org.bukkit.Bukkit;

public class CloseSocket {
	
	public static void close(String server){
		try {
			Socket s = main.Main.listServer.get(server);
			Bukkit.getLogger().info(server + " vient de se deconnecter, il etait sur le port  " + s.getPort());
			s.close();
			main.Main.listServer.remove(server);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
