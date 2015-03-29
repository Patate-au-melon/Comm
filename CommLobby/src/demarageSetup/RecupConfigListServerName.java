package demarageSetup;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class RecupConfigListServerName {
	
	
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

}
