package demarageSetup;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class CreateConfigServerInfo {
	
	public static void create(){
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

}
