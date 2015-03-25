package main;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	
	public static FileConfiguration getListServerNameConfig(){
		File f = new File("plugins/NitroGames/listServerName.yml");
		return YamlConfiguration.loadConfiguration(f);
	}
	
	public static void saveListServerNameConfig(FileConfiguration config){
		File f = new File("plugins/NitroGames/listServerName.yml");
		try {
			config.save(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
