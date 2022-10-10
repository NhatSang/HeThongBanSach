package entity;

public class TacGia {
	private String maTG;
	private String tenTG;
	
	public TacGia(String maTG, String tenTG) {
		super();
		this.maTG = maTG;
		this.tenTG = tenTG;
	}
	public String getMaTG() {
		return maTG;
	}
	public void setMaTG(String maTG) {
		this.maTG = maTG;
	}
	public String getTenTG() {
		return tenTG;
	}
	public void setTenTG(String tenTG) {
		this.tenTG = tenTG;
	}
	@Override
	public String toString() {
		return "TacGia [maTG=" + maTG + ", tenTG=" + tenTG + "]";
	}
	
	
}	
