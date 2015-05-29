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
		msg.add("signControl Update"); //On dit que l'on veut update un sign
		msg.add("§1§lPvP - Box"); //Line 1
		msg.add(""); //line 2
		msg.add("§7"+ nbPlayerOnServer + " / " + Bukkit.getMaxPlayers()); //Line 3
		msg.add(""); //Line 4
		commServer.SendMessage.sendToLobby(msg); //On envoie l'update au lobby
	}
	
}
