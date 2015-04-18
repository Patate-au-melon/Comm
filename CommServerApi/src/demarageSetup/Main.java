package demarageSetup;

public class Main {
	
	public static void setup(){
		main.Api.BdDconnect();
		CreateConfig.createServerInfo();
		CreateConfig.createSignControl();
		new signControl.UpdateBDD();
		new apiCommLobby.Connexion().runTaskAsynchronously(main.Main.getPlugin());
	}

}
