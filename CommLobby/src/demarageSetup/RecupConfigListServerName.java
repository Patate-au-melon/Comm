package demarageSetup;

import java.sql.ResultSet;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class RecupConfigListServerName {
	
	static void checkListServerName(){
		String version = main.Config.getListServerNameConfig().getString("version");
		String v = null;
		ResultSet rs = baseDeDonnee.Requette.sendRequette("");
		try {
			while(rs.next()){
				if(rs.getObject(1).toString().equalsIgnoreCase("listServerName")){
					v = rs.getObject(2).toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(!(version.equalsIgnoreCase(v))){
			recupListServerName();
			FileConfiguration config = main.Config.getListServerNameConfig();
			config.set("version", v);
			main.Config.saveListServerNameConfig(config);
			Bukkit.getLogger().info("Le fichier de config de la liste des serveurs a ete mise a jour");
		}
	}
	
	
	static void recupListServerName(){
		FileConfiguration config = main.Config.getListServerNameConfig();
		ResultSet rs = baseDeDonnee.Requette.sendRequette("");
		try {
			while(rs.next()){
				config.set("listServer."+rs.getString(2), rs.getString(1));
			}
			main.Config.saveListServerNameConfig(config);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
