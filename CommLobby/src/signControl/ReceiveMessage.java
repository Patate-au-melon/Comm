package signControl;

import org.bukkit.Bukkit;
import org.bukkit.block.Sign;

public class ReceiveMessage {
	
	public static void receive(String server, String label, String message){
		if(label.equalsIgnoreCase("sign")){
			String[] msg = message.split(" ");
			if(msg.length == 7){
				try{
					int posx = Integer.parseInt(msg[0]);
					int posy = Integer.parseInt(msg[1]);
					int posz = Integer.parseInt(msg[2]);
					System.out.println(Bukkit.getWorld("world").getBlockAt(posx, posy, posz).getType().toString());
					Sign sign = (Sign) Bukkit.getWorld("world").getBlockAt(posx, posy, posz).getState();
					for(int i = 0; i<4; i++){
						sign.setLine(i, msg[i+3]);
					}
					sign.update();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

}
