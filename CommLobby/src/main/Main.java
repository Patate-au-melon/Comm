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
		demarageSetup.Main.setup();
	}
	
	public void onDisable(){
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		return false;
	}
	
	public static Plugin getPlugin(){
		return Bukkit.getPluginManager().getPlugin("commLobby");
	}

}
