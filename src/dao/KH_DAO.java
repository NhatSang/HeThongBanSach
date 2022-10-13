/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.DataBase;
import entity.KhachHang;

/**
 *
 * @author MSI DESKTOP
 */
public class KH_DAO {

	public KH_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<KhachHang> getAllKhachHang(){
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			DataBase.getInstance();
			Connection con = DataBase.getConnection();
			
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String ma = rs.getString(1);
				String hoten = rs.getString(2);
				LocalDate ns = LocalDate.parse(rs.getDate(3).toString());
				String diaChi = rs.getString(4);
				String sdt = rs.getString(5);
				Boolean gt = rs.getBoolean(6);
				dsKH.add(new KhachHang(ma, hoten, ns, diaChi, sdt, gt));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}
	
}
