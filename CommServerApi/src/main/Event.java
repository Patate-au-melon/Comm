package main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Event implements Listener{
	
	@EventHandler
	public void playerQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		if(main.Main.noTouch.contains(p)){
			Main.noTouch.remove(p);
		}else{
			apiCommLobby.SendMessage.sendToLobby("playerQuit", p.getUniqueId().toString());
		}
	}

}
