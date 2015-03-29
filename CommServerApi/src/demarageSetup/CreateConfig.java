package demarageSetup;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class CreateConfig {
	
	public static void createServerInfo(){
		FileConfiguration config = main.Config.getServerInfo();
		if(config.getString("name") == null || config.getString("name") == ""){
			config.set("name", "");
			config.set("port", "");
			config.set("lobbyAdresse", "");
			config.set("lobbyPort", "");
			main.Config.setServerInfo(config);
			Bukkit.getLogger().info("Creation de la config serverInfo");
			Bukkit.getLogger().warning("Merci de la remplir avant de relancer le serveur");
			Bukkit.getServer().shutdown();
		}
	}
	
	public static void createSignControl(){
		FileConfiguration configSignControl = main.Config.getServerInfo();
		if(configSignControl.getString("world") == null || configSignControl.getString("world") == ""){
			configSignControl.set("world", "");
			configSignControl.set("x", "");
			configSignControl.set("y", "");
			configSignControl.set("z", "");
			configSignControl.set("serverDown.line1", "");
			configSignControl.set("serverDown.line2", "");
			configSignControl.set("serverDown.line3", "");
			configSignControl.set("serverDown.line4", "");
			main.Config.setSignControl(configSignControl);
			Bukkit.getLogger().info("Creation de la config signControl");
			Bukkit.getLogger().warning("Merci de la remplir avant de relancer le serveur");
			Bukkit.getServer().shutdown();
		}
	}

}
