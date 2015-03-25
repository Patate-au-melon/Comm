package server;

import java.net.ServerSocket;
import java.net.Socket;

import main.Main;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Start extends BukkitRunnable{
	private int nbServerConnect;
	
	@SuppressWarnings("resource")
	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(25600);
			Bukkit.getLogger().info("§4Pret pour recevoir les clients sur le port   " + ss.getLocalPort());
			while(true){
				Socket s = ss.accept();
				nbServerConnect++;
				String serverName = main.Config.getListServerNameConfig().getString(""+s.getPort());
				Main.listServer.put(serverName, s);
				new ReceiveMessage(s, nbServerConnect).runTaskAsynchronously(main.Main.getPlugin());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
