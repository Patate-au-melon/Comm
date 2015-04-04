package signControl;

import java.net.Socket;
import java.util.Map.Entry;

import org.bukkit.Bukkit;


public class Update {
	
	public Update(){
		for(Entry<String, Socket> entry : main.Main.listServer.entrySet()) {
			String server = entry.getKey();
			new server.SendMessage(server, "sign", "update").send();
		}
		
	}
	
	public Update(String server){
		if(main.Main.listServer.containsKey(server)){
			new server.SendMessage(server, "sign", "update").send();
		}
	}
	
	public static void boucle(){
		Bukkit.getScheduler().scheduleSyncDelayedTask(main.Main.getPlugin(), new Runnable(){

			@Override
			public void run() {
				new Update();
			}
			
		}, 2400);
	}

}
