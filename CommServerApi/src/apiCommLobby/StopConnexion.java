package apiCommLobby;

import org.bukkit.Bukkit;

public class StopConnexion {
	
	public static void close(){
		try {
			if(Connexion.co){
				SendMessage.sendToLobby("stop","");
				Connexion.co = false;
			}
			Bukkit.getLogger().info("Connexion avec le lobby interompue");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
