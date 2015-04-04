package apiCommLobby;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class ReceiveMessage extends BukkitRunnable{
	private Socket s;
	private BufferedReader br;
	
	public ReceiveMessage(Socket socket){
		this.s = socket;
	}

	@Override
	public void run() {
		try {
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			this.br = new BufferedReader(isr);
			while(true){
				try{
					String msg = br.readLine();
					message(msg);
				}catch(Exception e){
					e.printStackTrace();
					Bukkit.getServer().shutdown();
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
			String server = msg[0];
			String label = msg[1];
			String mes = msg[2];
			for(int i = 3;i<msg.length;i++){
				mes = mes + " " + msg[i];
			}
			System.out.println(message);
			TransmitMessage.send(server, label, mes);
		} catch (Exception e){
			Bukkit.getLogger().warning("Erreur lie au traitement du message, fixe non disponible pour le moment");
		}
	}


}
