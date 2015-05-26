package signControl;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class UpdateSign {
	
	public static void playerjoin(PlayerJoinEvent e){
		updateSign();
	}
	
	public static void playerQuit(PlayerQuitEvent e){
		updateSign();
	}
	
	public static void updateSign(){
		ArrayList<String> msg = new ArrayList<>();
		msg.add("signControl Update"); //On dit que l'on veut update un sign
		msg.add("§1§lPvP - Box"); //Line 1
		msg.add(""); //line 2
		msg.add("§7"+Bukkit.getOnlinePlayers().size() + " / " + Bukkit.getMaxPlayers()); //Line 3
		msg.add(""); //Line 4
		commServer.SendMessage.sendToLobby(msg); //On envoie l'update au lobby
	}
	
}
