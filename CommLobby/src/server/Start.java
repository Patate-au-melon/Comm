package server;

import java.net.ServerSocket;
import java.net.Socket;

import main.Main;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Start extends BukkitRunnable{
	private int nbServerConnect;
	public static ServerSocket ss;
	
	@Override
	public void run() {
		try {
			ss = new ServerSocket(25600);
			Bukkit.getLogger().info("Demarage du serveur de communication entre serveur effectue");
			while(true){
				Socket s = ss.accept();
				nbServerConnect++;
				String serverName = main.Config.getListServerNameConfig().getString(""+s.getPort());
				Main.listServer.put(serverName, s);
				Bukkit.getLogger().info(serverName+" vient de se connecter au lobby avec le port  "+s.getPort());
				new ReceiveMessage(s, nbServerConnect).runTaskAsynchronously(main.Main.getPlugin());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
