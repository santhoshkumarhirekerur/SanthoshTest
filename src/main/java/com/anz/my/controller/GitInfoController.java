package com.anz.my.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anz.my.model.GitInfo;

@RestController
public class GitInfoController {

	@Autowired
	BuildProperties buildProperties;

	@Value("${git.commit.id}")
	private String commitId;
	
	@Value("${git.commit.message.short}")
	private String message;
	
	@GetMapping("/version")
	public GitInfo getVersionInfo() {
		return new GitInfo(buildProperties.getVersion(), commitId, message);
	}

}
