package apiCommLobby;


import org.bukkit.Bukkit;

public class TransmitMessage {
	
	public static void send(String server, String label, String message) {
		traitement(server, label, message);
		new signControl.Receive(server, label, message);
	}
	
	//Action simple
	private static void traitement(String server, String label, String message){
		if(label.equalsIgnoreCase("stop")){
			Bukkit.getServer().shutdown();
		}
		if(label.equalsIgnoreCase("countPlayer")){
			int nb = Bukkit.getOnlinePlayers().size();
			SendMessage.sendToLobby("nbPlayer", nb +"");
		}
	}
}
