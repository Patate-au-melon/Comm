package signControl;

public class Send {
	
	public Send(String line){
		String msg = line;
		apiCommLobby.SendMessage.sendToLobby("sign", msg);
	}

}
