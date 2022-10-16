package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.DataBase;
import entity.NhaCungCap;

public class NCC_DAO {

	public NCC_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<NhaCungCap> getAllNhaCungCap(){
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		try {
			DataBase.getInstance();
			Connection con = DataBase.getConnection();
			
			String sql = "Select * from NhaCungCap";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String nguoidaidien = rs.getString(3);
				String sdt = rs.getString(4);
				String diachi = rs.getString(5);
				dsNCC.add(new NhaCungCap(ma, ten, nguoidaidien, sdt, diachi));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dsNCC;
	}
}