package entity;

public class NhaCungCap {
	private String maNCC;
	private String tenNCC;
	private String nguoiDaiDien;
	private String sDt;
	private String diaChi;

	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NhaCungCap(String tenNCC, String nguoiDaiDien, String sDt, String diaChi) {
		super();
		this.tenNCC = tenNCC;
		this.nguoiDaiDien = nguoiDaiDien;
		this.sDt = sDt;
		this.diaChi = diaChi;
	}

	public NhaCungCap(String maNCC) {
		super();
		this.maNCC = maNCC;
	}

	public NhaCungCap(String maNCC, String tenNCC, String nguoiDaiDien, String sDt, String diaChi) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.nguoiDaiDien = nguoiDaiDien;
		this.sDt = sDt;
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

	public String getsDt() {
		return sDt;
	}

	public void setsDt(String sDt) {
		sDt = sDt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	@Override
	public String toString() {
		return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", nguoiDaiDien=" + nguoiDaiDien + ", sDt=" + sDt
				+ ", diaChi=" + diaChi + "]";
	}
}
