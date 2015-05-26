package commServer;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class SendMessage {
	
	//Envoyer un message à un autre serveur
	public static void sendToLobby(ArrayList<String> message){
		Socket s = ConnexionServer.s;
		try {
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.println("start");
			pw.flush();
			for(String m : message){
				pw.println(m);
				pw.flush();
			}
			pw.println("stop");
			pw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendToLobby(String message){
		Socket s = ConnexionServer.s;
		String[] msg = message.split(" ");
		try {
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.println("start");
			for(String m : msg){
				pw.println(m);
			}
			pw.println("stop");
			pw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
