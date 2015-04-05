package signControl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;

public class UpdateBDD {
	
	private boolean test = false;
	
	public UpdateBDD(){
		HashMap<String, ArrayList<String>> list = baseDeDonnee.Requette.send("SELECT * FROM `signList`");
		String world = main.Config.getSignControl().getString("world");
	    String x = main.Config.getSignControl().getString("x");
	    String y = main.Config.getSignControl().getString("y");
	    String z = main.Config.getSignControl().getString("z");
		for(int i = 1; i<list.size();i++) {
		    ArrayList<String> l = list.get(i+"");
		    if(x.equalsIgnoreCase(l.get(1)) && y.equalsIgnoreCase(l.get(2))&& z.equalsIgnoreCase(l.get(3))){
		    	test = true;
		    	break;
		    }
		}
		if(!test){
			Bukkit.getLogger().info("Mise a jour de la base de donnee de gestion des panneau");
			String requette = "insert into `signList` (`world`, `x`, `y`, `z`)" + "values (?,?,?,?)";
			try {
				PreparedStatement prepa = baseDeDonnee.Connexion.cn.prepareStatement(requette);
				prepa.setString(1, world);
				prepa.setString(2, x);
				prepa.setString(3, y);
				prepa.setString(4, z);
				prepa.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
