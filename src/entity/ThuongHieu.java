package entity;
//Thanh
public class ThuongHieu {
	private String maTH;
	private String tenTH;
	public ThuongHieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThuongHieu(String maTH, String tenTH) {
		super();
		this.maTH = maTH;
		this.tenTH = tenTH;
	}
	@Override
	public String toString() {
		return "ThuongHieu [maTH=" + maTH + ", tenTH=" + tenTH + "]";
	}
	
	

}