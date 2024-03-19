package com.dao;

import java.util.List;

import com.bean.Cd;

public interface ICdDao {
	
	public List<Cd> findAllCd(Integer startIndex,Integer length) throws Exception;
	
	public List<Cd> findCanReserveCd() throws Exception;
	
	public Cd findCdByNo(String no) throws Exception;
	
	public void insertCd(Cd cd) throws Exception;
	
	public void updateCd(String no,Cd cd) throws Exception;
	
	public void deleteCdByNo(String no) throws Exception;

}
