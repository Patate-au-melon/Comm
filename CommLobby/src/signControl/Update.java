package signControl;

public class Update {
	
	public Update(){
		
	}
	
	public Update(String server){
		if(main.Main.listServer.containsKey(server)){
			new server.SendMessage(server, "sign", "update").send();
		}
	}

}
