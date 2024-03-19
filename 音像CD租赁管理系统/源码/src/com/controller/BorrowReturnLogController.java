package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BorrowReturnLog;
import com.bean.Message;
import com.bean.User;
import com.config.BeanFactory;
import com.dao.IBorrowReturnLogDao;
import com.dao.impl.BorrowReturnLogDaoImpl;
import com.service.IUserService;


public class BorrowReturnLogController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	private IUserService userService = (IUserService) BeanFactory.getBean("userService");
  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("borrowCdByNo")) {
			
			try {
			
				
				int vipNo =  (int) request.getSession().getAttribute("vipNo");

				int vipState = (new BorrowReturnLogDaoImpl()).findUserState(vipNo);
				
				
				if(vipState==1) {
					
					String cdNo = request.getParameter("cdNo");
							
						(new BorrowReturnLogDaoImpl()).borrowCd(vipNo,cdNo);
						
						response.sendRedirect("/cdmanagement/cd/findAllCd?admin=false&startIndex=0");
								
					
				} else {
					
					request.getSession().setAttribute("message","您的租用CD数量已达上限，请先还CD");
					request.getRequestDispatcher("/vippage/cdlist.jsp").forward(request, response);
					
				}
				
			 } catch (Exception e) {
				
				e.printStackTrace();
			}

	   } else if(methodName.equals("findFine")) {
			
			
		   		int vipNo =  (int) request.getSession().getAttribute("vipNo");
		   
			   try {
				   
				Double money = (new BorrowReturnLogDaoImpl()).findFine(vipNo);
				
				
				if(money == null || money == 0) {

					request.setAttribute("fineMessage","您当前没有任何待还罚款");
					request.getRequestDispatcher("/vippage/finemessage.jsp").forward(request, response);
					
				} else {

					request.setAttribute("fineMoney",money);
					request.getRequestDispatcher("/vippage/finemessage.jsp").forward(request, response);
					
				}
				
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("findAllBorrowCd")) {
		   
		   
		   	int vipNo =  (int) request.getSession().getAttribute("vipNo");
		   
			try {
				   
				List<BorrowReturnLog> allBorrowCd = (new BorrowReturnLogDaoImpl()).findAllBorrowCd(vipNo);
		
				request.getSession().setAttribute("allBorrowCd",allBorrowCd);
				request.getRequestDispatcher("/vippage/allborrowcd.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("returnCd")) {
		   
			try {
				   
			   	int vipNo =  (int) request.getSession().getAttribute("vipNo");
				String cdNo =  (String) request.getParameter("cdNo");
				
				(new BorrowReturnLogDaoImpl()).returnCd(vipNo, cdNo);
				
			
				response.sendRedirect("/cdmanagement/log/findAllBorrowCd");
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("payForFine")) {
		   
			try {
				  
			   	int vipNo =  (int) request.getSession().getAttribute("vipNo");
			   	
				(new BorrowReturnLogDaoImpl()).payForFine(vipNo);
				
				request.getSession().removeAttribute("fineMoney");
				response.sendRedirect("/cdmanagement/log/findFine");
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("renewCd")) {
		   
			try {
				  
			   	int vipNo =  (int) request.getSession().getAttribute("vipNo");
				String cdNo =  (String) request.getParameter("cdNo");
				
				(new BorrowReturnLogDaoImpl()).renewCd(vipNo, cdNo);

				response.sendRedirect("/cdmanagement/log/findAllBorrowCd");
	
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("findAllReserveCd")) {
		   
			try {
				  
			   	int vipNo =  (int) request.getSession().getAttribute("vipNo");
				
				List<BorrowReturnLog> allReserveCd = (new BorrowReturnLogDaoImpl()).findAllReserveCd(vipNo);
				request.getSession().setAttribute("allReserveCd",allReserveCd);

				request.getRequestDispatcher("/vippage/allreservecd.jsp").forward(request, response);
	
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("reserveCdByNo")) {
		   
			try {
				  
			   	int vipNo =  (int) request.getSession().getAttribute("vipNo");
			   	
				String cdNo =  (String) request.getParameter("cdNo");
				
				(new BorrowReturnLogDaoImpl()).reserveCdByNo(vipNo, cdNo);

				response.sendRedirect("/cdmanagement/cd/findCanReserveCd");
	
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("cancelReserveCd")) {
		   
			try {
				  
			   	int vipNo =  (int) request.getSession().getAttribute("vipNo");
			   	
				String cdNo =  (String) request.getParameter("cdNo");
				
				(new BorrowReturnLogDaoImpl()).cancelReserveCd(vipNo, cdNo);
	
				response.sendRedirect("/cdmanagement/log/findAllReserveCd");
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("findAllMessage")) {
		   
			try {
				  
			   	int vipNo =  (int) request.getSession().getAttribute("vipNo");
			   	
				
				List<Message> allMessage = (new BorrowReturnLogDaoImpl()).findMessageByNo(vipNo);
				
				request.setAttribute("allMessage",allMessage);
	
				request.getRequestDispatcher("/vippage/allmessage.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("toOneConcreteMessage")) {
		   
			try {
				  
			   	String sender =  request.getParameter("sender");
			   	String time =  request.getParameter("time");
			   	String message =  request.getParameter("message");
			   	
				request.setAttribute("sender",sender);
				request.setAttribute("time",time);
				request.setAttribute("message",message);
	
				request.getRequestDispatcher("/vippage/onemessage.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("toSendLetterPage")) {
		   
			try {

				request.getRequestDispatcher("/vippage/sendletter.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("toSystemFeedbackPage")) {
		   
			try {
				 
				request.getRequestDispatcher("/vippage/systemfeedback.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("deleteOneConcreteMessage")) {
		   
			try {
				
				String sender = (String) request.getParameter("sender");
				String receiverNo = String.valueOf(request.getSession().getAttribute("vipNo"));
				String message = (String) request.getParameter("message");
				
				(new BorrowReturnLogDaoImpl()).deleteOneConceteMessage(sender, receiverNo, message);
				
				response.sendRedirect("/cdmanagement/log/findAllMessage");
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("toEditPasswordPage")) {
		   
			try {
				
				request.getRequestDispatcher("/vippage/editpassword.jsp").forward(request, response);;
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } 
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("insertNotice")) {

			try {
				
			   	String sender = Integer.toString((Integer) request.getSession().getAttribute("vipNo"));
			   	
			   	String receiver = request.getParameter("no");
			   	
			   	String message = request.getParameter("message");
				   
		
				(new BorrowReturnLogDaoImpl()).insertNotice(sender, receiver, message);
				
				request.setAttribute("success","success");
				request.getRequestDispatcher("/vippage/sendletter.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("insertSystemFeedbackNotice")) {

			try {
				
			   	String sender = Integer.toString((Integer) request.getSession().getAttribute("vipNo"));
			   	
			   	String receiver = "admin";
			   	
			   	String message = request.getParameter("message");
				   

		
				(new BorrowReturnLogDaoImpl()).insertNotice(sender, receiver, message);
				
				request.setAttribute("success","success");
				request.getRequestDispatcher("/vippage/systemfeedback.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("insertSystemNotice")) {

			try {
				
				IBorrowReturnLogDao log = new BorrowReturnLogDaoImpl();
			   	
			   	
			   	String sender = "admin";
			   	
			   	String message = request.getParameter("message");
				   
			   	List<User> allUser = userService.findAllUser();
			   	

			   	
			   	for(User user: allUser) {
			   		
			   		String vipNo = String.valueOf(user.getVipNo());
			   		log.insertNotice(sender,vipNo,message);
			   	}
			   	
	
				request.setAttribute("success","success");
				request.getRequestDispatcher("/adminpage/givenotice.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   }
	}

}

