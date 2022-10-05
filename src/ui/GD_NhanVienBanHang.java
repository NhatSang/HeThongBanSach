package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
//Sang
public class GD_NhanVienBanHang extends JFrame{
	private JLabel lblTenNV;
	private JButton btnDX;
	
	public GD_NhanVienBanHang() {
		setTitle("Hệ thống quản lý hiệu sách");
		setSize(getMaximumSize());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		createGui();
	}
	
	private void createGui() {
		Container con = getContentPane();

		
		Box menuB = Box.createHorizontalBox();
		menuB.setBorder(new LineBorder(Color.BLACK));
		lblTenNV = new JLabel("Nhân Viên");
		btnDX = new JButton("Đăng xuất");
		JMenuBar menu = new JMenuBar();
		JMenu menu1 = new JMenu("Sản Phẩm");
		JMenu menu2 = new JMenu("Hóa đơn");
		JMenu menu3 = new JMenu("Thống kê");
		menu1.setFont(new Font("Serif", Font.BOLD, 40));
		menu2.setFont(new Font("Serif", Font.BOLD, 40));
		menu3.setFont(new Font("Serif", Font.BOLD, 40));
		lblTenNV.setFont(new Font("Serif", Font.BOLD, 20));
		btnDX.setFont(new Font("Serif", Font.BOLD, 20));
		menu.add(menu1);
		menu.add(menu2);
		menu.add(menu3);

		menuB.add(menu);
		menuB.add(Box.createHorizontalStrut(550));
		menuB.add(lblTenNV);
		menuB.add(Box.createHorizontalStrut(20));
		menuB.add(btnDX);
		con.add(menuB,BorderLayout.NORTH);
		
	}

	public static void main(String[] args) {
		new GD_NhanVienBanHang().setVisible(true);
	}
}
