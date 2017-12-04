package com.bks.service;

import java.util.List;

import com.bks.pojo.PFile;

public interface PFileService {
	void add(PFile file);
	
	void delete(int fid);
	
	PFile findByFid(int fid);
	
	PFile find();
	
	List<PFile> findAllFiles();
}
