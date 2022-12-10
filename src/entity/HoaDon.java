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
		this.dsChiTiet = new ArrayList<ChiTietHoaDon>();
	}

	public HoaDon(String maHD, LocalDate ngayLapHD, int caLapHD, NhanVien nhanVien, KhachHang khachHang) {
		super();
		this.maHD = maHD;
		this.ngayLapHD = ngayLapHD;
		this.caLapHD = caLapHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.dsChiTiet = new ArrayList<ChiTietHoaDon>();
	}

	public void themCTHD(SanPham sp, double giaBan, int soLuong) {
		ChiTietHoaDon cTHD = new ChiTietHoaDon(soLuong, giaBan, sp);
		this.dsChiTiet.add(cTHD);
	}

	public void xoaCTHD(int index) {
		this.dsChiTiet.remove(index);
	}
	public double tongTien() {
		double s = 0;
		for(ChiTietHoaDon c : dsChiTiet) {
			s+=c.getGiaBan()*c.getSoLuong();
		}
		return s;
	}
	public double tongVAT() {
		double s = 0;
		for(ChiTietHoaDon c : dsChiTiet) {
			s+=(c.getGiaBan()*(double)c.getSanPham().getVAT()/100)*c.getSoLuong();
		}
		return s;
	}
	public double tongTienSauVAT() {
		double s = 0;
		for(ChiTietHoaDon c : dsChiTiet) {
			s+=c.thanhTien();
		}
		return s;
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
