package demarageSetup;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class CreateConfig {
	
	public static void createServerInfo(){
		FileConfiguration config = main.Config.getServerInfoConfig();
		if(config.getString("name") == null || config.getString("name") == ""){
			config.set("name", "");
			config.set("port", "");
			config.set("lobbyAdresse", "");
			config.set("lobbyPort", "");
			main.Config.setServerInfoConfig(config);
			Bukkit.getLogger().info("Creation de la config serverInfo.yml");
			Bukkit.getLogger().warning("Merci de la remplir avant de relancer le serveur");
			Bukkit.getServer().shutdown();
		}
	}
	
	public static void createPass(){
		FileConfiguration config = main.Config.getPassConfig();
		if(config.getString("user") == null || config.getString("user") == ""){
			config.set("user", "");
			config.set("password", "");
			main.Config.setPassConfig(config);
			Bukkit.getLogger().info("Creation de la config pass.yml");
			Bukkit.getLogger().warning("Merci de la remplir avant de relancer le serveur");
			Bukkit.getServer().shutdown();
		}
	}

}
