package entity;
//Thanh
public class CapDoHoc {
	private String maCDH;
	private String capHoc;
	private int capLop;
	public CapDoHoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CapDoHoc(String maCDH, String capHoc, int capLop) {
		super();
		this.maCDH = maCDH;
		this.capHoc = capHoc;
		this.capLop = capLop;
	}
	@Override
	public String toString() {
		return "CapDoHoc [maCDH=" + maCDH + ", capHoc=" + capHoc + ", capLop=" + capLop + "]";
	}
	
}
