package tk.roccodev.beezig.installer.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18N {
	
	private static ResourceBundle strings;
	private static Locale currentLocale;
	
	public static void init() {
		currentLocale = Locale.getDefault();
		strings = ResourceBundle.getBundle("lang.BeezigInstaller", currentLocale);
	}

	public static String s(String key) {
		return strings.getString(key);
	}
	
}
