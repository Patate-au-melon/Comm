package commServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class ReceptionMessage extends BukkitRunnable{
	
	private Socket s;
	
	ReceptionMessage(Socket socket) {
		this.s = socket;
		this.runTaskAsynchronously(main.Main.getPlugin());
	}

	@Override
	public void run() {
		InputStream is;
		try {
			is = this.s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			while (true){
				ArrayList<String> msg = RecuperationMessage(br);
				Transmition.transmit(ConnexionServer.lobbyServerName, msg);
			}
		} catch (Exception e) {
			cancel();
		}
	}
	
	private ArrayList<String> RecuperationMessage(BufferedReader br){
		ArrayList<String> msg= new ArrayList<>();
		String m;
		try {
			m = br.readLine();
			if(m.equalsIgnoreCase("start")){
				while(m.equalsIgnoreCase("stop") == false){
					m = br.readLine();
					msg.add(m);
				}
				return msg;
			}
		} catch (Exception e) {
			Bukkit.getLogger().warning(ConnexionServer.lobbyServerName + " vient d'etre deconnecter de ce serveur");
			serverDisconnect();
		}
		return msg;
	}
	
	private void serverDisconnect(){
		try {
			s.close();
			ConnexionServer.s = null;
			new ConnexionServer();
			cancel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
