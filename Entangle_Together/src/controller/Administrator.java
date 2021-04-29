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
			String url = "/administer_function.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		
		}
		
		//這個是管理員的功能之一：查詢單一會員
		if(action.equals("check_OneMember")) {
			String id = (String)req.getParameter("id");
			
			System.out.println("id是："+id);
			MembershipDAO mem = new MembershipDAO();
			Membership list = mem.selectOneMember(id);
			System.out.println("這是查詢單一會員的list =" + list);
		}


	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}

}
