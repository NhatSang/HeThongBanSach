package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.DataBase;
import entity.CapDoHoc;
import entity.LoaiBia;
import entity.LoaiSanPham;
import entity.NhaCungCap;
import entity.NhaXuatBan;
import entity.Sach;
import entity.SanPham;
import entity.TacGia;

public class SanPham_DAO {

	public SanPham_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Sang
	public ArrayList<Sach> getAllSach() {
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		DataBase.getInstance();
		Connection con = DataBase.getConnection();

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(
					"select maSP,tenSP,namXB_SX,soLuong,donGia,donVi,VAT,soTrang,nguoiDich,tuoiGioiHan,moTa,hinhAnh,maLoai,maNCC,maNXB,maTG,maLB,maCDH from SanPham");

			while (rs.next()) {
				String maSach = rs.getString(1);
				String tenSach = rs.getString(2);
				int namXB = rs.getInt(3);
				int soLuong = rs.getInt(4);
				double donGia = rs.getFloat(5);
				String donVi = rs.getString(6);
				int VAT = rs.getInt(7);
				int soTrang = rs.getInt(8);
				String nguoiDich = rs.getString(9);
				int tuoiGH = rs.getInt(10);
				String moTa = rs.getString(11);
				String hinhAnh = rs.getString(12);
				LoaiSanPham loaiSp = new LoaiSanPham(rs.getString(13));
				NhaCungCap ncc = new NhaCungCap(rs.getString(14));
				NhaXuatBan nxb = new NhaXuatBan(rs.getString(15));
				TacGia tacGia = new TacGia(rs.getString(16));
				LoaiBia loaiBia = new LoaiBia(rs.getString(17));
				String maCDH = rs.getString(18);
				CapDoHoc cdh = null;
				if (maCDH != null) {
					cdh = new CapDoHoc(maCDH);
				}
				Sach sach = new Sach(maSach, tenSach, donVi, moTa, hinhAnh, soLuong, VAT, donGia, loaiSp, ncc, namXB,
						soTrang, tuoiGH, nguoiDich, nxb, tacGia, loaiBia, cdh);
				dsSach.add(sach);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsSach;
	}

	// Sang
	public SanPham timKiemSPTheoMa(String key) {
		SanPham sp = null;
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			String sql = "select maSP,tenSP,hinhAnh,donGia, donVi, soLuong,maNCC from SanPham where tenSP = "
					+ "N'"+key+"' or maSP =" +"'"+key +"'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maSp = rs.getString(1);
				String tenSp = rs.getString(2);
				String hinhAnh = rs.getString(3);
				double donGia = rs.getFloat(4);
				String donVi = rs.getString(5);
				int soLuong = rs.getInt(6);
				NhaCungCap ncc = new NhaCungCap(rs.getString(7));
				sp = new SanPham(maSp, tenSp, donVi, hinhAnh, soLuong, donGia, ncc);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sp;
	}

}
