package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MembershipDAO;
import Entity.Membership;
import Service.MembershipServiceImpl;

@WebServlet("/MemberShip")
public class MemberShip extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		res.setContentType("text/html; charset=UTF-8");		
		PrintWriter out = res.getWriter();
		String action = req.getParameter("action");

		System.out.println(action);
		
		//會員登入
		if(action.equals("membership_LogIn")) {
			
			String name = req.getParameter("name");
			String password = req.getParameter("Password");
			System.out.println(name);
			
			
			//帳號驗證：過濾無輸入及空格
			if("".equals(name) && "".equals(name.trim()))
				out.println("請輸入帳號");
			
			//密碼驗證：過濾無輸入及空格
			if("".equals(password) && "".equals(password.trim())) {
				out.println("請輸入密碼");
				accountCheck(name);
			}
				
			
			
			//用account來驗證是否有帳號跟密碼，以及帳號密碼是否正確：service未寫，DAO的account寫完，不知道對不對
			 
			
		}
			
	/*		if(name == null || password == null) {//不會有null
				out.println("請輸入帳密111喔!");
			} 
			
			//帳號密碼驗證：過濾輸入空格
			if ("".equals(name.trim()) || "".equals(password.trim())) {
				out.println("請輸入帳密喔!");
			} 
			
			//帳號密碼驗證：驗證為administrator，帳密正確進入，轉跳administer_function.jsp
			if (name.equals("administrator") && password.equals("administrator")) { // todo
				System.out.println("帳密正確，進入");
				
				HttpSession session = req.getSession();
		        session.setAttribute("name", name); 
				
		        String user = (String)session.getAttribute("name");// todo
		        System.out.println("我是session：" + user);
				
				String url = "/administer_function.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, res);
						
			}
			
			//如果帳號，密碼不等於"administrator"，就是一般使用戶的登入
			if(name != "administrator" || password != "administrator") { // todo
				
				MembershipDAO memDAO = new MembershipDAO();
				Membership list = memDAO.logInFromAccount(name); // todo
				System.out.println(list);
				String memAccount = list.getAccount();
				String memPassword = list.getPassword();
				System.out.println("輸入的account是：" + name + "密碼是：" + password);	
				System.out.println("這是用account登入 ，我抓到的account是：" + memAccount + "密碼是：" + memPassword);
				
				if(name.equals(memAccount) && password.equals(memPassword)) {
					System.out.println("帳密正確，進入");
					
					HttpSession session = req.getSession();
			        session.setAttribute("name", memAccount); 
					
			        String user = (String)session.getAttribute("name");// todo
			        System.out.println("我是session：" + user);
			        
			        req.setAttribute("mem", list); 
			        
			        String url = "/oneMember.jsp";
					RequestDispatcher rd = req.getRequestDispatcher(url);
					rd.forward(req, res);
				}
				
			}else {
				out.println("帳號或密碼不對喔!"); // todo
			}							
		}
		
		*/
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

	//確認帳號是否存在
	private String accountCheck(String account) {
		MembershipServiceImpl membershipService = new MembershipServiceImpl();		
		String password = membershipService.selectOne(account).getPassword();
		System.out.println(password);
			return password;
		}
	}
	
	

