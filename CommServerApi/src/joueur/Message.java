package joueur;

import java.util.ArrayList;

import org.bukkit.Bukkit;

public class Message {
	
	public static void sendJoueur(String server, ArrayList<String> message){
		if(message.get(0).equalsIgnoreCase("sendJoueur")){
			if(Bukkit.getOnlinePlayers().size() <= Bukkit.getMaxPlayers()){
				ArrayList<String> msg = new ArrayList<>();
				msg.add("transfertJoueur");
				msg.add(message.get(1));
				msg.add(message.get(2));
				commServer.SendMessage.sendToLobby(msg);
			}else{
				ArrayList<String> msg = new ArrayList<>();
				msg.add("sendMessageJoueur");
				msg.add(message.get(1));
				msg.add(message.get(2));
				msg.add("§4Le serveur est complet, merci d'attendre qu'une place ce libère");
				commServer.SendMessage.sendToLobby(msg);
			}
		}
	}

}
