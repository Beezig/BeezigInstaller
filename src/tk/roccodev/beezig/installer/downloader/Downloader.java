package tk.roccodev.beezig.installer.downloader;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JProgressBar;

import tk.roccodev.beezig.installer.utils.I18N;

public class Downloader {

	private URL url;
	private String name;
	private String toRename;
	private boolean run = true;

	public void download(File target, JProgressBar toUpdate, JButton toUpdateBtn, boolean complete) {
		toUpdate.setValue(0);
		toUpdateBtn.setEnabled(true);
		BufferedInputStream in = null;
		FileOutputStream out = null;

		boolean removeFile = false;

		try {
			URLConnection conn = url.openConnection();
			int size = conn.getContentLength();

			in = new BufferedInputStream(url.openStream());
			out = new FileOutputStream(target);
			byte data[] = new byte[1024];
			int count;
			double sumCount = 0.0;

			while ((count = in.read(data, 0, 1024)) != -1) {
				if (!run) {
					removeFile = true;
					break;
				}
				out.write(data, 0, count);

				sumCount += count;
				if (size > 0) {
					toUpdate.setValue((int) (sumCount / size * 100));
				}
			}

			if (removeFile) {
				target.delete();
				toUpdateBtn.setEnabled(false);
				return;
			}

			toUpdateBtn.setEnabled(false);

			File pluginsDir = target.getParentFile();
			File[] files = pluginsDir.listFiles(new FilenameFilter() {

				@Override
				public boolean accept(File dir, String name) {
					return name.toLowerCase().contains("beezig") && name.toLowerCase().endsWith(".jar");
				}
			});

			if (files != null) {
				for (File f : files) {
					f.delete();
				}
			}

			target.renameTo(new File(pluginsDir + "/" + toRename));

			if(!complete) return;
			
			toUpdateBtn.setAction(new AbstractAction() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			toUpdate.setString(I18N.s("general.done"));
			toUpdateBtn.setText(I18N.s("general.close"));
			toUpdateBtn.setEnabled(true);
			toUpdateBtn.setBackground(new Color(7, 196, 76));

		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e3) {
					e3.printStackTrace();
				}
			if (out != null)
				try {
					out.close();
				} catch (IOException e4) {
					e4.printStackTrace();
				}
		}
	}

	public void downloadOld(File target) throws IOException {
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(target);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
	}

	public Downloader(URL url, String name, String rename) {
		super();
		this.url = url;
		this.name = name;
		this.toRename = rename;
	}

	public void stop() {
		run = false;
	}

	public URL getUrl() {
		return url;
	}

	public String getName() {
		return name;
	}

}
