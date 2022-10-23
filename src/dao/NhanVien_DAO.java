package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.DataBase;
import entity.ChucVu;
import entity.NhanVien;

public class NhanVien_DAO {

	private Statement sta;
	
	public ArrayList<NhanVien> getnv(){
		ArrayList<NhanVien> ls = new ArrayList<NhanVien>();
		try {
			DataBase.getInstance();
			Connection con = DataBase.getConnection();
			
			String sql = "select * from NhanVien";
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(2);
				String hoten = rs.getString(3);
				String ngaysinh = rs.getString(4);
				String cccd = rs.getString(5);
				String diachi = rs.getString(6);
				String  sdt = rs.getString(7);
				boolean gioitinh = rs.getBoolean(8);
				String taikhoan = rs.getString(9);
				String chucvu = rs.getString(10);
				NhanVien nv = new NhanVien(ma, hoten, cccd, diachi, sdt, null, gioitinh, null);
			}
		}catch(Exception e){
			
		}
		return ls;
	}
	
	public NhanVien_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien timKiemNVTheoMa(String maNV) {
		NhanVien nv = null;
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select hoTen,maCV from NhanVien where maNV = " + "'" + maNV + "'");
			if (rs.next()) {
				String hoTen = rs.getString(1);
				ChucVu chucVu = new ChucVu(rs.getString(2));
				nv = new NhanVien(hoTen, chucVu);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nv;
	}
	public void xoaNV(String maNV) {
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			String sql = "delete NhanVien where maNV=?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(0, maNV);
			pre.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void suanv(NhanVien nv) {
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement("update NhanVien set hoTen=?,ngaySinh=?,email=?,diachi=?,sdt=?,gioitinh=?,chucvu=? where maNV=?");
			pre.setString(3,nv.getHoTen() );
			pre.setDate(4,nv.getNgaySinh() );
			pre.setString(5,nv.getCccd() );
			pre.setString(6,nv.getDiaChi() );
			pre.setString(7,nv.getSdt() );
			pre.setBoolean(8,nv.isGioiTinh() );
			pre.setString(10,nv.getChucVu().getTenCV() );
			pre.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
