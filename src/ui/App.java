package ui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {
	public static void main(String[] args) {
	try {
		UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
	} catch (Exception e) {
	}
	GD_DangNhap f = new GD_DangNhap();
	f.setVisible(true);
}
}
