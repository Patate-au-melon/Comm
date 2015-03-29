package signControl;


public class sendMessage {
	
	public static void send(String world,int x, int y, int z, String line1, String line2, String line3, String line4){
		apiCommLobby.SendMessage.sendToLobby("sign", world+" "+ x+" "+ y+" "+ z+" "+line1+" "+line2+" "+line3+" "+line4);
	}

}
