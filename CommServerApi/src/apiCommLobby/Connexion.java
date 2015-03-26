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
			co = true;
			s = new Socket(InetAddress.getLocalHost(), 25600, InetAddress.getLocalHost(), 25601);
			new ReceiveMessage(s).runTaskAsynchronously(main.Main.getPlugin());
			Bukkit.getLogger().info("Connexion avec le lobby effectue sur le port  " + s.getPort());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
