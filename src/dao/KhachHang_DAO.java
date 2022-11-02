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

			String sql = "Select * from KhachHang where trangThai = 0";
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
	// Sang đã chỉnh sửa
	public void xoa_KH(String maKH) throws SQLException {
		DataBase.getInstance();
		Connection connection = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "update KhachHang set trangThai = 1 where maKH = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, maKH);
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}

	public void xoaTheoTrangThai(KhachHang kh) throws SQLException {
		DataBase.getInstance();
		Connection connection = DataBase.getConnection();
		PreparedStatement statement = null;
		String trangThai = "1";
		try {
			String sql = "update KhachHang set trangThai=? where maKH=?";
			statement = connection.prepareStatement(sql);
			statement.setString(2, kh.getMaKH());
			statement.setString(1, trangThai);
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
			ResultSet rs = stm
					.executeQuery("select maKH,hoTen,diaChi,sdt from KhachHang where sdt =" + "'" + key + "'");
			if (rs.next()) {
				String maKh = rs.getString(1);
				String hoTen = rs.getString(2);
				String diaChi = rs.getString(3);
				String sdt = rs.getString(4);
				kh = new KhachHang(maKh, hoTen, diaChi, sdt);
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
			String sql = "insert into KhachHang values (default, ?, ?, ?, ?, ?,0)";
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

//	Thêm khách hàng
	public void capNhat(KhachHang khachHang) throws SQLException {
		DataBase.getInstance();
		Connection connection = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "update KhachHang set hoTen=?, ngaySinh=?, diaChi=?, sdt=?, gioiTinh=? where maKH=?";
			statement = connection.prepareStatement(sql);
			statement.setString(6, khachHang.getMaKH());
			statement.setString(1, khachHang.getHoTen());
			statement.setString(2, khachHang.getNgaySinh().toString());
			statement.setString(3, khachHang.getDiaChi());
			statement.setString(4, khachHang.getsDT());
			statement.setString(5, khachHang.getGioiTinh().toString());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}
}
