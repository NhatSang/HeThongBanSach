package entity;

//Sang
public class ChiTietHoaDon {
	private int soLuong;
	private double giaBan;
	private SanPham sanPham;

	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDon(int soLuong, double giaBan, SanPham sanPham) {
		super();
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.sanPham = sanPham;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
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
	
	public double thanhTien() {
		return (soLuong*giaBan)*(1+(double)sanPham.getVAT()/100);
	}
	
	@Override
	public String toString() {
		return "ChiTietHoaDon [soLuong=" + soLuong + ", sanPham=" + sanPham + "]";
	}
}
