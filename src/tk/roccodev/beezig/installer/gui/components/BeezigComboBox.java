package tk.roccodev.beezig.installer.gui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class BeezigComboBox<T> extends JComboBox<T> {

	public BeezigComboBox() {
		this(true);
	}

	public BeezigComboBox(boolean hover) {
		super();
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
	
	public void changeRenderer(Color color1, Color color2) {
		setRenderer(new Renderer(getRenderer(), color1, color2));
	}
	
	class Renderer extends DefaultListCellRenderer {

		  private ListCellRenderer defaultRenderer;
		  private Color color1, color2;

		  public Renderer(ListCellRenderer defaultRenderer) {
		    this.defaultRenderer = defaultRenderer;
		  }
		  
		  public Renderer(ListCellRenderer defaultRenderer, Color color1, Color color2) {
			  this.defaultRenderer = defaultRenderer;
			  this.color1 = color1;
			  this.color2 = color2;
		  }

		  @Override
		  public Component getListCellRendererComponent(JList list, Object value,
		      int index, boolean isSelected, boolean cellHasFocus) {
		    Component c = defaultRenderer.getListCellRendererComponent(list, value,
		        index, isSelected, cellHasFocus);
		    if (c instanceof JLabel) {
		      if (isSelected) {
		        c.setBackground(color2);
		        c.setForeground(Color.WHITE);
		      } else {
		        c.setBackground(color1);
		      }
		    } else {
		      c.setBackground(color1);
		      c = super.getListCellRendererComponent(list, value, index, isSelected,
		          cellHasFocus);
		    }
		    return c;
		  }
	
	}

}
