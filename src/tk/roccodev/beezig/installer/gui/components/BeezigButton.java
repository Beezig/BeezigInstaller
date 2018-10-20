package tk.roccodev.beezig.installer.gui.components;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class BeezigButton extends JButton {
	
	private Color cachedBackground;
	
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
	                    setNoCache(getBackground().darker());
	                }

	                @Override
	                public void mouseExited(MouseEvent e) {
	                    setNoCache(getBackground().brighter());
	                }

					@Override
					public void mouseClicked(MouseEvent e) {
						setNoCache(cachedBackground);
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						setNoCache(cachedBackground);
					}
	                
	                
	                
	            });
	}
	
	public void setNoCache(Color color) {
		super.setBackground(color);
	}
	
	@Override
	public void setBackground(Color color) {
		super.setBackground(color);
		cachedBackground = color;
	}

}
