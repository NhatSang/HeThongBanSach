package entity;

//Sang
public class SanPham {
	protected String maSP, tenSP, donVi, moTa, hinhAnh;
	protected int soLuong, VAT;
	protected double donGia;
	protected LoaiSanPham loaiSP;
	protected NhaCungCap nhaCC;

	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanPham(String maSP, String tenSP, int soLuong, int vAT, double donGia) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		VAT = vAT;
		this.donGia = donGia;
	}

	public SanPham(String maSP, String tenSP, String donVi, String moTa, String hinhAnh, int soLuong, int vAT,
			double donGia, LoaiSanPham loaiSP, NhaCungCap nhaCC) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donVi = donVi;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.soLuong = soLuong;
		VAT = vAT;
		this.donGia = donGia;
		this.loaiSP = loaiSP;
		this.nhaCC = nhaCC;
	}

	public SanPham(String maSP, String tenSP, String donVi, String hinhAnh, int soLuong, int vAT, double donGia,
			NhaCungCap nhaCC) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donVi = donVi;
		this.hinhAnh = hinhAnh;
		this.soLuong = soLuong;
		VAT = vAT;
		this.donGia = donGia;
		this.nhaCC = nhaCC;
	}
	
	

	public SanPham(String tenSP, String donVi, String moTa, String hinhAnh, int soLuong, int vAT, double donGia,
			LoaiSanPham loaiSP, NhaCungCap nhaCC) {
		super();
		this.tenSP = tenSP;
		this.donVi = donVi;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.soLuong = soLuong;
		VAT = vAT;
		this.donGia = donGia;
		this.loaiSP = loaiSP;
		this.nhaCC = nhaCC;
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

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getVAT() {
		return VAT;
	}

	public void setVAT(int vAT) {
		VAT = vAT;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public LoaiSanPham getLoaiSP() {
		return loaiSP;
	}

	public void setLoaiSP(LoaiSanPham loaiSP) {
		this.loaiSP = loaiSP;
	}

	public NhaCungCap getNhaCC() {
		return nhaCC;
	}

	public void setNhaCC(NhaCungCap nhaCC) {
		this.nhaCC = nhaCC;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", donVi=" + donVi + ", moTa=" + moTa + ", soLuong="
				+ soLuong + ", VAT=" + VAT + ", donGia=" + donGia + ", loaiSP=" + loaiSP + ", nhaCC=" + nhaCC + "]";
	}

}
