package dao;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Result;

import database.JDBCUtil;
import model.User;

public class UserDAO implements DAOInterface<User> {
	public static UserDAO getInstance() {
		return new UserDAO();
	}

	@Override
	public int insert(User t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			String sql ="INSERT INTO User(username,password,hoten)"
					+"VALUES (?,?,?)";
			// Bước 2: Tạo ra đối tượng statement
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getPassword());
			pst.setString(3,t.getHoten());
			//Bước 3: Thục thi câu lệnh SQL			 
			 
			ketQua = pst.executeUpdate(sql);
			System.out.println("Bạn đã thực thi: "+sql);
			System.out.println("có"+ketQua+"dòng bị thay đổi");
			
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(User t) {
		int ketQua =0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "UPDATE User "
					 +" SET "
					+"username='"+t.getUsername()+"'"
					+", password='"+t.getPassword()+"'"
					+", hoten='"+t.getHoten()+"'"
					+" WHERE username='"+t.getUsername()+"\'";
					
			System.out.println(sql);
			ketQua = st.executeUpdate(sql);
			
			System.out.println("Bạn đã thực thi:"+sql);
			System.out.println("có "+ketQua+" dòng bị thay đổi");
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(User t) {
		int ketQua = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "DELETE from User "
					+" WHERE id='"+t.getUsername()+"'";
			
			System.out.println(sql);
			
			ketQua = st.executeUpdate(sql);
			System.out.println("có "+ketQua +" dòng bị thay đổi");
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return ketQua;
	}

	@Override
	public ArrayList<User> selectAll() {
		ArrayList<User> ketQua = new ArrayList<User>();
		
		 try {
			Connection con = JDBCUtil.getConnection();
			 
			 Statement st = con.createStatement();
			 
			 String sql = "SELECT * FROM User";
			 ResultSet rs = st.executeQuery(sql);
			 
			 while(rs.next()) {
				 String username = rs.getString("usrname");
				 String password = rs.getString("password");
				 String hoten = rs.getString("hoten");
				 
				 
				 User User = new User(username,password,hoten);
				 ketQua.add(User);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public User selectById(User t) {
		User ketQua = null;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM User WHERE username ='"+t.getUsername()+"'";
			
			ResultSet rs = st.executeQuery(sql);
			 while(rs.next()) {
				 String username = rs.getString("username");
				 String password = rs.getString("password");
				 String hoten = rs.getString("hoten");
				 
				 
				ketQua = new User(username,password,hoten);
				
				JDBCUtil.closeConnection(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return ketQua;
	}

	@Override
	public ArrayList<User> selectbyCondition(String condition) {
		ArrayList<User> ketQua = new ArrayList<User>();
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * FROM User WHERE "+condition;
			
			ResultSet rs = st.executeQuery(sql);
			 while(rs.next()) {
				 String username = rs.getString("usrname");
				 String password = rs.getString("password");
				 String hoten = rs.getString("hoten");
				 
				 
				 User User = new User(username,password,hoten);
				ketQua.add(User);
				JDBCUtil.closeConnection(con);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
	
}
