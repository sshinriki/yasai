package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.ItemBean;
import la.dao.DAOException;
import la.dao.ItemDAO;

/**
 * Servlet implementation class ShowItemServlet
 */
@WebServlet("/ShowItemServlet")
public class ShowItemServlet extends HttpServlet {
		/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//パラメータの解析
			String action =request.getParameter("action");
			//パラメータなしの場合はtopページを表示
			if(action==null||action.length()==0){
				gotoPage(request,response,"/top.jsp");
			}else if(action.equals("list")){
				int itemCode=Integer.parseInt(request.getParameter("code"));
				ItemDAO dao=new ItemDAO();
				List<ItemBean>list=(List<ItemBean>) dao.findByPrimaryKey(itemCode);
				//リストをリクエストスコープにいれてJSPへフォワードする
				request.setAttribute("items",list);
				gotoPage(request,response,"/showItem.jsp");
			}else{
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request,response,"/errInternal.jsp");
			}
			}catch(DAOException e){
			e.printStackTrace();
			request.setAttribute("message","内部エラーが発生しました。");
			gotoPage(request,response,"/errInternal.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response,String page)throws ServletException,IOException{
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}