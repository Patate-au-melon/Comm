package server;

public class TransmitMessage {
	
	public static void send(String server, String label, String message){
		if(label.equalsIgnoreCase("stop")&&main.Main.listServer.containsKey(server)){
			CloseSocket.close(server);
		}
	}


}
