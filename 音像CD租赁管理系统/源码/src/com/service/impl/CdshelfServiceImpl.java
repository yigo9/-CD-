package com.service.impl;

import java.util.List;

import com.bean.Cdshelf;
import com.config.BeanFactory;
import com.dao.ICdshelfDao;
import com.service.ICdshelfService;

public class CdshelfServiceImpl implements ICdshelfService {

	private ICdshelfDao cdshelfDao =  (ICdshelfDao) BeanFactory.getBean("cdshelfDao");

	
	
	public List<Cdshelf> findAllCdshelf() throws Exception {return cdshelfDao.findAllCdshelf();}

	public Cdshelf findCdshelfByNo(String no) throws Exception{ return cdshelfDao.findCdshelfByNo(no);}

	public void insertCdshelf(Cdshelf cdshelf) throws Exception {	cdshelfDao.insertCdshelf(cdshelf);}

	public void updateCdshelf(String no,Cdshelf cdshelf) throws Exception {cdshelfDao.updateCdshelf(no,cdshelf);}

	public void deleteCdshelfByNo(String no) throws Exception {	cdshelfDao.deleteCdshelfByNo(no);}

}
