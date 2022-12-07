package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import entity.ChucVu;
import entity.NhanVien;

//Sang
public class GD_NhanVienBanHang extends JFrame implements ActionListener, MenuListener {
	private JLabel lblTenNV, lblNgay, lblCa;
	private NhanVien nhanVien;
	private JMenuBar menuBar;
	private JMenu menuSach, menuVPP, menuHD, menuTK, menuTC,menuKH;
	private JMenuItem itemDangXuat, itemDoiMatKhau, itemThoat, itemLapHd, itemTimHD;
	private Box centerB;
	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	static LocalDate ngayHienTai = LocalDate.now();
	private int caLap;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public GD_NhanVienBanHang(NhanVien nhanVien) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\icon\\logobook.png"));
		this.nhanVien = nhanVien;
		setTitle("Hệ thống quản lý hiệu sách Chí Tâm");
		setExtendedState(this.MAXIMIZED_BOTH);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createGui();
	}

	private void createGui() {
		Container con = getContentPane();

		Font font1 = new Font("Serif", Font.ITALIC, 20);
		Box northB = Box.createHorizontalBox();
		northB.setBorder(new LineBorder(Color.black));
		Box infoB = Box.createHorizontalBox();
		Box infoB1 = Box.createVerticalBox();
		
		lblTenNV = new JLabel();
		lblTenNV.setText(nhanVien.getHoTen());
		lblNgay = new JLabel();
		lblNgay.setText("Ngày: " + dtf.format(ngayHienTai));
		lblCa = new JLabel();
		int gioHT = LocalDateTime.now().getHour();
		if (gioHT >= 8 && gioHT <= 15)
			caLap = 1;
		else
			caLap = 2;
		lblCa.setText("Ca: "+caLap);

		infoB1.add(lblNgay);
		infoB1.add(lblCa);

		infoB.add(lblTenNV);
		infoB.add(Box.createHorizontalStrut(20));
		infoB.add(infoB1);

		Box menuB = Box.createHorizontalBox();
		menuB.setPreferredSize(new Dimension(1000, 50));
		menuBar = new JMenuBar();
		menuSach = new JMenu("Sách");
		menuVPP = new JMenu("Văn Phòng Phẩm");
		menuHD = new JMenu("Hóa Đơn");
		menuKH = new JMenu("Khách hàng");
		menuTK = new JMenu("Thống Kê");
		menuTC = new JMenu("Tùy chọn");

		itemDangXuat = new JMenuItem("Đăng xuất");
		itemDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		itemThoat = new JMenuItem("Thoát");
		itemLapHd = new JMenuItem("Lập Hóa Đơn");
		itemTimHD = new JMenuItem("Xem Hàng Đợi");

		menuHD.add(itemLapHd);
		menuHD.add(itemTimHD);
		menuTC.add(itemDangXuat);
		menuTC.add(itemDoiMatKhau);
		menuTC.add(itemThoat);

		menuBar.add(menuTC);
		menuBar.add(menuSach);
		menuBar.add(menuVPP);
		menuBar.add(menuHD);
		menuBar.add(menuKH);
		menuBar.add(menuTK);

		lblTenNV.setFont(font1);
		lblNgay.setFont(font1);
		lblCa.setFont(font1);

		menuSach.setFont(new Font("Serif", Font.BOLD, 25));
		menuVPP.setFont(new Font("Serif", Font.BOLD, 25));
		menuHD.setFont(new Font("Serif", Font.BOLD, 25));
		menuTK.setFont(new Font("Serif", Font.BOLD, 25));
		menuTC.setFont(new Font("Serif", Font.BOLD, 25));
		menuKH.setFont(new Font("Serif", Font.BOLD, 25));

		itemDangXuat.setFont(new Font("Serif", Font.ITALIC, 25));
		itemDoiMatKhau.setFont(new Font("Serif", Font.ITALIC, 25));
		itemThoat.setFont(new Font("Serif", Font.ITALIC, 25));
		itemLapHd.setFont(new Font("Serif", Font.ITALIC, 25));
		itemTimHD.setFont(new Font("Serif", Font.ITALIC, 25));

		menuSach.setIcon(new ImageIcon(".\\icon\\book.png"));
		menuVPP.setIcon(new ImageIcon(".\\icon\\vpp.png"));
		menuHD.setIcon(new ImageIcon(".\\icon\\bill.png"));
		menuKH.setIcon(new ImageIcon(".\\icon\\kh.png"));
		menuTK.setIcon(new ImageIcon(".\\icon\\chart.png"));
		menuTC.setIcon(new ImageIcon(".\\icon\\symbol.png"));
		itemDangXuat.setIcon(new ImageIcon(".\\icon\\logout.png"));
		itemDoiMatKhau.setIcon(new ImageIcon(".\\icon\\key.png"));
		itemThoat.setIcon(new ImageIcon(".\\icon\\close.png"));
		itemLapHd.setIcon(new ImageIcon(".\\icon\\addbill.png"));
		itemTimHD.setIcon(new ImageIcon(".\\icon\\searchbill.png"));

		menuB.add(menuBar);
		northB.add(menuB);
		northB.add(Box.createHorizontalStrut(50));
		northB.add(infoB);
		northB.add(Box.createHorizontalStrut(20));

		con.add(northB, BorderLayout.NORTH);
		centerB = Box.createVerticalBox();
		con.add(centerB, BorderLayout.CENTER);

		menuSach.addMenuListener(this);
		menuVPP.addMenuListener(this);
		menuKH.addMenuListener(this);
		menuTK.addMenuListener(this);
		itemDangXuat.addActionListener(this);
		itemDoiMatKhau.addActionListener(this);
		itemThoat.addActionListener(this);
		itemLapHd.addActionListener(this);
		itemTimHD.addActionListener(this);
	}

//	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
//		} catch (Exception e) {
//		}
//		new GD_NhanVienBanHang(new NhanVien("",new ChucVu())).setVisible(true);
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = new Object();
		obj = e.getSource();
		if (obj == itemThoat) {
			System.exit(0);
		}
		else if(obj == itemDangXuat) {
			new GD_DangNhap().setVisible(true);
			this.dispose();
		}
		else if(obj == itemLapHd) {
			thayCenterP(new GD_LapHoaDon(this));
		}
		else if(obj == itemTimHD) {
			thayCenterP(new GD_HangDoiHD(this));
		}
	}

	public void thayCenterP(JPanel p) {
		centerB.removeAll();
		centerB.add(p);
		centerB.validate();
	}

	@Override
	public void menuSelected(MenuEvent e) {
		Object obj = e.getSource();
		if(obj == menuSach) {
			thayCenterP(new GD_Sach());
		}
		if(obj == menuVPP) {
			thayCenterP(new GD_VPP());
		}
		if(obj == menuKH) {
			thayCenterP(new GD_KH());
		}
		if(obj == menuTK) {

		}

	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub

	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}
	
}
