package entity;

public class TaiKhoan {
	private String tenTK, matKhau;
	private NhanVien nhanVien;
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan(String tenTK, String matKhau, NhanVien nhanVien) {
		super();
		this.tenTK = tenTK;
		this.matKhau = matKhau;
		this.nhanVien = nhanVien;
	}
	public String getTenTK() {
		return tenTK;
	}
	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	@Override
	public String toString() {
		return "TaiKhoan [tenTK=" + tenTK + ", matKhau=" + matKhau + ", nhanVien=" + nhanVien + "]";
	}
	
	
}
