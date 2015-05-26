package commServer;

import java.util.ArrayList;

public class Transmition {
	
	//Recupération de tous les messages
	static void transmit(String server, ArrayList<String> message){
		joueur.Message.sendJoueur(server, message);
	}

}
