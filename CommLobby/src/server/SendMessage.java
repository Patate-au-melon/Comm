package server;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import main.Main;

public class SendMessage {
	private String server;
	private String label;
	private String msg;
	
	public SendMessage(String server, String label, String message){
		this.server = server;
		this.label = label;
		this.msg= message;
	}
	
	public void send(){
		if(Main.listServer.containsKey(this.server)){
			try {
				Socket s = Main.listServer.get(this.server);
				OutputStream os = s.getOutputStream();
				PrintWriter pw = new PrintWriter(os);
				String serverName = main.Config.getListServerNameConfig().getString("Servername");
				pw.println(serverName + " " + this.label +" "+ this.msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
