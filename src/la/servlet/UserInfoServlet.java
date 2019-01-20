package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.CustomerBean;
import la.dao.DAOException;
import la.dao.OrderDAO;
/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");
			
		String action = request.getParameter("action");

		if (action.equals("setUser")){
			  String u_name = request.getParameter("username");
			  String u_address= request.getParameter("address");
			  String u_tel = request.getParameter("tel");
			  String u_id = request.getParameter("email");
			  String u_pw= request.getParameter("pw");
			  
			  OrderDAO dao= new OrderDAO();
			  int countUser =dao.setUser(u_name,u_address,u_tel,u_id,u_pw);
			  
			  if (countUser != 0){
				    request.setAttribute("message",countUser);
					gotoPage(request,response,"/errInternal.jsp");
			  }else {
				  request.setAttribute("message","ユーザ登録完失敗しました！");
				  gotoPage(request,response,"/errInternal.jsp");
			  }
			  
		}
		  }catch(DAOException e){
				e.printStackTrace();
				request.setAttribute("message","内部エラーが発生しました。");
				gotoPage(request,response,"/errInternal.jsp");
			  
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response,String page)throws ServletException,IOException{
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	
	
	
}
