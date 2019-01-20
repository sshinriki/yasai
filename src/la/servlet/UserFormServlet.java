package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.runtime.Name;

import la.bean.CartBean;
import la.bean.CustomerBean;
import la.dao.DAOException;
import la.dao.OrderDAO;

@WebServlet("/UserFormServlet")
public class UserFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	private String name=null;
	private String address=null;
	private String tel=null;
	private String id=null;
	private String pw=null;
	
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try{
			//actionリクエストパラメータの読み込み
			String action = request.getParameter("action");
			if (action.equals("register")) {
				//新規ユーザ登録時
				name = request.getParameter("name");
				address = request.getParameter("address");
				tel = request.getParameter("tel");
				id = request.getParameter("id");
				pw= request.getParameter("pw");
				if (name =="" || address =="" || tel =="" || id =="" || pw =="") {
					request.setAttribute("message","入力できていない項目があります。");
					gotoPage(request,response,"/errInternal.jsp");
					return;
				}else {
					//全ての項目が入力されたら
					request.setAttribute("message","新規ユーザ登録が完了しました。");
					gotoPage(request,response,"/errInternal.jsp");
					
				}
			}
				OrderDAO dao= new OrderDAO();
				int userset=dao.saveCustomer(name, address, tel, id, pw);
			
		}catch(DAOException e){
			e.printStackTrace();
			request.setAttribute("message","内部エラーが発生しました。");
			//gotoPage(request,response,"/errInternal.jsp");
		}
	}

	

	
	private void gotoPage(HttpServletRequest request, HttpServletResponse response,String page)throws ServletException,IOException{
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
