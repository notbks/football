package com.bks.mapper;

import java.util.List;

import com.bks.pojo.PFile;

public interface PFileMapper {
	public void add(PFile file);
	public void delete(int fid);
	public PFile findByFid(int fid);
	public PFile find();
	public List<PFile> findAllFiles();
}
