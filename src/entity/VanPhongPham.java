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

	@Override
	public String toString() {
		return "VanPhongPham [xuatXu=" + xuatXu + ", chatLieu=" + chatLieu + ", thuongHieu=" + thuongHieu + ", mauSac="
				+ mauSac + "]";
	}

}
