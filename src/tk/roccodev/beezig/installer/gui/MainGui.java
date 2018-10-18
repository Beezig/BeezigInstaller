package tk.roccodev.beezig.installer.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import tk.roccodev.beezig.installer.Main;
import tk.roccodev.beezig.installer.downloader.Downloader;
import tk.roccodev.beezig.installer.downloader.JSONUtils;
import java.awt.Toolkit;

public class MainGui {

	public JFrame frmLabymodTozig;
	private JLabel lblSelectMinecraftDirectory;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnInstall;
	private final Action action = new SwingAction();
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	private JLabel label_24;
	private JLabel label_25;
	private JLabel label_26;
	private JLabel label_27;
	private JLabel label_28;
	private JLabel label_29;
	private JLabel label_30;
	private JLabel lblAfdadad;
	private JRadioButton rdbtnLatestBeta;
	private JRadioButton rdbtnLatestStable;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel label_33;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;



	/**
	 * Create the application.
	 */
	public MainGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLabymodTozig = new JFrame();
		frmLabymodTozig.setTitle("Beezig Installer v1.1");
		frmLabymodTozig.setBounds(100, 100, 450, 300);
		frmLabymodTozig.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("");
		
		btnNewButton = new JButton("Browse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);
				int returnValue = fileChooser.showOpenDialog(btnNewButton.getParent());
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					
					File f = fileChooser.getSelectedFile();
					Main.MC_DIR = f;
					textField.setText(f.getAbsolutePath());
					
				}
			}
		});
		
		label_1 = new JLabel("");
		
		lblSelectMinecraftDirectory = new JLabel("Select Minecraft Directory");
		
		label_2 = new JLabel("");
		
		label_3 = new JLabel("            ");
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(17);
		textField.setText(Main.MC_DIR.getAbsolutePath());
		
		label_16 = new JLabel("");
		
		label_4 = new JLabel("");
		
		label_17 = new JLabel("");
		
		label_5 = new JLabel("");
		
		label_18 = new JLabel("");
		
		label_19 = new JLabel("");
		
		label_20 = new JLabel("");
		
		label_6 = new JLabel("");
		
		label_7 = new JLabel("");
		
		label_8 = new JLabel("");
		
		label_9 = new JLabel("");
		
		label_10 = new JLabel("");
		
		label_21 = new JLabel("");
		
		label_22 = new JLabel("");
		
		label_23 = new JLabel("");
		
		label_24 = new JLabel("");
		
		label_25 = new JLabel("");
		
		label_11 = new JLabel("");
		
		label_26 = new JLabel("");
		
		label_12 = new JLabel("");
		
		label_27 = new JLabel("");
		
		label_13 = new JLabel("");
		
		label_14 = new JLabel("");
		
		btnInstall = new JButton("Install");
		btnInstall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
						String ur = null;
						if(buttonGroup.isSelected(rdbtnLatestBeta.getModel())) {
							lblNewLabel_1.setText("Fetching URL...");
							ur = "https://github.com/RoccoDev/Beezig-Deploy/raw/experimental/experimental/jar/Beezig.jar";
						}
						else {
							lblNewLabel_1.setText("Fetching URL...");
							JSONObject api = JSONUtils.json("https://api.github.com/repos/RoccoDev/Beezig/releases/latest");
							JSONArray assets = (JSONArray) api.get("assets");
							JSONObject first = (JSONObject) assets.get(0);
							ur = (String) first.get("browser_download_url");
						}
						lblNewLabel_1.setText("Downloading Beezig...");
						File target = new File(Main.ZIG_DIR + "/plugins/Beezig.jar");
						if(!target.exists()) target.createNewFile();
						Downloader d = new Downloader(new URL(ur), "Beezig.jar");
						d.download(target);
						JOptionPane.showMessageDialog(btnInstall.getParent(), "Succesfully installed Beezig.");
						lblNewLabel_1.setText("");
						} catch(Exception e ) {
							JOptionPane.showMessageDialog(btnInstall.getParent(), "An error occurred while installing Beezig. Please check the log for details.");
							lblNewLabel_1.setText("");	
							e.printStackTrace();
						}
					}
				}).start();
				
					
			
				
			}
		});
		
		label_15 = new JLabel("      ");
		
		label_28 = new JLabel("");
		
		label_29 = new JLabel("");
		
		label_30 = new JLabel("");
		
		lblAfdadad = new JLabel("");
		frmLabymodTozig.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		frmLabymodTozig.getContentPane().add(label);
		frmLabymodTozig.getContentPane().add(label_1);
		frmLabymodTozig.getContentPane().add(lblSelectMinecraftDirectory);
		frmLabymodTozig.getContentPane().add(label_2);
		frmLabymodTozig.getContentPane().add(label_3);
		frmLabymodTozig.getContentPane().add(textField);
		frmLabymodTozig.getContentPane().add(label_16);
		frmLabymodTozig.getContentPane().add(label_4);
		frmLabymodTozig.getContentPane().add(label_17);
		frmLabymodTozig.getContentPane().add(label_5);
		frmLabymodTozig.getContentPane().add(label_18);
		frmLabymodTozig.getContentPane().add(btnNewButton);
		frmLabymodTozig.getContentPane().add(label_19);
		frmLabymodTozig.getContentPane().add(label_20);
		frmLabymodTozig.getContentPane().add(label_6);
		frmLabymodTozig.getContentPane().add(label_7);
		frmLabymodTozig.getContentPane().add(label_8);
		frmLabymodTozig.getContentPane().add(label_9);
		frmLabymodTozig.getContentPane().add(label_10);
		frmLabymodTozig.getContentPane().add(label_21);
		frmLabymodTozig.getContentPane().add(label_22);
		
		rdbtnLatestStable = new JRadioButton("Latest Stable");
		rdbtnLatestStable.setSelected(true);
		buttonGroup.add(rdbtnLatestStable);
		frmLabymodTozig.getContentPane().add(rdbtnLatestStable);
		
		rdbtnLatestBeta = new JRadioButton("Latest Beta");
		buttonGroup.add(rdbtnLatestBeta);
		frmLabymodTozig.getContentPane().add(rdbtnLatestBeta);
		frmLabymodTozig.getContentPane().add(label_23);
		frmLabymodTozig.getContentPane().add(label_24);
		frmLabymodTozig.getContentPane().add(label_25);
		frmLabymodTozig.getContentPane().add(label_11);
		frmLabymodTozig.getContentPane().add(label_26);
		frmLabymodTozig.getContentPane().add(label_12);
		frmLabymodTozig.getContentPane().add(label_27);
		frmLabymodTozig.getContentPane().add(label_13);
		frmLabymodTozig.getContentPane().add(label_14);
		frmLabymodTozig.getContentPane().add(label_15);
		frmLabymodTozig.getContentPane().add(btnInstall);
		
		lblNewLabel = new JLabel("                 ");
		frmLabymodTozig.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		frmLabymodTozig.getContentPane().add(lblNewLabel_1);
		
		label_33 = new JLabel("");
		frmLabymodTozig.getContentPane().add(label_33);
		frmLabymodTozig.getContentPane().add(label_28);
		frmLabymodTozig.getContentPane().add(label_29);
		frmLabymodTozig.getContentPane().add(label_30);
		frmLabymodTozig.getContentPane().add(lblAfdadad);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
