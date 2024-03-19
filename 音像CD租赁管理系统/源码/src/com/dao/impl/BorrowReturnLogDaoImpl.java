package com.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.BorrowReturnLog;
import com.bean.Cd;
import com.bean.Message;
import com.config.DatabaseConnection;
import com.dao.IBorrowReturnLogDao;

public class BorrowReturnLogDaoImpl implements IBorrowReturnLogDao {
	
	
	
	@SuppressWarnings("resource")
	public void borrowCd(Integer vipNo,String cdNo) throws Exception{
		
		
		String borrowDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		Connection connection = DatabaseConnection.getConnection();
		
		Cd cd = (new CdDaoImpl()).findCdByNo(cdNo);
		
		int cdNum = cd.getNum();
		
		//添加一条会员租赁CD记录
		
		String sql = "insert into vip_cd_relation(Vno,Cno,time,renew) values(?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		System.out.println(vipNo+" "+cdNo+" "+borrowDate);
		
		ps.setInt(1,vipNo);
		ps.setString(2,cdNo);
		ps.setString(3,borrowDate);
		ps.setInt(4,0);

		
		ps.execute();
		
		//更新所租赁CD的数量
	
		sql = "update CD set Cnum = ? where Cno = ?";
		
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1,cdNum-1);
		ps.setString(2,cdNo);
		
		ps.execute();
		
		//更新会员借CD的关系	
		
		sql = "select * from vip_borrow_relation where Vno =?";
		ps = connection.prepareStatement(sql);
		ps.setInt(1,vipNo);
		

		ResultSet r=ps.executeQuery();

		
		if(r.next()) {
			
			int num = r.getInt(3);

			if(num<7) {
				
				sql = "update vip_borrow_relation set num = ? where Vno = ?";
				ps = connection.prepareStatement(sql);
				ps.setInt(1,num+1);
				ps.setInt(2,vipNo);
				ps.executeUpdate();
				 
			} else {

				sql = "update vip_borrow_relation set num = ?,state = ? where Vno = ?";
				ps = connection.prepareStatement(sql);
				
				ps.setInt(1,num+1);
				ps.setInt(2,0);
				ps.setInt(3,vipNo);
				
				ps.executeUpdate();
				
			}
			
		}
		
		DatabaseConnection.releaseAll(connection, ps, r);
		
	}


	public Integer findUserState(Integer vipNo) throws Exception {
		
		String 	sql = "select * from vip_borrow_relation where Vno = ?";
		PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,vipNo);
		
		ResultSet r = ps.executeQuery();
		
		if(r.next()){
			
			int state = r.getInt(4);
			return state;
		}
		
		
		DatabaseConnection.release(ps, r);
		
		return 0;	
		
	}
	
	public Double findFine(Integer vipNo) throws Exception {
		
		
		String 	sql = "select * from vip_fine_relation where Vno = ?";
		PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,vipNo);
		
		ResultSet r = ps.executeQuery();
		
		if(r.next()) {
			
			double money = r.getDouble(3);
			
			DatabaseConnection.release(ps, r);
			
			return money;
			
		}

		DatabaseConnection.release(ps, r);
		return null;	
		
	}

	public List<BorrowReturnLog> findAllBorrowCd(Integer vipNo) throws Exception {


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



	@SuppressWarnings("resource")
	public void returnCd(Integer vipNo, String cdNo) throws Exception {
		
		int renew;
		String borrowDate;
		String backDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		

		Connection connection = DatabaseConnection.getConnection();
		
		
		
		//删已借CD记录并记录租赁日期
		
		String 	sql = "select time,renew from vip_cd_relation where Vno = ? and Cno = ?";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1,vipNo);
		ps.setString(2,cdNo);
		
		ResultSet r = ps.executeQuery();
		
		r.next();
		
		borrowDate = r.getString(1);
		renew = r.getInt(2);
		
		sql = "delete from vip_cd_relation where Vno = ? and Cno = ?";
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1,vipNo);
		ps.setString(2,cdNo);

		ps.execute();
		
		//更新所借Cd数量
		
		Cd cd = (new CdDaoImpl()).findCdByNo(cdNo);
		
		int cdNum = cd.getNum();
		
		sql = "update cd set Cnum = ? where Cno = ?";
		
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1,cdNum+1);
		ps.setString(2,cdNo);
		
		ps.execute();
		
		//更新个人借Cd状态
		
		sql = "select num , state from vip_borrow_relation where Vno = ?";
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1,vipNo);
		
		r = ps.executeQuery();
		
		r.next();
		
		int num = r.getInt(1);
		int state = r.getInt(2);

		if(num == 8) {
			state = 1;
		} 
		
		num--;
		
		sql = "update vip_borrow_relation set num = ?,state = ? where Vno = ?";
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1,num);
		ps.setInt(2,state);
		ps.setInt(3,vipNo);
		
		ps.executeUpdate();
		
		
		//更新罚款信息
		
		java.sql.Date borrow = java.sql.Date.valueOf(borrowDate);
		
		java.sql.Date back = java.sql.Date.valueOf(backDate);
		
		int duration =(int) ((back.getTime()-borrow.getTime())/(1000*60*60*24));
		
		int fineMoney = 0;
		
		if(renew == 1) {
			
			if(duration > 30) {
				
				fineMoney += duration-30;
			}
			
		} else {
			
			if(duration > 15) {
				
				fineMoney += duration-15;
			}
			
		}
		
		sql = "select Vno , money from vip_fine_relation where Vno = ?";
			
		
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1,vipNo);

		r = ps.executeQuery();
		
		if(r.next()) {
			
			int money = r.getInt(2);
			
			sql = "update vip_fine_relation set money = ? where Vno = ?";
			
			ps = connection.prepareStatement(sql);
			
			ps.setInt(1,money+fineMoney);
			ps.setInt(2,vipNo);
			
			ps.executeUpdate();
			
		} else {
			
			if(fineMoney != 0) {
				
				sql = "insert into vip_fine_relation(Vno,money) values(?,?)";
				
				ps = connection.prepareStatement(sql);
				
				ps.setInt(1,vipNo);
				ps.setInt(2,fineMoney);
				
				ps.execute();
				
			} 
			
		}
		
		DatabaseConnection.releaseAll(connection, ps, r);
		
	}


	public void payForFine(Integer vipNo) throws Exception {
		
		String sql = "update vip_fine_relation set money = 0 where Vno = ? ";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,vipNo);
		
		ps.executeUpdate();
		
		ps.close();
		
	}



	public void renewCd(Integer vipNo, String cdNo) throws Exception {

		String sql = "update vip_cd_relation set renew = 1 where Vno = ? and Cno = ? ";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,vipNo);
		ps.setString(2,cdNo);
		
		ps.executeUpdate();
		
		ps.close();

	}


	public List<BorrowReturnLog> findAllReserveCd(Integer vipNo) throws Exception {

		String sql = " select c.Cno,c.Cname,c.Cauthor,c.Cprice,c.Cnum,v.type,v.location "
				   + " from cd_appointment_relation r "
				   + " left join cd c "
				   + " on r.Cno = c.Cno "
				   + " left join cdshelf v "
				   + " on c.Cshelf = v.no "
				   + " where r.Vno = ? ";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,vipNo);

		ResultSet r = ps.executeQuery();
		
		List<BorrowReturnLog> cds=new ArrayList<>();
		
		while(r.next()) {
	
			String cdNo = r.getString(1);
			String cdname = r.getString(2);
			String author = r.getString(3);
			Double price = r.getDouble(4);
			
			Integer cdNum = r.getInt(5);
			String type = r.getString(6);
			String cdLocation = r.getString(7);
			
			BorrowReturnLog borrowedCd = new BorrowReturnLog(cdNo,cdNum,cdname,author,price,type,cdLocation);
			
			cds.add(borrowedCd);
			
		}
		
		DatabaseConnection.release(ps, r);
		
		return cds;
		
	}


	public void reserveCdByNo(Integer vipNo,String cdNo) throws Exception {

	
		String sql = "insert into cd_appointment_relation(Vno,Cno) values(?,?)";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,vipNo);
		ps.setString(2,cdNo);
		
		ps.execute();
		
		ps.close();
		
	}



	public void cancelReserveCd(Integer vipNo, String cdNo) throws Exception {
		

		String sql = "delete from cd_appointment_relation where Vno = ? and Cno = ?";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,vipNo);
		ps.setString(2,cdNo);
		
		ps.execute();
		
		ps.close();
		
	}



	public List<Message> findMessageByNo(Integer vipNo) throws Exception {
		
		
		String sql = "select sender,receiver,message,time from notice where receiver = ?";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,vipNo);
		

		
		List<Message> messages = new ArrayList<>();
		
		ResultSet r = ps.executeQuery();
		
		while(r.next()) {
			
	
			String sender = r.getString(1);
			String receiver = r.getString(2);
			String message = r.getString(3);
			String time = r.getString(4);

			Message oneMessage = new Message(sender, receiver, message, time);
			
			
			messages.add(oneMessage);

		}
		
		DatabaseConnection.release(ps, r);
		
		return messages;
		
		
	}



	public void initialUserState(Integer vipNo) throws Exception {
		
		String sql = "insert into vip_borrow_relation(Vno,num,state) values(?,0,1)";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,vipNo);
		
		ps.execute();
		
		ps.close();
		
	}



	public void insertNotice(String sender, String receiver, String message) throws Exception {
		
		String sendDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		String sql = "insert into notice(sender,receiver,message,time) values(?,?,?,?)";
		
		PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setString(1,sender);
		ps.setString(2,receiver);
		ps.setString(3,message);
		ps.setString(4,sendDate);
		
		ps.execute();
		
		ps.close();
	}



	public List<Message> findAllUserFeedback() throws Exception {
	

		String sql = " select n.sender,n.receiver,n.message,n.time ,v.Vname,m.Mname,m.Mdept from notice n "
				   + " left join vip v "
				   + " on n.sender = v.Vno "
				   + " left join major m "
				   + " on m.Mname = v.Vmajor "
				   + " where receiver = 'admin' ";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);

		List<Message> messages = new ArrayList<>();
		
		ResultSet r = ps.executeQuery();
		
		while(r.next()) {
			
	
			String sender = r.getString(1);
			String receiver = r.getString(2);
			String message = r.getString(3);
			String time = r.getString(4);
			String senderName = r.getString(5);
			String senderMajor = r.getString(6);
			String senderDepartment = r.getString(7);

			Message oneMessage = new Message(sender, receiver, message, time,senderName,senderMajor,senderDepartment);
			
			
			messages.add(oneMessage);

		}
		
		DatabaseConnection.release(ps, r);
		
		return messages;
	}



	public void deleteOneConceteMessage(String sender, String receiver, String message) throws Exception {
		
		System.out.println(sender+" "+receiver+" "+message);
		
		String sql = "delete from notice where sender = ? and receiver = ? and message = ?";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setString(1,sender);
		ps.setString(2,receiver);
		ps.setString(3,message);
		
		ps.execute();
		
		ps.close();
		
		System.out.println(sender+" "+receiver+" "+message);

	}


}

