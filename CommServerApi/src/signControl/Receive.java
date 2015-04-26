package signControl;

public class Receive {
	
	public Receive(String server, String label, String message){
		System.out.println(label);
		System.out.println(message);
		if(label.equalsIgnoreCase("sign")){
			if(message.equalsIgnoreCase("update")){
				new Send("aze:aze a z e");
			}
		}
		if(label.equalsIgnoreCase("sendJoueur")){
			System.out.println("yolo");
			apiCommLobby.SendMessage.sendToLobby("sendJoueur", message);
		}
	}

}
