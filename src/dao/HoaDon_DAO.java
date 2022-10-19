package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import connectDB.DataBase;

public class HoaDon_DAO {

	public HoaDon_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaHD() {
		String s = "";
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select dbo.autoIdHD()");
			if (rs.next()) {
				s=rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return s;
	}
}
