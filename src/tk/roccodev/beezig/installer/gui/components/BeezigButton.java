package tk.roccodev.beezig.installer.gui.components;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class BeezigButton extends JButton {
	
	public BeezigButton() { this(true); }
	
	public BeezigButton(boolean hover) {
		 super();
	        setBorderPainted(false);
	        setFocusPainted(false);
	        setBackground(Color.WHITE);
	        setForeground(new Color(30, 30, 30));
	        if (hover)
	            addMouseListener(new MouseAdapter() {
	                @Override
	                public void mouseEntered(MouseEvent e) {
	                    setBackground(getBackground().darker());
	                }

	                @Override
	                public void mouseExited(MouseEvent e) {
	                    setBackground(getBackground().brighter());
	                }
	            });
	}
	

}
