package tk.roccodev.beezig.installer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import tk.roccodev.beezig.installer.gui.MainGuiNew;
import tk.roccodev.beezig.installer.utils.Exceptions;
import tk.roccodev.beezig.installer.utils.I18N;
import tk.roccodev.beezig.installer.utils.InstallationProcess;

public class Main {

	public static File MC_DIR;

	public static String VERSION = "2.0";

	
	public static InstallationProcess currentInstall = new InstallationProcess();
	
	
	public static void main(String args[]) throws FontFormatException, IOException {
		
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				Exceptions.handle(e);	
			}
		});
		
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
		
		I18N.init();

		GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Main.class.getResourceAsStream("/assets/fonts/Montserrat.ttf")));
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGuiNew window = new MainGuiNew();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	
	}
	
}
