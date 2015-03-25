package main;

import java.net.Socket;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static HashMap<String, Socket> listServer;
	
	public void onEnable(){
		listServer = new HashMap<String, Socket>();
		new server.Start().runTaskAsynchronously(getPlugin());
		Bukkit.getLogger().info("Plugin pret a etre utilse");
		System.out.println("yolo");
	}
	
	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("test")){
			new server.SendMessage("S2", "gh", "je vais bien").send();
		}
		return false;
	}
	
	public static Plugin getPlugin(){
		return Bukkit.getPluginManager().getPlugin("commLobby");
	}

}
