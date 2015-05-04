package demarageSetup;

public class Main {
	
	public static void setup(){
		String url = "jdbc:mysql://mysql-hbct.alwaysdata.net/hbct_plugin";
		String user = "hbct_plugin";
		String password = "jeje";
		main.Api.BdDconnect(url, user, password);
		CreateConfig.createServerInfo();
		new apiCommLobby.Connexion().runTaskAsynchronously(main.Main.getPlugin());
	}

}
