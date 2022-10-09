package entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class HoaDon {
	private String maHD;
	private LocalDate ngayLapHD;
	private int caLapHD;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private ArrayList<ChiTietHoaDon> dsChiTiet;

	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String maHD, LocalDate ngayLapHD, int caLapHD, NhanVien nhanVien, KhachHang khachHang) {
		super();
		this.maHD = maHD;
		this.ngayLapHD = ngayLapHD;
		this.caLapHD = caLapHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.dsChiTiet = new ArrayList<>(dsChiTiet);
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public LocalDate getNgayLapHD() {
		return ngayLapHD;
	}

	public void setNgayLapHD(LocalDate ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}

	public int getCaLapHD() {
		return caLapHD;
	}

	public void setCaLapHD(int caLapHD) {
		this.caLapHD = caLapHD;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public ArrayList<ChiTietHoaDon> getDsChiTiet() {
		return dsChiTiet;
	}

	public void setDsChiTiet(ArrayList<ChiTietHoaDon> dsChiTiet) {
		this.dsChiTiet = dsChiTiet;
	}

	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ngayLapHD=" + ngayLapHD + ", caLapHD=" + caLapHD + ", nhanVien=" + nhanVien
				+ ", khachHang=" + khachHang + ", dsChiTiet=" + dsChiTiet + "]";
	}

}
