package apiCommLobby;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SendMessage {
	private String label;
	private String msg;
	
	public SendMessage(String label, String message){
		this.label = label;
		this.msg = message;
	}
	
	public void sendToLobby(){
		if(Connexion.co){
			try {
				Socket s = Connexion.s;
				OutputStream os = s.getOutputStream();
				PrintWriter pw = new PrintWriter(os);
				String serverName = main.Config.getServerInfo().getString("name");
				pw.println(serverName + " " + this.label +" "+ this.msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


}
