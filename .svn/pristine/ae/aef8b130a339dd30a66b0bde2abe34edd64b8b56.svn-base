package com.fhcf.manager.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class HttpUtil {

	private static ResourceBundle bundle = ResourceBundle.getBundle("cache");
	public static String getPropertyValue(String string) {
		return bundle.getString(string);
	}
	private static String cookie = "";

	public static String post(String path, Map<String, String> map) {
		//System.out.println(System.getProperty("http.proxyHost"));
		BufferedReader br = null;
		OutputStream os = null;
		HttpURLConnection conn = null;
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL(path);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Cookie", cookie);
			StringBuffer buffer = new StringBuffer();
			if (map != null && !map.isEmpty()) {
				for (Map.Entry<String, String> entry : map.entrySet())
					buffer.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
				buffer.deleteCharAt(buffer.length() - 1);
			}
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			conn.getOutputStream().write(buffer.toString().getBytes("UTF-8"));

			if (conn.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
				String lines;
				while ((lines = br.readLine()) != null)
					sb.append(lines);
				Map<String, List<String>> head = conn.getHeaderFields();
				Set<String> set = head.keySet();
				for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
					String key = iterator.next();
					if (key != null && "Set-Cookie".equals(key)) {
						List<String> list = head.get(key);
						StringBuilder builder = new StringBuilder();
						for (String str : list)
							builder.append(str).toString();
						cookie = builder.toString();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.disconnect();
				if (br != null)
					br.close();
				if (os != null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return sb.toString();
	}
	
	
}