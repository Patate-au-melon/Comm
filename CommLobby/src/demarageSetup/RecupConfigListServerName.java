package demarageSetup;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class RecupConfigListServerName {
	
	static void checkListServerName(){
		String version = main.Config.getListServerNameConfig().getString("version");
		String v = null;
		HashMap<String, ArrayList<String>> list = baseDeDonnee.Requette.send("Select * FROM `version` WHERE `configName` = 'listServerName'");
		ArrayList<String> l = list.get("1");
		System.out.println(l.toString());
		if(l.get(0).equalsIgnoreCase("listServerName")){
			System.out.println(l.get(0));
			v = l.get(1);
		}
		if(version != v){
			recupListServerName();
			FileConfiguration config = main.Config.getListServerNameConfig();
			config.set("version", v);
			main.Config.saveListServerNameConfig(config);
			Bukkit.getLogger().info("Le fichier de config de la liste des serveurs a ete mise a jour");
		}
	}
	
	
	static void recupListServerName(){
		FileConfiguration config = main.Config.getListServerNameConfig();
		HashMap<String, ArrayList<String>> list = baseDeDonnee.Requette.send("SELECT * FROM `listServer`");
		for(int i = 1; i <list.size();i++){
			ArrayList<String> l = list.get(i+"");
			config.set(l.get(1), l.get(0));
		}
		main.Config.saveListServerNameConfig(config);
	}

}
