package entity;
//Sang
public abstract class SanPham{
	protected String maSP, tenSP, donVi, moTa;
	protected int soLuong, VAT;
	protected double donGia;
	protected LoaiSanPham loaiSP;
	protected NhaCungCap nhaCC;
	
	
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SanPham(String maSP, String tenSP, String donVi, String moTa, int soLuong, int vAT, double donGia,
			LoaiSanPham loaiSP, NhaCungCap nhaCC) {
		super();
		setMaSP(maSP);
		setDonGia(donGia);
		setDonVi(donVi);
		setLoaiSP(loaiSP);
		setMoTa(moTa);
		setNhaCC(nhaCC);
		setSoLuong(soLuong);
		setTenSP(tenSP);
		setVAT(vAT);
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

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", donVi=" + donVi + ", moTa=" + moTa + ", soLuong="
				+ soLuong + ", VAT=" + VAT + ", donGia=" + donGia + ", loaiSP=" + loaiSP + ", nhaCC=" + nhaCC + "]";
	}
	
}
