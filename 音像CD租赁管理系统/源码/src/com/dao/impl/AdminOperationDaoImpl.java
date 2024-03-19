package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bean.BorrowReturnLog;
import com.config.DatabaseConnection;
import com.dao.IAdminOperationDao;

public class AdminOperationDaoImpl implements IAdminOperationDao {


	public List<BorrowReturnLog> findVipBorrowCdByNo(Integer vipNo) throws Exception {
		
		String 	sql = " select r.Cno,c.Cname,c.Cauthor,c.Cprice,r.time,v.type,v.location,r.renew "
				+ " from vip_cd_relation r "
				+ " left join cd c "
				+ " on r.Cno = c.Cno "
				+ " left join cdshelf v "
				+ " on c.Cshelf = v.no "
				+ " where Vno = ? " ;
	
		PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,vipNo);
		
		ResultSet r = ps.executeQuery();
		
		List<BorrowReturnLog> cds=new ArrayList<>();
		
		while(r.next()) {
			
	
			String cdNo = r.getString(1);
			String cdname = r.getString(2);
			String author = r.getString(3);
			Double price = r.getDouble(4);
			String borrowTime = r.getString(5);
			String type = r.getString(6);
			String cdLocation = r.getString(7);
			Integer renew = r.getInt(8);
			
			java.sql.Date borrowDate = java.sql.Date.valueOf(borrowTime);
			
			java.sql.Date backDate = new java.sql.Date(borrowDate.getTime()+(renew+1)*15*24*60*60*1000L);
			
			String backTime = new SimpleDateFormat("yyyy-MM-dd").format(backDate);
			
			BorrowReturnLog borrowedCd = new BorrowReturnLog(cdNo,cdname,author,price,borrowTime,backTime,type,cdLocation,renew);
			
			cds.add(borrowedCd);
			
		}
		
		DatabaseConnection.release(ps, r);
		
		return cds;
	}


	public List<BorrowReturnLog> findAllVipFineInfo() throws Exception {
		
		
		String sql = " select r.Vno,v.Vname,v.Vage,v.Vsex,v.Vtel,v.Vmajor,r.money "
				   + " from vip_fine_relation r "
				   + " left join vip v "
				   + " on v.Vno = r.Vno " ;
		
		PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
		
		ResultSet r = ps.executeQuery();
		
		List<BorrowReturnLog> allFineInfo = new ArrayList<>();
		
		while(r.next()) {
			
	
			Integer vipNo = r.getInt(1);
			String vipName = r.getString(2);
			Integer vipAge = r.getInt(3);
			String vipSex = r.getString(4);
			String vipTelephone = r.getString(5);
			String vipMajor = r.getString(6);
	
			Double fineMoney = r.getDouble(7);
		
			
			BorrowReturnLog fineInfo = new BorrowReturnLog(vipNo,vipName,vipAge,vipSex,vipTelephone,vipMajor,fineMoney);
			
			allFineInfo.add(fineInfo);
		}
		
		DatabaseConnection.release(ps, r);
		
		return allFineInfo;
		
	}

}
