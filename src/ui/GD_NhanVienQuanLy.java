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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;
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
	private JMenu menuNV, menuNCC, menuTK, menuTC;
	private JMenuItem itemDangXuat, itemDoiMatKhau, itemThoat;
	private Box centerB;
	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	static LocalDate ngayHienTai = LocalDate.now();
	private int caLap;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public GD_NhanVienQuanLy(NhanVien nhanVien) {
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
		menuNV = new JMenu("Nhân Viên");
		menuNCC = new JMenu("Nhà Cung Cấp");
		menuTK = new JMenu("Thống kê");
		menuTC = new JMenu("Tùy chọn");

		itemDangXuat = new JMenuItem("Đăng xuất");
		itemDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		itemThoat = new JMenuItem("Thoát");

		menuTC.add(itemDangXuat);
		menuTC.add(itemDoiMatKhau);
		menuTC.add(itemThoat);

		menuBar.add(menuTC);
		menuBar.add(menuNV);
		menuBar.add(menuNCC);
		menuBar.add(menuTK);

		lblTenNV.setFont(font1);
		lblNgay.setFont(font1);
		lblCa.setFont(font1);

		menuNV.setFont(new Font("Serif", Font.BOLD, 25));
		menuNCC.setFont(new Font("Serif", Font.BOLD, 25));
		menuTK.setFont(new Font("Serif", Font.BOLD, 25));
		menuTC.setFont(new Font("Serif", Font.BOLD, 25));

		itemDangXuat.setFont(new Font("Serif", Font.ITALIC, 25));
		itemDoiMatKhau.setFont(new Font("Serif", Font.ITALIC, 25));
		itemThoat.setFont(new Font("Serif", Font.ITALIC, 25));

		menuNV.setIcon(new ImageIcon(".\\icon\\nv.png"));
		menuNCC.setIcon(new ImageIcon(".\\icon\\home.png"));
		menuTK.setIcon(new ImageIcon(".\\icon\\chart.png"));
		menuTC.setIcon(new ImageIcon(".\\icon\\symbol.png"));
		itemDangXuat.setIcon(new ImageIcon(".\\icon\\logout.png"));
		itemDoiMatKhau.setIcon(new ImageIcon(".\\icon\\key.png"));
		itemThoat.setIcon(new ImageIcon(".\\icon\\close.png"));

		menuB.add(menuBar);
		northB.add(menuB);
		northB.add(Box.createHorizontalStrut(130));
		northB.add(infoB);
		northB.add(Box.createHorizontalStrut(20));

		con.add(northB, BorderLayout.NORTH);

		centerB = Box.createVerticalBox();
		con.add(centerB, BorderLayout.CENTER);

		menuNV.addMenuListener(this);
		menuNCC.addMenuListener(this);
		menuTK.addMenuListener(this);
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
		centerB.removeAll();
		centerB.add(p);
		centerB.validate();
	}

	@Override
	public void menuSelected(MenuEvent e) {
		Object obj = e.getSource();
		if(obj == menuNV) {
			thayCenterP(new GD_QuanLyNhanVien());
		}
		if(obj == menuNCC) {
			thayCenterP(new GD_NhaCungCap());
		}
		if(obj == menuTK) {
       thayCenterP(new GD_TKDT());
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
