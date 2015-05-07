package demarageSetup;

public class Main {
	
	public static void setup(){
		String url = "jdbc:mysql://publicsql-1.pulseheberg.net/service_35502";
		String user = main.Config.getPassConfig().getString("user");
		String password = main.Config.getPassConfig().getString("password");
		main.Api.BdDconnect(url, user, password);
		CreateConfig.createServerInfo();
		CreateConfig.createPass();
		new apiCommLobby.Connexion().runTaskAsynchronously(main.Main.getPlugin());
	}

}
