package entity;

import java.time.LocalDate;

public class KhachHang {
	private String maKH;
	private String hoTen;
	private LocalDate ngaySinh;
	private String diaChi;
	private String SĐT;
	private Boolean gioiTinh;
	
	public KhachHang(String maKH, String hoTen, LocalDate ngaySinh, String diaChi, String sĐT, Boolean gioiTinh) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		SĐT = sĐT;
		this.gioiTinh = gioiTinh;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSĐT() {
		return SĐT;
	}
	public void setSĐT(String sĐT) {
		SĐT = sĐT;
	}
	public Boolean getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi
				+ ", SĐT=" + SĐT + ", gioiTinh=" + gioiTinh + "]";
	}
}
