package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import entity.NhanVien;
import entity.TaiKhoan;

//Sang
public class GD_DangNhap extends JFrame implements ActionListener {
	private JLabel lblTaiKhoan, lblMatKhau, lblTieuDe;
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;
	private JButton btnDangNhap;
	private TaiKhoan_DAO tk_DAO;
	private NhanVien_DAO nv_DAO;
	private TaiKhoan tk;
	private NhanVien nv;

	public GD_DangNhap() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\icon\\logobook.png"));
		setTitle("Hệ thống quản lý hiệu sách Chí Tâm");
		setSize(600, 350);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		createGui();
		tk_DAO = new TaiKhoan_DAO();
		nv_DAO = new NhanVien_DAO();
		tk = new TaiKhoan();

	}

	private void createGui() {
		Container con = getContentPane();

		lblTieuDe = new JLabel("Đăng Nhập");
		lblTaiKhoan = new JLabel("Tài khoản");
		lblMatKhau = new JLabel("Mật khẩu");
		lblTieuDe.setFont(new Font("Serif", Font.BOLD, 50));
		lblTaiKhoan.setFont(new Font("Serif", Font.BOLD, 20));
		lblMatKhau.setFont(new Font("Serif", Font.BOLD, 20));

		txtTaiKhoan = new JTextField();
		txtMatKhau = new JPasswordField();
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input1 = classLoader.getResourceAsStream("login.png");
		
		BufferedImage image1 = null;
		
		try {
		    image1 = ImageIO.read(input1);

		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setFont(new Font("Serif", Font.BOLD, 20));
		btnDangNhap.setIcon(new ImageIcon(image1));

		Box titleB = Box.createVerticalBox();

		titleB.add(Box.createHorizontalStrut(20));
		titleB.add(lblTieuDe);

		con.add(titleB, BorderLayout.NORTH);

		Box centerB = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();

		b1.add(Box.createHorizontalStrut(70));
		b1.add(lblTaiKhoan);
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtTaiKhoan);
		b1.add(Box.createHorizontalStrut(70));

		b2.add(Box.createHorizontalStrut(70));
		b2.add(lblMatKhau);
		b2.add(Box.createHorizontalStrut(20));
		b2.add(txtMatKhau);
		b2.add(Box.createHorizontalStrut(70));

		centerB.add(Box.createVerticalStrut(30));
		centerB.add(b1);
		centerB.add(Box.createVerticalStrut(30));
		centerB.add(b2);
		centerB.add(Box.createVerticalStrut(30));

		con.add(centerB, BorderLayout.CENTER);

		Box southB = Box.createVerticalBox();
		southB.add(Box.createHorizontalStrut(110));
		southB.add(btnDangNhap);
		southB.add(Box.createVerticalStrut(50));
		con.add(southB, BorderLayout.SOUTH);

		btnDangNhap.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnDangNhap) {
			if (txtTaiKhoan.getText().length() != 0) {
				tk = tk_DAO.timTaiKhoan(txtTaiKhoan.getText());
				if (tk != null) {
					if (txtMatKhau.getText().equals(tk.getMatKhau())) {
						nv = new NhanVien();
						nv = nv_DAO.timKiemNVTheoMa(tk.getNhanVien().getMaNV());
						if(nv.getChucVu().getMaCV().equals("CV00001")) 
							new GD_NhanVienBanHang(nv).setVisible(true);
						else
							new GD_NhanVienQuanLy(nv).setVisible(true);
						this.dispose();
					} else
						JOptionPane.showMessageDialog(null, "Mật khẩu không chính xác");
				} else
					JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại");
			} else
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tài khoản");
		}
	}
}
