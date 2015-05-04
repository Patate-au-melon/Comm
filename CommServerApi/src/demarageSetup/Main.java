package demarageSetup;

public class Main {
	
	public static void setup(){
		String url = "jdbc:mysql://publicsql-1.pulseheberg.net/service_35502";
		String user = "service_35502";
		String password = "V7f9ebUn31";
		main.Api.BdDconnect(url, user, password);
		CreateConfig.createServerInfo();
		new apiCommLobby.Connexion().runTaskAsynchronously(main.Main.getPlugin());
	}

}
