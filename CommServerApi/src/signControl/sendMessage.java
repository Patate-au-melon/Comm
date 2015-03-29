package signControl;


public class sendMessage {
	
	public static void send(){
		apiCommLobby.SendMessage.sendToLobby("sign", "144 65 217 yolo jevais bien yolo");
		System.out.println("envoi du message");
	}

}
