package com.bks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bks.mapper.PFileMapper;
import com.bks.pojo.PFile;
import com.bks.service.PFileService;

@Service
public class PFileServiceImpl implements PFileService {
	
	@Autowired
	PFileMapper pfileMapper;
	
	public void add(PFile file) {
		pfileMapper.add(file);
	}

	public void delete(int fid) {
		pfileMapper.delete(fid);
	}

	public PFile findByFid(int fid) {
		return pfileMapper.findByFid(fid);
	}

	public PFile find() {
		return pfileMapper.find();
	}

	public List<PFile> findAllFiles() {
		return pfileMapper.findAllFiles();
	}

}
