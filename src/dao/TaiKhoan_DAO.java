package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.DataBase;
import entity.NhanVien;
import entity.TaiKhoan;

public class TaiKhoan_DAO {

	public TaiKhoan_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TaiKhoan timTaiKhoan(String key) {
		TaiKhoan tk = null;
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from TaiKhoan where tenTK = '"+key+"'");
			if(rs.next()) {
				String tenTK = rs.getString(1);
				String mK = rs.getString(2);
				NhanVien nv = new NhanVien(rs.getString(3));
				tk = new TaiKhoan(tenTK, mK, nv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tk;
	}
	public void updateMk(String maNV, String mk) throws SQLException {
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "update TaiKhoan set matKhau = ? where maNV = '"+maNV+"'";
			statement = con.prepareStatement(sql);
			statement.setString(1,mk);
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			statement.close();
		}
	}
}
