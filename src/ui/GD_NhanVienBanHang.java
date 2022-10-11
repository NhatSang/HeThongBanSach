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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import entity.NhanVien;
//Sang
public class GD_NhanVienBanHang extends JFrame implements ActionListener {
	private JLabel lblTenNV, lblNgay, lblCa;
	private NhanVien nhanVien;
	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	static LocalDate ngayHienTaiDate = LocalDate.now();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public GD_NhanVienBanHang(NhanVien nhanVien) {
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
		lblNgay.setText("Ngày: " + dtf.format(ngayHienTaiDate));
		lblCa = new JLabel();
		lblCa.setText("Ca: 1");

		infoB1.add(lblNgay);
		infoB1.add(lblCa);

		infoB.add(lblTenNV);
		infoB.add(Box.createHorizontalStrut(20));
		infoB.add(infoB1);

		Box menuB = Box.createHorizontalBox();
		menuB.setPreferredSize(new Dimension(900, 50));
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Sách");
		JMenu menu2 = new JMenu("Văn Phòng Phẩm");
		JMenu menu3 = new JMenu("Hóa Đơn");
		JMenu menu4 = new JMenu("Thống Kê");
		JMenu menu5 = new JMenu("Tùy chọn");

		JMenuItem itemDangXuat = new JMenuItem("Đăng xuất");
		JMenuItem itemDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		JMenuItem itemThoat = new JMenuItem("Thoát");
		JMenuItem itemLapHd = new JMenuItem("Lập Hóa Đơn");
		JMenuItem itemTimHD = new JMenuItem("Tìm kiếm Hóa Đơn");
		
		menu3.add(itemLapHd);
		menu3.add(itemTimHD);
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
		itemLapHd.setFont(new Font("Serif", Font.ITALIC, 25));
		itemTimHD.setFont(new Font("Serif", Font.ITALIC, 25));
		
		menu1.setIcon(new ImageIcon(".\\icon\\book.png"));
		menu2.setIcon(new ImageIcon(".\\icon\\vpp.png"));
		menu3.setIcon(new ImageIcon(".\\icon\\bill.png"));
		menu4.setIcon(new ImageIcon(".\\icon\\chart.png"));
		menu5.setIcon(new ImageIcon(".\\icon\\symbol.png"));
		itemDangXuat.setIcon(new ImageIcon(".\\icon\\logout.png"));
		itemDoiMatKhau.setIcon(new ImageIcon(".\\icon\\key.png"));
		itemThoat.setIcon(new ImageIcon(".\\icon\\close.png"));
		itemLapHd.setIcon(new ImageIcon(".\\icon\\addbill.png"));
		itemTimHD.setIcon(new ImageIcon(".\\icon\\searchbill.png"));
		
		menuB.add(menuBar);
		northB.add(menuB);
		northB.add(Box.createHorizontalStrut(130));
		northB.add(infoB);
		northB.add(Box.createHorizontalStrut(20));

		con.add(northB, BorderLayout.NORTH);

	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (Exception e) {
		}
		new GD_NhanVienBanHang(new NhanVien()).setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
//		Object obj = new Object();
//		obj = e.getSource();
//		if(obj==btnDangXuat) {
//			GD_DangNhap gd_DangNhap = new GD_DangNhap();
//			gd_DangNhap.setVisible(true);
//			this.dispose();
//		}

	}
}
