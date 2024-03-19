package com.service;

import java.util.List;

import com.bean.Vip;

public interface IVipService {
	
	public List<Vip> findAllVip() throws Exception;
	
	public Vip findVipByNo(Integer no) throws Exception;
	
	public void insertVip(Vip vip) throws Exception;
	
	public void updateVip(Integer no,Vip vip) throws Exception;
	
	public void deleteVipByNo(Integer no) throws Exception;

}
