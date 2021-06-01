package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MembershipDAO;
import Entity.Membership;
import Service.IMembershipService;
import Service.MembershipServiceImpl;



@WebServlet("/Administrator")
public class Administrator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Administrator() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html; charset=UTF-8");		
		PrintWriter out = res.getWriter();
		String action = req.getParameter("action");

		System.out.println(action);
		
		//這個是"管理員"登入的code
		if(action.equals("log_in")) {
			
			String name = req.getParameter("name");
			String password = req.getParameter("Password");

			//帳號密碼驗證：過濾無輸入
			if(name == null || password == null) {
				out.println("請輸入帳密喔!");
			} 
			
			//帳號密碼驗證：過濾輸入空格
			if ("".equals(name.trim()) || "".equals(password.trim())) {
				out.println("請輸入帳密喔!");
			} 
			
			//帳號密碼驗證：驗證為administrator，帳密正確進入，轉跳administer_function.jsp
			if (name.equals("administrator") && password.equals("administrator")) {
				System.out.println("帳密正確，進入");
				
				HttpSession session = req.getSession();
		        session.setAttribute("name", name); 
				
		        String user = (String)session.getAttribute("name");
		        System.out.println("我是session：" + user);
				
				String url = "/administer_function.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, res);
						
			}
			
			//如果帳號，密碼不等於"administrator"，就是一般使用戶的登入
			if(name != "administrator" || password != "administrator") {
				
				MembershipDAO memDAO = new MembershipDAO();
				List<Membership> list = memDAO.logInFromAccount(name);
				System.out.println(list);
				String memAccount = list.get(0).getAccount();
				String memPassword = list.get(0).getPassword();
				System.out.println("輸入的account是：" + name + "密碼是：" + password);	
				System.out.println("這是用account登入 ，我抓到的account是：" + memAccount + "密碼是：" + memPassword);
				
				if(name.equals(memAccount) && password.equals(memPassword)) {
					System.out.println("帳密正確，進入");
					
					HttpSession session = req.getSession();
			        session.setAttribute("name", memAccount); 
					
			        String user = (String)session.getAttribute("name");
			        System.out.println("我是session：" + user);
			        
			        req.setAttribute("mem", list); 
			        
			        String url = "/oneMember.jsp";
					RequestDispatcher rd = req.getRequestDispatcher(url);
					rd.forward(req, res);
				}
				
			}else {
				out.println("帳號或密碼不對喔!");
			}							
		}
		
		
		//這個是管理員的功能之一：查詢全部會員
		if(action.equals("select_all")) {
			MembershipDAO mem = new MembershipDAO();
			List<Membership> list = mem.selectAll();
			
			req.setAttribute("list", list);
			System.out.println("我是select_all的jsp");
			out.print("這個是controller跳出來的list" + list);
			String url = "/administer_function.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		
		}
		
		//這個是管理員的功能之一：查詢單一會員
		if(action.equals("check_OneMember")) {
			String id = (String)req.getParameter("id");
			
			System.out.println("id是："+id);
			MembershipDAO mem = new MembershipDAO();
			List<Membership> oneMember = mem.selectOneMember(id);
			System.out.println("這是查詢單一會員的Membership =" + oneMember);
			
			req.setAttribute("mem", oneMember); 
	        
			String url = "/oneMember.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
			
		}
		
		//新會員註冊
		if(action.equals("Sign_in")) {
			String url = "/addMemberShip.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}
		

		//data from addMembership.jsp；資料由註冊頁面傳入
		if(action.equals("insert")) {
			
			//建立錯誤訊息顯示的List
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			//接受參數
			try {
				
				String account = (String)req.getParameter("account");
				System.out.println(account);
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (account == null || account.trim().length() == 0) {
					errorMsgs.add("account: 請勿空白");
				} else if(!account.trim().matches(enameReg)) { 
					errorMsgs.add("account:英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				String password = (String)req.getParameter("password");
				System.out.println(password);
				if (password == null || password.trim().length() == 0) {
					errorMsgs.add("password: 請勿空白");
				} else if(!password.trim().matches(enameReg)) { 
					errorMsgs.add("password:英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				String nickname = (String)req.getParameter("nickname");
				System.out.println(nickname);
				if (nickname == null || nickname.trim().length() == 0) {
					errorMsgs.add("Nickname: 請勿空白");
				} else if(!nickname.trim().matches(enameReg)) { 
					errorMsgs.add("Nickname:只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				String realName = (String)req.getParameter("realName");
				System.out.println(realName);
				if (realName == null || realName.trim().length() == 0) {
					errorMsgs.add("Real Name: 請勿空白");
				} else if(!realName.trim().matches(enameReg)) { 
					errorMsgs.add("Real Name:只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				
				String idNumber = (String)req.getParameter("idNumber");
				System.out.println(idNumber);
				if (idNumber == null || idNumber.trim().length() == 0) {
					errorMsgs.add("Personal ID: 請勿空白");
				} else if(!idNumber.trim().matches(enameReg)) { 
					errorMsgs.add("Personal ID:只能是英文字母、數字");
				}
				
				
				byte[] photo = { };

				String email = (String)req.getParameter("email");
				System.out.println(email);
				if (email == null || email.trim().length() == 0) {
					errorMsgs.add("Email: 請勿空白");
				}
				
				
				String statusDescription = (String)req.getParameter("statusDescription");
				System.out.println(statusDescription);
				
				int bankAccount = 0;
				try {
					bankAccount = new Integer(req.getParameter("bankAccount").trim());
					System.out.println(bankAccount);
				}catch (NumberFormatException e) {
					bankAccount = 0;
					errorMsgs.add("bankAccount請填數字.");
				}
				
				
				Membership membership = new Membership();
				membership.setAccount(account);
				membership.setPassword(password);
				membership.setNickname(nickname);
				membership.setRealName(realName);
				membership.setIdNumber(idNumber);
				membership.setPhoto(photo);
				membership.setEmail(email);
				membership.setStatusDescription(statusDescription);
				membership.setBankAccount(bankAccount);
				System.out.println(membership);
				
				if (!errorMsgs.isEmpty()) {
					System.out.println("errorMsgs" + errorMsgs);
					req.setAttribute("membership", membership); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/addMemberShip.jsp");
					failureView.forward(req, res);
					System.out.println("failureView出現");
					return;
				}
				
				//參數接入完畢，接下來要寫入SQL子句裡面
				
				System.out.println("我要進去了");
				IMembershipService memService = new MembershipServiceImpl();
				memService.addData(account, password, realName, idNumber, photo, email, statusDescription, bankAccount, nickname);
				
				//寫進去之後，轉交給成功頁面//oneMember要用list讀(未解決)
				
				List<Membership> list = new ArrayList();
				list.add(membership);
				HttpSession session = req.getSession();
		        session.setAttribute("name", account);
		        System.out.println("我是session：" + session.getAttribute("name"));
				
				String url = "/oneMember.jsp";
				req.setAttribute("mem", list);
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交oneMember.jsp
				successView.forward(req, res);	
				
			}catch(Exception e) {
				e.printStackTrace(System.err);
			}
			
		}
		

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}

}
