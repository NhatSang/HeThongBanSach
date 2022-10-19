package dao;

import java.sql.Connection;
import java.sql.ResultSet;
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
			ResultSet rs = stm.executeQuery("select * from TaiKhoan where tenTK = " +"'"+key+"'");
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
}
