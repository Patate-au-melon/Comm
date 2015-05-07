package apiCommLobby;

import java.net.InetAddress;
import java.net.Socket;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Connexion extends BukkitRunnable{
	public static Socket s;
	public static boolean co = false;
	
	@Override
	public void run() {
		try {
			s = new Socket(InetAddress.getLocalHost(), main.Config.getServerInfoConfig().getInt("lobbyPort"), InetAddress.getLocalHost(), main.Config.getServerInfoConfig().getInt("port"));
			new ReceiveMessage(s).runTaskAsynchronously(main.Main.getPlugin());
			Bukkit.getLogger().info("Connexion avec le lobby effectue sur le port  " + s.getPort());
			co = true;
		} catch (Exception e) {
			Bukkit.getLogger().warning("Impossible de se connecter au lobby");
			delayed();
		}
	}
	
	public void delayed(){
		Bukkit.getScheduler().runTaskLater(main.Main.getPlugin(), new Runnable(){

			@Override
			public void run() {
				trans();
			}
			
		}, 40);
	}
	
	public void trans(){
		run();
	}
}
