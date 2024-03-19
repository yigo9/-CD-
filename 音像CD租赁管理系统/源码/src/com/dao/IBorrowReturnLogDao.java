package com.dao;

import java.util.List;

import com.bean.BorrowReturnLog;
import com.bean.Message;

public interface IBorrowReturnLogDao {
	
	public void borrowCd(Integer vipNo,String cdNo) throws Exception;

	public Integer findUserState(Integer vip) throws Exception;
	
	public Double findFine(Integer vipNo) throws Exception;
	
	public List<BorrowReturnLog> findAllReserveCd(Integer vipNo) throws Exception;
	
	public List<BorrowReturnLog> findAllBorrowCd(Integer vipNo) throws Exception;
	
	public void returnCd(Integer vipNo,String cdNo) throws Exception;
	
	public void payForFine(Integer vipNo) throws Exception;
	
	public void renewCd(Integer vipNo,String cdNo) throws Exception;
	
	public void reserveCdByNo(Integer vipNo,String cdNo) throws Exception;
	
	public void cancelReserveCd(Integer vipNo,String cdNo) throws Exception;
	
	public List<Message> findMessageByNo(Integer vipNo) throws Exception;
	
	public void initialUserState(Integer vipNo) throws Exception;
	
	public void insertNotice(String sender,String receiver,String message) throws Exception;
	
	public List<Message> findAllUserFeedback() throws Exception;
	
	public void deleteOneConceteMessage(String sender,String receiver,String message) throws Exception;

}

