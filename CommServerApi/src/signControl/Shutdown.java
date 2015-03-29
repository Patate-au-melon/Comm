package signControl;

public class Shutdown {
	
	public static void stop(){
		String world = main.Config.getSignControl().getString("world");
		int x = main.Config.getSignControl().getInt("x");
		int y = main.Config.getSignControl().getInt("y");
		int z = main.Config.getSignControl().getInt("z");
		String line1 = main.Config.getSignControl().getString("serverDown.line1");
		String line2 = main.Config.getSignControl().getString("serverDown.line2");
		String line3 = main.Config.getSignControl().getString("serverDown.line3");
		String line4 = main.Config.getSignControl().getString("serverDown.line4");
		sendMessage.send(world, x, y, z, line1, line2, line3, line4);
	}

}
