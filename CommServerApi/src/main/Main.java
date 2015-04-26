package main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		demarageSetup.Main.setup();
	}
	
	public void onDisable(){
		apiCommLobby.StopConnexion.close();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("down")){
			apiCommLobby.SendMessage.sendToLobby("down", "aze");
		}
		return false;
	}
	
	public static Plugin getPlugin(){
		return Bukkit.getPluginManager().getPlugin("commServer");
	}

}
