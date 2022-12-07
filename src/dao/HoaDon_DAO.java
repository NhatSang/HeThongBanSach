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
import entity.SanPham;

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
			ResultSet rs = stm.executeQuery("select dbo.autoIDHD()");
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
					"select hd.maHD,hd.ngayLap,hd.caLap,nv.maNV,nv.hoTen,kh.maKH,kh.hoTen,kh.diaChi, kh.sdt from HoaDon hd join NhanVien nv on hd.maNV = nv.maNV join KhachHang kh on hd.maKH=kh.maKH where hd.trangThai = 0");
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

	public void themCTHD(ChiTietHoaDon c, String maHD) throws SQLException {
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		PreparedStatement stm = null;
		try {
			String sql = "insert into ChiTietHoaDon \r\n" + "values (?,?,?,?)";
			stm = con.prepareStatement(sql);
			stm.setDouble(1, c.getGiaBan());
			stm.setInt(2, c.getSoLuong());
			stm.setString(3, c.getSanPham().getMaSP());
			stm.setString(4, maHD);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			stm.close();
		}
	}

	public ArrayList<ChiTietHoaDon> getDSCT(String key) {
		ArrayList<ChiTietHoaDon> dsCTHD = new ArrayList<ChiTietHoaDon>();
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(
					"select ct.*,sp.tenSP,sp.donGia,sp.VAT,sp.soLuong from ChiTietHoaDon ct join SanPham sp on ct.maSP = sp.maSP where maHD = '"
							+ key + "'");
			while (rs.next()) {
				double giaBan = rs.getFloat(1);
				int soLuong = rs.getInt(2);
				String maSp = rs.getString(3);
				String maHD = rs.getString(4);
				String tenSp = rs.getString(5);
				double donGia = rs.getFloat(6);
				int vat = rs.getInt(7);
				int sl = rs.getInt(8);
				SanPham sp = new SanPham(maSp, tenSp, sl, vat, donGia);
				ChiTietHoaDon c = new ChiTietHoaDon(soLuong, giaBan, sp);
				dsCTHD.add(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsCTHD;
	}

	public void xoaHD(String key) throws SQLException {
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		PreparedStatement stm = null;
		try {
			String sql = "delete from HoaDon where maHD = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, key);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			stm.close();
		}
	}

	public void thanhToanHD(String key) throws SQLException {
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		PreparedStatement stm = null;
		try {
			String sql = "update HoaDon\r\n" + "set trangThai = 1\r\n" + "where maHd = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, key);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			stm.close();
		}
	}

	public ArrayList<HoaDon> timHD(String key){
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			Statement stm = con.createStatement();
			String sql = "select hd.maHD,hd.ngayLap,hd.caLap,nv.maNV,nv.hoTen,kh.maKH,kh.hoTen,kh.diaChi, kh.sdt from HoaDon hd join NhanVien nv on hd.maNV = nv.maNV join KhachHang kh on hd.maKH=kh.maKH where hd.trangThai = 0 and kh.sdt = '"+key+"'";
			ResultSet rs = stm.executeQuery(sql);
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
}
