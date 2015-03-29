package signControl;

public class Start {
	
	public static void demarage(){
		String world = main.Config.getSignControl().getString("world");
		int x = main.Config.getSignControl().getInt("x");
		int y = main.Config.getSignControl().getInt("y");
		int z = main.Config.getSignControl().getInt("z");
		String line1 ="";
		String line2 = "";
		String line3 = "";
		String line4 = "";
		sendMessage.send(world, x, y, z, line1, line2, line3, line4);
	}

}
