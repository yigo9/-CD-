package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Major;
import com.bean.Vip;
import com.config.BeanFactory;
import com.service.IMajorService;
import com.service.IVipService;


public class VipController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IVipService vipService = (IVipService) BeanFactory.getBean("vipService");
	private IMajorService majorService = (IMajorService) BeanFactory.getBean("majorService");
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findAllVip")) {
			
			try {

				List<Vip> vips = vipService.findAllVip ();
				
				request.setAttribute("allVip",vips);
				
				request.getRequestDispatcher("/adminpage/vip/list.jsp").forward(request, response);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} else if(methodName.equals("deleteVipByNo")) {
			
			try {
				
				Integer no = Integer.parseInt(request.getParameter("vipNo"));
				vipService.deleteVipByNo(no);

				response.sendRedirect("/cdmanagement/vip/findAllVip");
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("toEditVipPage")) {
			
			try {

				Integer originalVipNo = Integer.valueOf(request.getParameter("originalVipNo"));
				
				Vip vip = vipService.findVipByNo(originalVipNo);
				
				request.setAttribute("vip",vip);
				request.setAttribute("originalVipNo",originalVipNo);
				
				List<Major> majors = majorService.findAllMajor();
				
				
				request.setAttribute("allMajor",majors);
				
				request.getRequestDispatcher("/adminpage/vip/edit.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("toAddVipPage")) {
			
			try {
				
				
				List<Major> majors = majorService.findAllMajor();
				
				request.setAttribute("allMajor",majors);
				
				request.getRequestDispatcher("/adminpage/vip/add.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findVipByNo")) {
			
			Integer no = Integer.parseInt(request.getParameter("no"));
			
			try {
				
				Vip vip = vipService.findVipByNo(no);
				System.out.println(vip);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("insertVip")) {
			
			try {
				
				Integer vipNo = Integer.parseInt(request.getParameter("no"));
				String name = request.getParameter("name");
				Integer age = Integer.parseInt(request.getParameter("age"));
				String sex = request.getParameter("sex");
				String tel = request.getParameter("tel");
				String major = request.getParameter("major");	
				

				Vip vip = new Vip(vipNo, name, age, sex, tel, major);
				
				vipService.insertVip(vip);
				
				response.sendRedirect("/cdmanagement/vip/findAllVip");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("updateVip")) {
			
			try {
				
				Integer originalVipNo = Integer.parseInt(request.getParameter("originalVipNo"));
				
				Integer vipNo = Integer.parseInt(request.getParameter("no"));
				String name = request.getParameter("name");
				Integer age = Integer.parseInt(request.getParameter("age"));
				String sex = request.getParameter("sex");
				String tel = request.getParameter("tel");
				String major = request.getParameter("major");	
				
				Vip vip = new Vip(vipNo, name, age, sex, tel, major);
				
				vipService.updateVip (originalVipNo, vip);
				
				response.sendRedirect("/cdmanagement/vip/findAllVip");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
