package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Cd;
import com.config.DatabaseConnection;
import com.dao.ICdDao;


public class CdDaoImpl implements ICdDao {
	
	
	
	public List<Cd> findAllCd(Integer startIndex,Integer length) throws Exception {
		
		String sql = "select * from cd limit ?,?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, startIndex);
		ps.setInt(2, length);
		
		ResultSet r=ps.executeQuery();
		
		List<Cd> cds=new ArrayList<>();
		
		while(r.next()) {
			
			String no = r.getString(2);
			String name = r.getString(3);
			String author = r.getString(4);
			double price = r.getDouble(5);
			int num = r.getInt(6);
			String shelf = r.getString(7);
			String remark = r.getString(8);
			
			Cd cd = new Cd(no,name,author,price,num,shelf,remark);
			
			cds.add(cd);
			
		}
		
		DatabaseConnection.releaseAll(connection, ps, r);
		return cds;
		
	}
	
	public Cd findCdByNo(String no) throws Exception {
		
		String sql = "select * from cd where Cno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1,no);
		ResultSet r=ps.executeQuery();
		
		r.next();
		
		String cdNo = r.getString(2);
		String name = r.getString(3);
		String author = r.getString(4);
		double price = r.getDouble(5);
		int num = r.getInt(6);
		String shelf = r.getString(7);
		String remark = r.getString(8);
		
		Cd cd = new Cd(cdNo,name,author,price,num,shelf,remark);
		
		
		DatabaseConnection.releaseAll(connection, ps, r);
		
		return cd;
		
	}
	
	public void insertCd(Cd cd) throws Exception {
		
		String sql = "insert into cd(Cno,Cname,Cauthor,Cprice,Cnum,Cshelf,Cremark) values(?,?,?,?,?,?,?)";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,cd.getNo());
		ps.setString(2,cd.getName());
		ps.setString(3,cd.getAuthor());
		ps.setDouble(4, cd.getPrice());
		ps.setInt(5, cd.getNum());
		ps.setString(6,cd.getShelf());
		ps.setString(7,cd.getRemark());
		
		ps.execute();
		
		DatabaseConnection.release(connection, ps);
	}


	public void updateCd(String no,Cd cd) throws Exception {
		
		String sql = "update cd set Cno = ?,Cname = ?,Cauthor = ?,Cprice = ?,Cnum = ? ,Cshelf = ? ,Cremark = ? where Cno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,cd.getNo());
		ps.setString(2,cd.getName());
		ps.setString(3,cd.getAuthor());
		ps.setDouble(4,cd.getPrice());
		ps.setInt(5, cd.getNum());
		ps.setString(6,cd.getShelf());
		ps.setString(7,cd.getRemark());
		ps.setString(8,no);
		
		ps.execute();
		
		DatabaseConnection.release(connection, ps);
		
	}


	public void deleteCdByNo(String no) throws Exception {
		
		String sql = "delete from cd where Cno = ?";
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,no);
		ps.execute();
		
		DatabaseConnection.release(connection, ps);
		
	}


	public List<Cd> findCanReserveCd() throws Exception {


		String sql = " select Cno,Cname,Cauthor,Cprice,Cshelf,type,location "
				   + " from cd "
				   + " left join cdshelf " 
				   + " on no = Cshelf "
				   + " where " 
				   + " Cnum = 0 ";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		
		ResultSet r=ps.executeQuery();
		
		List<Cd> cds=new ArrayList<>();
		
		while(r.next()) {
			
			String no = r.getString(1);
			String name = r.getString(2);
			String author = r.getString(3);
			double price = r.getDouble(4);

			String shelf = r.getString(5);
			String cdType = r.getString(6);
			String cdLocation = r.getString(7);
			
			Cd cd = new Cd(no,name,author,price,shelf,cdType,cdLocation);
			
			cds.add(cd);
		}
		
		DatabaseConnection.releaseAll(connection,ps, r);
		return cds;
		
	}

}
