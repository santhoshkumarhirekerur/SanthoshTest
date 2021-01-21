package com.anz.my.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anz.my.model.GitInfo;
import com.anz.my.model.Project;

@RestController
public class GitInfoController {

	@Autowired
	BuildProperties buildProperties;

	@Value("${git.commit.id}")
	private String commitId;
	
	@Value("${git.commit.message.short}")
	private String message;
	
	@GetMapping("/version")
	public Project getVersionInfo() {
		
		List<GitInfo> gitInfo = new ArrayList<GitInfo>();
		gitInfo.add(new GitInfo(buildProperties.getVersion(), commitId, message));
		
		Project project = new Project(buildProperties.getName(),gitInfo);
		 
		
		return project;
	}

}
