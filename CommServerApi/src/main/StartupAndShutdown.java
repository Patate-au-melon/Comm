package main;

import java.util.ArrayList;

import main.Event;

import org.bukkit.Bukkit;

public class StartupAndShutdown {
	
	//Effectue au demarage du serveur
	public static void onEnable(){
		Config.createPassConfig();
		Main.noTouch = new ArrayList<>();
		String url = "jdbc:mysql://publicsql-1.pulseheberg.net/service_35502";
		String user = Config.getPassConfig().getString("user");
		String password = Config.getPassConfig().getString("password");
		Bukkit.getMessenger().registerOutgoingPluginChannel(Main.getPlugin(), "BungeeCord");
		Bukkit.getPluginManager().registerEvents(new Event(), Main.getPlugin());
		Api.BdDconnect(url, user, password);
		recupPort();
		new apiCommLobby.Connexion().runTaskAsynchronously(Main.getPlugin());
	}
	
	public static void onDisable(){
		new signControl.Send("§1 §4Serveur §4Offline §1");
		apiCommLobby.SendMessage.sendToLobby("disconect", "a");
		apiCommLobby.StopConnexion.close();
	}
	
	private static void recupPort(){
		String requette = "SELECT * FROM `listServer`;";
		ArrayList<ArrayList<String>> list = Api.BdDsendRequette(requette);
		for(ArrayList<String> l : list){
			if(l.get(0).equalsIgnoreCase(Bukkit.getServerName())){
				Main.localPort = Integer.parseInt(l.get(1));
			}else if(l.get(0).equalsIgnoreCase("lobby")){
				apiCommLobby.Connexion.lobbyPort = Integer.parseInt(l.get(1));
			}
		}
	}

}
