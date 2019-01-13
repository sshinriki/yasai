package la.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import la.bean.CategoryBean;
import la.bean.ItemBean;
import la.dao.DAOException;
import la.dao.ItemDAO;

/**
 * Servlet implementation class ShowItemServlet
 */
@WebServlet("/ShowItemListServlet")
public class ShowItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			//パラメータ解析
			String action=request.getParameter("action");
			//topまたはパラメータなしの場合はtop
			if(action==null||action.length()==0||action.equals("top")){
				gotoPage(request,response,"/top.jsp");
			}else if(action.equals("list")){
				int categoryCode=Integer.parseInt(request.getParameter("code"));
				ItemDAO dao =new ItemDAO();
				List<ItemBean>list=dao.findByCategory(categoryCode);
				//Listをリクエストスコープに入れてjspへフォワードする
				request.setAttribute("items",list);
				gotoPage(request,response,"/itemList.jsp");
			}else{
				request.setAttribute("message","正しく操作してください");
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


	public void init()throws ServletException{
		try{
			//カテゴリ一覧は最初にアプリケーションスコープに入れる
			ItemDAO dao=new ItemDAO();
			List<CategoryBean>list=dao.findAllCategory();
			getServletContext().setAttribute("categories",list);
		}catch(DAOException e){
			e.printStackTrace();
			throw new ServletException();
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}}