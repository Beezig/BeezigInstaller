package tk.roccodev.beezig.installer.utils;

public class InstallationProcess {
	
	/*
	 * 0: Stable
	 * 1: Beta
	 */
	private int channel; 

	private boolean forge;

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public boolean shouldInstallBeezigForge() {
		return forge;
	}
	
	public void installForge(boolean b) {
		forge = b;
	}

	
	
	
}
