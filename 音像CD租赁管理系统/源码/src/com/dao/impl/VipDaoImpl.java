package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Vip;
import com.config.DatabaseConnection;
import com.dao.IVipDao;


public class VipDaoImpl implements IVipDao {

	public List<Vip> findAllVip() throws Exception {

		String sql = "select * from Vip";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet r=ps.executeQuery();
		
		List<Vip> vips=new ArrayList<>();
		
		while(r.next()) {
			
			int no = r.getInt(2);
			String name = r.getString(3);
			int age = r.getInt(4);
			String sex = r.getString(5);
			String telephone = r.getString(6);
			String major = r.getString(7);
			
			Vip vip = new Vip(no,name, age, sex, telephone,major);
			
			vips.add(vip);
			
		}
		
		DatabaseConnection.releaseAll(connection,ps, r);
		return vips;
	}


	public Vip findVipByNo(Integer no) throws Exception {

		String sql = "select * from vip where Vno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1,no);
		ResultSet r=ps.executeQuery();
		
	
		if(r.next()) {
		
			int vipNo = r.getInt(2);
			String name = r.getString(3);
			int age = r.getInt(4);
			String sex = r.getString(5);
			String telephone = r.getString(6);
			String major = r.getString(7);
			
			Vip vip = new Vip(vipNo,name, age, sex, telephone,major);
			
			return vip;
		
		}
		
		DatabaseConnection.releaseAll(connection,ps, r);
		
		return null;
		
	}


	public void insertVip(Vip vip) throws Exception {

		String sql = "insert into vip(Vno,Vname,Vage,Vsex,Vtel,Vmajor) values(?,?,?,?,?,?)";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1,vip.getNo());
		ps.setString(2,vip.getName());
		ps.setInt(3,vip.getAge());
		ps.setString(4,vip.getSex());
		ps.setString(5,vip.getTelephone());
		ps.setString(6,vip.getMajor());
		
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}


	public void updateVip(Integer no,Vip vip) throws Exception {

		String sql = "update vip set Vno = ?,Vname = ?,Vage = ?,Vsex = ?,Vtel = ?,Vmajor = ? where Vno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1,vip.getNo());
		ps.setString(2,vip.getName());
		ps.setInt(3,vip.getAge());
		ps.setString(4,vip.getSex());
		ps.setString(5,vip.getTelephone());
		ps.setString(6,vip.getMajor());
		ps.setInt(7,no);
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}


	public void deleteVipByNo(Integer no) throws Exception {
		
		String sql = "delete from vip where Vno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1,no);
		ps.execute();
		
		DatabaseConnection.release(connection,ps);

	}

}
