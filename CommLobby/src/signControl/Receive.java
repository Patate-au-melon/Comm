package signControl;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public class Receive {

	private Location loc;
	private String[] line;
	
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
				updateSign(this.loc, this.line);
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

}
