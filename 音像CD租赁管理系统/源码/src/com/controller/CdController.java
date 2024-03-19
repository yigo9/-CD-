package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Cd;
import com.bean.Cdshelf;
import com.config.BeanFactory;
import com.service.ICdService;
import com.service.ICdshelfService;

public class CdController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ICdService cdService = (ICdService) BeanFactory.getBean("cdService");
	private ICdshelfService cdshelfService = (ICdshelfService) BeanFactory.getBean("cdshelfService");


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");

		
		if(methodName.equals("findAllCd")) {
					
			try {

				String adminJudge = request.getParameter("admin");

				Integer startIndex = Integer.parseInt(request.getParameter("startIndex"));

				
				
				List<Cd> cds = cdService.findAllCd(startIndex,9);
		

		
				request.getSession().setAttribute("allCd",cds);
				
				if(adminJudge.equals("true")) {
					
					request.getRequestDispatcher("/adminpage/cd/list.jsp").forward(request, response);
					return ;
				}
	
				
				request.getRequestDispatcher("/vippage/cdlist.jsp").forward(request, response);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} else if(methodName.equals("deleteCdByNo")) {
			
			try {
				
				String no = request.getParameter("cdNo");
				cdService.deleteCdByNo(no);
				response.sendRedirect("/cdmanagement/cd/findAllCd?admin=true&startIndex=0");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("findCanReserveCd")) {
			
			try {

				List<Cd> cds = cdService.findCanReserveCd();
				
				request.getSession().setAttribute("canReserveCd",cds);
				
				request.getRequestDispatcher("/vippage/reservecd.jsp").forward(request, response);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} else if(methodName.equals("toEditCdPage")) {
			
			try {

				String originalCdNo = (String) request.getParameter("originalCdNo");
				
				Cd cd = cdService.findCdByNo(originalCdNo);
				
				List<Cdshelf> allCdshelf = cdshelfService.findAllCdshelf();
				
				request.setAttribute("cd",cd);
				request.setAttribute("originalCdNo",originalCdNo);
				request.setAttribute("allCdshelf",allCdshelf);
				
				request.getRequestDispatcher("/adminpage/cd/edit.jsp").forward(request, response);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} else if(methodName.equals("toAddCdPage")) {
			
			try {

				List<Cdshelf> allCdshelf = cdshelfService.findAllCdshelf();
				
				request.setAttribute("allCdshelf",allCdshelf);

				request.getRequestDispatcher("/adminpage/cd/add.jsp").forward(request, response);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findCdByNo")) {
			
			try {
				
				String no = request.getParameter("no");
				Cd cd = cdService.findCdByNo(no);
				System.out.println(cd);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(methodName.equals("insertCd")) {
		
			try {
				System.out.print(request.getParameter("money"));
				String no = request.getParameter("no");
				String name = request.getParameter("name");
				String author = request.getParameter("author");
				Double price = Double.parseDouble(request.getParameter("price"));
				Integer num = Integer.parseInt(request.getParameter("num"));
				String shelf = request.getParameter("shelf");
				String remark = request.getParameter("remark");
				
				cdService.insertCd(new Cd(no,name,author,price,num,shelf,remark));
				
				response.sendRedirect("/cdmanagement/cd/findAllCd?admin=true&startIndex=0");
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		} else if(methodName.equals("updateCd")) {
				
			try {
				
				String originalCdNo = request.getParameter("originalCdNo");
				
				String no = request.getParameter("no");
				String name = request.getParameter("name");
				String author = request.getParameter("author");
				double price = Double.parseDouble(request.getParameter("price"));
				int num = Integer.parseInt(request.getParameter("num"));
				String shelf = request.getParameter("shelf");
				String remark = request.getParameter("remark");
				
				cdService.updateCd(originalCdNo,new Cd(no,name,author,price,num,shelf,remark));
				
				response.sendRedirect("/cdmanagement/cd/findAllCd?admin=true&startIndex=0");
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

}
