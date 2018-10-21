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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import tk.roccodev.beezig.installer.Main;
import tk.roccodev.beezig.installer.gui.MainGuiNew;
import tk.roccodev.beezig.installer.gui.StepManager;
import tk.roccodev.beezig.installer.gui.components.BeezigButton;
import tk.roccodev.beezig.installer.gui.components.BeezigCheckbox;
import tk.roccodev.beezig.installer.gui.components.Gradient;
import tk.roccodev.beezig.installer.utils.BeezigDir;
import tk.roccodev.beezig.installer.utils.I18N;

public class InstallBeezigStepSpecial extends JPanel {

	
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private BeezigCheckbox chckbxInstallBeezigforge;

	
	/**
	 * Create the frame.
	 */
	public InstallBeezigStepSpecial() {



		Gradient gradient = new Gradient();
		gradient.kEndColor = new Color(0, 102, 153);
		gradient.kStartColor = new Color(0, 153, 153);
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(gradient,
				GroupLayout.PREFERRED_SIZE, 1308, GroupLayout.PREFERRED_SIZE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(gradient,
				GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE));

		JLabel lblBeezig = new JLabel(I18N.s("step.special.title"));
		lblBeezig.setForeground(new Color(255, 255, 255));
		lblBeezig.setFont(Main.MONTSERRAT.deriveFont(Font.BOLD, 36));
		lblBeezig.setHorizontalAlignment(SwingConstants.CENTER);

		BeezigButton btnInstall = new BeezigButton();
		btnInstall.setAction(action_1);
		btnInstall.setFont(Main.MONTSERRAT.deriveFont(Font.BOLD, 29));
		btnInstall.setText(I18N.s("channel.stable"));
		btnInstall.setBackground(new Color(7, 196, 76));
		btnInstall.setForeground(Color.WHITE);
		
		
		JButton button = new JButton("");
		button.setEnabled(false);
		button.setAction(action);
		button.setIcon(new ImageIcon(InstallBeezigStepSpecial.class.getResource("/assets/icons/back_icn.png")));
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		BeezigButton bzgbtnBeta = new BeezigButton();
		bzgbtnBeta.setAction(action_2);
		bzgbtnBeta.setText(I18N.s("channel.beta"));
		bzgbtnBeta.setForeground(Color.WHITE);
		bzgbtnBeta.setFont(Main.MONTSERRAT.deriveFont(Font.BOLD, 29));
		bzgbtnBeta.setBackground(new Color(51, 102, 255));
		
		JLabel lblAnInstallationOf = new JLabel(I18N.s("step.special.desc"));
		lblAnInstallationOf.setForeground(Color.WHITE);
		lblAnInstallationOf.setFont(Main.MONTSERRAT.deriveFont(Font.BOLD, 15));
		lblAnInstallationOf.setHorizontalAlignment(SwingConstants.CENTER);
		
		chckbxInstallBeezigforge = new BeezigCheckbox();
		chckbxInstallBeezigforge.setForeground(new Color(255, 255, 255));
		chckbxInstallBeezigforge.setFont(Main.MONTSERRAT.deriveFont(Font.BOLD, 15));
		chckbxInstallBeezigforge.setText(I18N.s("step.special.forge"));
		chckbxInstallBeezigforge.setHorizontalAlignment(SwingConstants.CENTER);
		if(!BeezigDir.hasForge()) {
			chckbxInstallBeezigforge.setSelected(false);
			chckbxInstallBeezigforge.setVisible(false);
		}
		else if(BeezigDir.isBeezigForgePresent())
			chckbxInstallBeezigforge.setSelected(true);

		GroupLayout gl_gradient = new GroupLayout(gradient);
		gl_gradient.setHorizontalGroup(
			gl_gradient.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_gradient.createSequentialGroup()
					.addGap(441)
					.addComponent(btnInstall, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
					.addGap(436))
				.addGroup(gl_gradient.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gradient.createParallelGroup(Alignment.TRAILING)
						.addComponent(chckbxInstallBeezigforge, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1285, Short.MAX_VALUE)
						.addComponent(lblAnInstallationOf, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1285, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_gradient.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblBeezig, GroupLayout.PREFERRED_SIZE, 1285, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_gradient.createSequentialGroup()
					.addGap(441)
					.addComponent(bzgbtnBeta, GroupLayout.PREFERRED_SIZE, 432, Short.MAX_VALUE)
					.addGap(436))
				.addGroup(Alignment.LEADING, gl_gradient.createSequentialGroup()
					.addContainerGap()
					.addComponent(button)
					.addContainerGap(1227, Short.MAX_VALUE))
		);
		gl_gradient.setVerticalGroup(
			gl_gradient.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradient.createSequentialGroup()
					.addContainerGap()
					.addComponent(button)
					.addGap(163)
					.addComponent(lblBeezig, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblAnInstallationOf)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxInstallBeezigforge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(bzgbtnBeta, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btnInstall, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(234, Short.MAX_VALUE))
		);
		gradient.setLayout(gl_gradient);
		setLayout(gl_contentPane);
	}
	private class SwingAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			InstallBeezigStepSpecial.this.getRootPane().setContentPane(StepManager.lastStep.get(StepManager.lastStep.size() - 1));
			StepManager.lastStep.remove(StepManager.lastStep.size() - 1);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			StepManager.lastStep.add(InstallBeezigStepSpecial.this);
			Main.currentInstall.setChannel(0);
			Main.currentInstall.installForge(chckbxInstallBeezigforge.isSelected());
			InstallBeezigStepDownload pane = new InstallBeezigStepDownload();
			MainGuiNew.inst.setContentPane(pane);
			MainGuiNew.inst.pack();
		
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			StepManager.lastStep.add(InstallBeezigStepSpecial.this);
			Main.currentInstall.setChannel(1);
			Main.currentInstall.installForge(chckbxInstallBeezigforge.isSelected());
			InstallBeezigStepDownload pane = new InstallBeezigStepDownload();
			MainGuiNew.inst.setContentPane(pane);
			MainGuiNew.inst.pack();
		}
	}
}
