package server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

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
				String msg = br.readLine();
				message(msg);
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
			TransmitMessage.send(server, label, mes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}