package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Cdshelf;
import com.config.DatabaseConnection;
import com.dao.ICdshelfDao;


public class CdshelfDaoImpl implements ICdshelfDao {


	public List<Cdshelf> findAllCdshelf() throws Exception {
		
		String sql = "select * from cdshelf";
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet r=ps.executeQuery();
		
		List<Cdshelf> cdshelfs=new ArrayList<>();
		
		while(r.next()) {
			
			String no = r.getString(2);
			String area = r.getString(3);
			String location = r.getString(4);
			String type = r.getString(5);
			String remark = r.getString(6);
			
			Cdshelf cdshelf = new Cdshelf(no, area, location, type, remark);
			
			cdshelfs.add(cdshelf);
		}
		
		DatabaseConnection.releaseAll(connection,ps, r);
		return cdshelfs;

	}


	public Cdshelf findCdshelfByNo(String no) throws Exception {
		
		
		String sql = "select * from cdshelf where no = ?";
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1,no);
		ResultSet r=ps.executeQuery();
		
		if(r.next()) {
			
			String cdshelfNo = r.getString(2);
			String area = r.getString(3);
			String location = r.getString(4);
			String type = r.getString(5);
			String remark = r.getString(6);
			
			Cdshelf cdshelf = new Cdshelf(cdshelfNo,area,location,type,remark);
			
			DatabaseConnection.releaseAll(connection,ps, r);
			
			return cdshelf;
		}

		DatabaseConnection.releaseAll(connection,ps, r);
		
		return null;

	}


	public void insertCdshelf(Cdshelf cdshelf) throws Exception {

		String sql = "insert into cdshelf(no,area,location,type,remark) values(?,?,?,?,?)";
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,cdshelf.getNo());
		ps.setString(2,cdshelf.getArea());
		ps.setString(3,cdshelf.getLocation());
		ps.setString(4,cdshelf.getType());
		ps.setString(5,cdshelf.getRemark());
		
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}


	public void updateCdshelf(String no,Cdshelf cdshelf) throws Exception {

		String sql = "update cdshelf set no = ?,area = ?,location = ?,type = ?,remark = ? where no = ?";
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,cdshelf.getNo());
		ps.setString(2,cdshelf.getArea());
		ps.setString(3,cdshelf.getLocation());
		ps.setString(4,cdshelf.getType());
		ps.setString(5,cdshelf.getRemark());
		ps.setString(6,no);
		
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}


	public void deleteCdshelfByNo(String no) throws Exception {

		String sql = "delete from cdshelf where no = ?";
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,no);
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}


}
