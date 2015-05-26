package joueur;

import java.util.ArrayList;

public class Message {
	
	public static void sendJoueur(String server, ArrayList<String> message){
		if(message.get(0).equalsIgnoreCase("sendJoueur")){
			ArrayList<String> msg = new ArrayList<>();
			msg.add("transfertJoueur");
			msg.add(message.get(1));
			msg.add(message.get(2));
			commServer.SendMessage.sendToLobby(msg);
		}
	}

}
