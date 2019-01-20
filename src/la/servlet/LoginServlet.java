package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
//テストのために（後で削除）
	


protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
  response.setContentType("text/html;charset=UTF-8");
  PrintWriter out = response.getWriter();
  try{
  //actionリクエストパラメータの読み込み
		String action = request.getParameter("action");
		if (action.equals("login")){//ログイン時
		  String id = request.getParameter("id");
		  String pw= request.getParameter("pw");
		  
		  OrderDAO dao= new OrderDAO();
		  CustomerBean user=dao.saveUser(id);
		
		  //ユーザ名とパスワードが一致したら
		  if (pw.equals(user.getPass())){
		    //セッション管理を行う
		    HttpSession session = request.getSession();
		    //ログイン済みの属性を設定する。
		    session.setAttribute("isLogin","true");
		    session.setAttribute("userinfo",user);
		    request.setAttribute("message","ログイン成功");
			gotoPage(request,response,"/errInternal.jsp");
		    
		  }else{
			  request.setAttribute("message","パスワードが違います");
				gotoPage(request,response,"/errInternal.jsp");
		  }
		
		}else if(action.equals("logout")){//ログアウト時
		  //すでに作成されているセッション領域を取得する。新しくは作成しない
		  HttpSession session = request.getSession(false);
		  if(session !=null){
		    //セッション領域を無効にする。
		    session.invalidate();
		    request.setAttribute("message","ログアウトしました");
			gotoPage(request,response,"/errInternal.jsp");
		  }
		}

  }catch(DAOException e){
	e.printStackTrace();
	request.setAttribute("message","内部エラーが発生しました。");
	//gotoPage(request,response,"/errInternal.jsp");
  }
}


private void gotoPage(HttpServletRequest request,
		HttpServletResponse response,String page)throws ServletException,IOException{
	RequestDispatcher rd=request.getRequestDispatcher(page);
	rd.forward(request, response);
}





protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
  doGet(request,response);
}
}