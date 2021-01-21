package com.anz.my.controller;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anz.my.model.GitInfo;

@RestController
public class GitInfoController {

	@Autowired
	BuildProperties buildProperties;
	
	//@Value("${GIT_URL}")
	String GIT_URL;
	
	//@Value("${GIT_DIR}")
	String GIT_DIR;
	
	
	@GetMapping("/version")
	public GitInfo getVersionInfo() throws InvalidRemoteException, TransportException, GitAPIException {

		/*
		 * File directory = new File(GIT_DIR); Git repository =
		 * Git.cloneRepository().setURI(GIT_URL).setDirectory(directory).call();
		 * RevCommit latestCommit =
		 * repository.log().setMaxCount(1).call().iterator().next();
		 */
		
		
		return new GitInfo(buildProperties.getVersion(), "test", "test");
	}

}
