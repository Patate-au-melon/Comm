package commServer;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class SendMessage {
	
	static boolean sendInProgress;
	static ArrayList<ArrayList<String>> listMessage;
	
	//Envoyer un message à un autre serveur
	public static void sendToLobby(ArrayList<String> message){
		if(!sendInProgress){
			sendInProgress = true;
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
				sendInProgress = false;
				sendListMessage();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			listMessage.add(message);
		}
	}
	
	public static void sendToLobby(String message){
		if(!sendInProgress){
			sendInProgress = true;
			Socket s = ConnexionServer.s;
			String[] msg = message.split(" ");
			try {
				OutputStream os = s.getOutputStream();
				PrintWriter pw = new PrintWriter(os);
				pw.println("start");
				pw.flush();
				for(String m : msg){
					pw.println(m);
					pw.flush();
				}
				pw.println("stop");
				pw.flush();
				sendInProgress = false;
				sendListMessage();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			ArrayList<String> m = new ArrayList<>();
			String[] msg = message.split(" ");
			for(String mm : msg){
				m.add(mm);
			}
			listMessage.add(m);
		}
	}
	
	
	private static boolean sendListMessage(){
		if(!sendInProgress || listMessage.isEmpty() == false){
			for(ArrayList<String> msg : listMessage){
				sendToLobby(msg);
				return true;
			}
		}
		return false;
	}

}
