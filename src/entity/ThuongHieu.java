package entity;
//Thanh
public class ThuongHieu {
	private String maTH;
	private String tenTH;
	public ThuongHieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ThuongHieu(String maTH) {
		super();
		this.maTH = maTH;
	}

	public ThuongHieu(String maTH, String tenTH) {
		super();
		this.maTH = maTH;
		this.tenTH = tenTH;
	}
	
	
	public String getMaTH() {
		return maTH;
	}
	public void setMaTH(String maTH) {
		this.maTH = maTH;
	}
	public String getTenTH() {
		return tenTH;
	}
	public void setTenTH(String tenTH) {
		this.tenTH = tenTH;
	}
	@Override
	public String toString() {
		return tenTH;
	}
	
	

}