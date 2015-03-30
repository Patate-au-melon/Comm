package demarageSetup;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Main {
	
	public static void setup(){
		main.Main.listServer = new HashMap<String, Socket>();
		signControl.ReceiveMessage.listLoc = new ArrayList<Location>();
		signControl.ReceiveMessage.listMessage = new ArrayList<String[]>();
		new server.Start().runTaskAsynchronously(main.Main.getPlugin());
		baseDeDonnee.Connexion.connect();
		RecupConfigListServerName.recupListServerName();
		signControl.Start.start();
		Bukkit.getLogger().info("Plugin operationel");
	}

}
