package com.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.BorrowReturnLog;
import com.bean.Message;
import com.dao.impl.AdminOperationDaoImpl;
import com.dao.impl.BorrowReturnLogDaoImpl;


public class AdminOperationController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findVipBorrowCdByNo")) {
			   
			try {
				   
				Integer vipNo =  Integer.parseInt(request.getParameter("vipNo"));
				
				List<BorrowReturnLog> allBorrowCd = (new AdminOperationDaoImpl()).findVipBorrowCdByNo(vipNo);
				
				
				request.setAttribute("allBorrowCd",allBorrowCd);
		

				request.getRequestDispatcher("/adminpage/onevipborrow.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("findAllVipFineInfo")) {
		   
		try {
			   

			List<BorrowReturnLog> allFineInfo = (new AdminOperationDaoImpl()).findAllVipFineInfo();

			request.setAttribute("allFineInfo",allFineInfo);
			
			request.getRequestDispatcher("/adminpage/allvipfineinfo.jsp").forward(request, response);
				
		} catch (Exception e) {

			e.printStackTrace();
		}
		   
	  } else if(methodName.equals("toUserFeedbackPage")) {
		   
			try {
				  
				List<Message> allMessage = (new BorrowReturnLogDaoImpl()).findAllUserFeedback();

				request.setAttribute("allMessage",allMessage);
				request.getRequestDispatcher("/adminpage/alluserfeedback.jsp").forward(request,response);

					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("toOneConcreteFeedbackPage")) {
		   
			try {
				  
			   	String senderName =  request.getParameter("senderName");
			   	String time =  request.getParameter("time");
			   	String message =  request.getParameter("message");
			   	
				request.setAttribute("senderName",senderName);
				request.setAttribute("time",time);
				request.setAttribute("message",message);
	
				request.getRequestDispatcher("/adminpage/onefeedback.jsp").forward(request, response);

					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("urgeOneUserPayback")) {
		   
			try {
				  
			   	String vipNo =  request.getParameter("vipNo");
			   	
				(new BorrowReturnLogDaoImpl()).insertNotice("admin",vipNo,"好兄弟该还钱啦 !");
	
				response.sendRedirect("/cdmanagement/admin/findAllVipFineInfo");

					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("deleteOneFeedback")) {
		   
			try {
				  
			   	String senderNo =  request.getParameter("senderNo");
			   	
			   	String message = request.getParameter("message");
			   	
				(new BorrowReturnLogDaoImpl()).deleteOneConceteMessage(senderNo, "admin", message);
	
				response.sendRedirect("/cdmanagement/admin/toUserFeedbackPage");

					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   }
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
