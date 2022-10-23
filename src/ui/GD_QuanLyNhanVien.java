package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.NhanVien;

public class GD_QuanLyNhanVien extends JPanel implements ActionListener{

	private NhanVien nhanVien;
	private JLabel lblma,lblhoten,lblngaysinh,lblemail,lbldiachi,lblsdt,lblgioitinh,lblchucvu,lbltaikhoan,lblmatkhau;
	private JTextField txttim,txtma,txthoten,txtNgaysinh,txtemail,txtdiachi,txtsdt,txttaikhoan,txtmatkhau;
	private JButton btntim,btnthem,btnxoa,btnsua;
	private JComboBox cbbchucvu;
	private DefaultTableModel tableModel;
	private JTable table;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private JRadioButton rbgt1,rbgt2;
	
	public GD_QuanLyNhanVien() {
		createGui();
	}
	
	private void createGui() {
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		Box boxright = Box.createVerticalBox();
		Box boxleft = Box.createVerticalBox();
		
		Box boxtim = Box.createHorizontalBox();
		Box boxtable = Box.createHorizontalBox();
		Box boxma = Box.createHorizontalBox();
		Box boxhoten = Box.createHorizontalBox();
		Box boxngaysinh = Box.createHorizontalBox();
		Box boxemail = Box.createHorizontalBox();
		Box boxdiachi = Box.createHorizontalBox();
		Box boxsdt = Box.createHorizontalBox();
		Box boxgioitinh = Box.createHorizontalBox();
		Box boxchucvu = Box.createHorizontalBox();
		Box boxtaikhoan = Box.createHorizontalBox();
		Box boxmatkhau = Box.createHorizontalBox();
		Box boxchucnang = Box.createHorizontalBox();
		
		lblma = new JLabel("Mã:");
		lblhoten = new JLabel("Họ Tên:");
		lblngaysinh = new JLabel("Ngày Sinh:");
		lblemail = new JLabel("Email:");
		lbldiachi = new JLabel("Địa Chỉ:");
		lblsdt = new JLabel("SĐT:");
		lblgioitinh = new JLabel("Giới Tính:");
		lblchucvu = new JLabel("Chức Vụ:");
		lbltaikhoan = new JLabel("Tài khoản:");
		lblmatkhau = new JLabel("Mật khẩu:");
		
		txttim = new JTextField(50);
		txtma = new JTextField(10);
		txthoten = new JTextField(10);
		txtNgaysinh = new JTextField(10);
		txtemail = new JTextField(10);
		txtsdt = new JTextField(10);
		txtdiachi = new JTextField(10);
		txttaikhoan = new JTextField(10);
		txtmatkhau = new JTextField(10);
		
		btntim = new JButton("Tìm Kiếm");
		btnthem = new JButton("Thêm");
		btnxoa = new JButton("Xóa");
		btnsua = new JButton("Sửa");
		
		rbgt1 = new JRadioButton("Nam");
		rbgt2 = new JRadioButton("Nữ");
		String chucvu[]= {"Nhân Viên Bán Hàng"," Người Quản Lý"};
		cbbchucvu = new JComboBox(chucvu);
		txtma.enable(false);
		txttaikhoan.enable(false);
		txtmatkhau.enable(false);
		
		
		//set font
		lblma.setFont(new Font("Serif", Font.ITALIC, 20));
		lblhoten.setFont(new Font("Serif", Font.ITALIC, 20));
		lblngaysinh.setFont(new Font("Serif", Font.ITALIC, 20));
		lblemail.setFont(new Font("Serif", Font.ITALIC, 20));
		lbldiachi.setFont(new Font("Serif", Font.ITALIC, 20));
		lblsdt.setFont(new Font("Serif", Font.ITALIC, 20));
		lblgioitinh.setFont(new Font("Serif", Font.ITALIC, 20));
		lblchucvu.setFont(new Font("Serif", Font.ITALIC, 20));
		lbltaikhoan.setFont(new Font("Serif", Font.ITALIC, 20));
		lblmatkhau.setFont(new Font("Serif", Font.ITALIC, 20));

		//set size
		
		lblma.setPreferredSize(lblngaysinh.getPreferredSize());
		lblhoten.setPreferredSize(lblngaysinh.getPreferredSize());
		lblemail.setPreferredSize(lblngaysinh.getPreferredSize());
		lbldiachi.setPreferredSize(lblngaysinh.getPreferredSize());
		lblsdt.setPreferredSize(lblngaysinh.getPreferredSize());
		lblgioitinh.setPreferredSize(lblngaysinh.getPreferredSize());
		lblchucvu.setPreferredSize(lblngaysinh.getPreferredSize());
		lbltaikhoan.setPreferredSize(lblngaysinh.getPreferredSize());
		lblmatkhau.setPreferredSize(lblngaysinh.getPreferredSize());
		
		//tạo bảng danh sách nhân viên
		String[] header = "STT;Mã;Họ tên;Ngày sinh;CCCD;Địa chỉ;SĐT;Giới tính;Tài khoản;Chức vụ".split(";");
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		JScrollPane DSNV = new JScrollPane(table);
		DSNV.setPreferredSize(new Dimension(1000, 1590));
		txttim.setPreferredSize(new Dimension(100, 30));
		txttim.setText("Nhập");
		btntim.setPreferredSize(new Dimension(100, 30));
		btnthem.setPreferredSize(new Dimension(90, 30));
		btnxoa.setPreferredSize(new Dimension(90, 30));
		btnsua.setPreferredSize(new Dimension(90, 30));
		
		boxtim.add(Box.createHorizontalStrut(100));
		boxtim.add(txttim);
		boxtim.add(Box.createHorizontalStrut(15));
		boxtim.add(btntim); 
		boxtim.add(Box.createHorizontalStrut(100));
		boxtable.add(DSNV);
		
		boxma.add(lblma);
		boxma.add(txtma);
		boxhoten.add(lblhoten);
		boxhoten.add(txthoten);
		boxngaysinh.add(lblngaysinh);
		boxngaysinh.add(txtNgaysinh);
		boxemail.add(lbldiachi);
		boxemail.add(txtdiachi);
		boxsdt.add(lblsdt);
		boxsdt.add(txtsdt);
		boxgioitinh.add(lblgioitinh);
		boxgioitinh.add(Box.createHorizontalStrut(0));
		boxgioitinh.add(rbgt1);
		boxgioitinh.add(Box.createHorizontalStrut(45));
		boxgioitinh.add(rbgt2);
		boxgioitinh.add(Box.createHorizontalStrut(210));
		boxchucvu.add(lblchucvu);
		boxchucvu.add(cbbchucvu);
		boxtaikhoan.add(lbltaikhoan);
		boxtaikhoan.add(txttaikhoan);
		boxmatkhau.add(lblmatkhau);
		boxmatkhau.add(txtmatkhau);
		
		//boxleft.add(DSNV);
		
		boxleft.add(Box.createVerticalStrut(40));
		boxleft.add(boxtim);
		boxleft.add(Box.createVerticalStrut(40));
		boxleft.add(boxtable);
		boxright.add(Box.createVerticalStrut(30));
		boxright.add(boxma);
		boxright.add(Box.createVerticalStrut(40));
		boxright.add(boxhoten);
		boxright.add(Box.createVerticalStrut(40));
		boxright.add(boxngaysinh);
		boxright.add(Box.createVerticalStrut(40));
		boxright.add(boxemail);
		boxright.add(Box.createVerticalStrut(40));
		boxright.add(boxdiachi);
		
		boxright.add(boxsdt);
		boxright.add(Box.createVerticalStrut(40));
		boxright.add(boxgioitinh);
		boxright.add(Box.createVerticalStrut(40));
		boxright.add(boxchucvu);
		boxright.add(Box.createVerticalStrut(40));
		boxright.add(boxtaikhoan);
		boxright.add(Box.createVerticalStrut(40));
		boxright.add(boxmatkhau);
		boxright.add(Box.createVerticalStrut(80));
		JPanel panel = new JPanel();
		JPanel panelright = new JPanel();
		JPanel panelleft = new JPanel();
		JPanel panelcn = new JPanel();
		
		panelcn.add(btnthem);
		panelcn.add(new Panel());
		panelcn.add(btnxoa);
		panelcn.add(new Panel());
		panelcn.add(btnsua);
		panelcn.add(new Panel());
		
		boxright.add(panelcn,BorderLayout.CENTER);
		panelright.add(boxright);
		panelleft.add(boxleft);
		panel.add(panelleft);
		panel.add(panelright);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panelright.setBorder(BorderFactory.createLineBorder(Color.black));
		panelright.setPreferredSize(new Dimension(500, 1710));
		panelleft.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(panel);

	}
//	public static void main(String[] args) {
//		
//		
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
