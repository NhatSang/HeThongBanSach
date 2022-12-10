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

			String sql = "select  cthd.maSP, sp.tenSP, SUM(cthd.soLuong) as 'soLuong' , hd.ngayLap, sp.donGia from ChiTietHoaDon cthd left join SanPham sp on cthd.maSP = sp.maSP left join HoaDon hd on cthd.maHD = hd.maHD group by cthd.maSP,sp.tenSP, hd.ngayLap, sp.donGia having hd.ngayLap=" + "'" + ngay + "'";

                        Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String tenSP = rs.getString(2);
				String maSP = rs.getString(1);
				int soLuong = rs.getInt(3);
				Date ngayLap = rs.getDate(4);
				Double giaBan = rs.getDouble(5);
//				String maHD = rs.getString(6);
				dsThongKe.add(new ThongKeDoanhThu(maSP, tenSP, soLuong, giaBan, ngayLap));
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

			String sql = "select test.maSP, test.tenSP, SUM(test.soLuong) as 'soLuong' , test.donGia from (select  cthd.maSP, sp.tenSP, SUM(cthd.soLuong) as 'soLuong' , hd.ngayLap, sp.donGia, hd.maHD from ChiTietHoaDon cthd left join SanPham sp on cthd.maSP = sp.maSP left join HoaDon hd on cthd.maHD = hd.maHD  group by cthd.maSP,sp.tenSP, hd.ngayLap, sp.donGia , hd.maHD having YEAR(hd.ngayLap)="+ "'"+ nam +"'" + "and MONTH(hd.ngayLap)=" + "'" + thang + "') as test group by test.maSP,test.tenSP ,test.donGia";

                        Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String tenSP = rs.getString(2);
				String maSP = rs.getString(1);
				int soLuong = rs.getInt(3);
//				Date ngayLap = rs.getDate(4);
				Double giaBan = rs.getDouble(4);
//				String maHD = rs.getString(6);
				dsThongKe.add(new ThongKeDoanhThu(maSP, tenSP, soLuong, giaBan));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsThongKe;
	}
        public ArrayList<ThongKeDoanhThu> DemTKTheoNgay(String ngay) {
		ArrayList<ThongKeDoanhThu> dsThongKe = new ArrayList<ThongKeDoanhThu>();
		try {
			DataBase.getInstance();
			Connection con = DataBase.getConnection();

			String sql = "select cthd.maSP,hd.ngayLap, cthd.maHD from HoaDon hd  join ChiTietHoaDon cthd on hd.maHD = cthd.maHD group by cthd.maSP, hd.ngayLap,cthd.maHD having hd.ngayLap=" + "'" + ngay + "'";

                        Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maSP = rs.getString(1);
				Date ngayLap = rs.getDate(2);
				String maHD = rs.getString(3);
//              int soLuong = rs.getInt(4);
				dsThongKe.add(new ThongKeDoanhThu(maSP, ngayLap, maHD));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsThongKe;
	}
        
        public ArrayList<ThongKeDoanhThu> DemTheoThang(String nam, String thang) {
		ArrayList<ThongKeDoanhThu> dsThongKe = new ArrayList<ThongKeDoanhThu>();
                int n = Integer.valueOf(nam);
                int t = Integer.valueOf(thang);

		try {
			DataBase.getInstance();
			Connection con = DataBase.getConnection();

			String sql = "select cthd.maSP,hd.ngayLap, cthd.maHD from HoaDon hd  join ChiTietHoaDon cthd on hd.maHD = cthd.maHD group by cthd.maSP, hd.ngayLap,cthd.maHD having YEAR(hd.ngayLap)="+ "'"+ nam +"'" + "and MONTH(hd.ngayLap)=" + "'" + thang + "'";

                        Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maSP = rs.getString(1);
				Date ngayLap = rs.getDate(2);
				String maHD = rs.getString(3);
				dsThongKe.add(new ThongKeDoanhThu(maSP, ngayLap, maHD));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsThongKe;
	}
        
        
        public ArrayList<ThongKeDoanhThu> VAT(String ma) {
    		ArrayList<ThongKeDoanhThu> dsThongKe = new ArrayList<ThongKeDoanhThu>();

    		try {
    			DataBase.getInstance();
    			Connection con = DataBase.getConnection();

    			String sql = " select maSP , VAT from SanPham  where maSP = " + "'" + ma + "'";

                            Statement statement = con.createStatement();
    			ResultSet rs = statement.executeQuery(sql);

    			while (rs.next()) {
    				String maSP = rs.getString(1);
    				double vat = rs.getDouble(2);
    				dsThongKe.add(new ThongKeDoanhThu(maSP, vat));
    			}
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    		return dsThongKe;
    	}
}
