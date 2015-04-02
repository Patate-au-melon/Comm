package signControl;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class Start {
	
	public static void start(){
		HashMap<String, ArrayList<String>> list = baseDeDonnee.Requette.send("SELECT * FROM `signList`");
		for(int i = 1; i <list.size();i++){
			ArrayList<String> l = list.get(i+"");
			World world = Bukkit.getWorld(l.get(0));
			int x = Integer.parseInt(l.get(1));
			int y = Integer.parseInt(l.get(2));
			int z = Integer.parseInt(l.get(3));
			String[] msg = {"","","",""};
			msg[0] = "";
			msg[1] = "Serveur";
			msg[2] = "ferme";
			msg[3] = "";
			Location loc = new Location(world, x, y, z);
			ReceiveMessage.listLoc.add(loc);
			ReceiveMessage.listMessage.add(msg);
			ReceiveMessage.update();
		}
	}

}
