package entity;

public class LoaiBia {
	private String maLB;
	private String tenLB;
	
	
	
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
		return "LoaiBia [maLB=" + maLB + ", tenLB=" + tenLB + "]";
	}
	
	
}
