package com.dao;

import java.util.List;

import com.bean.Cdshelf;

public interface ICdshelfDao {
	
	public List<Cdshelf> findAllCdshelf() throws Exception;
	
	public Cdshelf findCdshelfByNo(String no) throws Exception;
	
	public void insertCdshelf(Cdshelf cdshelf) throws Exception;
	
	public void updateCdshelf(String no,Cdshelf cdshelf) throws Exception;
	
	public void deleteCdshelfByNo(String no) throws Exception;

}
