package com.dao;

import java.util.List;

import com.bean.BorrowReturnLog;

public interface IAdminOperationDao {
	
	public List<BorrowReturnLog> findVipBorrowCdByNo(Integer vipNo) throws Exception;
	
	public List<BorrowReturnLog> findAllVipFineInfo() throws Exception;
}
