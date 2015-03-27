package demarageSetup;

public class Main {
	
	public static void setup(){
		baseDeDonnee.Connexion.connect();
		new apiCommLobby.Connexion().runTaskAsynchronously(main.Main.getPlugin());
	}

}
