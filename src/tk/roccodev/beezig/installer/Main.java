package tk.roccodev.beezig.installer;

import java.awt.EventQueue;
import java.io.File;

import tk.roccodev.beezig.installer.gui.MainGui;

public class Main {

	public static File MC_DIR;
	public static File ZIG_DIR;
	
	
	
	public static void main(String args[]) {
		
		
		String OS = System.getProperty("os.name").toLowerCase();
		try{
		if (OS.contains("mac")) {
		    MC_DIR = new File(System.getProperty("user.home") + "/Library/Application Support/minecraft");
		} else if (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0) {
			MC_DIR = new File(System.getProperty("user.home") + "/.minecraft");
		} else if (OS.contains("win")) {
		    MC_DIR = new File(System.getenv("APPDATA") + "/.minecraft");
		} else {
		   MC_DIR = new File(System.getProperty("user.home") + "/Minecraft5zig");
		}
		}catch(Exception e){
			 MC_DIR = new File(System.getProperty("user.home") + "/Minecraft5zig");
		}
		if(!MC_DIR.exists()) MC_DIR.mkdir();
		

		ZIG_DIR = new File(MC_DIR + "/the5zigmod");
		

		if(!ZIG_DIR.exists()) {
			System.out.println("No 5zig found!");
			System.exit(0);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
					window.frmLabymodTozig.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	
	}
	
}
