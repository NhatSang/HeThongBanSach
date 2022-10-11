package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
	private JButton btnThanhToan, btnTimKh, btnTimSp, btnThemKh, btnThemCTHD;
	private DefaultTableModel tableModel;
	private JTable table;
	static LocalDate ngayHienTai = LocalDate.now();
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public GD_LapHoaDon(NhanVien nhanVien) {
		createGui();
	}

	private void createGui() {
		this.setLayout(new BorderLayout());
		
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

		nlb1.add(txtTimKh);
		nlb1.add(btnTimKh);
		nlb1.add(btnThemKh);

		nlb2.add(lblTenKh);
		nlb2.add(txtTenKh);

		nlb3.add(lblSdt);
		nlb3.add(txtSdt);

		nlb4.add(lblEmail);
		nlb4.add(txtEmail);

		nlb5.add(lblDiaChi);
		nlb5.add(txtDiaChi);

		northLB.add(nlb1);
		northLB.add(nlb2);
		northLB.add(nlb3);
		northLB.add(nlb4);
		northLB.add(nlb5);

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
		cb1.add(txtTimSp);
		cb1.add(btnTimSp);

		centerLB.add(cb1);
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
		
		JPanel rP1 = new JPanel();
		rP1.setLayout(new GridLayout(4, 2,10,30));
		rP1.add(lblMaHd);
		rP1.add(txtMaHd);
		rP1.add(lblNgayLap);
		rP1.add(txtNgayLap);
		rP1.add(lblCaLap);
		rP1.add(txtCaLap);
		rP1.add(lblTenNv);
		rP1.add(txtTenNv);
		
		String[] header = "STT;Tên sản phẩm;Đơn vị tính;Số lượng;Đơn giá;VAT;Thành tiền".split(";");
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		
		JScrollPane scrRP = new JScrollPane(table);
		scrRP.setPreferredSize(new Dimension(WIDTH, 300));
		scrRP.setBorder(BorderFactory.createTitledBorder("Chi tiết hóa đơn"));
		
		rightB.add(rP1);
		rightB.add(scrRP);
		this.add(rightB,BorderLayout.EAST);
	}
}
