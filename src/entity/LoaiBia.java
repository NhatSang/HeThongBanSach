package entity;

public class LoaiBia {
	private String maLB;
	private String tenLB;

	public LoaiBia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiBia(String maLB) {
		super();
		this.maLB = maLB;
	}

	public LoaiBia(String maLB, String tenLB) {
		super();
		this.maLB = maLB;
		this.tenLB = tenLB;
	}

	public String getMaLB() {
		return maLB;
	}

	public void setMaLB(String maLB) {
		this.maLB = maLB;
	}

	public String getTenLB() {
		return tenLB;
	}

	public void setTenLB(String tenLB) {
		this.tenLB = tenLB;
	}

	@Override
	public String toString() {
		return tenLB;
	}

}
