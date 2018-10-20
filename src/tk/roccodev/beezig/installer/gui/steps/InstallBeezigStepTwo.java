package tk.roccodev.beezig.installer.gui.steps;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import tk.roccodev.beezig.installer.Main;
import tk.roccodev.beezig.installer.gui.MainGuiNew;
import tk.roccodev.beezig.installer.gui.StepManager;
import tk.roccodev.beezig.installer.gui.components.BeezigButton;
import tk.roccodev.beezig.installer.gui.components.BeezigCheckbox;
import tk.roccodev.beezig.installer.gui.components.BeezigComboBox;
import tk.roccodev.beezig.installer.gui.components.Gradient;
import tk.roccodev.beezig.installer.utils.BeezigDir;
import tk.roccodev.beezig.installer.utils.I18N;

public class InstallBeezigStepTwo extends JPanel {

	
	private BeezigComboBox<String> txt;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private BeezigCheckbox bzgchckbxInstallBeezigforge;

	
	/**
	 * Create the frame.
	 */
	public InstallBeezigStepTwo() {



		Gradient gradient = new Gradient();
		gradient.kEndColor = new Color(0, 102, 153);
		gradient.kStartColor = new Color(0, 153, 153);
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(gradient,
				GroupLayout.PREFERRED_SIZE, 1308, GroupLayout.PREFERRED_SIZE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(gradient,
				GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE));

		JLabel lblBeezig = new JLabel(I18N.s("step.channel"));
		lblBeezig.setForeground(new Color(255, 255, 255));
		lblBeezig.setFont(new Font("Montserrat", Font.BOLD, 36));
		lblBeezig.setHorizontalAlignment(SwingConstants.CENTER);

		BeezigButton btnInstall = new BeezigButton();
		btnInstall.setAction(action_1);
		btnInstall.setFont(new Font("Montserrat", Font.BOLD, 29));
		btnInstall.setText(I18N.s("general.next"));
		btnInstall.setBackground(new Color(7, 196, 76));
		btnInstall.setForeground(Color.WHITE);
		
		txt = new BeezigComboBox<String>();
		txt.setForeground(Color.WHITE);
		Color bg = new Color(51, 102, 255);
		txt.changeRenderer(bg, new Color(7, 25, 145));
		txt.setBackground(bg);
		txt.setFont(new Font("Montserrat", Font.BOLD, 20));
		txt.addItem(I18N.s("channel.stable_long"));
		txt.addItem(I18N.s("channel.beta_long"));
		txt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		txt.setEditable(false);
		
		JButton button = new JButton("");
		button.setEnabled(false);
		button.setAction(action);
		button.setIcon(new ImageIcon(InstallBeezigStepTwo.class.getResource("/assets/icons/back_icn.png")));
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		bzgchckbxInstallBeezigforge = new BeezigCheckbox();
		bzgchckbxInstallBeezigforge.setForeground(new Color(255, 255, 255));
		bzgchckbxInstallBeezigforge.setFont(new Font("Montserrat", Font.BOLD, 15));
		bzgchckbxInstallBeezigforge.setHorizontalAlignment(SwingConstants.CENTER);
		bzgchckbxInstallBeezigforge.setText(I18N.s("step.channel.forge"));
		if(!BeezigDir.hasForge()) bzgchckbxInstallBeezigforge.setVisible(false);

		GroupLayout gl_gradient = new GroupLayout(gradient);
		gl_gradient.setHorizontalGroup(
			gl_gradient.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_gradient.createSequentialGroup()
					.addContainerGap(355, Short.MAX_VALUE)
					.addComponent(txt, GroupLayout.PREFERRED_SIZE, 606, GroupLayout.PREFERRED_SIZE)
					.addGap(347))
				.addGroup(gl_gradient.createSequentialGroup()
					.addGap(436)
					.addComponent(btnInstall, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(440, Short.MAX_VALUE))
				.addGroup(gl_gradient.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gradient.createParallelGroup(Alignment.TRAILING)
						.addComponent(bzgchckbxInstallBeezigforge, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1284, Short.MAX_VALUE)
						.addComponent(lblBeezig, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1284, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_gradient.createSequentialGroup()
					.addContainerGap()
					.addComponent(button)
					.addContainerGap(1226, Short.MAX_VALUE))
		);
		gl_gradient.setVerticalGroup(
			gl_gradient.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradient.createSequentialGroup()
					.addContainerGap()
					.addComponent(button)
					.addGap(159)
					.addComponent(lblBeezig)
					.addGap(53)
					.addComponent(bzgchckbxInstallBeezigforge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txt, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(btnInstall, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(226, Short.MAX_VALUE))
		);
		gradient.setLayout(gl_gradient);
		setLayout(gl_contentPane);
	
	}
	private class SwingAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			InstallBeezigStepTwo.this.getRootPane().setContentPane(StepManager.lastStep.get(StepManager.lastStep.size() - 1));
			StepManager.lastStep.remove(StepManager.lastStep.size() - 1);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			StepManager.lastStep.add(InstallBeezigStepTwo.this);
			Main.currentInstall.setChannel(txt.getSelectedIndex());
			Main.currentInstall.installForge(bzgchckbxInstallBeezigforge.isSelected());
			InstallBeezigStepDownload pane = new InstallBeezigStepDownload();
			MainGuiNew.inst.setContentPane(pane);
			MainGuiNew.inst.pack();
		}
	}
}
