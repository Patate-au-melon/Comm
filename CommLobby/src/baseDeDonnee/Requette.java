package baseDeDonnee;

import java.sql.ResultSet;

import org.bukkit.Bukkit;

public class Requette {
	
	public static ResultSet sendRequette(String requette){
		if(Connexion.co){
			java.sql.Statement st = null;
			try {
				st = Connexion.cn.createStatement();
				ResultSet rs = st.executeQuery(requette);
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					st.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else{
			Bukkit.getLogger().warning("Erreur de connexion a la base de donnee");
		}
		return null;
	}
	
}
