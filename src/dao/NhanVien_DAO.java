package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import connectDB.DataBase;
import entity.ChucVu;
import entity.NhanVien;

public class NhanVien_DAO {

	public NhanVien_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien timKiemNVTheoMa(String maNV) {
		NhanVien nv = null;
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select maNV,hoTen,maCV from NhanVien where maNV = " + "'" + maNV + "'");
			if (rs.next()) {
				String ma = rs.getString(1);
				String hoTen = rs.getString(2);
				ChucVu chucVu = new ChucVu(rs.getString(3));
				nv = new NhanVien(ma,hoTen, chucVu);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nv;
	}
}
