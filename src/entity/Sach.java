package entity;

//Thanh
public class Sach extends SanPham {
	private int namXB, soTrang, tuoiGioiHan;
	private String nguoiDich;
	private NhaXuatBan nhaXB;
	private TacGia tacGia;
	private LoaiBia loaiBia;
	private CapDoHoc capDoHoc;

	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sach(String maSP, String tenSP, String donVi, String moTa, String hinhAnh, int soLuong, int vAT,
			double donGia, LoaiSanPham loaiSP, NhaCungCap nhaCC, int namXB, int soTrang, int tuoiGioiHan,
			String nguoiDich, NhaXuatBan nhaXB, TacGia tacGia, LoaiBia loaiBia, CapDoHoc capDoHoc) {
		super(maSP, tenSP, donVi, moTa, hinhAnh, soLuong, vAT, donGia, loaiSP, nhaCC);
		this.namXB = namXB;
		this.soTrang = soTrang;
		this.tuoiGioiHan = tuoiGioiHan;
		this.nguoiDich = nguoiDich;
		this.nhaXB = nhaXB;
		this.tacGia = tacGia;
		this.loaiBia = loaiBia;
		this.capDoHoc = capDoHoc;
	}

	public Sach(String tenSP, String donVi, String moTa, String hinhAnh, int soLuong, int vAT, double donGia,
			LoaiSanPham loaiSP, NhaCungCap nhaCC, int namXB, int soTrang, int tuoiGioiHan, String nguoiDich,
			NhaXuatBan nhaXB, TacGia tacGia, LoaiBia loaiBia, CapDoHoc capDoHoc) {
		super(tenSP, donVi, moTa, hinhAnh, soLuong, vAT, donGia, loaiSP, nhaCC);
		this.namXB = namXB;
		this.soTrang = soTrang;
		this.tuoiGioiHan = tuoiGioiHan;
		this.nguoiDich = nguoiDich;
		this.nhaXB = nhaXB;
		this.tacGia = tacGia;
		this.loaiBia = loaiBia;
		this.capDoHoc = capDoHoc;
	}

	public int getNamXB() {
		return namXB;
	}

	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public int getTuoiGioiHan() {
		return tuoiGioiHan;
	}

	public void setTuoiGioiHan(int tuoiGioiHan) {
		this.tuoiGioiHan = tuoiGioiHan;
	}

	public String getNguoiDich() {
		return nguoiDich;
	}

	public void setNguoiDich(String nguoiDich) {
		this.nguoiDich = nguoiDich;
	}

	public NhaXuatBan getNhaXB() {
		return nhaXB;
	}

	public void setNhaXB(NhaXuatBan nhaXB) {
		this.nhaXB = nhaXB;
	}

	public TacGia getTacGia() {
		return tacGia;
	}

	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}

	public LoaiBia getLoaiBia() {
		return loaiBia;
	}

	public void setLoaiBia(LoaiBia loaiBia) {
		this.loaiBia = loaiBia;
	}

	public CapDoHoc getCapDoHoc() {
		return capDoHoc;
	}

	public void setCapDoHoc(CapDoHoc capDoHoc) {
		this.capDoHoc = capDoHoc;
	}

	@Override
	public String toString() {
		return "Sach [namXB=" + namXB + ", soTrang=" + soTrang + ", tuoiGioiHan=" + tuoiGioiHan + ", nguoiDich="
				+ nguoiDich + ", nhaXB=" + nhaXB + ", tacGia=" + tacGia + ", loaiBia=" + loaiBia + ", capDoHoc="
				+ capDoHoc + "]";
	}

}
