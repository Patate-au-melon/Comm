package main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	
	private static String serverInfoPath ="plugins/NitroGames/serverInfo.yml";
	private static String passPath = "plugins/NitroGames/pass.yml";
	
	public static FileConfiguration getServerInfoConfig(){
		File f = new File(serverInfoPath);
		return YamlConfiguration.loadConfiguration(f);
	}
	
	public static void setServerInfoConfig(FileConfiguration config){
		try {
			config.save(serverInfoPath);
		} catch (Exception e) {
			Bukkit.getLogger().warning("Erreur lors de la sauvegarde de la config");
			e.printStackTrace();
		}
	}
	
	public static FileConfiguration getPassConfig(){
		File f = new File(passPath);
		return YamlConfiguration.loadConfiguration(f);
	}
	
	public static void setPassConfig(FileConfiguration config){
		try {
			config.save(passPath);
		} catch (Exception e) {
			Bukkit.getLogger().warning("Erreur lors de la sauvegarde de la config");
			e.printStackTrace();
		}
	}
	
}
