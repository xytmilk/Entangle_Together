package blob.reader;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import Service.MembershipServiceImpl;
 
public class GifReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		
		String id = req.getParameter("id");
		MembershipServiceImpl memServ = new MembershipServiceImpl();
		out.write(memServ.selectOne(id).getPhoto());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
