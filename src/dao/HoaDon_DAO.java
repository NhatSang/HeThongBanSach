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
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

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
				s = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return s;
	}

	public void themHD(HoaDon hd, boolean trangThai) throws SQLException {
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		PreparedStatement stm = null;
		try {
			String sql = "insert into HoaDon \r\n" + "values (?,?,?,?,?,?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, hd.getMaHD());
			stm.setDate(2, Date.valueOf(hd.getNgayLapHD()));
			stm.setInt(3, hd.getCaLapHD());
			stm.setBoolean(4, trangThai);
			stm.setString(5, hd.getNhanVien().getMaNV());
			stm.setString(6, hd.getKhachHang().getMaKH());
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			stm.close();
		}
	}

	public ArrayList<HoaDon> getDSHD0() {
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(
					"select hd.maHD,hd.ngayLap,hd.caLap,nv.maNV,nv.hoTen,kh.maKH,kh.hoTen,kh.diaChi, kh.sdt from HoaDon hd join NhanVien nv on hd.maNV = nv.maNV join KhachHang kh on hd.maKH=kh.maKH");
			while (rs.next()) {
				String maHd = rs.getString(1);
				LocalDate ngayLap = LocalDate.parse(rs.getDate(2).toString());
				int caLap = rs.getInt(3);
				String maNv = rs.getString(4);
				String tenNv = rs.getString(5);
				NhanVien nv = new NhanVien(maNv, tenNv);
				String maKh = rs.getString(6);
				String tenKh = rs.getString(7);
				String diaChi = rs.getString(8);
				String sdt = rs.getString(9);
				KhachHang kh = new KhachHang(maKh, tenKh, diaChi, sdt);
				HoaDon hd = new HoaDon(maHd, ngayLap, caLap, nv, kh);
				dsHD.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsHD;
	}

	public void addCTHD(HoaDon hd) throws SQLException {
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		PreparedStatement stm = null;
		for (ChiTietHoaDon c : hd.getDsChiTiet()) {
			try {
				String sql = "insert into ChiTietHoaDon \r\n" + "values (?,?,?,?)";
				stm = con.prepareStatement(sql);
				stm.setDouble(1, c.getGiaBan());
				stm.setInt(2, c.getSoLuong());
				stm.setString(3, c.getSanPham().getMaSP());
				stm.setString(4, hd.getMaHD());
				stm.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				stm.close();
			}
		}
	}
}
