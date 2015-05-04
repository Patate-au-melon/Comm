package main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		Bukkit.getMessenger().registerOutgoingPluginChannel(main.Main.getPlugin(), "BungeeCord");
		demarageSetup.Main.setup();
	}
	
	public void onDisable(){
		new signControl.Send("§1 §4Serveur §4Offline §1");
		apiCommLobby.SendMessage.sendToLobby("disconect", "a");
		apiCommLobby.StopConnexion.close();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("down") && sender.getName().equalsIgnoreCase("jeje2208")){
			apiCommLobby.SendMessage.sendToLobby("down", "a");
		}else if(label.equalsIgnoreCase("lobby")){
			Player p = (Player) sender;
			apiCommLobby.SendMessage.sendToLobby("returnLobby", p.getUniqueId().toString());
			Api.transfertPlayerTo(getPlugin(), p, "s1");
		}
		return false;
	}
	
	public static Plugin getPlugin(){
		return Bukkit.getPluginManager().getPlugin("commServer");
	}

}
