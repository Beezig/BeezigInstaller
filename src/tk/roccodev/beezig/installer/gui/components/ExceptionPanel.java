package tk.roccodev.beezig.installer.gui.components;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import tk.roccodev.beezig.installer.utils.I18N;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ExceptionPanel extends JPanel {
	private JTextArea textField;

	public ExceptionPanel(Throwable ex) {
		Gradient gradient = new Gradient();
		gradient.kEndColor = new Color(0, 102, 153);
		gradient.kStartColor = new Color(0, 153, 153);
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(gradient,
				GroupLayout.PREFERRED_SIZE, 1308, GroupLayout.PREFERRED_SIZE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(gradient,
				GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE));

		JLabel lblBeezig = new JLabel("Uhm... looks like something went wrong.");
		lblBeezig.setForeground(new Color(255, 255, 255));
		lblBeezig.setFont(new Font("Montserrat", Font.BOLD, 36));
		lblBeezig.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextArea();
		textField.setEditable(false);
		textField.setColumns(100);
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		textField.setText(sw.toString());
		try {
			sw.close();
		} catch (IOException ignored) {}
		pw.close();
		
		BeezigButton btnInstall = new BeezigButton();
		btnInstall.setAction(new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URI("https://discord.gg/Yk5zg69"));
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
			}
		});
		btnInstall.setFont(new Font("Montserrat", Font.BOLD, 29));
		btnInstall.setText(I18N.s("error.report"));
		btnInstall.setBackground(new Color(114, 137, 218));
		btnInstall.setForeground(Color.WHITE);
		
		GroupLayout gl_gradient = new GroupLayout(gradient);
		gl_gradient.setHorizontalGroup(
			gl_gradient.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_gradient.createSequentialGroup()
					.addGroup(gl_gradient.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_gradient.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBeezig, GroupLayout.DEFAULT_SIZE, 1284, Short.MAX_VALUE))
						.addGroup(gl_gradient.createSequentialGroup()
							.addGap(387)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(gl_gradient.createSequentialGroup()
					.addContainerGap(501, Short.MAX_VALUE)
					.addComponent(btnInstall, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(497))
		);
		gl_gradient.setVerticalGroup(
			gl_gradient.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradient.createSequentialGroup()
					.addGap(199)
					.addComponent(lblBeezig)
					.addGap(33)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(btnInstall, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(145, Short.MAX_VALUE))
		);
		gradient.setLayout(gl_gradient);
		setLayout(gl_contentPane);
	
	}
}
