package tk.roccodev.beezig.installer.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import tk.roccodev.beezig.installer.Main;
import tk.roccodev.beezig.installer.gui.components.BeezigButton;
import tk.roccodev.beezig.installer.gui.components.Gradient;
import tk.roccodev.beezig.installer.gui.steps.InstallBeezigStepOne;
import tk.roccodev.beezig.installer.utils.I18N;

public class MainGuiNew extends JFrame {


	private final Action action = new SwingAction();
	
	public static MainGuiNew inst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGuiNew frame = new MainGuiNew();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGuiNew() {
		inst = this;
		setResizable(false);
		setTitle("Beezig Installer v" + Main.VERSION);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/assets/icons/beezig_icn.png")).getImage());
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);

		Gradient gradient = new Gradient();
		gradient.kEndColor = new Color(0, 102, 153);
		gradient.kStartColor = new Color(0, 153, 153);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(gradient,
				GroupLayout.PREFERRED_SIZE, 1308, GroupLayout.PREFERRED_SIZE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(gradient,
				GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE));

		JLabel lblBeezig = new JLabel("Beezig");
		lblBeezig.setForeground(new Color(255, 255, 255));
		lblBeezig.setFont(new Font("Montserrat", Font.BOLD, 99));
		lblBeezig.setHorizontalAlignment(SwingConstants.CENTER);

		BeezigButton btnInstall = new BeezigButton();
		btnInstall.setAction(action);
		btnInstall.setFont(new Font("Montserrat", Font.BOLD, 29));
		btnInstall.setText(I18N.s("general.next"));
		btnInstall.setBackground(new Color(7, 196, 76));
		btnInstall.setForeground(Color.WHITE);

		GroupLayout gl_gradient = new GroupLayout(gradient);
		gl_gradient.setHorizontalGroup(gl_gradient.createParallelGroup(Alignment.CENTER).addGroup(gl_gradient
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_gradient.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBeezig, GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_gradient.createSequentialGroup()
								.addComponent(btnInstall, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
								.addGap(543)))));
		gl_gradient.setVerticalGroup(gl_gradient.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradient.createSequentialGroup().addGap(215).addComponent(lblBeezig).addGap(21)
						.addComponent(btnInstall, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(319, Short.MAX_VALUE)));
		gradient.setLayout(gl_gradient);
		contentPane.setLayout(gl_contentPane);
		pack();
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			StepManager.lastStep.add(getContentPane());
			InstallBeezigStepOne pane = new InstallBeezigStepOne();
			MainGuiNew.this.setContentPane(pane);
			MainGuiNew.this.pack();
		}
	}
}
