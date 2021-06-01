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
		
		//�o�ӬO"�޲z��"�n�J��code
		if(action.equals("log_in")) {
			
			String name = req.getParameter("name");
			String password = req.getParameter("Password");

			//�b���K�X���ҡG�L�o�L��J
			if(name == null || password == null) {
				out.println("�п�J�b�K��!");
			} 
			
			//�b���K�X���ҡG�L�o��J�Ů�
			if ("".equals(name.trim()) || "".equals(password.trim())) {
				out.println("�п�J�b�K��!");
			} 
			
			//�b���K�X���ҡG���Ҭ�administrator�A�b�K���T�i�J�A���administer_function.jsp
			if (name.equals("administrator") && password.equals("administrator")) {
				System.out.println("�b�K���T�A�i�J");
				
				HttpSession session = req.getSession();
		        session.setAttribute("name", name); 
				
		        String user = (String)session.getAttribute("name");
		        System.out.println("�ڬOsession�G" + user);
				
				String url = "/administer_function.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, res);
						
			}
			
			//�p�G�b���A�K�X������"administrator"�A�N�O�@��ϥΤ᪺�n�J
			if(name != "administrator" || password != "administrator") {
				
				MembershipDAO memDAO = new MembershipDAO();
				List<Membership> list = memDAO.logInFromAccount(name);
				System.out.println(list);
				String memAccount = list.get(0).getAccount();
				String memPassword = list.get(0).getPassword();
				System.out.println("��J��account�O�G" + name + "�K�X�O�G" + password);	
				System.out.println("�o�O��account�n�J �A�ڧ�쪺account�O�G" + memAccount + "�K�X�O�G" + memPassword);
				
				if(name.equals(memAccount) && password.equals(memPassword)) {
					System.out.println("�b�K���T�A�i�J");
					
					HttpSession session = req.getSession();
			        session.setAttribute("name", memAccount); 
					
			        String user = (String)session.getAttribute("name");
			        System.out.println("�ڬOsession�G" + user);
			        
			        req.setAttribute("mem", list); 
			        
			        String url = "/oneMember.jsp";
					RequestDispatcher rd = req.getRequestDispatcher(url);
					rd.forward(req, res);
				}
				
			}else {
				out.println("�b���αK�X�����!");
			}							
		}
		
		
		//�o�ӬO�޲z�����\�ध�@�G�d�ߥ����|��
		if(action.equals("select_all")) {
			MembershipDAO mem = new MembershipDAO();
			List<Membership> list = mem.selectAll();
			
			req.setAttribute("list", list);
			System.out.println("�ڬOselect_all��jsp");
			out.print("�o�ӬOcontroller���X�Ӫ�list" + list);
			String url = "/administer_function.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		
		}
		
		//�o�ӬO�޲z�����\�ध�@�G�d�߳�@�|��
		if(action.equals("check_OneMember")) {
			String id = (String)req.getParameter("id");
			
			System.out.println("id�O�G"+id);
			MembershipDAO mem = new MembershipDAO();
			List<Membership> oneMember = mem.selectOneMember(id);
			System.out.println("�o�O�d�߳�@�|����Membership =" + oneMember);
			
			req.setAttribute("mem", oneMember); 
	        
			String url = "/oneMember.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
			
		}
		
		//�s�|�����U
		if(action.equals("Sign_in")) {
			String url = "/addMemberShip.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}
		

		//data from addMembership.jsp�F��ƥѵ��U�����ǤJ
		if(action.equals("insert")) {
			
			//�إ߿��~�T����ܪ�List
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			//�����Ѽ�
			try {
				
				String account = (String)req.getParameter("account");
				System.out.println(account);
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (account == null || account.trim().length() == 0) {
					errorMsgs.add("account: �ФŪť�");
				} else if(!account.trim().matches(enameReg)) { 
					errorMsgs.add("account:�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
	            }
				
				String password = (String)req.getParameter("password");
				System.out.println(password);
				if (password == null || password.trim().length() == 0) {
					errorMsgs.add("password: �ФŪť�");
				} else if(!password.trim().matches(enameReg)) { 
					errorMsgs.add("password:�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
	            }
				
				String nickname = (String)req.getParameter("nickname");
				System.out.println(nickname);
				if (nickname == null || nickname.trim().length() == 0) {
					errorMsgs.add("Nickname: �ФŪť�");
				} else if(!nickname.trim().matches(enameReg)) { 
					errorMsgs.add("Nickname:�u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
	            }
				
				String realName = (String)req.getParameter("realName");
				System.out.println(realName);
				if (realName == null || realName.trim().length() == 0) {
					errorMsgs.add("Real Name: �ФŪť�");
				} else if(!realName.trim().matches(enameReg)) { 
					errorMsgs.add("Real Name:�u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
	            }
				
				
				String idNumber = (String)req.getParameter("idNumber");
				System.out.println(idNumber);
				if (idNumber == null || idNumber.trim().length() == 0) {
					errorMsgs.add("Personal ID: �ФŪť�");
				} else if(!idNumber.trim().matches(enameReg)) { 
					errorMsgs.add("Personal ID:�u��O�^��r���B�Ʀr");
				}
				
				
				byte[] photo = { };

				String email = (String)req.getParameter("email");
				System.out.println(email);
				if (email == null || email.trim().length() == 0) {
					errorMsgs.add("Email: �ФŪť�");
				}
				
				
				String statusDescription = (String)req.getParameter("statusDescription");
				System.out.println(statusDescription);
				
				int bankAccount = 0;
				try {
					bankAccount = new Integer(req.getParameter("bankAccount").trim());
					System.out.println(bankAccount);
				}catch (NumberFormatException e) {
					bankAccount = 0;
					errorMsgs.add("bankAccount�ж�Ʀr.");
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
					req.setAttribute("membership", membership); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req.getRequestDispatcher("/addMemberShip.jsp");
					failureView.forward(req, res);
					System.out.println("failureView�X�{");
					return;
				}
				
				//�ѼƱ��J�����A���U�ӭn�g�JSQL�l�y�̭�
				
				System.out.println("�ڭn�i�h�F");
				IMembershipService memService = new MembershipServiceImpl();
				memService.addData(account, password, realName, idNumber, photo, email, statusDescription, bankAccount, nickname);
				
				//�g�i�h����A��浹���\����//oneMember�n��listŪ(���ѨM)
				
				List<Membership> list = new ArrayList();
				list.add(membership);
				HttpSession session = req.getSession();
		        session.setAttribute("name", account);
		        System.out.println("�ڬOsession�G" + session.getAttribute("name"));
				
				String url = "/oneMember.jsp";
				req.setAttribute("mem", list);
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����oneMember.jsp
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
