package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
			String url = "/administer_function.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		
		}
		
		//�o�ӬO�޲z�����\�ध�@�G�d�߳�@�|��
		if(action.equals("check_OneMember")) {
			String id = (String)req.getParameter("id");
			
			System.out.println("id�O�G"+id);
			MembershipDAO mem = new MembershipDAO();
			Membership list = mem.selectOneMember(id);
			System.out.println("�o�O�d�߳�@�|����list =" + list);
		}


	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}

}
