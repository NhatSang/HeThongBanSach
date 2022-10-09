package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.border.LineBorder;

public class GD_NhanVienQuanLy extends JFrame implements ActionListener{
	private JLabel lblTenNV;
	private JButton btnDangXuat;
	static GraphicsDevice device = GraphicsEnvironment
	        .getLocalGraphicsEnvironment().getScreenDevices()[0];

	public GD_NhanVienQuanLy() {
		setTitle("Hệ thống quản lý hiệu sách Chí Tâm");
//		setUndecorated(true);
		device.setFullScreenWindow(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createGui();
		
	}
	private void createGui() {
		Container con = getContentPane();
		
		Box northB = Box.createHorizontalBox();
		northB.setBorder(new LineBorder(Color.black));
		
		lblTenNV = new JLabel();
		lblTenNV.setText("Tên Nhân Viên");
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setFocusable(false);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Nhân Viên");
		JMenu menu2 = new JMenu("Khách Hàng");
		JMenu menu3 = new JMenu("Nhà Cung Cấp");
		JMenu menu4 = new JMenu("Thống kê");
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);
		
		lblTenNV.setFont(new Font("Serif", Font.ITALIC, 20));
		btnDangXuat.setFont(new Font("Serif", Font.BOLD, 20));
		menu1.setFont(new Font("Serif", Font.BOLD, 30));
		menu2.setFont(new Font("Serif", Font.BOLD, 30));
		menu3.setFont(new Font("Serif", Font.BOLD, 30));
		menu4.setFont(new Font("Serif", Font.BOLD, 30));
		
		northB.add(menuBar);
		northB.add(Box.createHorizontalStrut(400));
		northB.add(lblTenNV);
		northB.add(Box.createHorizontalStrut(20));
		northB.add(btnDangXuat);
		northB.add(Box.createHorizontalStrut(20));
		
		con.add(northB,BorderLayout.NORTH);
		btnDangXuat.addActionListener(this);
		
	}
	public static void main(String[] args) {
		new GD_NhanVienQuanLy().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = new Object();
		obj = e.getSource();
		if(obj==btnDangXuat) {
			GD_DangNhap gd_DangNhap = new GD_DangNhap();
			gd_DangNhap.setVisible(true);
			this.dispose();
		}
		
	}
}
