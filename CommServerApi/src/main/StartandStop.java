package main;

import java.util.ArrayList;

import org.bukkit.Bukkit;

import commServer.ConnexionServer;

public class StartandStop {


	//Lancement du serveur
	public static void onEnbale(){
		Config.passCreate(); //Creation de la config pass.yml si besoin
	
		
		Bukkit.getPluginManager().registerEvents(new Event(), main.Main.getPlugin()); //Gestion des events dans la classe Event
		Bukkit.getMessenger().registerOutgoingPluginChannel(Main.getPlugin(), "BungeeCord"); //Chargement de l'API Bungeecord
		
		
		String dev = main.Config.getPassConfig().getString("BaseDeDonnee.dev");
		String user = main.Config.getPassConfig().getString("BaseDeDonnee.user");
		String password = main.Config.getPassConfig().getString("BaseDeDonnee.password"); //Recuperation des informations de connexion à la base de donnee
		String url;
		if(dev.equalsIgnoreCase("true")){
			url = "jdbc:mysql://mysql-hbct.alwaysdata.net/hbct_plugin";
			Bukkit.getLogger().info("Connexion avec la base de donnee de developpement");
		}else{
			url = "jdbc:mysql://mysql-hbct.alwaysdata.net/hbct_nitro";
			Bukkit.getLogger().info("Connexion avec la base de donnee du serveur");
		}
		Api.BdDconnect(url, user, password); //Connexion avec la base de donnee
		
		ArrayList<ArrayList<String>> list = Api.BdDsendRequette("SELECT * FROM `listServer`"); //On recupère la liste des serveurs
		for(ArrayList<String> l : list){
			if(l.get(0).equalsIgnoreCase(Bukkit.getServerName())){ //Si c'est le serveur
				ConnexionServer.localServerName = l.get(0);
				ConnexionServer.localPort = Integer.parseInt(l.get(1));
			}else if(l.get(2).equalsIgnoreCase("true")){ //Si c'est le Lobby
				ConnexionServer.lobbyServerName = l.get(0);
				ConnexionServer.lobbyPort = Integer.parseInt(l.get(1));
			}
		}
		
		new ConnexionServer(); //On lance le serveur de communication
		
		Bukkit.getLogger().info("Plugin completement demarre");
	}
	
	
	//Arret du serveur
	public static void onDisable(){
		
	}

}
