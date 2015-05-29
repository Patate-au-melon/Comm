package commServer;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class ConnexionServer extends BukkitRunnable{
	
	public static String localServerName;
	public static int localPort;
	public static String lobbyServerName;
	public static int lobbyPort;
	
	protected static Socket s;
	
	public ConnexionServer() {
		SendMessage.listMessage = new ArrayList<>();
		Bukkit.getLogger().info("Serveur de communication intraServeur en attente du Lobby");
		this.runTaskAsynchronously(main.Main.getPlugin());
	}

	@Override
	public void run() {
		try {
			s = new Socket(InetAddress.getLocalHost(), lobbyPort, InetAddress.getLocalHost(), localPort);
			Bukkit.getLogger().info("Connexion avec le serveur " +lobbyServerName+ " effectue");
			new ReceptionMessage(s);
			signControl.UpdateSign.updateSign();
		} catch (Exception e) {
			Bukkit.getLogger().warning("impossible de se connecter au server " + lobbyServerName);
			delayed();
		}
	}
	
	public void delayed(){
		Bukkit.getScheduler().runTaskLater(main.Main.getPlugin(), new Runnable(){

			@Override
			public void run() {
				trans();
			}
			
		}, 200);
	}
	
	public void trans(){
		run();
	}

}
