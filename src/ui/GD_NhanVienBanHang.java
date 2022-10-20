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
	private JMenu menu1, menu2, menu3, menu4, menu5;
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
		menu1 = new JMenu("Sách");
		menu2 = new JMenu("Văn Phòng Phẩm");
		menu3 = new JMenu("Hóa Đơn");
		menu4 = new JMenu("Thống Kê");
		menu5 = new JMenu("Tùy chọn");

		itemDangXuat = new JMenuItem("Đăng xuất");
		itemDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		itemThoat = new JMenuItem("Thoát");
		itemLapHd = new JMenuItem("Lập Hóa Đơn");
		itemTimHD = new JMenuItem("Tìm kiếm Hóa Đơn");

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

		lblTenNV.setFont(font1);
		lblNgay.setFont(font1);
		lblCa.setFont(font1);

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
		centerB = Box.createVerticalBox();
		con.add(centerB, BorderLayout.CENTER);

		JPanel southP = new JPanel();
		southP.setLayout(new GridLayout(1, 2,30,30));
		southP.setBackground(Color.orange);
		southP.setPreferredSize(new Dimension(WIDTH, 100));
		southP.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel southp1 = new JPanel();
		JPanel southp2 = new JPanel();
		southp1.setBackground(Color.orange);
		southp2.setBackground(Color.orange);
		southp1.setLayout(new GridLayout(3, 1));
		southp2.setLayout(new GridLayout(4,1));
		JLabel lblMonHoc = new JLabel("Môn: Phát Triển Ứng Dụng");
		JLabel lblGV = new JLabel("Giáo Viên: Trần Thị Anh Thi");
		JLabel lblLop = new JLabel("Lớp: DHKTPM16FTT");
		JLabel lblSV1 = new JLabel("Nguyễn Nhật Sang - 20001531 (Nhóm trưởng)");
		JLabel lblSV2 = new JLabel("Lương Viết Thanh - ");
		JLabel lblSV3 = new JLabel("Trương Văn Tuấn - ");
		JLabel lblSV4 = new JLabel("Nguyễn Minh Quân -");
		lblGV.setFont(font1);
		lblMonHoc.setFont(font1);
		lblLop.setFont(font1);
		lblSV1.setFont(font1);
		lblSV2.setFont(font1);
		lblSV3.setFont(font1);
		lblSV4.setFont(font1);
		
		southp1.add(lblMonHoc);
		southp1.add(lblGV);
		southp1.add(lblLop);
		
		southp2.add(lblSV1);
		southp2.add(lblSV2);
		southp2.add(lblSV3);
		southp2.add(lblSV4);
		
		southP.add(southp1);
		southP.add(southp2);
		con.add(southP, BorderLayout.SOUTH);

		menu1.addMenuListener(this);
		menu2.addMenuListener(this);
		menu4.addMenuListener(this);
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
		if(obj == itemDangXuat) {
			new GD_DangNhap().setVisible(true);
			this.dispose();
		}
		if(obj == itemLapHd) {
			thayCenterP(new GD_LapHoaDon(nhanVien));
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
		if(obj == menu1) {
			thayCenterP(new GD_Sach());
		}
		if(obj == menu2) {
			thayCenterP(new GD_VPP());
		}
		if(obj == menu4) {

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
}
