package com.anz.my.model;

public class GitInfo {
	
	
	private  String version;
	private  String lastcommitsha;
	private  String description;
	
	
	public GitInfo(String version, String lastcommitsha, String description) {
		super();
		this.version = version;
		this.lastcommitsha = lastcommitsha;
		this.description = description;
	}
	
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getLastcommitsha() {
		return lastcommitsha;
	}
	public void setLastcommitsha(String lastcommitsha) {
		this.lastcommitsha = lastcommitsha;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}