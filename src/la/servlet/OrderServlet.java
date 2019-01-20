package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.CartBean;
import la.bean.CustomerBean;
import la.dao.DAOException;
import la.dao.OrderDAO;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet{


protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

  //注文処理の業務はすべてセッションとCartが存在することが前提
  HttpSession session = request.getSession(false);

	if(session == null){//セッションオブジェクトなし
	request.setAttribute("message","セッションがきれています。もう一度トップページより操作してください。");
	gotoPage(request,response,"/errInternal.jsp");
	return;
	}
	String isLogin=(String)session.getAttribute("isLogin");
	
	if(isLogin==null||!isLogin.equals("true")) {
		request.setAttribute("message","ログインしてください1");
		gotoPage(request,response,"/errInternal.jsp");
		return;
	}else{
		CartBean cart = (CartBean)session.getAttribute("cart");
		CustomerBean user=(CustomerBean) session.getAttribute("userinfo");
		if(cart == null||user==null){//カートがない
			request.setAttribute("message","正しく操作してください。");
			gotoPage(request,response,"/errInternal.jsp");
			return;
		}
	}
	

	  try{
		    //パラメータの解析
		    String action = request.getParameter("action");
		    //input_customerまたはパラメータなしの場合は顧客情報入力ページを表示
		    if(action.equals("confirm")){
		      gotoPage(request,response,"/confirm.jsp");
		      //orderは注文確定
		    }else if(action.equals("order")){
		    	CartBean cart = (CartBean)session.getAttribute("cart");
		    	CustomerBean customer = (CustomerBean)session.getAttribute("userinfo");
		    	if(customer == null) {//顧客情報がない
		    		request.setAttribute("message","正しく操作してください。");
		    		gotoPage(request,response,"/errInternal.jsp");
		    	}

		      OrderDAO order = new OrderDAO();
		      int orderNumber = order.saveOrder(customer.getCode(),cart);
		      
		      //注文後はセッション上方をクリアする
		      session.removeAttribute("cart");
		      session.removeAttribute("customer");
		      //注文番号をクライアントへ送る。
		      request.setAttribute("orderNumber",new Integer(orderNumber));
		      gotoPage(request,response,"/order.jsp");

		    }else{ //actionの値が不正
		      request.setAttribute("message","正しく操作してください。");
		      gotoPage(request,response,"/errInternal.jsp");
		    }

		  }catch(DAOException e){
		    e.printStackTrace();
		    request.setAttribute("message","内部エラーが発生しました。");
		    gotoPage(request,response,"/errInternal.jsp");
		  }

}

private void gotoPage(HttpServletRequest request,HttpServletResponse response,String page)
		throws ServletException,IOException{

	RequestDispatcher rd = request.getRequestDispatcher(page);
	rd.forward(request,response);

}

protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	doGet(request,response);
}

}

