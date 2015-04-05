package demarageSetup;

import java.net.Socket;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Main {
	
	public static void setup(){
		main.Main.listServer = new HashMap<String, Socket>();
		signControl.Receive.listSign = new HashMap<Location, String[]>();
		CreateConfig.createServerInfo();
		new server.Start().runTaskAsynchronously(main.Main.getPlugin());
		baseDeDonnee.Connexion.connect();
		CreateConfig.recupListServerName();
		CreateConfig.createSignControl();
		new signControl.DemarageSetup();
		Bukkit.getLogger().info("Plugin operationel");
	}

}
