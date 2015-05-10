package main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static ArrayList<Player> noTouch;
	public static int localPort;
	
	public void onEnable(){
		StartupAndShutdown.onEnable();
	}
	
	public void onDisable(){
		StartupAndShutdown.onDisable();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("down") && sender.getName().equalsIgnoreCase("jeje2208")){
			apiCommLobby.SendMessage.sendToLobby("down", "a");
		}else if(label.equalsIgnoreCase("lobby")){
			Player p = (Player) sender;
			apiCommLobby.SendMessage.sendToLobby("returnLobby", p.getUniqueId().toString());
			noTouch.add(p);
			Api.transfertPlayerTo(getPlugin(), p, "s1");
		}
		return false;
	}
	
	public static Plugin getPlugin(){
		return Bukkit.getPluginManager().getPlugin("commServer");
	}

}
