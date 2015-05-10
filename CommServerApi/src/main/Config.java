package main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	
	private static String PassPath = "plugins/NitroGames/pass.yml";
	
	//Config contenant les identifiant de connexion a la base de donnee
	public static FileConfiguration getPassConfig(){
		File f = new File(PassPath);
		return YamlConfiguration.loadConfiguration(f);
	}
	
	public static void createPassConfig(){
		FileConfiguration config = getPassConfig();
		if(config.getString("user") == null || config.getString("user") == ""){
			config.set("user", "");
			config.set("password", "");
			try {
				config.save(new File(PassPath));
			} catch (Exception e) {
				e.printStackTrace();
			}
			Bukkit.getLogger().info("La config pass.yml a ete cree");
			Bukkit.getLogger().info("Merci de la remplir avant de relancer le serveur");
			Bukkit.shutdown();
		}
	}

}
