package apiCommLobby;

import org.bukkit.Bukkit;

public class TransmitMessage {
	
	public static void send(String server, String label, String message) {
		if(label.equalsIgnoreCase("stop")){
			Bukkit.getServer().shutdown();
		}
		new signControl.Receive(server, label, message);
	}

}
