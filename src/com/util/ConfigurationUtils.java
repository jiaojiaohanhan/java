package com.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.util.ResourceUtils;

import com.google.gson.Gson;
import com.util.config.Config;

public class ConfigurationUtils {
	private static final Config CONFIG = readConfig();
	private static Config readConfig() {
		Config config = null;
		try {
			Path path = ResourceUtils.getFile("classpath:app.json").toPath();
			String aString = new String(Files.readAllBytes(path));
			Gson gson = new Gson();
			config = gson.fromJson(aString, Config.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return config;
	}
	
	public static String getCookie() {
		return CONFIG.getCookieName();
	}
	
	public static synchronized void setDatabasePort(int newPort) {	
		// 修改内存设置
		CONFIG.getDatabaseServer().setPort(newPort);
		try {
			Path path = ResourceUtils.getFile("classpath:app.json").toPath();
			PrintWriter writer = new PrintWriter(path.toFile());
			Gson gson = new Gson();
			// 写入
			writer.write(gson.toJson(CONFIG));
			writer.close();	
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			// 重新读取，防止写入错误
			readConfig();
		}
	}
	
	public static int getDatabasePort() {
		return CONFIG.getDatabaseServer().getPort();
	}
}
