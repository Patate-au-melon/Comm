package demarageSetup;

public class Main {
	
	public static void setup(){
		String url = "jdbc:mysql://mysql-hbct.alwaysdata.net/hbct_plugin";
		String user = "hbct_plugin";
		String password = "jeje";
		main.Api.BdDconnect(url, user, password);
		CreateConfig.createServerInfo();
		CreateConfig.createSignControl();
		new signControl.UpdateBDD();
		new apiCommLobby.Connexion().runTaskAsynchronously(main.Main.getPlugin());
	}

}
