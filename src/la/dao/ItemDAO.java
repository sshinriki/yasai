package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.CategoryBean;
import la.bean.ItemBean;

public class ItemDAO {
	private Connection con;

	public ItemDAO()throws DAOException{
		getConnection();
	}
//全カテゴリ取得
	public List<CategoryBean>findAllCategory()throws DAOException{
		if(con==null)
			getConnection();

		PreparedStatement st=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM category ORDER BY code";
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			List<CategoryBean>list=new ArrayList<CategoryBean>();
			while(rs.next()){
				int code=rs.getInt("code");
				String name=rs.getString("name");
				CategoryBean bean=new CategoryBean(code,name);
				list.add(bean);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		}finally{
			try{
				if(rs!=null)rs.close();
				if(st!=null)st.close();
				close();
			}catch(Exception e){
				throw new DAOException("リソースの開放に失敗しました");
			}
		}


	}

//カテゴリに対する商品
	public List<ItemBean>findByCategory(int categoryCode)throws DAOException{
		if(con==null)
			getConnection();
		PreparedStatement st=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM item WHERE category_code=? ORDER BY code";
			st=con.prepareStatement(sql);
			st.setInt(1, categoryCode);
			rs=st.executeQuery();
			List<ItemBean>list=new ArrayList<ItemBean>();
			while(rs.next()){
				int code=rs.getInt("code");
				String name=rs.getString("name");
				int price=rs.getInt("price");
				String img=rs.getString("img");
				int stock=rs.getInt("stock");
				String detail=rs.getString("detail");
				ItemBean bean=new ItemBean(code,name,price,img,stock,detail);
				list.add(bean);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		}finally{
			try{
				if(rs!=null)rs.close();
				if(st!=null)st.close();
				close();
			}catch(Exception e){
				throw new DAOException("リソースの開放に失敗しました");
			}
		}

	}
//商品コードに対する商品
	public ItemBean findByPrimaryKey(int key)throws DAOException{
		if(con==null)
			getConnection();

		PreparedStatement st=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM item WHERE code=?";
			st=con.prepareStatement(sql);
			st.setInt(1, key);
			rs=st.executeQuery();
			if(rs.next()){
				int code=rs.getInt("code");
				String name=rs.getString("name");
				int price=rs.getInt("price");
				String img=rs.getString("img");
				int stock=rs.getInt("stock");
				String detail=rs.getString("detail");
				ItemBean bean=new ItemBean(code,name,price,img,stock,detail);
				return bean;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		}finally{
			try{
				if(rs!=null)rs.close();
				if(st!=null)st.close();
				close();
			}catch(Exception e){
				throw new DAOException("リソースの開放に失敗しました");
			}
		}


		}
	private void getConnection() throws DAOException{
		try{
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql:yasai";
			String user="sbyk";
			String pass="12345678";
			con=DriverManager.getConnection(url,user,pass);
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("接続に失敗しました");
		}
	}



	private void close() throws SQLException{
		if(con!=null){
			con.close();
			con=null;
		}
	}
}


