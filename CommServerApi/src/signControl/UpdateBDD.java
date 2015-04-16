package signControl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;

public class UpdateBDD {
	
	private boolean test = false;
	
	public UpdateBDD(){
		HashMap<String, ArrayList<String>> list = baseDeDonnee.Requette.send("SELECT * FROM `signList`");
		String serverName = main.Config.getServerInfo().getString("name");
		String world = main.Config.getSignControl().getString("world");
	    String x = main.Config.getSignControl().getString("x");
	    String y = main.Config.getSignControl().getString("y");
	    String z = main.Config.getSignControl().getString("z");
		for(int i = 1; i<list.size();i++) {
		    ArrayList<String> l = list.get(i+"");
		    if(x.equalsIgnoreCase(l.get(2)) && y.equalsIgnoreCase(l.get(3))&& z.equalsIgnoreCase(l.get(4))){
		    	test = true;
		    	break;
		    }
		}
		if(!test){
			Bukkit.getLogger().info("Mise a jour de la base de donnee de gestion des panneau");
			String requette = "insert into `signList` (`Server`, `world`, `x`, `y`, `z`)" + "values (?,?,?,?,?)";
			try {
				PreparedStatement prepa = baseDeDonnee.Connexion.cn.prepareStatement(requette);
				prepa.setString(1, serverName);
				prepa.setString(2, world);
				prepa.setString(3, x);
				prepa.setString(4, y);
				prepa.setString(5, z);
				prepa.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
