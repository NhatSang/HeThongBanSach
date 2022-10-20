package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.DataBase;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.SanPham_DAO;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

public class GD_LapHoaDon extends JPanel implements ActionListener {
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private HoaDon hoaDon;
	private SanPham sp;
	private JLabel lblTenKh, lblSdt, lblDiaChi, lblTenKh1, lblSdt1, lblDiaChi1, lblImg, lblTenSp, lblNCC, lblDonGia,
			lblDonVi, lblSoLuong, lblMaHd, lblNgayLap, lblCaLap, LblNguoiLap, lblTongTien, lblTongVAT, lblTienCanTra,
			lblTienKhachTra, lblTienThua;
	private JTextField txtTimKh, txtTimSp, txtTienKhachTra;
	private JButton btnTimKh, btnThemKh, btnTimSp, btnThemCTHD, btnThanhToan;
	private Box leftBox, rightBox, northLB, centerLB;
	private JTable tblCTHD;
	private DefaultTableModel tblModel;
	private JScrollPane scrP;
	private SanPham_DAO sp_DAO;
	private HoaDon_DAO hd_DAO;
	private KhachHang_DAO kh_DAO;
	private String soHD;
	private LocalDate ngayHienTai;
	private int caLap;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public GD_LapHoaDon(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
		createGui();
		DataBase.getInstance().connect();
		sp_DAO = new SanPham_DAO();
		hd_DAO = new HoaDon_DAO();
		kh_DAO = new KhachHang_DAO();
		hoaDon = new HoaDon();
		sp = new SanPham();
		khachHang = new KhachHang();

	}

	private void createGui() {
		getThongTinHD();
		this.setLayout(new BorderLayout());
		Font font1 = new Font("Serif", Font.PLAIN, 17);
		Font font2 = new Font("Serif", Font.ITALIC, 17);

		leftBox = Box.createVerticalBox();
		northLB = Box.createVerticalBox();
		northLB.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));

		txtTimKh = new JTextField();
		btnTimKh = new JButton(new ImageIcon(".\\icon\\search.png"));
		btnThemKh = new JButton(new ImageIcon(".\\icon\\addkh.png"));

		lblTenKh = new JLabel("Họ tên:");
		lblTenKh1 = new JLabel();
		lblSdt = new JLabel("Số điện thoại:");
		lblSdt1 = new JLabel();
		lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi1 = new JLabel();
		lblTenKh.setFont(font1);
		lblSdt.setFont(font1);
		lblDiaChi.setFont(font1);
		lblTenKh1.setFont(font1);
		lblSdt1.setFont(font1);
		lblDiaChi1.setFont(font1);

		// nlb viet tat north left box
		Box nlb1 = Box.createHorizontalBox();
		nlb1.add(Box.createHorizontalStrut(20));
		nlb1.add(txtTimKh);
		nlb1.add(btnTimKh);
		nlb1.add(Box.createHorizontalStrut(20));
		nlb1.add(btnThemKh);
		nlb1.add(Box.createHorizontalStrut(20));

		Box nlb2 = Box.createHorizontalBox();
		Box nlb2label = Box.createVerticalBox();
		Box nlb2Text = Box.createVerticalBox();

		nlb2label.add(Box.createVerticalStrut(20));
		nlb2label.add(lblTenKh);
		nlb2label.add(Box.createVerticalStrut(20));
		nlb2label.add(lblSdt);
		nlb2label.add(Box.createVerticalStrut(20));
		nlb2label.add(lblDiaChi);
		nlb2label.add(Box.createVerticalStrut(20));

		nlb2Text.add(Box.createVerticalStrut(20));
		nlb2Text.add(lblTenKh1);
		nlb2Text.add(Box.createVerticalStrut(20));
		nlb2Text.add(lblSdt1);
		nlb2Text.add(Box.createVerticalStrut(20));
		nlb2Text.add(lblDiaChi1);
		nlb2Text.add(Box.createVerticalStrut(20));

		nlb2.add(Box.createHorizontalStrut(20));
		nlb2.add(nlb2label);
		nlb2.add(Box.createHorizontalStrut(20));
		nlb2.add(nlb2Text);
		nlb2.add(Box.createHorizontalStrut(600));

		northLB.add(Box.createVerticalStrut(25));
		northLB.add(nlb1);
		northLB.add(Box.createVerticalStrut(20));
		northLB.add(nlb2);

		centerLB = Box.createVerticalBox();
		centerLB.setBorder(BorderFactory.createTitledBorder("Thông tin sản phẩm"));
		txtTimSp = new JTextField();
		btnTimSp = new JButton(new ImageIcon(".\\icon\\search.png"));
		btnThemCTHD = new JButton(new ImageIcon(".\\icon\\plus.png"));

		Box clb1 = Box.createHorizontalBox();
		JPanel clP1 = new JPanel();
		clP1.setLayout(new GridBagLayout());
		clP1.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc = new GridBagConstraints();

		clb1.add(Box.createHorizontalStrut(20));
		clb1.add(txtTimSp);
		clb1.add(btnTimSp);
		clb1.add(Box.createHorizontalStrut(20));

		lblImg = new JLabel();
		lblImg.setIcon(loadImg(".\\img\\picture.png", 150, 150));
		JPanel imgP = new JPanel();
		imgP.setPreferredSize(new Dimension(150, 150));
		imgP.add(lblImg);
		lblTenSp = new JLabel("Tên sản phẩm:");
		lblNCC = new JLabel("Nhà cung cấp:");
		lblDonGia = new JLabel("Đơn giá:");
		lblDonVi = new JLabel("Đơn vị tính:");
		lblSoLuong = new JLabel("Số lượng:");
		lblTenSp.setFont(font2);
		lblNCC.setFont(font2);
		lblDonGia.setFont(font2);
		lblDonVi.setFont(font2);
		lblSoLuong.setFont(font2);

		Box clb2Center = Box.createVerticalBox();
		clb2Center.setPreferredSize(new Dimension(590, 200));
		clb2Center.add(Box.createHorizontalStrut(10));
//		clb2Center.add(Box.createVerticalStrut(10));
		clb2Center.add(lblTenSp);
		clb2Center.add(Box.createVerticalStrut(10));
		clb2Center.add(lblNCC);
		clb2Center.add(Box.createVerticalStrut(10));
		clb2Center.add(lblDonGia);
		clb2Center.add(Box.createVerticalStrut(10));
		clb2Center.add(lblDonVi);
		clb2Center.add(Box.createVerticalStrut(10));
		clb2Center.add(lblSoLuong);
		clb2Center.add(Box.createVerticalStrut(10));

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		clP1.add(imgP, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		clP1.add(clb2Center, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 4;
		gbc.gridy = 0;
		clP1.add(btnThemCTHD, gbc);

		centerLB.add(Box.createVerticalStrut(25));
		centerLB.add(clb1);
		centerLB.add(Box.createVerticalStrut(20));
		centerLB.add(clP1);
		centerLB.add(Box.createVerticalStrut(20));

		leftBox.add(northLB);
		leftBox.add(centerLB);

		rightBox = Box.createVerticalBox();
		rightBox.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
		rightBox.setPreferredSize(new Dimension(550, HEIGHT));

		lblMaHd = new JLabel("Số:" + soHD);
		lblNgayLap = new JLabel("Ngày lập: " + dtf.format(ngayHienTai));
		LblNguoiLap = new JLabel("Người lập: " + nhanVien.getHoTen());
		lblCaLap = new JLabel("Ca lập: " + caLap);
		lblMaHd.setFont(font1);
		lblNgayLap.setFont(font1);
		lblCaLap.setFont(font1);
		LblNguoiLap.setFont(font1);

		JPanel northRP = new JPanel();
		northRP.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();

		Box nrb1 = Box.createVerticalBox();
		nrb1.setPreferredSize(new Dimension(350, 70));
		Box nrb2 = Box.createVerticalBox();
		nrb2.setPreferredSize(new Dimension(150, 70));

		nrb1.add(lblMaHd);
		nrb1.add(Box.createVerticalStrut(10));
		nrb1.add(LblNguoiLap);

		nrb2.add(lblNgayLap);
		nrb2.add(Box.createVerticalStrut(10));
		nrb2.add(lblCaLap);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		northRP.add(nrb1, gbc1);
		gbc.gridx = 1;
		gbc.gridy = 0;
		northRP.add(nrb2, gbc1);

		String[] header = "STT,Tên sản phẩm,Đơn giá,Số lượng,VAT,Thành tiền".split(",");
		tblModel = new DefaultTableModel(header, 0);
		tblCTHD = new JTable(tblModel);

		scrP = new JScrollPane(tblCTHD);
		scrP.setPreferredSize(new Dimension(WIDTH, 300));
		scrP.setBorder(BorderFactory.createTitledBorder("Chi tiết hóa đơn"));

		lblTongTien = new JLabel("Tổng:");
		lblTongVAT = new JLabel("Tổng VAT:");
		lblTienCanTra = new JLabel("Tổng tiền (gồm VAT):");
		lblTienKhachTra = new JLabel("Khách thanh toán:");
		lblTienThua = new JLabel("Tiền thừa:");
		lblTongTien.setFont(font1);
		lblTongVAT.setFont(font1);
		lblTienCanTra.setFont(font1);
		lblTienKhachTra.setFont(font1);
		lblTienThua.setFont(font1);

		txtTienKhachTra = new JTextField(20);

		JPanel srP1 = new JPanel();
		Box srb1 = Box.createVerticalBox();
		srb1.setPreferredSize(new Dimension(500, 100));

		srb1.add(lblTongTien);
		srb1.add(Box.createVerticalStrut(10));
		srb1.add(lblTongVAT);
		srb1.add(Box.createVerticalStrut(10));
		srb1.add(lblTienCanTra);

		srP1.add(srb1);

		JPanel srP2 = new JPanel(new GridLayout(1, 2, 20, 10));

		Box srb2 = Box.createHorizontalBox();
		Box srb3 = Box.createHorizontalBox();

		srb2.add(Box.createHorizontalStrut(20));
		srb2.add(lblTienKhachTra);
		srb2.add(txtTienKhachTra);

		srb3.add(lblTienThua);

		srP2.add(srb2);
		srP2.add(srb3);

		JPanel southP = new JPanel();
		southP.setBorder(BorderFactory.createLineBorder(Color.black));
		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setFont(new Font("Serif", Font.PLAIN, 18));
		southP.add(btnThanhToan);

		rightBox.add(northRP);
		rightBox.add(scrP);
		rightBox.add(srP1);
		rightBox.add(srP2);
		rightBox.add(Box.createVerticalStrut(10));
		rightBox.add(southP);
//		rightBox.add(Box.createVerticalStrut(100));

		this.add(leftBox, BorderLayout.CENTER);
		this.add(rightBox, BorderLayout.EAST);

		btnTimSp.addActionListener(this);
		btnThemCTHD.addActionListener(this);
		btnThemKh.addActionListener(this);
		btnTimKh.addActionListener(this);
	}

	public Icon loadImg(String linkImage, int k, int m) {
		/*
		 * linkImage là tên icon, k kích thước chiều rộng mình muốn,m chiều dài và hàm
		 * này trả về giá trị là 1 icon.
		 */
		try {
			BufferedImage image = ImageIO.read(new File(linkImage));// đọc ảnh dùng BufferedImage
			int x = k;
			int y = m;
			int ix = image.getWidth();
			int iy = image.getHeight();
			int dx = 0, dy = 0;
			if (x / y > ix / iy) {
				dy = y;
				dx = dy * ix / iy;
			} else {
				dx = x;
				dy = dx * iy / ix;
			}
			return new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnTimSp) {
			if (txtTimSp.getText().length() != 0) {
				sp = sp_DAO.timKiemSPTheoMa(txtTimSp.getText());
				if (sp != null) {
					capNhatSanPham(sp);
				} else
					JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm");
			}
		} else if (obj == btnThemCTHD) {
			clearSanPham();

		} else if (obj == btnTimKh) {
			if (txtTimKh.getText().length() != 0) {
				khachHang = kh_DAO.timKhachHangTheoSdt(txtTimKh.getText());
				if (khachHang != null)
					capNhatKhachHang(khachHang);
				else
					JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng");
			}
		} else if (obj == btnThemKh) {
			new Frm_ThemKhachHang(this).setVisible(true);
		}

	}

	public void capNhatSanPham(SanPham sp) {
		lblImg.setIcon(loadImg(".\\img\\" + sp.getHinhAnh(), 150, 150));
		lblTenSp.setText("Tên sản phẩm: " + sp.getTenSP());
		lblNCC.setText("Nhà cung cấp: " + sp.getNhaCC().getMaNCC());
		lblDonGia.setText("Đơn giá: " + sp.getDonGia());
		lblDonVi.setText("Đơn vị tính: " + sp.getDonVi());
		lblSoLuong.setText("Số lượng: " + sp.getSoLuong());
	}

	public void clearSanPham() {
		txtTimSp.setText("");
		lblImg.setIcon(loadImg(".\\img\\picture.png", 150, 150));
		lblTenSp.setText("Tên sản phẩm: ");
		lblNCC.setText("Nhà cung cấp: ");
		lblDonGia.setText("Đơn giá: ");
		lblDonVi.setText("Đơn vị tính: ");
		lblSoLuong.setText("Số lượng: ");
	}

	public void getThongTinHD() {
		ngayHienTai = LocalDate.now();
		hd_DAO = new HoaDon_DAO();
		soHD = hd_DAO.getMaHD();
		int gioHT = LocalDateTime.now().getHour();
		if (gioHT >= 8 && gioHT <= 15)
			caLap = 1;
		else
			caLap = 2;
	}

	public void capNhatKhachHang(KhachHang kh) {
		lblTenKh1.setText(kh.getHoTen());
		lblDiaChi1.setText(kh.getDiaChi());
		lblSdt1.setText(kh.getsDT());
	}
}
