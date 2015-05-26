package main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	
	public void onEnable(){
		StartandStop.onEnbale();
	}
	
	public void onDisable(){
		StartandStop.onDisable();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return false;
	}
	
	
	//Recuperation de l'objet Plugin
	public static Plugin getPlugin(){
		return Bukkit.getPluginManager().getPlugin("commServer");
	}
	

}
