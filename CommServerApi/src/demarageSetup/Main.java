package demarageSetup;

public class Main {
	
	public static void setup(){
		baseDeDonnee.Connexion.connect();
		CreateConfig.createServerInfo();
		CreateConfig.createSignControl();
		new signControl.UpdateBDD();
		new apiCommLobby.Connexion().runTaskAsynchronously(main.Main.getPlugin());
	}

}
