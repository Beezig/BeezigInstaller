package tk.roccodev.beezig.installer.downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONUtils {

	public static JSONObject json(String url) {
		try {
			return getObject(readURL(new URL(url)));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
	private static JSONObject getObject(Reader toParse) {
        JSONParser parser = new JSONParser();
        JSONObject o = null;
        try {
            o = (JSONObject) parser.parse(toParse);
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return o;

	}
	 private static Reader readURL(URL url) {
	        return read(url);
	    }
	 
	 private static Reader read(URL url) {
         BufferedReader reader = null;
         try {
             URLConnection conn = url.openConnection();
             conn.addRequestProperty("User-Agent", "Beezig Installer");
             conn.setRequestProperty("Accept", "application/json");

             return new BufferedReader(new InputStreamReader(conn.getInputStream(), Charset.forName("UTF-8")));

         } catch (Exception e) {

             //e.printStackTrace();
             return null;
         } finally {
             if (reader != null)
                 try {
                     reader.close();
                 } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                 }
         }
     }
}
