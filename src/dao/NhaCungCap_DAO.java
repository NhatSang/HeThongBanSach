package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connectDB.DataBase;
import entity.NhaCungCap;

public class NhaCungCap_DAO {

	public NhaCungCap_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<NhaCungCap> getAllNhaCungCap() {
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		try {
			DataBase.getInstance();
			Connection con = DataBase.getConnection();

			String sql = "Select * from NhaCungCap where trangThai = 0";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String nguoidaidien = rs.getString(3);
				String sdt = rs.getString(4);
				String diachi = rs.getString(5);
				dsNCC.add(new NhaCungCap(ma, ten, nguoidaidien, sdt, diachi));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNCC;
	}

//  Xoá NCC
	public void xoaNCC(String maNCC) throws SQLException {
		DataBase.getInstance();
		Connection connection = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "delete from NhaCungCap where maNCC='" + maNCC + "'";
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}
//        Xoá theo trạng thái - sử dụng
        public void xoaTheoTrangThai(NhaCungCap nhaCungCap) throws SQLException {
		DataBase.getInstance();
		Connection connection = DataBase.getConnection();
		PreparedStatement statement = null;
                String trangThai = "1";
		try {
			String sql = "update NhaCungCap set trangThai=? where maNCC=?";
			statement = connection.prepareStatement(sql);
			statement.setString(2, nhaCungCap.getMaNCC());
                        statement.setString(1, trangThai);
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}
	public void addNCC(NhaCungCap ncc) throws SQLException {
		DataBase.getInstance();
		Connection connection = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "insert into NhaCungCap values (default, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
//		statement.setString(1, ncc.getMaNCC());
			statement.setString(1, ncc.getTenNCC());
			statement.setString(2, ncc.getNguoiDaiDien());
			statement.setString(3, ncc.getsDt());
			statement.setString(4, ncc.getDiaChi());
                        statement.setString(5, "0");
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}
	
//	Thêm nhà cung cấp
	public void capNhat(NhaCungCap nhaCungCap) throws SQLException {
		DataBase.getInstance();
		Connection connection = DataBase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "update NhaCungCap set tenNCC=?, nguoiDaiDien=?, sdt=?, diaChi=? where maNCC=?";
			statement = connection.prepareStatement(sql);
			statement.setString(5, nhaCungCap.getMaNCC());
			statement.setString(1, nhaCungCap.getTenNCC());
			statement.setString(2, nhaCungCap.getNguoiDaiDien());
			statement.setString(3, nhaCungCap.getsDt());
			statement.setString(4, nhaCungCap.getDiaChi());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}
        public ArrayList<NhaCungCap> timKiem(String Key) {
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		DataBase.getInstance();
		Connection con = DataBase.getConnection();

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from NhaCungCap where (NhaCungCap.maNCC like '%"+Key+"%' or NhaCungCap.sdt like '%"+Key+"%' or NhaCungCap.tenNCC like N'%"+Key+"%') and NhaCungCap.trangThai = 0");

			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String nguoidaidien = rs.getString(3);
				String sdt = rs.getString(4);
				String diachi = rs.getString(5);
				dsNCC.add(new NhaCungCap(ma, ten, nguoidaidien, sdt, diachi));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsNCC;
	}
}
