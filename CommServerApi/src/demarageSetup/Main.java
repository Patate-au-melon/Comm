package demarageSetup;

public class Main {
	
	public static void setup(){
		baseDeDonnee.Connexion.connect();
		CreateConfigServerInfo.create();
		new apiCommLobby.Connexion().runTaskAsynchronously(main.Main.getPlugin());
	}

}
