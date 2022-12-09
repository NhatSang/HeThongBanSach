/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.DataBase;
import entity.ThongKeDoanhThu;
import entity.ThongKeDoanhThu;

/**
 *
 * @author MSI DESKTOP
 */
public class TKDT_DAO {

	public TKDT_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<ThongKeDoanhThu> getAllThongKeDoanhThu(String ngay) {
		ArrayList<ThongKeDoanhThu> dsThongKe = new ArrayList<ThongKeDoanhThu>();
		try {
			DataBase.getInstance();
			Connection con = DataBase.getConnection();

			String sql = "select  cthd.maSP, sp.tenSP, SUM(cthd.soLuong) as 'soLuong' , hd.ngayLap, sp.donGia, hd.maHD from ChiTietHoaDon cthd left join SanPham sp on cthd.maSP = sp.maSP left join HoaDon hd on cthd.maHD = hd.maHD group by cthd.maSP,sp.tenSP, hd.ngayLap, sp.donGia, hd.maHD having hd.ngayLap=" + "'" + ngay + "'";

                        Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String tenSP = rs.getString(2);
				String maSP = rs.getString(1);
				int soLuong = rs.getInt(3);
				Date ngayLap = rs.getDate(4);
				Double giaBan = rs.getDouble(5);
				String maHD = rs.getString(6);
				dsThongKe.add(new ThongKeDoanhThu(maSP, tenSP, soLuong, giaBan, ngayLap, maHD));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsThongKe;
	}
        
        public ArrayList<ThongKeDoanhThu> ThongKeDoanhThuTheoThang(String nam, String thang) {
		ArrayList<ThongKeDoanhThu> dsThongKe = new ArrayList<ThongKeDoanhThu>();
                int n = Integer.valueOf(nam);
                int t = Integer.valueOf(thang);

		try {
			DataBase.getInstance();
			Connection con = DataBase.getConnection();

			String sql = " select  cthd.maSP, sp.tenSP, SUM(cthd.soLuong) as 'soLuong' , hd.ngayLap, sp.donGia, hd.maHD from ChiTietHoaDon cthd left join SanPham sp on cthd.maSP = sp.maSP left join HoaDon hd on cthd.maHD = hd.maHD group by cthd.maSP,sp.tenSP, hd.ngayLap, sp.donGia, hd.maHD having YEAR(hd.ngayLap)="+ "'"+ nam +"'" + "and MONTH(hd.ngayLap)=" + "'" + thang + "'";

                        Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String tenSP = rs.getString(2);
				String maSP = rs.getString(1);
				int soLuong = rs.getInt(3);
				Date ngayLap = rs.getDate(4);
				Double giaBan = rs.getDouble(5);
				String maHD = rs.getString(6);
				dsThongKe.add(new ThongKeDoanhThu(maSP, tenSP, soLuong, giaBan, ngayLap, maHD));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsThongKe;
	}
}
