package com.anz.my.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Project {

	public Project(String projectName,List<GitInfo> gitInfo) {
		this.projectName=projectName;
		this.gitInfo = gitInfo;
	}
	
	@Autowired
	@JsonIgnore
	private String projectName;
	
	@JsonIgnore
	List<GitInfo> gitInfo;

	@JsonAnyGetter
    public Map<String, Object> any() {
        return Collections.singletonMap(projectName, gitInfo);
    }
	
	public List<GitInfo> getGitInfo() {
		return gitInfo;
	}

	public void setGitInfo(List<GitInfo> gitInfo) {
		this.gitInfo = gitInfo;
	}

}
