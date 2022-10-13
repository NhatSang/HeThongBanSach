package entity;
//Thanh
public class MauSac {
	private String maMau;
	private String mau;
	public MauSac() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MauSac(String maMau, String mau) {
		super();
		this.maMau = maMau;
		this.mau = mau;
	}
	@Override
	public String toString() {
		return "MauSac [maMau=" + maMau + ", mau=" + mau + "]";
	}
	
	
}
