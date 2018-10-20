package tk.roccodev.beezig.installer.utils;

import java.io.File;
import java.io.FilenameFilter;

import tk.roccodev.beezig.installer.Main;

public class BeezigDir {

	public static boolean isBeezigPresent() {
		
		File mcDir = new File(Main.MC_DIR + "/the5zigmod/plugins/");
		File[] matches = mcDir.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File arg0, String arg1) {
				return arg1.toLowerCase().contains("beezig");
			}
		});
		
		if(matches == null) return false;
		
		return matches.length != 0;
		
	}
	
	public static boolean isBeezigForgePresent() {
		File mcDir = new File(Main.MC_DIR + "/mods/");
		File[] matches = mcDir.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File arg0, String arg1) {
				return arg1.toLowerCase().contains("beezigforge");
			}
		});
		
		if(matches == null) return false;
		
		return matches.length != 0;
		
	}
	
	public static boolean hasForge() {
		File mcDir = new File(Main.MC_DIR + "/mods/");
		return mcDir.exists();
	}
	
}
