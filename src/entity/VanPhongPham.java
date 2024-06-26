package entity;

//Thanh
public class VanPhongPham extends SanPham {
	private String xuatXu;
	private String chatLieu;
	private ThuongHieu thuongHieu;
	private MauSac mauSac;

	public VanPhongPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VanPhongPham(String maSP, String tenSP, String donVi, String moTa, String hinhAnh, int soLuong, int vAT,
			double donGia, LoaiSanPham loaiSP, NhaCungCap nhaCC, String xuatXu, String chatLieu, ThuongHieu thuongHieu,
			MauSac mauSac) {
		super(maSP, tenSP, donVi, moTa, hinhAnh, soLuong, vAT, donGia, loaiSP, nhaCC);
		this.xuatXu = xuatXu;
		this.chatLieu = chatLieu;
		this.thuongHieu = thuongHieu;
		this.mauSac = mauSac;
	}
	
	public VanPhongPham(String tenSP, String donVi, String moTa, String hinhAnh, int soLuong, int vAT,
			double donGia, LoaiSanPham loaiSP, NhaCungCap nhaCC, String xuatXu, String chatLieu, ThuongHieu thuongHieu,
			MauSac mauSac) {
		super(tenSP, donVi, moTa, hinhAnh, soLuong, vAT, donGia, loaiSP, nhaCC);
		this.xuatXu = xuatXu;
		this.chatLieu = chatLieu;
		this.thuongHieu = thuongHieu;
		this.mauSac = mauSac;
	}

	public String getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}

	public String getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}

	public ThuongHieu getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(ThuongHieu thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public MauSac getMauSac() {
		return mauSac;
	}

	public void setMauSac(MauSac mauSac) {
		this.mauSac = mauSac;
	}

	@Override
	public String toString() {
		return "VanPhongPham [xuatXu=" + xuatXu + ", chatLieu=" + chatLieu + ", thuongHieu=" + thuongHieu + ", mauSac="
				+ mauSac + "]";
	}

}
