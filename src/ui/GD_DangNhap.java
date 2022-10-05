package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//Sang
public class GD_DangNhap extends JFrame{
	private JLabel lblTK,lblMK;
	private JTextField txtTK;
	private JPasswordField txtMK;
	private JButton btnDN;
	
	public GD_DangNhap() {
		setTitle("Hệ thống quản lý hiệu sách");
		setSize(700, 380);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		createGUI();
	}
	private void createGUI() {
		Container con = getContentPane();
		Box titleB = Box.createVerticalBox();
		
		JLabel lblTitle = new JLabel("Đăng Nhập");
		lblTitle.setFont(new Font("Serif", Font.BOLD, 50));
		lblTitle.setForeground(Color.GREEN);
		
		titleB.add(Box.createVerticalStrut(20));
		titleB.add(Box.createHorizontalStrut(20));
		titleB.add(lblTitle);
		con.add(titleB,BorderLayout.NORTH);
		
		Box centerB = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		
		lblTK = new JLabel("Tài khoản: ");
		lblMK = new JLabel("Mật khẩu: ");
		lblTK.setFont(new Font("Serif", Font.BOLD, 20));
		lblMK.setFont(new Font("Serif", Font.BOLD, 20));
		lblMK.setPreferredSize(lblTK.getPreferredSize());
		
		txtTK = new JTextField();
		txtMK = new JPasswordField();

		
		b1.add(Box.createHorizontalStrut(100));
		b1.add(lblTK);
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtTK);
		b1.add(Box.createHorizontalStrut(100));
		
		b2.add(Box.createHorizontalStrut(100));
		b2.add(lblMK);
		b2.add(Box.createHorizontalStrut(20));
		b2.add(txtMK);
		b2.add(Box.createHorizontalStrut(100));
		
		
		centerB.add(Box.createVerticalStrut(40));
		centerB.add(b1);
		centerB.add(Box.createVerticalStrut(30));
		centerB.add(b2);
		centerB.add(Box.createVerticalStrut(30));
		
		con.add(centerB,BorderLayout.CENTER);
		
		Box southB = Box.createVerticalBox();
		btnDN = new JButton("Đăng Nhập");
		btnDN.setFont(new Font("Serif", Font.BOLD, 20));
		
		southB.add(Box.createHorizontalStrut(120));
		southB.add(btnDN);
		southB.add(Box.createVerticalStrut(40));
		con.add(southB,BorderLayout.SOUTH);
	}

}
