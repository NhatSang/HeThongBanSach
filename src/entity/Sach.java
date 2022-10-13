package entity;
//Thanh
public class Sach extends SanPham{
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

	
	public Sach(String maSP, String tenSP, String donVi, String moTa, int soLuong, int vAT, double donGia,
			LoaiSanPham loaiSP, NhaCungCap nhaCC) {
		super(maSP, tenSP, donVi, moTa, soLuong, vAT, donGia, loaiSP, nhaCC);
		// TODO Auto-generated constructor stub
	}

	public Sach(int namXB, int soTrang, int tuoiGioiHan, String nguoiDich, NhaXuatBan nhaXB, TacGia tacGia,
			LoaiBia loaiBia, CapDoHoc capDoHoc) {
		super();
		this.namXB = namXB;
		this.soTrang = soTrang;
		this.tuoiGioiHan = tuoiGioiHan;
		this.nguoiDich = nguoiDich;
		this.nhaXB = nhaXB;
		this.tacGia = tacGia;
		this.loaiBia = loaiBia;
		this.capDoHoc = capDoHoc;
	}

	@Override
	public String toString() {
		return "Sach [namXB=" + namXB + ", soTrang=" + soTrang + ", tuoiGioiHan=" + tuoiGioiHan + ", nguoiDich="
				+ nguoiDich + ", nhaXB=" + nhaXB + ", tacGia=" + tacGia + ", loaiBia=" + loaiBia + ", capDoHoc="
				+ capDoHoc + "]";
	}
	
	
	
	
	
}
