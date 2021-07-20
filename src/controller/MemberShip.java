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
		
		//�|���n�J
		if(action.equals("membership_LogIn")) {
			
			String name = req.getParameter("name");
			String password = req.getParameter("Password");
			System.out.println(name);
			
			
			//�b�����ҡG�L�o�L��J�ΪŮ�
			if("".equals(name) && "".equals(name.trim()))
				out.println("�п�J�b��");
			
			//�K�X���ҡG�L�o�L��J�ΪŮ�
			if("".equals(password) && "".equals(password.trim())) {
				out.println("�п�J�K�X");
				accountCheck(name);
			}
				
			
			
			//��account�����ҬO�_���b����K�X�A�H�αb���K�X�O�_���T�Gservice���g�ADAO��account�g���A�����D�藍��
			 
			
		}
			
	/*		if(name == null || password == null) {//���|��null
				out.println("�п�J�b�K111��!");
			} 
			
			//�b���K�X���ҡG�L�o��J�Ů�
			if ("".equals(name.trim()) || "".equals(password.trim())) {
				out.println("�п�J�b�K��!");
			} 
			
			//�b���K�X���ҡG���Ҭ�administrator�A�b�K���T�i�J�A���administer_function.jsp
			if (name.equals("administrator") && password.equals("administrator")) { // todo
				System.out.println("�b�K���T�A�i�J");
				
				HttpSession session = req.getSession();
		        session.setAttribute("name", name); 
				
		        String user = (String)session.getAttribute("name");// todo
		        System.out.println("�ڬOsession�G" + user);
				
				String url = "/administer_function.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, res);
						
			}
			
			//�p�G�b���A�K�X������"administrator"�A�N�O�@��ϥΤ᪺�n�J
			if(name != "administrator" || password != "administrator") { // todo
				
				MembershipDAO memDAO = new MembershipDAO();
				Membership list = memDAO.logInFromAccount(name); // todo
				System.out.println(list);
				String memAccount = list.getAccount();
				String memPassword = list.getPassword();
				System.out.println("��J��account�O�G" + name + "�K�X�O�G" + password);	
				System.out.println("�o�O��account�n�J �A�ڧ�쪺account�O�G" + memAccount + "�K�X�O�G" + memPassword);
				
				if(name.equals(memAccount) && password.equals(memPassword)) {
					System.out.println("�b�K���T�A�i�J");
					
					HttpSession session = req.getSession();
			        session.setAttribute("name", memAccount); 
					
			        String user = (String)session.getAttribute("name");// todo
			        System.out.println("�ڬOsession�G" + user);
			        
			        req.setAttribute("mem", list); 
			        
			        String url = "/oneMember.jsp";
					RequestDispatcher rd = req.getRequestDispatcher(url);
					rd.forward(req, res);
				}
				
			}else {
				out.println("�b���αK�X�����!"); // todo
			}							
		}
		
		*/
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

	//�T�{�b���O�_�s�b
	private String accountCheck(String account) {
		MembershipServiceImpl membershipService = new MembershipServiceImpl();		
		String password = membershipService.selectOne(account).getPassword();
		System.out.println(password);
			return password;
		}
	}
	
	

