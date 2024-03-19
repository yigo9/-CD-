package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Cdshelf;
import com.config.BeanFactory;
import com.service.ICdshelfService;



public class CdshelfController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ICdshelfService cdshelfService = (ICdshelfService) BeanFactory.getBean("cdshelfService");

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findAllCdshelf")) {
			
			try {

				List<Cdshelf> cdshelfs = cdshelfService.findAllCdshelf();
				
				request.setAttribute("allCdshelf",cdshelfs);
				
				request.getRequestDispatcher("/adminpage/cdshelf/list.jsp").forward(request, response);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} else if(methodName.equals("deleteCdshelfByNo")) {
		
			
			try {
				
				String no = request.getParameter("cdshelfNo");
				cdshelfService.deleteCdshelfByNo(no);
				response.sendRedirect("/cdmanagement/cdshelf/findAllCdshelf");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("toEditCdshelfPage")) {

			try {
				
				String originalCdshelfNo = request.getParameter("originalCdshelfNo");
				
				Cdshelf cdshelf = cdshelfService.findCdshelfByNo(originalCdshelfNo);
				
				request.setAttribute("cdshelf",cdshelf);
				request.setAttribute("originalCdshelfNo",originalCdshelfNo);
				
				request.getRequestDispatcher("/adminpage/cdshelf/edit.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("toAddCdshelfPage")) {
			
			try {

				request.getRequestDispatcher("/adminpage/cdshelf/add.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findCdshelfByNo")) {
			
			try {
				
				String no = request.getParameter("no");
				
				Cdshelf cdshelf = cdshelfService.findCdshelfByNo(no);
				System.out.println(cdshelf);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("insertCdshelf")) {

			
			try {
				
				String no = request.getParameter("no");
				String area = request.getParameter("area");
				String location = request.getParameter("location");
				String type = request.getParameter("type");
				String remark = request.getParameter("remark");
				
				cdshelfService.insertCdshelf(new Cdshelf(no, area, location, type, remark));
				
				response.sendRedirect("/cdmanagement/cdshelf/findAllCdshelf");
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		} else if(methodName.equals("updateCdshelf")) {
			
			try {
				
				String originalCdshelfNo = request.getParameter("originalCdshelfNo");
				
				String no = request.getParameter("no");
				String area = request.getParameter("area");
				String location = request.getParameter("location");
				String type = request.getParameter("type");
				String remark = request.getParameter("remark");
				
				cdshelfService.updateCdshelf(originalCdshelfNo,new Cdshelf(no, area, location, type, remark));
				
				response.sendRedirect("/cdmanagement/cdshelf/findAllCdshelf");
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		
		} else if(methodName.equals("insertCdshelf")) {
			
			try {
				
				String no = request.getParameter("no");
				String area = request.getParameter("area");
				String location = request.getParameter("location");
				String type = request.getParameter("type");
				String remark = request.getParameter("remark");
				
				cdshelfService.insertCdshelf(new Cdshelf(no, area, location, type, remark));
					
				response.sendRedirect("/cdmanagement/cdshelf/findAllCdshelf");
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		
		}
	}

}
