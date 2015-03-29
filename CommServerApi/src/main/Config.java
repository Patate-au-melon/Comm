package main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	
	private static String serverInfoPath ="plugins/NitroGames/serverInfo.yml";
	private static String signControlPath ="plugins/NitroGames/signControl.yml";
	
	public static FileConfiguration getServerInfo(){
		File f = new File(serverInfoPath);
		return YamlConfiguration.loadConfiguration(f);
	}
	
	public static void setServerInfo(FileConfiguration config){
		try {
			config.save(serverInfoPath);
		} catch (Exception e) {
			Bukkit.getLogger().warning("Erreur lors de la sauvegarde de la config");
			e.printStackTrace();
		}
	}
	
	public static FileConfiguration getSignControl(){
		File f = new File(signControlPath);
		return YamlConfiguration.loadConfiguration(f);
	}
	
	public static void setSignControl(FileConfiguration config){
		try {
			config.save(signControlPath);
		} catch (Exception e) {
			Bukkit.getLogger().warning("Erreur lors de la sauvegarde de la config");
			e.printStackTrace();
		}
	}

}
