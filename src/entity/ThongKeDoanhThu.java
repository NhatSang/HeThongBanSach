package entity;

import java.sql.Date;

public class ThongKeDoanhThu {
	private String maSP;
	private String tenSP;
	private int tongSoLuong;
	private double giaBan;
	private Date ngay;
    private String maHD;
    private double vat;
	
	
	public ThongKeDoanhThu() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public ThongKeDoanhThu(String maSP, Date ngay, String maHD) {
		super();
		this.maSP = maSP;
		this.ngay = ngay;
		this.maHD = maHD;
	}



	public ThongKeDoanhThu(String maSP, String tenSP, int tongSoLuong, double giaBan, Date ngay) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.tongSoLuong = tongSoLuong;
		this.giaBan = giaBan;
		this.ngay = ngay;
	}

        public ThongKeDoanhThu(String maSP, String tenSP, int tongSoLuong, double giaBan) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.tongSoLuong = tongSoLuong;
		this.giaBan = giaBan;
	}

	public ThongKeDoanhThu(String maSP, double vat) {
		super();
		this.maSP = maSP;
		this.vat = vat;
	}



	public String getMaSP() {
		return maSP;
	}



	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}



	public String getTenSP() {
		return tenSP;
	}



	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}



	public int getTongSoLuong() {
		return tongSoLuong;
	}



	public void setTongSoLuong(int tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}



	public double getGiaBan() {
		return giaBan;
	}



	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}



	public Date getNgay() {
		return ngay;
	}



	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}



	public String getMaHD() {
		return maHD;
	}



	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}



	public double getVat() {
		return vat;
	}



	public void setVat(double vat) {
		this.vat = vat;
	}



	@Override
	public String toString() {
		return "ThongKeDoanhThu [maSP=" + maSP + ", tenSP=" + tenSP + ", tongSoLuong=" + tongSoLuong + ", giaBan="
				+ giaBan + ", ngay=" + ngay + ", maHD=" + maHD + ", vat=" + vat + "]";
	}
	

	
        
}
