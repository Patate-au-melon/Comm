package demarageSetup;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class CreateConfig {
	
	
	static void recupListServerName(){
		FileConfiguration config = main.Config.getListServerNameConfig();
		HashMap<String, ArrayList<String>> list = baseDeDonnee.Requette.send("SELECT * FROM `listServer`");
		for(int i = 1; i <list.size();i++){
			ArrayList<String> l = list.get(i+"");
			config.set(l.get(0), l.get(1));
		}
		main.Config.saveListServerNameConfig(config);
		Bukkit.getLogger().info("Mise a jour de la config ListServerName termine");
	}
	
	static void createServerInfo(){
		FileConfiguration config = main.Config.getServerInfo();
		if(config.getString("name") == null || config.getString("name") == ""){
			config.set("name", "");
			config.set("port", "");
			main.Config.setServerInfo(config);
			Bukkit.getLogger().info("Creation de la config serverInfo");
			Bukkit.getLogger().warning("Merci de la remplir avant de relancer le serveur");
			Bukkit.getServer().shutdown();
		}
	}
	
	static void createSignControl(){
		FileConfiguration config = main.Config.getSignControl();
		if(config.getString("line1") == null || config.getString("line1") == ""){
			config.set("line1", "");
			config.set("line2", "");
			config.set("line3", "");
			config.set("line4", "");
			main.Config.setSignControl(config);
			Bukkit.getLogger().info("Creation de la config serverInfo");
			Bukkit.getLogger().warning("Merci de la remplir avant de relancer le serveur");
			Bukkit.getServer().shutdown();
		}
	}

}
