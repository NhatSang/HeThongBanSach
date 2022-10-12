package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import entity.NhanVien;

//Sang
public class GD_LapHoaDon extends JPanel {
	private NhanVien nhanVien;
	private JLabel lblTenKh, lblSdt, lblEmail, lblDiaChi, lblMaHd, lblNgayLap, lblCaLap, lblTenNv, lblTongTien,
			lblTongVAT, lblTienCanTra, lblTienKhachTra, lblTienThua;
	private JTextField txtTimKh, txtTenKh, txtSdt, txtEmail, txtDiaChi, txtTimSp, txtMaHd, txtNgayLap, txtCaLap,
			txtTenNv, txtTongTien, txtTongVat, txtTienCanTra, txtTienKhachTra, txtTienThua;
	private JButton btnThanhToan, btnTimKh, btnTimSp, btnThemKh, btnThemCTHD, btnXoaCTHD;
	private DefaultTableModel tableModel;
	private JTable table;
	static LocalDate ngayHienTai = LocalDate.now();
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public GD_LapHoaDon(NhanVien nhanVien) {
		createGui();
	}

	private void createGui() {
		this.setLayout(new BorderLayout());
		
		Font font1 = new Font("Serif", Font.PLAIN, 18);
		Box leftB = Box.createVerticalBox();
		
		// tạo box thôn tin khách hàng
		Box northLB = Box.createVerticalBox();
		northLB.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));

		Box nlb1 = Box.createHorizontalBox();
		Box nlb2 = Box.createHorizontalBox();
		Box nlb3 = Box.createHorizontalBox();
		Box nlb4 = Box.createHorizontalBox();
		Box nlb5 = Box.createHorizontalBox();

		txtTimKh = new JTextField();
		txtTenKh = new JTextField();
		txtSdt = new JTextField();
		txtEmail = new JTextField();
		txtDiaChi = new JTextField();

		txtTenKh.setEnabled(false);
		txtSdt.setEnabled(false);
		txtEmail.setEnabled(false);
		txtDiaChi.setEnabled(false);

		btnTimKh = new JButton(new ImageIcon(".\\icon\\search.png"));
		btnThemKh = new JButton(new ImageIcon(".\\icon\\addkh.png"));

		lblTenKh = new JLabel("Họ tên: ");
		lblSdt = new JLabel("Số điện thoại: ");
		lblEmail = new JLabel("Email: ");
		lblDiaChi = new JLabel("Địa chỉ: ");
		lblTenKh.setFont(font1);
		lblSdt.setFont(font1);
		lblEmail.setFont(font1);
		lblDiaChi.setFont(font1);
		lblTenKh.setPreferredSize(lblSdt.getPreferredSize());
		lblEmail.setPreferredSize(lblSdt.getPreferredSize());
		lblDiaChi.setPreferredSize(lblSdt.getPreferredSize());
		
		nlb1.add(Box.createHorizontalStrut(20));
		nlb1.add(txtTimKh);
		nlb1.add(btnTimKh);
		nlb1.add(Box.createHorizontalStrut(30));
		nlb1.add(btnThemKh);
		nlb1.add(Box.createHorizontalStrut(20));

		nlb2.add(Box.createHorizontalStrut(20));
		nlb2.add(lblTenKh);
		nlb2.add(txtTenKh);
		nlb2.add(Box.createHorizontalStrut(20));
		
		nlb3.add(Box.createHorizontalStrut(20));
		nlb3.add(lblSdt);
		nlb3.add(txtSdt);
		nlb3.add(Box.createHorizontalStrut(20));

		nlb4.add(Box.createHorizontalStrut(20));
		nlb4.add(lblEmail);
		nlb4.add(txtEmail);
		nlb4.add(Box.createHorizontalStrut(20));

		nlb5.add(Box.createHorizontalStrut(20));
		nlb5.add(lblDiaChi);
		nlb5.add(txtDiaChi);
		nlb5.add(Box.createHorizontalStrut(20));

		northLB.add(Box.createVerticalStrut(20));
		northLB.add(nlb1);
		northLB.add(Box.createVerticalStrut(20));
		northLB.add(nlb2);
		northLB.add(Box.createVerticalStrut(20));
		northLB.add(nlb3);
		northLB.add(Box.createVerticalStrut(20));
		northLB.add(nlb4);
		northLB.add(Box.createVerticalStrut(20));
		northLB.add(nlb5);
		northLB.add(Box.createVerticalStrut(20));

		leftB.add(northLB);

		// box thông tin sản phẩm
		Box centerLB = Box.createVerticalBox();
//		centerB.setPreferredSize(new Dimension(northB.getWidth(), 500));
		centerLB.setBorder(BorderFactory.createTitledBorder("Thông tin sản phẩm"));

		txtTimSp = new JTextField();
		btnTimSp = new JButton(new ImageIcon(".\\icon\\search.png"));

		JLabel lblImg = new JLabel(new ImageIcon(".\\img\\logo.png"));
		JScrollPane scrLP = new JScrollPane(lblImg);
//		scrP.setPreferredSize(new Dimension(centerB.getWidth(), 600));

		Box cb1 = Box.createHorizontalBox();
		
		cb1.add(Box.createHorizontalStrut(20));
		cb1.add(txtTimSp);
		cb1.add(btnTimSp);
		cb1.add(Box.createHorizontalStrut(20));
		
		centerLB.add(Box.createVerticalStrut(20));
		centerLB.add(cb1);
		centerLB.add(Box.createVerticalStrut(20));
		centerLB.add(scrLP);

		leftB.add(centerLB);
		this.add(leftB, BorderLayout.CENTER);
		
		// box thông tin hóa đơn
		Box rightB = Box.createVerticalBox();	
		rightB.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
		rightB.setPreferredSize(new Dimension(700, HEIGHT));
		
		lblMaHd = new JLabel("Số: ");
		lblNgayLap = new JLabel("Ngày lập: ");
		lblCaLap = new JLabel("Ca lập: ");
		lblTenNv = new JLabel("Người lập: ");
		lblTongTien = new JLabel("Tổng tiền: ");
		lblTongVAT = new JLabel("Tổng VAT: ");
		lblTienCanTra = new JLabel("Khách cần trả: ");
		lblTienKhachTra = new JLabel("Khách thanh toán: ");
		lblTienThua = new JLabel("Tiền thừa: ");
		lblMaHd.setFont(font1);
		lblNgayLap.setFont(font1);
		lblCaLap.setFont(font1);
		lblTenNv.setFont(font1);
		lblTongTien.setFont(font1);
		lblTongVAT.setFont(font1);
		lblTienCanTra.setFont(font1);
		lblTienKhachTra.setFont(font1);
		lblTienThua.setFont(font1);
		lblMaHd.setPreferredSize(lblTienKhachTra.getPreferredSize());
		lblNgayLap.setPreferredSize(lblTienKhachTra.getPreferredSize());
		lblCaLap.setPreferredSize(lblTienKhachTra.getPreferredSize());
		lblTenNv.setPreferredSize(lblTienKhachTra.getPreferredSize());
		lblTongTien.setPreferredSize(lblTienKhachTra.getPreferredSize());
		lblTongVAT.setPreferredSize(lblTienKhachTra.getPreferredSize());
		lblTienCanTra.setPreferredSize(lblTienKhachTra.getPreferredSize());
		lblTienThua.setPreferredSize(lblTienKhachTra.getPreferredSize());

		txtMaHd = new JTextField();
		txtNgayLap = new JTextField();
		txtCaLap = new JTextField();
		txtTenNv = new JTextField();
		txtTongTien = new JTextField();
		txtTongVat = new JTextField();
		txtTienCanTra = new JTextField();
		txtTienKhachTra = new JTextField();
		txtTienThua = new JTextField();
		
		txtMaHd.setEnabled(false);
		txtNgayLap.setEnabled(false);
		txtCaLap.setEnabled(false);
		txtTenNv.setEnabled(false);
		txtTongTien.setEnabled(false);
		txtTongVat.setEnabled(false);
		txtTienCanTra.setEnabled(false);
		txtTienThua.setEnabled(false);
		
		txtNgayLap.setText(dtf.format(ngayHienTai));
		txtCaLap.setText("1");
		
		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setFont(new Font("Serif", Font.BOLD, 25));
		btnXoaCTHD = new JButton(new ImageIcon(".\\icon\\trash.png"));
		btnXoaCTHD.setFont(new Font("Serif", Font.BOLD, 25));
		
		Box rb1 = Box.createHorizontalBox();
		Box rb2 = Box.createHorizontalBox();
		Box rb3 = Box.createHorizontalBox();
		Box rb4 = Box.createHorizontalBox();
		Box rb5 = Box.createVerticalBox();
		Box rb6 = Box.createHorizontalBox();
		Box rb7 = Box.createHorizontalBox();
		Box rb8 = Box.createHorizontalBox();
		Box rb9 = Box.createHorizontalBox();
		Box rb10 = Box.createHorizontalBox();
		
		rb1.add(Box.createHorizontalStrut(20));
		rb1.add(lblMaHd);
		rb1.add(txtMaHd);
		rb1.add(Box.createHorizontalStrut(20));
		
		rb2.add(Box.createHorizontalStrut(20));
		rb2.add(lblNgayLap);
		rb2.add(txtNgayLap);
		rb2.add(Box.createHorizontalStrut(20));
		
		rb3.add(Box.createHorizontalStrut(20));
		rb3.add(lblCaLap);
		rb3.add(txtCaLap);
		rb3.add(Box.createHorizontalStrut(20));
		
		rb4.add(Box.createHorizontalStrut(20));
		rb4.add(lblTenNv);
		rb4.add(txtTenNv);
		rb4.add(Box.createHorizontalStrut(20));
//		JPanel rP1 = new JPanel();
//		rP1.setLayout(new GridLayout(4, 2,10,30));
//		rP1.add(lblMaHd);
//		rP1.add(txtMaHd);
//		rP1.add(lblNgayLap);
//		rP1.add(txtNgayLap);
//		rP1.add(lblCaLap);
//		rP1.add(txtCaLap);
//		rP1.add(lblTenNv);
//		rP1.add(txtTenNv);
		
		String[] header = "STT;Tên sản phẩm;Đơn vị tính;Số lượng;Đơn giá;VAT;Thành tiền".split(";");
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		
		JScrollPane scrRP = new JScrollPane(table);
		scrRP.setPreferredSize(new Dimension(WIDTH, 150));

		Box rb51 = Box.createHorizontalBox();
		rb51.add(Box.createHorizontalStrut(620));
		rb51.add(btnXoaCTHD);
		rb5.setBorder(BorderFactory.createTitledBorder("Chi tiết hóa đơn"));
		rb5.add(scrRP);
		rb5.add(rb51);
		rb5.add(Box.createHorizontalGlue());
		
		rb6.add(Box.createHorizontalStrut(20));
		rb6.add(lblTongTien);
		rb6.add(txtTongTien);
		rb6.add(Box.createHorizontalStrut(20));
		
		rb7.add(Box.createHorizontalStrut(20));
		rb7.add(lblTongVAT);
		rb7.add(txtTongVat);
		rb7.add(Box.createHorizontalStrut(20));
		
		rb8.add(Box.createHorizontalStrut(20));
		rb8.add(lblTienCanTra);
		rb8.add(txtTienCanTra);
		rb8.add(Box.createHorizontalStrut(20));
		
		rb9.add(Box.createHorizontalStrut(20));
		rb9.add(lblTienKhachTra);
		rb9.add(txtTienKhachTra);
		rb9.add(Box.createHorizontalStrut(20));
		
		rb10.add(Box.createHorizontalStrut(20));
		rb10.add(lblTienThua);
		rb10.add(txtTienThua);
		rb10.add(Box.createHorizontalStrut(20));
//		JPanel rP2 = new JPanel();
//		rP2.setLayout(new GridLayout(5, 2,10, 30));
//		rP2.add(lblTongTien);
//		rP2.add(txtTongTien);
//		rP2.add(lblTongVAT);
//		rP2.add(txtTongVat);
//		rP2.add(lblTienCanTra);
//		rP2.add(txtTienCanTra);
//		rP2.add(lblTienKhachTra);
//		rP2.add(txtTienKhachTra);
//		rP2.add(lblTienThua);
//		rP2.add(txtTienThua);
		
		JPanel rP3 = new JPanel();
		rP3.setBorder(BorderFactory.createLineBorder(Color.black));
		rP3.add(btnThanhToan);
		
		rightB.add(Box.createVerticalStrut(20));
		rightB.add(rb1);
		rightB.add(Box.createVerticalStrut(20));
		rightB.add(rb2);
		rightB.add(Box.createVerticalStrut(20));
		rightB.add(rb3);
		rightB.add(Box.createVerticalStrut(20));
		rightB.add(rb4);
//		rightB.add(Box.createVerticalStrut(10));
//		rightB.add(scrRP);
		rightB.add(Box.createVerticalStrut(10));
		rightB.add(rb5);
		rightB.add(Box.createVerticalStrut(20));
		rightB.add(rb6);
		rightB.add(Box.createVerticalStrut(20));
		rightB.add(rb7);
		rightB.add(Box.createVerticalStrut(20));
		rightB.add(rb8);
		rightB.add(Box.createVerticalStrut(20));
		rightB.add(rb9);
		rightB.add(Box.createVerticalStrut(20));
		rightB.add(rb10);
		rightB.add(Box.createVerticalStrut(20));
		rightB.add(rP3);
		this.add(rightB,BorderLayout.EAST);
	}
}
