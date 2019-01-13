package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
//テストのために（後で削除）
	
private static final String USER ="jack";
private static final String PASS ="abc";

protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
  response.setContentType("text/html;charset=UTF-8");
  PrintWriter out = response.getWriter();

  //actionリクエストパラメータの読み込み
String action = request.getParameter("action");
if (action.equals("login")){//ログイン時
  String name = request.getParameter("name");
  String passWord = request.getParameter("pw");

  //ユーザ名とパスワードが一致したら
  if (name.equals(USER) && passWord.equals(PASS)){
    //セッション管理を行う
    HttpSession session = request.getSession();
    //ログイン済みの属性を設定する。
    session.setAttribute("isLogin","true");
    
    
   //ここで本当は、menuページに遷移する。
    out.println("<html><head><title>ShowCart</title></head><body>");
    out.println("<h1>ログイン成功！</h1><br>");
    out.println("<a href='menu.jsp’>メニューへ</a><br>");
    out.println("</body></html>");
  }else{
	  out.println("<html><head><title>ShowCart</title></head><body>");
	  out.println("<h1>ユーザ名またはパスワードが違います</h1>");
	  out.println("</body></html>");
  }

}else if(action.equals("logout")){//ログアウト時
  //すでに作成されているセッション領域を取得する。新しくは作成しない
  HttpSession session = request.getSession(false);
  if(session !=null){
    //セッション領域を無効にする。
    session.invalidate();
    out.println("<html><head><title>ShowCart</title></head><body>");
    out.println("<h1>ログアウトしました</h1>");
    out.println("</body></html>");
  }

}
}



protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
  doGet(request,response);
}
}