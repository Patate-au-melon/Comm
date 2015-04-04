package signControl;

public class Receive {
	
	public Receive(String server, String label, String message){
		if(label.equalsIgnoreCase("sign")){
			if(message.equalsIgnoreCase("update")){
				new Send("aze a z e");
			}
		}
	}

}
