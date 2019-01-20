package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import la.bean.CartBean;
import la.bean.CustomerBean;
import la.bean.ItemBean;

public class OrderDAO{
  private Connection con;

  public OrderDAO() throws DAOException{
    getConnection();
  }

  
  public CustomerBean saveUser(String id) throws DAOException{
	    if(con == null)
	      getConnection();

	    PreparedStatement st = null;
	    ResultSet rs = null;

	    try{
	      //ユーザIDを取得する。
	    	
	      String sql = "SELECT * FROM customer WHERE email=?";
			st=con.prepareStatement(sql);
			st.setString(1, id);
			rs=st.executeQuery();
	      
			if(rs.next()){
				int code=rs.getInt("code");
				String name=rs.getString("name");
				String address=rs.getString("address");
				String tel=rs.getString("tel");
				String email=rs.getString("email");
				String pass=rs.getString("pass");
				CustomerBean bean=new CustomerBean(code,name,address,tel,email,pass);
				return bean;
			}else{
				return null;
			}
	    }catch(Exception e){
	      e.printStackTrace();
	      throw new DAOException("レコードの操作に失敗しました。");
	    }finally{
	      try{
	        //リソースの開放
	        if(rs != null)
	          rs.close();
	        if(st != null)
	          st.close();
	        close();
	      }catch(Exception e){
	        throw new DAOException("リソースの開放に失敗しました。");
	      }
	    }
	  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  public int saveOrder(CustomerBean customer, CartBean cart) throws DAOException{
    if(con == null)
      getConnection();

    PreparedStatement st = null;
    ResultSet rs = null;

    try{
      //顧客番号の取得 Serial型の暗黙シーケンスから取得
      int customerNumber = 0;
      String sql = "SELECT nextval('customer_code_seq')";
      st = con.prepareStatement(sql);
      rs = st.executeQuery();
      if(rs.next()){
        customerNumber = rs.getInt(1);
      }
      rs.close();
      st.close();
      //顧客情報の追加SQL文
      sql = "INSERT INTO customer VALUES(?, ?, ?, ?, ?)";
      //PreparedStatementオブジェクトの取得
      st = con.prepareStatement(sql);
      //プレースホルダーの設定
      st.setInt(1, customerNumber);
      st.setString(2, customer.getName());
      st.setString(3, customer.getAddress());
      st.setString(4, customer.getTel());
      st.setString(5, customer.getEmail());
      //SQLの実行
      st.executeUpdate();
      st.close();

      //注文番号の取得 Serial型の暗黙シーケンスから取得
      int orderNumber = 0;
      sql = "SELECT nextval('ordered_code_seq')";
      st = con.prepareStatement(sql);
      rs = st.executeQuery();
      if(rs.next()){
        orderNumber = rs.getInt(1);
      }
      rs.close();
      st.close();

      //注文情報のOrderedテーブルへの追加
      sql = "INSERT INTO ordered VALUES(?, ?, ?, ?)";
      st = con.prepareStatement(sql);
      //プレースホルダーの設定
      st.setInt(1, orderNumber);
      st.setInt(2, customerNumber);
      Date today = new Date(System.currentTimeMillis());
      st.setDate(3, today);
      st.setInt(4, cart.getTotal());
      //SQLの実行
      st.executeUpdate();
      st.close();

      //注文明細情報のOrderedDetailテーブルへの追加
      //商品ごとに複数レコード追加
      sql = "INSERT INTO ordered_detail VALUES(?, ?, ?)";
      st = con.prepareStatement(sql);
      Map<Integer, ItemBean> items = cart.getItems();
      Collection<ItemBean> list = items.values();
      for (ItemBean item : list){
        st.setInt(1, orderNumber);
        st.setInt(2, item.getCode());
        st.setInt(3, item.getQuantity());
        st.executeUpdate();
      }
      st.close();
      return orderNumber;
    }catch(Exception e){
      e.printStackTrace();
      throw new DAOException("レコードの操作に失敗しました。");
    }finally{
      try{
        //リソースの開放
        if(rs != null)
          rs.close();
        if(st != null)
          st.close();
        close();
      }catch(Exception e){
        throw new DAOException("リソースの開放に失敗しました。");
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
    if(con != null){
      con.close();
      con = null;
    }
  }
}