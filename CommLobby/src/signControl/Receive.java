package signControl;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public class Receive {

	private Location loc;
	private String[] line;
	public static HashMap<Location, String[]> listSign;
	
	public Receive(String server, String label, String message){
		if(label.equalsIgnoreCase("sign")){
			String[] msg = message.split(" ");
			if(msg.length == 8){
				World w = Bukkit.getWorld(msg[0]);
				int x = Integer.parseInt(msg[1]);
				int y = Integer.parseInt(msg[2]);
				int z = Integer.parseInt(msg[3]);
				this.loc = new Location(w, x, y, z);
				for(int i = 0; i<4;i++)
					line[i] = msg[i+4];
				if(loc.getChunk().isLoaded()){
					updateSign(loc, line);
				}else{
					if(listSign.containsKey(loc)){
						listSign.replace(loc, line);
					}else{
						listSign.put(loc, line);
					}
					boucle();
				}
			}
		}
	}
	
	public void updateSign(Location loc, String[] line){
		Block b = loc.getBlock();
		if(b.getType() == Material.WALL_SIGN){
			Sign sign = (Sign) b.getState();
			for(int i =0;i<4;i++)
				sign.setLine(i, line[i]);
			sign.update();
			System.out.println("mise a jour du panneau en pos x:"+ loc.getBlockX() + " pos y "+ loc.getBlockY()+ " pos z" +loc.getBlockZ());
		}
	}
	
	private void boucle(){
		Bukkit.getScheduler().scheduleSyncDelayedTask(main.Main.getPlugin(), new Runnable(){

			@Override
			public void run() {
				for(Entry<Location, String[]> entry : listSign.entrySet()) {
				    Location loc = entry.getKey();
				    String[] line = entry.getValue();
				    if(loc.getChunk().isLoaded()){
				    	updateSign(loc, line);
				    }
				}
				if(listSign.isEmpty() == false){
					boucle();
				}
			}
			
		}, 40);
	}

}
