package demarageSetup;

import java.net.Socket;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Main {
	
	public static void setup(){
		main.Main.listServer = new HashMap<String, Socket>();
		signControl.Receive.listSign = new HashMap<Location, String[]>();
		new server.Start().runTaskAsynchronously(main.Main.getPlugin());
		baseDeDonnee.Connexion.connect();
		RecupConfigListServerName.recupListServerName();
		Bukkit.getLogger().info("Plugin operationel");
	}

}
