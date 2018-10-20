package tk.roccodev.beezig.installer.gui.steps;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import tk.roccodev.beezig.installer.Main;
import tk.roccodev.beezig.installer.gui.MainGuiNew;
import tk.roccodev.beezig.installer.gui.StepManager;
import tk.roccodev.beezig.installer.gui.components.BeezigButton;
import tk.roccodev.beezig.installer.gui.components.Gradient;
import tk.roccodev.beezig.installer.utils.BeezigDir;
import tk.roccodev.beezig.installer.utils.I18N;

public class InstallBeezigStepOne extends JPanel {

	
	private JTextField txt;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();

	

	/**
	 * Create the frame.
	 */
	public InstallBeezigStepOne() {



		Gradient gradient = new Gradient();
		gradient.kEndColor = new Color(0, 102, 153);
		gradient.kStartColor = new Color(0, 153, 153);
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(gradient,
				GroupLayout.PREFERRED_SIZE, 1308, GroupLayout.PREFERRED_SIZE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(gradient,
				GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE));

		JLabel lblBeezig = new JLabel(I18N.s("step.dir"));
		lblBeezig.setForeground(new Color(255, 255, 255));
		lblBeezig.setFont(Main.MONTSERRAT.deriveFont(Font.BOLD, 36));
		lblBeezig.setHorizontalAlignment(SwingConstants.CENTER);

		BeezigButton btnInstall = new BeezigButton();
		btnInstall.setAction(action_1);
		btnInstall.setFont(Main.MONTSERRAT.deriveFont(Font.BOLD, 29));
		btnInstall.setText(I18N.s("general.next"));
		btnInstall.setBackground(new Color(7, 196, 76));
		btnInstall.setForeground(Color.WHITE);
		
		txt = new JTextField();
		txt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.setFileHidingEnabled(false);
				int returnValue = fileChooser.showOpenDialog(txt.getParent());
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					
					File f = fileChooser.getSelectedFile();
					Main.MC_DIR = f;
					txt.setText(f.getAbsolutePath());
					
				}
			}
		});
		txt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		txt.setEditable(false);
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		txt.setColumns(40);
		txt.setText(Main.MC_DIR.getAbsolutePath());
		
		JButton button = new JButton("");
		button.setEnabled(false);
		button.setAction(action);
		button.setIcon(new ImageIcon(InstallBeezigStepOne.class.getResource("/assets/icons/back_icn.png")));
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));

		GroupLayout gl_gradient = new GroupLayout(gradient);
		gl_gradient.setHorizontalGroup(
			gl_gradient.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_gradient.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gradient.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBeezig, GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
						.addGroup(gl_gradient.createSequentialGroup()
							.addComponent(button)
							.addContainerGap())))
				.addGroup(Alignment.TRAILING, gl_gradient.createSequentialGroup()
					.addContainerGap(355, Short.MAX_VALUE)
					.addComponent(txt, GroupLayout.PREFERRED_SIZE, 606, GroupLayout.PREFERRED_SIZE)
					.addGap(347))
				.addGroup(Alignment.LEADING, gl_gradient.createSequentialGroup()
					.addGap(436)
					.addComponent(btnInstall, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(440, Short.MAX_VALUE))
		);
		gl_gradient.setVerticalGroup(
			gl_gradient.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradient.createSequentialGroup()
					.addContainerGap()
					.addComponent(button)
					.addGap(163)
					.addComponent(lblBeezig)
					.addGap(88)
					.addComponent(txt, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(btnInstall, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(232, Short.MAX_VALUE))
		);
		gradient.setLayout(gl_gradient);
		setLayout(gl_contentPane);
		
	
	}
	private class SwingAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			InstallBeezigStepOne.this.getRootPane().setContentPane(StepManager.lastStep.get(StepManager.lastStep.size() - 1));
			StepManager.lastStep.remove(StepManager.lastStep.size() - 1);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			StepManager.lastStep.add(InstallBeezigStepOne.this);
			Main.MC_DIR = new File(txt.getText());
			JPanel pane = null;
			if(BeezigDir.isBeezigPresent()) pane = new InstallBeezigStepSpecial();
			else pane = new InstallBeezigStepTwo();
			MainGuiNew.inst.setContentPane(pane);
			MainGuiNew.inst.pack();
		
		}
	}
}
