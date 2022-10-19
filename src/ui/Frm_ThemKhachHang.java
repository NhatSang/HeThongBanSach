package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Frm_ThemKhachHang extends JFrame implements ActionListener{
	private JLabel lblTen, lblNgaySinh, lblDiaChi,lblSdt,lblGioiTinh;
	private JTextField txtTen, txtDiaChi, txtSdt;
	private JButton btnThem, btnHuy;
	private JRadioButton rdoNam, rdoNu;
	private JDateChooser jdcNgaySinh;
	private JPanel parent;
	public Frm_ThemKhachHang(JPanel parent) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\icon\\logobook.png"));
		setTitle("Hệ thống quản lý hiệu sách Chí Tâm");
		setSize(600, 350);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		this.parent = parent;
		createGui();
	}

	private void createGui() {
		Container con = getContentPane();
		Box mainBox = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();
		Box b6 = Box.createHorizontalBox();
		
		
		Font font1 = new Font("Serif", Font.PLAIN, 17);
		
		JLabel lblTieuDe = new JLabel("Thêm Khách Hàng");
		lblTieuDe.setFont(new Font("Serif", Font.BOLD, 50));
		b1.add(lblTieuDe);
		
		lblTen = new JLabel("Họ tên: ");
		lblGioiTinh = new JLabel("Giới tính: ");
		lblNgaySinh = new JLabel("Ngày sinh: ");
		lblDiaChi = new JLabel("Địa chỉ: ");
		lblSdt = new JLabel("Số điện thoại: ");
		lblTen.setFont(font1);
		lblGioiTinh.setFont(font1);
		lblNgaySinh.setFont(font1);
		lblDiaChi.setFont(font1);
		lblSdt.setFont(font1);
		lblTen.setPreferredSize(lblSdt.getPreferredSize());
		lblDiaChi.setPreferredSize(lblSdt.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblSdt.getPreferredSize());
		
		txtTen = new JTextField();
		txtDiaChi = new JTextField();
		txtSdt = new JTextField();

		String fdate = "yyyy-MM-dd";
		jdcNgaySinh = new JDateChooser();
		jdcNgaySinh.setDateFormatString(fdate);
		
		rdoNam = new JRadioButton("Nam");
		rdoNu = new JRadioButton("Nữ");
		ButtonGroup gr = new ButtonGroup();
		gr.add(rdoNam);
		gr.add(rdoNu);
		rdoNam.setSelected(true);
		
		btnThem = new JButton("Thêm");
		btnHuy = new JButton("Hủy");
		btnThem.setFont(new Font("Serif", Font.BOLD, 20));
		btnHuy.setFont(new Font("Serif", Font.BOLD, 20));
		
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblTen);
		b2.add(txtTen);
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblGioiTinh);
		b2.add(rdoNam);
		b2.add(Box.createHorizontalStrut(20));
		b2.add(rdoNu);
		b2.add(Box.createHorizontalStrut(20));
		
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblNgaySinh);
		b3.add(jdcNgaySinh);
		b3.add(Box.createHorizontalStrut(20));
		
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblDiaChi);
		b4.add(txtDiaChi);
		b4.add(Box.createHorizontalStrut(20));
		
		b5.add(Box.createHorizontalStrut(20));
		b5.add(lblSdt);
		b5.add(txtSdt);
		b5.add(Box.createHorizontalStrut(20));
		
		b6.add(Box.createHorizontalStrut(20));
		b6.add(btnThem);
		b6.add(Box.createHorizontalStrut(20));
		b6.add(btnHuy);
		b6.add(Box.createHorizontalStrut(20));
		
		mainBox.add(b1);
		mainBox.add(Box.createVerticalStrut(20));
		mainBox.add(b2);
		mainBox.add(Box.createVerticalStrut(20));
		mainBox.add(b3);
		mainBox.add(Box.createVerticalStrut(20));
		mainBox.add(b4);
		mainBox.add(Box.createVerticalStrut(20));
		mainBox.add(b5);
		mainBox.add(Box.createVerticalStrut(20));
		mainBox.add(b6);
		mainBox.add(Box.createVerticalStrut(20));
		
		con.add(mainBox,BorderLayout.CENTER);
		btnHuy.addActionListener(this);
		btnThem.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnHuy) {
			this.dispose();
		}
		else if(obj == btnThem) {
			this.dispose();
		}
	}

}
