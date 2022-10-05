package entity;
//Sang
public class ChiTietHoaDon {
	private int soLuong;
	private SanPham sanPham;
	
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon(int soLuong, SanPham sanPham) {
		super();
		this.soLuong = soLuong;
		this.sanPham = sanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [soLuong=" + soLuong + ", sanPham=" + sanPham + "]";
	}
	
	
}
