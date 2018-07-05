package com.util.config;

public class Config {
	private String cookieName;
	private String method;
	private DatabaseServer databaseServer;
	public String getCookieName() {
		return cookieName;
	}
	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public DatabaseServer getDatabaseServer() {
		return databaseServer;
	}
	public void setDatabaseServer(DatabaseServer databaseServer) {
		this.databaseServer = databaseServer;
	}
	

}
