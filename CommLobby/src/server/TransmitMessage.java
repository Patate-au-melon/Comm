package server;

import org.bukkit.Bukkit;

public class TransmitMessage {
	
	public static void send(String server, String label, String message){
		if(label.equalsIgnoreCase("stop")&&main.Main.listServer.containsKey(server)){
			CloseSocket.close(server);
			Bukkit.getLogger().info(server + " vient de se deconnecter");
		}
		new signControl.Receive(server, label, message);
	}


}
