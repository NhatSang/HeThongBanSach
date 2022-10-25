/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
public class KhachHang_DAO {

	public KhachHang_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<KhachHang> getAllKhachHang() {
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
				Date ns = rs.getDate(3);
				String diaChi = rs.getString(4);
				String sdt = rs.getString(5);
				Boolean gt = rs.getBoolean(6);
				dsKH.add(new KhachHang(ma, hoten, ns, diaChi, sdt, gt));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}

//        Xoá Khách hàng
	public void xoa_KH(String maKH) throws SQLException {
		DataBase.getInstance();
		Connection connection = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "delete from KhachHang where maKH='" + maKH + "'";
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}

	// Sang: tìm tt 1 khách hàng theo sdt
	public KhachHang timKhachHangTheoSdt(String key) {
		KhachHang kh = null;
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select hoTen,diaChi,sdt from KhachHang where sdt =" + "'" + key + "'");
			if(rs.next()) {
				String hoTen = rs.getString(1);
				String diaChi = rs.getString(2);
				String sdt = rs.getString(3);
				kh = new KhachHang(hoTen, diaChi, sdt);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kh;
	}
//	Thêm khách hàng
    public void addKH(KhachHang kh) throws SQLException {
        DataBase.getInstance();
	Connection connection = DataBase.getConnection();
	PreparedStatement statement = null;
	try {
		String sql = "insert into KhachHang values (default, ?, ?, ?, ?, ?)";
		statement = connection.prepareStatement(sql);
//		statement.setString(1, kh.getMaKH());
		statement.setString(1, kh.getHoTen());
		statement.setString(2, kh.getNgaySinh().toString());
        statement.setString(3, kh.getDiaChi());
        statement.setString(4, kh.getsDT());
		statement.setBoolean(5, kh.getGioiTinh());
		statement.executeUpdate();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} finally {
		statement.close();
	}
    }
}	
