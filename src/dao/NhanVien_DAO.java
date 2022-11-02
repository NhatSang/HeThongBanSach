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
import entity.ChucVu;
import entity.KhachHang;
import entity.LoaiBia;
import entity.NhanVien;
import entity.TaiKhoan;

public class NhanVien_DAO {

	public NhanVien_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<NhanVien> getAllNV() {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		try {
			DataBase.getInstance();
			Connection con = DataBase.getConnection();

			String sql = "Select nv.*,cv.tenCV from NhanVien nv\r\n" + "join ChucVu cv on nv.maCV = cv.maCV\r\n"
					+ "where trangThai = 0";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String ma = rs.getString(1);
				String hoten = rs.getString(2);
				Date ns = rs.getDate(3);
				String cccd = rs.getString(4);
				String diaChi = rs.getString(5);
				String sdt = rs.getString(6);
				Boolean gt = rs.getBoolean(7);
				ChucVu cv = new ChucVu(rs.getString(9), rs.getString(10));
				dsNV.add(new NhanVien(ma, hoten, cccd, diaChi, sdt, ns, gt, cv));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}

	public NhanVien timKiemNVTheoMa(String maNV) {
		NhanVien nv = null;
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(
					"select maNV,hoTen,maCV from NhanVien where maNV = " + "'" + maNV + "' and trangThai = 0");
			if (rs.next()) {
				String ma = rs.getString(1);
				String hoTen = rs.getString(2);
				ChucVu chucVu = new ChucVu(rs.getString(3));
				nv = new NhanVien(ma, hoTen, chucVu);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nv;
	}

	public NhanVien timKiemNVTheoCCCD(String cccd) {
		NhanVien nv = null;
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(
					"select maNV,hoTen,maCV from NhanVien where cccd = '" + cccd + "' and trangThai = 0");
			if (rs.next()) {
				String ma = rs.getString(1);
				String hoTen = rs.getString(2);
				ChucVu chucVu = new ChucVu(rs.getString(3));
				nv = new NhanVien(ma, hoTen, chucVu);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nv;
	}
	
	public void xoa_NV(String maNV) throws SQLException {
		DataBase.getInstance();
		Connection connection = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "update NhanVien set trangThai = 1 where maNV = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, maNV);
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}

	public void suanv(NhanVien nv) {
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(
					"update NhanVien set hoTen=?,ngaySinh=?,cccd=?,diaChi=?,sdt=?,gioiTinh=?,maCV=? where maNV=?");
			pre.setString(1, nv.getHoTen());
			pre.setDate(2, nv.getNgaySinh());
			pre.setString(3, nv.getCccd());
			pre.setString(4, nv.getDiaChi());
			pre.setString(5, nv.getSdt());
			pre.setBoolean(6, nv.isGioiTinh());
			pre.setString(7, nv.getChucVu().getMaCV());
			pre.setString(8, nv.getMaNV());
			pre.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void addNV(NhanVien nv) throws SQLException {
		DataBase.getInstance();
		Connection connection = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "insert into NhanVien values (default, ?, ?, ?, ?, ?, ?, 0,?)";
			statement = connection.prepareStatement(sql);
			// statement.setString(1, nv.getMaNV());
			statement.setString(1, nv.getHoTen());
			statement.setDate(2, nv.getNgaySinh());
			statement.setString(3, nv.getCccd());
			statement.setString(4, nv.getDiaChi());
			statement.setString(5, nv.getSdt());
			statement.setBoolean(6, nv.isGioiTinh());
			statement.setString(7, nv.getChucVu().getMaCV());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}

	public ArrayList<ChucVu> getchucvu() {
		ArrayList<ChucVu> dschucvu = new ArrayList<ChucVu>();
		try {
			DataBase.getInstance();
			Connection connection = DataBase.getConnection();
			PreparedStatement statement = null;

			String sql = "Select * from ChucVu";
			Statement statement1 = connection.createStatement();
			ResultSet rs = statement1.executeQuery(sql);

			while (rs.next()) {

				dschucvu.add(new ChucVu(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dschucvu;
	}

	public void themTK(String maNV) throws SQLException {
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		PreparedStatement stm = null;
		try {
			String sql = "insert into TaiKhoan values (?,'123',?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, maNV);
			stm.setString(2, maNV);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			stm.close();
		}
	}
	
	public TaiKhoan timTK(String maNV){
		TaiKhoan tk = null;
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			String sql = "select * from TaiKhoan where maNV = '"+maNV+"'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				String taiKhoan = rs.getString(1);
				String matKhau = rs.getString(2);
				NhanVien nv = new NhanVien(maNV);
				tk = new TaiKhoan(taiKhoan, matKhau, nv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tk;
	}
	
	public ArrayList<NhanVien> timKiemNV(String key){
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			String sql = "Select nv.*,cv.tenCV from NhanVien nv\r\n" + "join ChucVu cv on nv.maCV = cv.maCV\r\n"
					+ "where (maNV = '" +key+"' or hoTen like N'%"+key+"%') and trangThai = 0 ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String ma = rs.getString(1);
				String hoten = rs.getString(2);
				Date ns = rs.getDate(3);
				String cccd = rs.getString(4);
				String diaChi = rs.getString(5);
				String sdt = rs.getString(6);
				Boolean gt = rs.getBoolean(7);
				ChucVu cv = new ChucVu(rs.getString(9), rs.getString(10));
				dsNV.add(new NhanVien(ma, hoten, cccd, diaChi, sdt, ns, gt, cv));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsNV;
	}
}
