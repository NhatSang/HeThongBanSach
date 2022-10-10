package entity;

public class NhaCungCap {
	private String maNCC;
	private String tenNCC;
	private String nguoiDaiDien;
	private String SĐT;
	private String diaChi;
	
	public NhaCungCap(String maNCC, String tenNCC, String nguoiDaiDien, String sĐT, String diaChi) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.nguoiDaiDien = nguoiDaiDien;
		SĐT = sĐT;
		this.diaChi = diaChi;
	}
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	public String getNguoiDaiDien() {
		return nguoiDaiDien;
	}
	public void setNguoiDaiDien(String nguoiDaiDien) {
		this.nguoiDaiDien = nguoiDaiDien;
	}
	public String getSĐT() {
		return SĐT;
	}
	public void setSĐT(String sĐT) {
		SĐT = sĐT;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", nguoiDaiDien=" + nguoiDaiDien + ", SĐT=" + SĐT
				+ ", diaChi=" + diaChi + "]";
	}
}
