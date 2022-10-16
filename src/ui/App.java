package ui;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dao.KH_DAO;
import dao.NCC_DAO;
import entity.KhachHang;
import entity.NhaCungCap;

public class App {
	public static void main(String[] args) {
	try {
		UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
	} catch (Exception e) {
	}
	GD_DangNhap f = new GD_DangNhap();
	f.setVisible(true);
/* Test dữ liệu*/
	KH_DAO kh = new KH_DAO();
	ArrayList<KhachHang> dskh = kh.getAllKhachHang();
	for (KhachHang khachHang : dskh) {
		System.out.println(khachHang.toString());
	}
	
	NCC_DAO ncc = new NCC_DAO();
	ArrayList<NhaCungCap> dsncc = ncc.getAllNhaCungCap();
	for (NhaCungCap nhaCungCap : dsncc) {
		System.out.println(nhaCungCap.toString());
	}
}
}
