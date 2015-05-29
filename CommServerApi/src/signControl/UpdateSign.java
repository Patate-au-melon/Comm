package signControl;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class UpdateSign {
	
	public static void playerjoin(PlayerJoinEvent e){
		updateSign(Bukkit.getOnlinePlayers().size());
	}
	
	public static void playerQuit(PlayerQuitEvent e){
		updateSign(Bukkit.getOnlinePlayers().size() -1);
	}
	
	public static void updateSign(int nbPlayerOnServer){
		ArrayList<String> msg = new ArrayList<>();
		msg.add("test1"); //Line 1
		msg.add("test2"); //line 2
		msg.add("test3"); //Line 3
		msg.add("test4"); //Line 4
		commServer.SendMessage.sendToLobby(msg); //On envoie l'update au lobby
	}
	
}
