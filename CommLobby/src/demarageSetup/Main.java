package demarageSetup;

import java.net.Socket;
import java.util.HashMap;

import org.bukkit.Bukkit;

public class Main {
	
	public static void setup(){
		main.Main.listServer = new HashMap<String, Socket>();
		new server.Start().runTaskAsynchronously(main.Main.getPlugin());
		baseDeDonnee.Connexion.connect();
		RecupConfigListServerName.checkListServerName();
		Bukkit.getLogger().info("Plugin operationel");
	}

}
