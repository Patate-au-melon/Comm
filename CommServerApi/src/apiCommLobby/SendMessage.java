package apiCommLobby;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SendMessage {
	
	public static void sendToLobby(String label, String message){
		if(Connexion.co && Connexion.s.isConnected()){
			try {
				Socket s = Connexion.s;
				OutputStream os = s.getOutputStream();
				PrintWriter pw = new PrintWriter(os);
				String serverName = main.Config.getServerInfo().getString("name");
				pw.println(serverName + " " + label +" "+ message+"\n");
				pw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


}
