package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

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

import dao.KhachHang_DAO;
import entity.KhachHang;

public class Frm_ThemKhachHang extends JFrame implements ActionListener {
	private JLabel lblTen, lblNgaySinh, lblDiaChi, lblSdt, lblGioiTinh, messenger;
	private JTextField txtTen, txtDiaChi, txtSdt;
	private JButton btnThem, btnHuy;
	private JRadioButton rdoNam, rdoNu;
	private JDateChooser jdcNgaySinh;
	private GD_LapHoaDon parent;
	private KhachHang_DAO kh_DAO;

	public Frm_ThemKhachHang(GD_LapHoaDon parent) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\icon\\logobook.png"));
		setTitle("Hệ thống quản lý hiệu sách Chí Tâm");
		setSize(700, 450);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		this.parent = parent;
		kh_DAO = new KhachHang_DAO();
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
		Box b7 = Box.createHorizontalBox();

		Font font1 = new Font("Serif", Font.PLAIN, 17);

		JLabel lblTieuDe = new JLabel("Thêm Khách Hàng");
		lblTieuDe.setFont(new Font("Serif", Font.BOLD, 50));
		b1.add(lblTieuDe);

		lblTen = new JLabel("Họ tên: ");
		lblGioiTinh = new JLabel("Giới tính: ");
		lblNgaySinh = new JLabel("Ngày sinh: ");
		lblDiaChi = new JLabel("Địa chỉ: ");
		lblSdt = new JLabel("Số điện thoại: ");
		messenger = new JLabel(" ");
		lblTen.setFont(font1);
		lblGioiTinh.setFont(font1);
		lblNgaySinh.setFont(font1);
		lblDiaChi.setFont(font1);
		lblSdt.setFont(font1);
		messenger.setFont(new Font("Serif", Font.ITALIC, 17));
		messenger.setForeground(Color.red);
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
		
		b6.add(messenger);

		b7.add(Box.createHorizontalStrut(20));
		b7.add(btnThem);
		b7.add(Box.createHorizontalStrut(20));
		b7.add(btnHuy);
		b7.add(Box.createHorizontalStrut(20));

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
		mainBox.add(b7);
		mainBox.add(Box.createVerticalStrut(20));


		con.add(mainBox, BorderLayout.CENTER);
		btnHuy.addActionListener(this);
		btnThem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnHuy) {
			this.dispose();
		} else if (obj == btnThem) {
			if (checkThongTin()) {
				String hoTen = txtTen.getText();
				String diaChi = txtDiaChi.getText();
				String sdt = txtSdt.getText();

				Date ngaySinh = Date.valueOf(((JTextField) jdcNgaySinh.getDateEditor().getUiComponent()).getText());
				Boolean gioiTinh = rdoNam.isSelected() ? true : false;
				KhachHang kh1 = kh_DAO.timKhachHangTheoSdt(sdt);
				if (kh1 == null) {
					KhachHang kh = new KhachHang(hoTen, ngaySinh, diaChi, sdt, gioiTinh);
					try {
						kh_DAO.addKH(kh);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
//					e1.printStackTrace();
					}
					parent.setTextTimKiemSP(sdt);
					this.dispose();
				} else
					JOptionPane.showMessageDialog(null, "Số điện thoại này đã tồn tại");
			}
		}
	}

	public boolean checkThongTin() {
		String ten = txtTen.getText();
		String dc = txtDiaChi.getText();
		String sdt = txtSdt.getText();
		String today = Date.valueOf(LocalDate.now()).toString();
		if (ten.equals("")) {
			messenger.setText("Nhập họ tên khách hàng");
			return false;
		}
		if (jdcNgaySinh.getDate() == null) {
			messenger.setText("Nhập ngày sinh khách hàng");
			return false;
		}
		if (dc.equals("")) {
			messenger.setText("Nhập địa chỉ khách hàng");
			return false;
		}
		if (!sdt.matches("[0-9]{10}")) {
			messenger.setText("SĐT phải đúng định dạng 0xxxxxxxxx");
			return false;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String ns = dateFormat.format(jdcNgaySinh.getDate());
		int a = ns.compareTo(today);
		System.out.println(a);
		if (a > 0) {
			messenger.setText("Ngày sinh phải bé hơn ngày hiện tại");
			return false;
		}
		return true;
	}

}
