package com.service.impl;

import java.util.List;

import com.bean.Cd;
import com.config.BeanFactory;
import com.dao.ICdDao;
import com.service.ICdService;

public class CdServiceImpl implements ICdService {

	private ICdDao cdDao = (ICdDao) BeanFactory.getBean("cdDao");


	public List<Cd> findAllCd(Integer startIndex,Integer length) throws Exception {return cdDao.findAllCd(startIndex,length);}
	
	public List<Cd> findCanReserveCd() throws Exception {return cdDao.findCanReserveCd();}

	public Cd findCdByNo(String no) throws Exception {return cdDao.findCdByNo(no);}

	public void insertCd(Cd cd) throws Exception {cdDao.insertCd(cd);}

	public void updateCd(String no,Cd cd) throws Exception {cdDao.updateCd(no,cd);}

	public void deleteCdByNo(String no) throws Exception {cdDao.deleteCdByNo(no);}

}
