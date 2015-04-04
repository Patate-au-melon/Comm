package server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class ReceiveMessage extends BukkitRunnable{
	
	private Socket socket;
	@SuppressWarnings("unused")
	private int numServer;
	private BufferedReader br;
	
	public ReceiveMessage(Socket socket, int numServer){
		this.socket = socket;
		this.numServer = numServer;
	}
	
	
	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			this.br = new BufferedReader(isr);
			while(true){
				try{
					String msg = br.readLine();
					message(msg);
				} catch (Exception e) {
					this.cancel();
					Bukkit.getLogger().warning("Erreur lie a la deconnexion d'un serveur");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void message(String message){
		try {
			String msg[] = message.split(" ");
			String server = msg[0+0];
			String label = msg[1+0];
			String mes = msg[2+0];
			for(int i = 3;i<msg.length;i++){
				mes = mes + " " + msg[i];
			}
			System.out.println(message);
			TransmitMessage.send(server, label, mes);
		} catch (Exception e) {
			Bukkit.getLogger().warning("Erreur lors du traitement du message, correction non dispo pour le moment");
		}
	}
	
}
