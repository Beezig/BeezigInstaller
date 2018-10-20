package tk.roccodev.beezig.installer.utils;

import tk.roccodev.beezig.installer.gui.MainGuiNew;
import tk.roccodev.beezig.installer.gui.components.ExceptionPanel;

public class Exceptions {

	public static void handle(Throwable ex) {

		if(MainGuiNew.inst == null) {
			ex.printStackTrace();
			return;
		}
		
		ExceptionPanel pane = new ExceptionPanel(ex);
		MainGuiNew.inst.setContentPane(pane);
		MainGuiNew.inst.pack();
	}
	
}
