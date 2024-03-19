package com.service.impl;

import java.util.List;

import com.bean.Vip;
import com.config.BeanFactory;
import com.dao.IVipDao;
import com.service.IVipService;

public class VipServiceImpl implements IVipService {

	private IVipDao vipDao =  (IVipDao) BeanFactory.getBean("vipDao");


	public List<Vip> findAllVip() throws Exception {return vipDao.findAllVip();}

	public Vip findVipByNo(Integer no) throws Exception {return vipDao.findVipByNo(no);}

	public void insertVip(Vip vip) throws Exception {vipDao.insertVip(vip);}

	public void updateVip(Integer no,Vip vip) throws Exception {vipDao.updateVip(no,vip);	}

	public void deleteVipByNo(Integer no) throws Exception {vipDao.deleteVipByNo(no);	}
}
