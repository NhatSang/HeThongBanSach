package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.DataBase;
import entity.CapDoHoc;
import entity.LoaiBia;
import entity.LoaiSanPham;
import entity.MauSac;
import entity.NhaCungCap;
import entity.NhaXuatBan;
import entity.Sach;
import entity.SanPham;
import entity.TacGia;
import entity.ThuongHieu;
import entity.VanPhongPham;

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
					"select sp.maSP,sp.tenSP, sp.namXB_SX, sp.soLuong,sp.donGia, sp.donVi,sp.VAT, sp.soTrang, sp.tuoiGioiHan, sp.nguoiDich, sp.moTa,sp.hinhAnh,\r\n"
					+ "lsp.*,ncc.maNCC, ncc.tenNCC,nxb.*,tg.tenTG,lb.*,cdh.*\r\n"
					+ "from SanPham sp \r\n"
					+ "left join LoaiSanPham lsp on sp.maLoai = lsp.maLoai \r\n"
					+ "left join NhaCungCap ncc on sp.maNCC = ncc.maNCC\r\n"
					+ "left join NhaXuatBan nxb on sp.maNXB = nxb.maNXB\r\n"
					+ "left join TacGia tg on sp.maTG = tg.maTG\r\n"
					+ "left join LoaiBia lb on sp.maLB = lb.maLB\r\n"
					+ "left join CapDoHoc cdh on sp.maCDH = cdh.maCDH\r\n"
					+ "where maSP not like 'VPP%' and sp.trangThai = 0");

			while (rs.next()) {
				String maSach = rs.getString(1);
				String tenSach = rs.getString(2);
				int namXB = rs.getInt(3);
				int soLuong = rs.getInt(4);
				double donGia = rs.getFloat(5);
				String donVi = rs.getString(6);
				int VAT = rs.getInt(7);
				int soTrang = rs.getInt(8);
				int tuoiGH = rs.getInt(9);
				String nguoiDich = rs.getString(10);
				String moTa = rs.getString(11);
				String hinhAnh = rs.getString(12);
				LoaiSanPham loaiSp = new LoaiSanPham(rs.getString(13),rs.getString(14));
				NhaCungCap ncc = new NhaCungCap(rs.getString(15),rs.getString(16));
				NhaXuatBan nxb = new NhaXuatBan(rs.getString(17),rs.getString(18));
				TacGia tacGia = new TacGia(rs.getString(19));
				LoaiBia loaiBia = new LoaiBia(rs.getString(20),rs.getString(21));
				String maCDH = rs.getString(22);
				CapDoHoc cdh = null;
				if (maCDH != null) {
					cdh = new CapDoHoc(maCDH,rs.getString(23),rs.getInt(24));
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
	//get allVPP
	public ArrayList<VanPhongPham> getAllVPP1() {
		ArrayList<VanPhongPham> dsVPP = new ArrayList<VanPhongPham>();
		DataBase.getInstance();
		Connection con = DataBase.getConnection();

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(
					"select sp.maSP,sp.tenSP, sp.soLuong,sp.donGia,sp.donVi,sp.VAT ,sp.xuatXu,sp.chatLieu, sp.moTa,sp.hinhAnh,\r\n"
					+ "lsp.*,ncc.maNCC, ncc.tenNCC,th.*,ms.*\r\n"
					+ "from SanPham sp \r\n"
					+ "left join LoaiSanPham lsp on sp.maLoai = lsp.maLoai \r\n"
					+ "left join NhaCungCap ncc on sp.maNCC = ncc.maNCC\r\n"
					+ "left join ThuongHieu th on sp.maTH = th.maTH\r\n"
					+ "left join MauSac ms on sp.maMau = ms.maMau\r\n"
					+ "where maSP like 'VPP%' and sp.trangThai = 0");
			while (rs.next()) {
				String maVPP = rs.getString(1);
				String tenVPP = rs.getString(2);
				int soLuong = rs.getInt(3);
				double donGia = rs.getFloat(4);
				String donVi = rs.getString(5);
				int VAT = rs.getInt(6);
				String xuatXu = rs.getString(7);
				String chatLieu = rs.getString(8);
				String moTa = rs.getString(9);
				String hinhAnh = rs.getString(10);
				LoaiSanPham loaiSp = new LoaiSanPham(rs.getString(11),rs.getString(12));
				NhaCungCap ncc = new NhaCungCap(rs.getString(13),rs.getString(14));
				ThuongHieu th = new ThuongHieu(rs.getString(15), rs.getString(16));
				MauSac ms = new MauSac(rs.getString(17), rs.getString(18));
				VanPhongPham vpp = new VanPhongPham(maVPP, tenVPP, donVi, moTa, hinhAnh, soLuong, VAT, donGia, loaiSp, ncc, xuatXu, chatLieu, th, ms);
				dsVPP.add(vpp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsVPP;
	}
	// Sang
	public SanPham timKiemSPTheoMa(String key) {
		SanPham sp = null;
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			String sql = "select maSP,tenSP,hinhAnh,donGia, donVi, soLuong, VAT, ncc.maNCC, ncc.tenNCC from SanPham sp \r\n"
					+ "join NhaCungCap ncc on sp.maNCC = ncc.maNCC\r\n"
					+ "where (tenSP = "
					+ "N'" + key + "' or maSP =" + "'" + key + "') and sp.trangThai = 0";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maSp = rs.getString(1);
				String tenSp = rs.getString(2);
				String hinhAnh = rs.getString(3);
				double donGia = rs.getFloat(4);
				String donVi = rs.getString(5);
				int soLuong = rs.getInt(6);
				int VAT = rs.getInt(7);
				NhaCungCap ncc = new NhaCungCap(rs.getString(8),rs.getString(9));
				sp = new SanPham(maSp, tenSp, donVi, hinhAnh, soLuong, VAT, donGia, ncc);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sp;
	}
	//Sang xóa sp
	public void xoa_SP(String maSp) throws SQLException {
		DataBase.getInstance();
		Connection connection = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "update SanPham set trangThai = 1 where maSP = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, maSp);
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}
	// Sang cap nhat so luong
	public void capNhat_soLuong(String maSp,int soLuong) throws SQLException {
		DataBase.getInstance();
		Connection connection = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "update SanPham set soLuong = ? where maSP = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, soLuong);
			statement.setString(2, maSp);
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}
}
