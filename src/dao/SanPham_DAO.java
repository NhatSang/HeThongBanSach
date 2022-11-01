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
							+ "lsp.*,ncc.maNCC, ncc.tenNCC,nxb.*,tg.tenTG,lb.*,cdh.*\r\n" + "from SanPham sp \r\n"
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
				LoaiSanPham loaiSp = new LoaiSanPham(rs.getString(13), rs.getString(14));
				NhaCungCap ncc = new NhaCungCap(rs.getString(15), rs.getString(16));
				NhaXuatBan nxb = new NhaXuatBan(rs.getString(17), rs.getString(18));
				TacGia tacGia = new TacGia(rs.getString(19));
				LoaiBia loaiBia = new LoaiBia(rs.getString(20), rs.getString(21));
				String maCDH = rs.getString(22);
				CapDoHoc cdh = null;
				if (maCDH != null) {
					cdh = new CapDoHoc(maCDH, rs.getString(23), rs.getInt(24));
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

	// get allVPP
	public ArrayList<VanPhongPham> getAllVPP1() {
		ArrayList<VanPhongPham> dsVPP = new ArrayList<VanPhongPham>();
		DataBase.getInstance();
		Connection con = DataBase.getConnection();

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(
					"select sp.maSP,sp.tenSP, sp.soLuong,sp.donGia,sp.donVi,sp.VAT ,sp.xuatXu,sp.chatLieu, sp.moTa,sp.hinhAnh,\r\n"
							+ "lsp.*,ncc.maNCC, ncc.tenNCC,th.*,ms.*\r\n" + "from SanPham sp \r\n"
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
				LoaiSanPham loaiSp = new LoaiSanPham(rs.getString(11), rs.getString(12));
				NhaCungCap ncc = new NhaCungCap(rs.getString(13), rs.getString(14));
				ThuongHieu th = new ThuongHieu(rs.getString(15), rs.getString(16));
				MauSac ms = new MauSac(rs.getString(17), rs.getString(18));
				VanPhongPham vpp = new VanPhongPham(maVPP, tenVPP, donVi, moTa, hinhAnh, soLuong, VAT, donGia, loaiSp,
						ncc, xuatXu, chatLieu, th, ms);
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
					+ "join NhaCungCap ncc on sp.maNCC = ncc.maNCC\r\n" + "where (tenSP = " + "N'" + key + "' or maSP ="
					+ "'" + key + "') and sp.trangThai = 0";
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
				NhaCungCap ncc = new NhaCungCap(rs.getString(8), rs.getString(9));
				sp = new SanPham(maSp, tenSp, donVi, hinhAnh, soLuong, VAT, donGia, ncc);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sp;
	}

	// Sang xóa sp
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
	public void capNhat_soLuong(String maSp, int soLuong) throws SQLException {
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

	// Thanh_Them Sach
	public void themSach(Sach sach) throws SQLException {
		DataBase.getInstance();
		Connection connection = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "insert into SanPham (maSP,tenSP,namXB_SX,soLuong,donGia,donVi,VAT,soTrang,nguoiDich,tuoiGioiHan,moTa,hinhAnh,maLoai,maNCC,maNXB,maTG,maLB,maCDH,trangThai) values (dbo.autoIdSP(?), ?, ? ,? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, sach.getLoaiSP().getMaLoai());
			statement.setString(2, sach.getTenSP());
			statement.setInt(3, sach.getNamXB());
			statement.setInt(4, sach.getSoLuong());
			statement.setDouble(5, sach.getDonGia());
			statement.setString(6, sach.getDonVi());
			statement.setInt(7, sach.getVAT());
			statement.setInt(8, sach.getSoTrang());
			statement.setString(9, sach.getNguoiDich());
			statement.setInt(10, sach.getTuoiGioiHan());
			statement.setString(11, sach.getMoTa());
			statement.setString(12, sach.getHinhAnh());
			statement.setString(13, sach.getLoaiSP().getMaLoai());
			statement.setString(14, sach.getNhaCC().getMaNCC());
			statement.setString(15, sach.getNhaXB().getMaNXB());
			statement.setString(16, sach.getTacGia().getMaTG());
			statement.setString(17, sach.getLoaiBia().getMaLB());
			statement.setString(18, sach.getCapDoHoc().getMaCDH());
			statement.setString(19, "0");
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}

	public void suaSach(Sach sach) throws SQLException {
		DataBase.getInstance();
		Connection connection = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "update SanPham set tenSP=?,namXB_SX=?,soLuong=?,donGia=?,donVi=?,VAT=?,soTrang=?,nguoiDich=?,tuoiGioiHan=?,moTa=?,hinhAnh=?,maLoai=?,maNCC=?,maNXB=?,maTG=?,maLB=?,maCDH=? where maSP=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, sach.getTenSP());
			statement.setInt(2, sach.getNamXB());
			statement.setInt(3, sach.getSoLuong());
			statement.setDouble(4, sach.getDonGia());
			statement.setString(5, sach.getDonVi());
			statement.setInt(6, sach.getVAT());
			statement.setInt(7, sach.getSoTrang());
			statement.setString(8, sach.getNguoiDich());
			statement.setInt(9, sach.getTuoiGioiHan());
			statement.setString(10, sach.getMoTa());
			statement.setString(11, sach.getHinhAnh());
			statement.setString(12, sach.getLoaiSP().getMaLoai());
			statement.setString(13, sach.getNhaCC().getMaNCC());
			statement.setString(14, sach.getNhaXB().getMaNXB());
			statement.setString(15, sach.getTacGia().getMaTG());
			statement.setString(16, sach.getLoaiBia().getMaLB());
			statement.setString(17, sach.getCapDoHoc().getMaCDH());
			statement.setString(18, sach.getMaSP());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}

	// Thanh_Them VPP
	public void themVPP(VanPhongPham vpp) throws SQLException {
		DataBase.getInstance();
		Connection connection = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "insert into SanPham (maSP,tenSP,soLuong,donGia,donVi,VAT,xuatXu,chatLieu, moTa,hinhAnh,maLoai,maNCC,maTH,maMau,trangThai)\r\n"
					+ "values (dbo.autoIdSP(?),?, ?,?,?,?,?,?,?,?,?, ?, ?, ?, 0)\r\n";
			statement = connection.prepareStatement(sql);
			statement.setString(1, vpp.getLoaiSP().getMaLoai());
			statement.setString(2, vpp.getTenSP());
			statement.setInt(3, vpp.getSoLuong());
			statement.setDouble(4, vpp.getDonGia());
			statement.setString(5, vpp.getDonVi());
			statement.setInt(6, vpp.getVAT());
			statement.setString(7, vpp.getXuatXu());
			statement.setString(8, vpp.getChatLieu());
			statement.setString(9, vpp.getMoTa());
			statement.setString(10, vpp.getHinhAnh());
			statement.setString(11, vpp.getLoaiSP().getMaLoai());
			statement.setString(12, vpp.getNhaCC().getMaNCC());
			statement.setString(13, vpp.getThuongHieu().getMaTH());
			statement.setString(14, vpp.getMauSac().getMaMau());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}

	// Sua VPP
	public void suaVPP(VanPhongPham vpp) throws SQLException {
		DataBase.getInstance();
		Connection connection = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "update SanPham set tenSP=?,soLuong=?,donGia=?,donVi=?,VAT=?,moTa=?,hinhAnh=?,maLoai=?,maNCC=?,chatLieu=?,maTH=?,maMau=?,xuatXu=? where maSP=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, vpp.getTenSP());
			statement.setInt(2, vpp.getSoLuong());
			statement.setDouble(3, vpp.getDonGia());
			statement.setString(4, vpp.getDonVi());
			statement.setInt(5, vpp.getVAT());
			statement.setString(6, vpp.getMoTa());
			statement.setString(7, vpp.getHinhAnh());
			statement.setString(8, vpp.getLoaiSP().getMaLoai());
			statement.setString(9, vpp.getNhaCC().getMaNCC());
			statement.setString(10, vpp.getChatLieu());
			statement.setString(11, vpp.getThuongHieu().getMaTH());
			statement.setString(12, vpp.getMauSac().getMaMau());
			statement.setString(13, vpp.getXuatXu());
			statement.setString(14, vpp.getMaSP());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}

	public ArrayList<LoaiSanPham> getLoaiSP() {
		ArrayList<LoaiSanPham> dsLoaiSP = new ArrayList<LoaiSanPham>();
		try {
			DataBase.getInstance();
			Connection connection = DataBase.getConnection();
			PreparedStatement statement = null;

			String sql = "Select * from LoaiSanPham";
			Statement statement1 = connection.createStatement();
			ResultSet rs = statement1.executeQuery(sql);

			while (rs.next()) {

				dsLoaiSP.add(new LoaiSanPham(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsLoaiSP;
	}

	public ArrayList<NhaCungCap> getNCC() {
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		try {
			DataBase.getInstance();
			Connection connection = DataBase.getConnection();
			PreparedStatement statement = null;

			String sql = "Select * from NhaCungCap";
			Statement statement1 = connection.createStatement();
			ResultSet rs = statement1.executeQuery(sql);

			while (rs.next()) {

				dsNCC.add(new NhaCungCap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNCC;
	}

	public ArrayList<NhaXuatBan> getNXB() {
		ArrayList<NhaXuatBan> dsNXB = new ArrayList<NhaXuatBan>();
		try {
			DataBase.getInstance();
			Connection connection = DataBase.getConnection();
			PreparedStatement statement = null;

			String sql = "Select * from NhaXuatBan";
			Statement statement1 = connection.createStatement();
			ResultSet rs = statement1.executeQuery(sql);

			while (rs.next()) {

				dsNXB.add(new NhaXuatBan(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsNXB;
	}

	public ArrayList<MauSac> getMauSac() {
		ArrayList<MauSac> dsMauSac = new ArrayList<MauSac>();
		try {
			DataBase.getInstance();
			Connection connection = DataBase.getConnection();
			PreparedStatement statement = null;

			String sql = "Select * from MauSac";
			Statement statement1 = connection.createStatement();
			ResultSet rs = statement1.executeQuery(sql);

			while (rs.next()) {

				dsMauSac.add(new MauSac(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsMauSac;
	}

	public ArrayList<ThuongHieu> getTH() {
		ArrayList<ThuongHieu> dsTH = new ArrayList<ThuongHieu>();
		try {
			DataBase.getInstance();
			Connection connection = DataBase.getConnection();
			PreparedStatement statement = null;

			String sql = "Select * from ThuongHieu";
			Statement statement1 = connection.createStatement();
			ResultSet rs = statement1.executeQuery(sql);

			while (rs.next()) {

				dsTH.add(new ThuongHieu(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsTH;
	}

	public ArrayList<LoaiBia> getLoaiBia() {
		ArrayList<LoaiBia> dsLoaiBia = new ArrayList<LoaiBia>();
		try {
			DataBase.getInstance();
			Connection connection = DataBase.getConnection();
			PreparedStatement statement = null;

			String sql = "Select * from LoaiBia";
			Statement statement1 = connection.createStatement();
			ResultSet rs = statement1.executeQuery(sql);

			while (rs.next()) {

				dsLoaiBia.add(new LoaiBia(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsLoaiBia;
	}

	public ArrayList<CapDoHoc> getCDH() {
		ArrayList<CapDoHoc> dsCDH = new ArrayList<CapDoHoc>();
		try {
			DataBase.getInstance();
			Connection connection = DataBase.getConnection();
			PreparedStatement statement = null;

			String sql = "Select * from CapDoHoc";
			Statement statement1 = connection.createStatement();
			ResultSet rs = statement1.executeQuery(sql);

			while (rs.next()) {

				dsCDH.add(new CapDoHoc(rs.getString(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsCDH;
	}

	public TacGia timTacGia(String key) {
		TacGia tg = null;
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			String sql = "select * from TacGia where tenTG = N'" + key + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				String maTg = rs.getString(1);
				String tenTg = rs.getString(2);
				tg = new TacGia(maTg, tenTg);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tg;
	}
	public void themTG(TacGia tg) throws SQLException {
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "insert into TacGia values (default,?)";
			statement = con.prepareStatement(sql);
			statement.setNString(1, tg.getTenTG());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}
	
	public ThuongHieu timThuongHieu(String key) {
		ThuongHieu th = null;
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			String sql = "select * from ThuongHieu where tenTH = N'" + key + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				String maTg = rs.getString(1);
				String tenTg = rs.getString(2);
				th = new ThuongHieu(maTg, tenTg);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return th;
	}
	
	public void themThuongHieu(ThuongHieu th) throws SQLException {
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "insert into ThuongHieu values (default,?)";
			statement = con.prepareStatement(sql);
			statement.setNString(1, th.getTenTH());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}
	
	public ArrayList<Sach> timKiemSach(String key) {
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		DataBase.getInstance();
		Connection con = DataBase.getConnection();

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(
					"select sp.maSP,sp.tenSP, sp.namXB_SX, sp.soLuong,sp.donGia, sp.donVi,sp.VAT, sp.soTrang, sp.tuoiGioiHan, sp.nguoiDich, sp.moTa,sp.hinhAnh,\r\n"
							+ "lsp.*,ncc.maNCC, ncc.tenNCC,nxb.*,tg.tenTG,lb.*,cdh.*\r\n" + "from SanPham sp \r\n"
							+ "left join LoaiSanPham lsp on sp.maLoai = lsp.maLoai \r\n"
							+ "left join NhaCungCap ncc on sp.maNCC = ncc.maNCC\r\n"
							+ "left join NhaXuatBan nxb on sp.maNXB = nxb.maNXB\r\n"
							+ "left join TacGia tg on sp.maTG = tg.maTG\r\n"
							+ "left join LoaiBia lb on sp.maLB = lb.maLB\r\n"
							+ "left join CapDoHoc cdh on sp.maCDH = cdh.maCDH\r\n"
							+ "where maSP not like 'VPP%' and sp.trangThai = 0 "
							+ "and ( sp.maSP like '%"+ key +"%' or sp.tenSP like N'%"+ key +"%' "
							+ "or sp.nguoiDich like '%" + key + "%' or lsp.maLoai like '%" + key + "%' "
							+ "or lsp.tenLoai like '%" + key + "%' or tg.tenTG like '%" + key + "%'"
							+ ")");

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
				LoaiSanPham loaiSp = new LoaiSanPham(rs.getString(13), rs.getString(14));
				NhaCungCap ncc = new NhaCungCap(rs.getString(15), rs.getString(16));
				NhaXuatBan nxb = new NhaXuatBan(rs.getString(17), rs.getString(18));
				TacGia tacGia = new TacGia(rs.getString(19));
				LoaiBia loaiBia = new LoaiBia(rs.getString(20), rs.getString(21));
				String maCDH = rs.getString(22);
				CapDoHoc cdh = null;
				if (maCDH != null) {
					cdh = new CapDoHoc(maCDH, rs.getString(23), rs.getInt(24));
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
}
