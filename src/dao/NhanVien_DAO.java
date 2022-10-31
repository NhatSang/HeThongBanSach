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
import entity.NhanVien;

public class NhanVien_DAO {

	public NhanVien_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<NhanVien> getAllNV(){
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		try {
			DataBase.getInstance();
			Connection con = DataBase.getConnection();

			String sql = "Select nv.*,cv.tenCV from NhanVien nv\r\n"
					+ "join ChucVu cv on nv.maCV = cv.maCV\r\n"
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
			ResultSet rs = stm.executeQuery("select maNV,hoTen,maCV from NhanVien where maNV = " + "'" + maNV + "' and trangThai = 0");
			if (rs.next()) {
				String ma = rs.getString(1);
				String hoTen = rs.getString(2);
				ChucVu chucVu = new ChucVu(rs.getString(3));
				nv = new NhanVien(ma,hoTen, chucVu);
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
			pre = con.prepareStatement("update NhanVien set hoTen=?,ngaySinh=?,email=?,diachi=?,sdt=?,gioitinh=?,chucvu=? where maNV=?");
			pre.setString(2,nv.getHoTen() );
			pre.setString(3,nv.getNgaySinh().toString());
			pre.setString(4,nv.getCccd() );
			pre.setString(5,nv.getDiaChi() );
			pre.setString(6,nv.getSdt() );
			pre.setBoolean(7,nv.isGioiTinh() );
			pre.setString(9,nv.getChucVu().getTenCV());
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
    		statement.setString(1, nv.getMaNV());
    		statement.setString(2, nv.getHoTen());
    		statement.setString(3, nv.getNgaySinh().toString());
    		statement.setString(4, nv.getCccd());
            statement.setString(5, nv.getDiaChi());
            statement.setString(6, nv.getSdt());
    		statement.setBoolean(7, nv.isGioiTinh());
    		statement.setString(9,nv.getChucVu().getMaCV());
    		statement.executeUpdate();
    	} catch (Exception e) {
    		// TODO: handle exception
    		e.printStackTrace();
    	} finally {
    		statement.close();
    	}
        }
        
}
