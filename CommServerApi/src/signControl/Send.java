package signControl;

public class Send {
	
	public Send(String line){
		String world = main.Config.getSignControl().getString("world");
		String x = main.Config.getSignControl().getString("x");
		String y = main.Config.getSignControl().getString("y");
		String z = main.Config.getSignControl().getString("z");
		String msg = world +" "+ x +" "+ y +" "+ z+" "+ line;
		apiCommLobby.SendMessage.sendToLobby("sign", msg);
	}

}
