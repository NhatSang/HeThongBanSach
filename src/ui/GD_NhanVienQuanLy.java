package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import entity.NhanVien;

//Sang
public class GD_NhanVienQuanLy extends JFrame implements ActionListener, MenuListener {
	private JLabel lblTenNV, lblNgay, lblCa;
	private NhanVien nhanVien;
	private JMenuBar menuBar;
	private JMenu menu1, menu2, menu3, menu4, menu5;
	private JMenuItem itemDangXuat, itemDoiMatKhau, itemThoat;
	private JPanel centerP,childP;
	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	static LocalDate ngayHienTai = LocalDate.now();
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public GD_NhanVienQuanLy(NhanVien nhanVien) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\icon\\logobook.png"));
		this.nhanVien = nhanVien;
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
		Box infoB = Box.createHorizontalBox();
		Box infoB1 = Box.createVerticalBox();

		lblTenNV = new JLabel();
		lblTenNV.setText("Nguyễn Nhật Sang");
		lblNgay = new JLabel();
		lblNgay.setText("Ngày: " + dtf.format(ngayHienTai));
		lblCa = new JLabel();
		lblCa.setText("Ca: 1");

		infoB1.add(lblNgay);
		infoB1.add(lblCa);

		infoB.add(lblTenNV);
		infoB.add(Box.createHorizontalStrut(20));
		infoB.add(infoB1);

		Box menuB = Box.createHorizontalBox();
		menuB.setPreferredSize(new Dimension(900, 50));
		menuBar = new JMenuBar();
		menu1 = new JMenu("Nhân Viên");
		menu2 = new JMenu("Khách Hàng");
		menu3 = new JMenu("Nhà Cung Cấp");
		menu4 = new JMenu("Thống kê");
		menu5 = new JMenu("Tùy chọn");

		itemDangXuat = new JMenuItem("Đăng xuất");
		itemDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		itemThoat = new JMenuItem("Thoát");

		menu5.add(itemDangXuat);
		menu5.add(itemDoiMatKhau);
		menu5.add(itemThoat);

		menuBar.add(menu5);
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);

		lblTenNV.setFont(new Font("Serif", Font.ITALIC, 20));
		lblNgay.setFont(new Font("Serif", Font.ITALIC, 20));
		lblCa.setFont(new Font("Serif", Font.ITALIC, 20));

		menu1.setFont(new Font("Serif", Font.BOLD, 25));
		menu2.setFont(new Font("Serif", Font.BOLD, 25));
		menu3.setFont(new Font("Serif", Font.BOLD, 25));
		menu4.setFont(new Font("Serif", Font.BOLD, 25));
		menu5.setFont(new Font("Serif", Font.BOLD, 25));

		itemDangXuat.setFont(new Font("Serif", Font.ITALIC, 25));
		itemDoiMatKhau.setFont(new Font("Serif", Font.ITALIC, 25));
		itemThoat.setFont(new Font("Serif", Font.ITALIC, 25));

		menu1.setIcon(new ImageIcon(".\\icon\\nv.png"));
		menu2.setIcon(new ImageIcon(".\\icon\\kh.png"));
		menu3.setIcon(new ImageIcon(".\\icon\\home.png"));
		menu4.setIcon(new ImageIcon(".\\icon\\chart.png"));
		menu5.setIcon(new ImageIcon(".\\icon\\symbol.png"));
		itemDangXuat.setIcon(new ImageIcon(".\\icon\\logout.png"));
		itemDoiMatKhau.setIcon(new ImageIcon(".\\icon\\key.png"));
		itemThoat.setIcon(new ImageIcon(".\\icon\\close.png"));

		menuB.add(menuBar);
		northB.add(menuB);
		northB.add(Box.createHorizontalStrut(130));
		northB.add(infoB);
		northB.add(Box.createHorizontalStrut(20));

		con.add(northB, BorderLayout.NORTH);

		centerP = new JPanel();
		con.add(centerP, BorderLayout.CENTER);

		JPanel southP = new JPanel();
		southP.setPreferredSize(new Dimension(WIDTH, 100));
		con.add(southP, BorderLayout.SOUTH);

		menu1.addMenuListener(this);
		menu2.addMenuListener(this);
		menu3.addMenuListener(this);
		menu4.addMenuListener(this);
		itemDangXuat.addActionListener(this);
		itemDoiMatKhau.addActionListener(this);
		itemThoat.addActionListener(this);
		
	}

//	public static void main(String[] args) {
//		new GD_NhanVienQuanLy(new NhanVien()).setVisible(true);
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = new Object();
		obj = e.getSource();
		if (obj == itemThoat) {
			System.exit(0);
		}
		if(obj == itemDangXuat) {
			new GD_DangNhap().setVisible(true);
			this.dispose();
		}


	}
	public void thayCenterP(JPanel p) {
		childP = p;
		centerP.removeAll();
		centerP.add(childP);
		centerP.validate();
	}

	@Override
	public void menuSelected(MenuEvent e) {
		Object obj = e.getSource();
		if(obj == menu1) {
//			thayCenterP(new GD_KH());
		}
		if(obj == menu2) {
			thayCenterP(new GD_KH());
		}
		if(obj == menu3) {
			thayCenterP(new GD_NhaCungCap());
		}
		if(obj == menu4) {

		}
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {

		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
}
