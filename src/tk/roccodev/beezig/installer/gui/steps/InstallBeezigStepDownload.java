package tk.roccodev.beezig.installer.gui.steps;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import tk.roccodev.beezig.installer.Main;
import tk.roccodev.beezig.installer.downloader.Downloader;
import tk.roccodev.beezig.installer.downloader.JSONUtils;
import tk.roccodev.beezig.installer.gui.StepManager;
import tk.roccodev.beezig.installer.gui.components.BeezigButton;
import tk.roccodev.beezig.installer.gui.components.Gradient;
import tk.roccodev.beezig.installer.utils.I18N;

public class InstallBeezigStepDownload extends JPanel {

	
	private final Action action = new SwingAction();

	/**
	 * Create the frame.
	 */
	public InstallBeezigStepDownload() {
	
		JProgressBar bzgbtnBeta = new JProgressBar();
		bzgbtnBeta.setStringPainted(true);
		bzgbtnBeta.setForeground(new Color(0, 0, 204));
		bzgbtnBeta.setFont(new Font("Montserrat", Font.BOLD, 29));
		bzgbtnBeta.setBackground(new Color(255, 255, 255));
		
		BeezigButton btnInstall = new BeezigButton();
		btnInstall.setFont(new Font("Montserrat", Font.BOLD, 29));
		btnInstall.setText(I18N.s("general.cancel"));
		btnInstall.setBackground(new Color(204, 0, 51));
		btnInstall.setForeground(Color.WHITE);

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
				String ur = null;
				if(Main.currentInstall.getChannel() == 1) {
					ur = "https://github.com/RoccoDev/Beezig-Deploy/raw/experimental/experimental/jar/Beezig.jar";
				}
				else {
					JSONObject api = JSONUtils.json("https://api.github.com/repos/RoccoDev/Beezig/releases/latest");
					JSONArray assets = (JSONArray) api.get("assets");
					JSONObject first = (JSONObject) assets.get(0);
					ur = (String) first.get("browser_download_url");
				}
				
				File target = new File(Main.MC_DIR + "/the5zigmod/plugins/bzgToUpdate.jar");
				if(!target.exists()) target.createNewFile();
				Downloader d = new Downloader(new URL(ur), "bzgToUpdate.jar", "Beezig.jar");
				btnInstall.setAction(new SwingAction_1(d));
				btnInstall.setText(I18N.s("general.cancel"));
				d.download(target, bzgbtnBeta, btnInstall);
				} catch(Exception e ) {
					e.printStackTrace();
				}
			}
		}).start();

		Gradient gradient = new Gradient();
		gradient.kEndColor = new Color(0, 102, 153);
		gradient.kStartColor = new Color(0, 153, 153);
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(gradient,
				GroupLayout.PREFERRED_SIZE, 1308, GroupLayout.PREFERRED_SIZE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(gradient,
				GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE));

		JLabel lblBeezig = new JLabel(I18N.s("step.download.title"));
		lblBeezig.setForeground(new Color(255, 255, 255));
		lblBeezig.setFont(new Font("Montserrat", Font.BOLD, 36));
		lblBeezig.setHorizontalAlignment(SwingConstants.CENTER);


		
		
		JButton button = new JButton("");
		button.setEnabled(false);
		button.setAction(action);
		button.setIcon(new ImageIcon(InstallBeezigStepDownload.class.getResource("/assets/icons/back_icn.png")));
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
	
		
		JLabel lblAnInstallationOf = new JLabel(I18N.s("step.download.desc"));
		lblAnInstallationOf.setForeground(Color.WHITE);
		lblAnInstallationOf.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblAnInstallationOf.setHorizontalAlignment(SwingConstants.CENTER);

		GroupLayout gl_gradient = new GroupLayout(gradient);
		gl_gradient.setHorizontalGroup(
			gl_gradient.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradient.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gradient.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBeezig, GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
						.addGroup(gl_gradient.createSequentialGroup()
							.addComponent(button)
							.addContainerGap())))
				.addGroup(gl_gradient.createSequentialGroup()
					.addGap(464)
					.addGroup(gl_gradient.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_gradient.createSequentialGroup()
							.addComponent(bzgbtnBeta, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_gradient.createSequentialGroup()
							.addComponent(btnInstall, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
							.addGap(412))))
				.addGroup(gl_gradient.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAnInstallationOf, GroupLayout.DEFAULT_SIZE, 1284, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_gradient.setVerticalGroup(
			gl_gradient.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradient.createSequentialGroup()
					.addContainerGap()
					.addComponent(button)
					.addGap(163)
					.addComponent(lblBeezig)
					.addGap(18)
					.addComponent(lblAnInstallationOf)
					.addGap(47)
					.addComponent(bzgbtnBeta, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnInstall, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(234, Short.MAX_VALUE))
		);
		gradient.setLayout(gl_gradient);
		setLayout(gl_contentPane);
	
	}
	
	public void back() {
		getRootPane().setContentPane(StepManager.lastStep.get(StepManager.lastStep.size() - 1));
		StepManager.lastStep.remove(StepManager.lastStep.size() - 1);
	}
	
	private class SwingAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			InstallBeezigStepDownload.this.back();
		}
	}
	private class SwingAction_1 extends AbstractAction {
		private Downloader dl;
		
		public SwingAction_1(Downloader dl) {
			this.dl = dl;
		}
		
		public void actionPerformed(ActionEvent e) {
			dl.stop();
			InstallBeezigStepDownload.this.back();
		}
	}
	
}
