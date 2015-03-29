package signControl;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public class ReceiveMessage {
	public static ArrayList<Location> listLoc;
	public static ArrayList<String[]> listMessage;
	
	public static void receive(String server, String label, String message){
		if(label.equalsIgnoreCase("sign")){
			String[] msg = message.split(" ");
			if(msg.length >= 5){
				World w = Bukkit.getWorld(msg[0]);
				int x = Integer.parseInt(msg[1]);
				int y = Integer.parseInt(msg[2]);
				int z = Integer.parseInt(msg[3]);
				Location loc = new Location(w,x,y,z);
				if(listLoc.contains(loc)){
					listLoc.remove(loc);
					listMessage.remove(msg);
				}
				listLoc.add(loc);
				listMessage.add(msg);
				update();
			}
		}
	}
	
	public static void update(){
		for(int i=0;i<listLoc.size();i++){
			try{
				Block b = listLoc.get(i).getBlock();
				if(b.getType() == Material.WALL_SIGN){
					Sign sign = (Sign) b.getState();
					for(int n = 0;n<4;n++){
						sign.setLine(n, listMessage.get(i)[n+4]);
					}
					listLoc.remove(i);
					listMessage.remove(i);
					sign.update();
				}
			}catch(Exception e){
				Bukkit.getLogger().warning("Des panneaux n'ont pas pu etre mis a jour");
				if(listLoc.isEmpty() == false){
					Bukkit.getScheduler().scheduleSyncDelayedTask(main.Main.getPlugin(), new Runnable(){

						@Override
						public void run() {
							update();
						}
						
					}, 600);
				}
			}
		}
	}
	
}
