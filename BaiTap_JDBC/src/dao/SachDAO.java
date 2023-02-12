package dao;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Result;

import database.JDBCUtil;
import model.Sach;

public class SachDAO implements DAOInterface<Sach> {
	public static SachDAO getInstance() {
		return new SachDAO();
	}

	@Override
	public int insert(Sach t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: Tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			//Bước 3: Thục thi câu lệnh SQL
			String sql ="INSERT INTO sach(id,tenSach,giaBan,namXuatBan)"
					+"VALUES ('"+t.getId()+"','"+t.getTenSach()+"',"+t.getGiaban()+","+t.getNamXuatBan()+")";
			 
			ketQua = st.executeUpdate(sql);
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
	public int update(Sach t) {
		int ketQua =0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "UPDATE sach "
					 +" SET "
					+"tenSach='"+t.getTenSach()+"'"
					+", giaBan="+t.getGiaban()
					+", namXuatBan="+t.getNamXuatBan()
					+" WHERE id='"+t.getId()+"\'";
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
	public int delete(Sach t) {
		int ketQua = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			
			Statement st = con.createStatement();
			
			String sql = "DELETE from sach "
					+" WHERE id='"+t.getId()+"'";
			
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
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> ketQua = new ArrayList<Sach>();
		
		 try {
			Connection con = JDBCUtil.getConnection();
			 
			 Statement st = con.createStatement();
			 
			 String sql = "SELECT * FROM sach";
			 ResultSet rs = st.executeQuery(sql);
			 
			 while(rs.next()) {
				 String id = rs.getString("id");
				 String tenSach = rs.getString("tenSach");
				 float giaBan = rs.getFloat("giaBan");
				 int namXuatBan = rs.getInt("namXuatBan");
				 
				 Sach sach = new Sach(id,tenSach,giaBan,namXuatBan);
				 ketQua.add(sach);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public Sach selectById(Sach t) {
		Sach ketQua = null;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM sach WHERE id ='"+t.getId()+"'";
			
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				Float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				ketQua = new Sach(id,tenSach,giaBan,namXuatBan);
				JDBCUtil.closeConnection(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return ketQua;
	}

	@Override
	public ArrayList<Sach> selectbyCondition(String condition) {
		ArrayList<Sach> ketQua = new ArrayList<Sach>();
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * FROM sach WHERE "+condition;
			
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				float giaBan = rs.getFloat("giaBan");
				int namXuanBan = rs.getInt("namXuatBan");
				Sach sach = new Sach(id,tenSach,giaBan,namXuanBan);
				ketQua.add(sach);
				JDBCUtil.closeConnection(con);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
	
}
