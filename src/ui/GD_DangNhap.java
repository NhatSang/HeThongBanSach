package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//Sang
public class GD_DangNhap extends JFrame implements ActionListener{
	private JLabel lblTaiKhoan, lblMatKhau, lblTieuDe;
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;
	private JButton btnDangNhap;
	
	public GD_DangNhap() {
		setTitle("Hệ thống quản lý hiệu sách Chí Tâm");
		setSize(600,350);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		createGui();
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
		
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setFont(new Font("Serif", Font.BOLD, 20));
		
		Box titleB = Box.createVerticalBox();
		
		titleB.add(Box.createHorizontalStrut(20));
		titleB.add(lblTieuDe);
		
		con.add(titleB,BorderLayout.NORTH);
		
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
		
		con.add(centerB,BorderLayout.CENTER);
		
		Box southB = Box.createVerticalBox();
		southB.add(Box.createHorizontalStrut(100));
		southB.add(btnDangNhap);
		southB.add(Box.createVerticalStrut(50));
		con.add(southB,BorderLayout.SOUTH);
		
		btnDangNhap.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==btnDangNhap) {
			GD_NhanVienBanHang gd_NhanVien = new GD_NhanVienBanHang();
			gd_NhanVien.setVisible(true);
			this.dispose();
		}
		
	}

}
