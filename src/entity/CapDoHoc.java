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

	public CapDoHoc(String maCDH) {
		super();
		this.maCDH = maCDH;
	}

	public CapDoHoc(String maCDH, String capHoc, int capLop) {
		super();
		this.maCDH = maCDH;
		this.capHoc = capHoc;
		this.capLop = capLop;
	}

	public String getMaCDH() {
		return maCDH;
	}

	public void setMaCDH(String maCDH) {
		this.maCDH = maCDH;
	}

	public String getCapHoc() {
		return capHoc;
	}

	public void setCapHoc(String capHoc) {
		this.capHoc = capHoc;
	}

	public int getCapLop() {
		return capLop;
	}

	public void setCapLop(int capLop) {
		this.capLop = capLop;
	}

	@Override
	public String toString() {
		return  capHoc +"_Lớp "+capLop;
	}

}
