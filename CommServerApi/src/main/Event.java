package main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Event implements Listener{
	
	@EventHandler
	public void playerJoin(PlayerJoinEvent e){
		signControl.UpdateSign.playerjoin(e);
	}
	
	@EventHandler
	public void playerQuit(PlayerQuitEvent e){
		signControl.UpdateSign.playerQuit(e);
	}

}
