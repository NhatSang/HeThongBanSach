package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import connectDB.DataBase;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.SanPham_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

public class GD_LapHoaDon extends JPanel implements ActionListener, MouseListener {
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private HoaDon hoaDon;
	private SanPham sp;
	private ArrayList<SanPham> dssp;
	private GD_NhanVienBanHang parent;
	private JLabel lblTenKh, lblSdt, lblDiaChi, lblTenKh1, lblSdt1, lblDiaChi1, lblImg, lblTenSp, lblNCC, lblDonGia,
			lblDonVi, lblSoLuong, lblMaHd, lblNgayLap, lblCaLap, LblNguoiLap, lblTongTien, lblTongVAT, lblTienCanTra,
			lblTienKhachTra, lblTienThua;
	private JTextField txtTimKh, txtTimSp, txtTienKhachTra;
	private JButton btnTimKh, btnTimSp, btnThanhToan, btnXoaCTHD, btnLuu;
	private static JButton[] btn;
	private Box leftBox, rightBox, northLB, centerLB;
	private JTable tblCTHD;
	private DefaultTableModel tblModel;
	private JScrollPane scrLP, scrRP;
	private JPanel sanPhamP, clP1;
	private SanPham_DAO sp_DAO;
	private HoaDon_DAO hd_DAO;
	private KhachHang_DAO kh_DAO;
	private String soHD;
	private LocalDate ngayHienTai;
	private int caLap;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private int k;
	private DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
	public GD_LapHoaDon(GD_NhanVienBanHang parent) {
		this.parent = parent;
		this.nhanVien = parent.getNhanVien();
		getThongTinHD();
		createGui();
		DataBase.getInstance().connect();
		sp_DAO = new SanPham_DAO();
		hd_DAO = new HoaDon_DAO();
		kh_DAO = new KhachHang_DAO();
		hoaDon = null;
		sp = null;
		dssp = new ArrayList<SanPham>();
		khachHang = null;
		k = 0;
	}

	public GD_LapHoaDon(GD_NhanVienBanHang parent, HoaDon hoaDon) {
		super();
		this.parent = parent;
		this.hoaDon = hoaDon;
		this.nhanVien = hoaDon.getNhanVien();
		this.khachHang = hoaDon.getKhachHang();
		sp_DAO = new SanPham_DAO();
		hd_DAO = new HoaDon_DAO();
		kh_DAO = new KhachHang_DAO();
		loadTTHD();
		createGui();
		DataBase.getInstance().connect();
		capNhatKhachHang(khachHang);
		capNhatHoaDon();
		btnThanhToan.setEnabled(true);
		txtTimKh.setEditable(false);
		btnTimKh.setEnabled(false);
		dssp = new ArrayList<SanPham>();
		k = 1;
	}

	private void createGui() {

		this.setLayout(new BorderLayout());
		Font font1 = new Font("Serif", Font.PLAIN, 17);

		leftBox = Box.createVerticalBox();
		northLB = Box.createVerticalBox();
//		northLB.setPreferredSize(new Dimension(WIDTH, 1));
		northLB.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));

		txtTimKh = new JTextField();
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input1 = classLoader.getResourceAsStream("search.png");
		InputStream input2 = classLoader.getResourceAsStream("trash.png");
		
		BufferedImage image1 = null;
		BufferedImage image2 = null;
		
		try {
		    image1 = ImageIO.read(input1);
		    image2 = ImageIO.read(input2);

		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		btnTimKh = new JButton(new ImageIcon(image1));

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

		Box nlb2 = Box.createHorizontalBox();
		Box nlb2label = Box.createVerticalBox();
		Box nlb2Text = Box.createVerticalBox();

		nlb2label.add(Box.createVerticalStrut(5));
		nlb2label.add(lblTenKh);
		nlb2label.add(Box.createVerticalStrut(5));
		nlb2label.add(lblSdt);
		nlb2label.add(Box.createVerticalStrut(5));
		nlb2label.add(lblDiaChi);
		nlb2label.add(Box.createVerticalStrut(5));

		nlb2Text.add(Box.createVerticalStrut(5));
		nlb2Text.add(lblTenKh1);
		nlb2Text.add(Box.createVerticalStrut(5));
		nlb2Text.add(lblSdt1);
		nlb2Text.add(Box.createVerticalStrut(5));
		nlb2Text.add(lblDiaChi1);
		nlb2Text.add(Box.createVerticalStrut(5));

		nlb2.add(Box.createHorizontalStrut(20));
		nlb2.add(nlb2label);
		nlb2.add(Box.createHorizontalStrut(20));
		nlb2.add(nlb2Text);
		nlb2.add(Box.createHorizontalStrut(600));

		northLB.add(Box.createVerticalStrut(5));
		northLB.add(nlb1);
//		northLB.add(Box.createVerticalStrut(20));
		northLB.add(nlb2);

		centerLB = Box.createVerticalBox();
		centerLB.setBorder(BorderFactory.createTitledBorder("Thông tin sản phẩm"));
		txtTimSp = new JTextField();
		btnTimSp = new JButton(new ImageIcon(image1));

		Box clb1 = Box.createHorizontalBox();
		clP1 = new JPanel();
		clP1.setLayout(new BorderLayout());
		clP1.setPreferredSize(new Dimension(WIDTH, 600));
		clP1.setBorder(BorderFactory.createLineBorder(Color.black));
		sanPhamP = new JPanel();
		scrLP = new JScrollPane();
		clP1.add(scrLP);

		clb1.add(Box.createHorizontalStrut(20));
		clb1.add(txtTimSp);
		clb1.add(btnTimSp);
		clb1.add(Box.createHorizontalStrut(20));

		centerLB.add(Box.createVerticalStrut(5));
		centerLB.add(clb1);
		centerLB.add(Box.createVerticalStrut(5));
		centerLB.add(clP1);
		centerLB.add(Box.createVerticalStrut(5));

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

		gbc1.fill = GridBagConstraints.HORIZONTAL;
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		northRP.add(nrb1, gbc1);
		gbc1.gridx = 1;
		gbc1.gridy = 0;
		northRP.add(nrb2, gbc1);

		String[] header = "STT,Tên sản phẩm,Đơn giá,Số lượng,VAT(%),Thành tiền".split(",");
		tblModel = new DefaultTableModel(header, 0);
		tblCTHD = new JTable(tblModel) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		Box centerRB = Box.createVerticalBox();
		Box crB1 = Box.createHorizontalBox();
		btnXoaCTHD = new JButton(new ImageIcon(image2));

		scrRP = new JScrollPane(tblCTHD);
		scrRP.setPreferredSize(new Dimension(WIDTH, 350));

		centerRB.setBorder(BorderFactory.createTitledBorder("Chi tiết hóa đơn"));

		centerRB.add(scrRP);

		crB1.add(Box.createHorizontalStrut(450));
		crB1.add(btnXoaCTHD);
		centerRB.add(crB1);

		lblTongTien = new JLabel("Tổng: 0.0");
		lblTongVAT = new JLabel("Tổng VAT: 0.0");
		lblTienCanTra = new JLabel("Tổng tiền (gồm VAT): 0.0");
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
		btnLuu = new JButton("Lưu");
		btnThanhToan.setFont(new Font("Serif", Font.PLAIN, 18));
		btnLuu.setFont(new Font("Serif", Font.PLAIN, 18));

		EnabledBtn(false);

		southP.add(btnLuu);
		southP.add(Box.createHorizontalStrut(20));
		southP.add(btnThanhToan);

		rightBox.add(northRP);
		rightBox.add(centerRB);
		rightBox.add(srP1);
		rightBox.add(srP2);
		rightBox.add(Box.createVerticalStrut(10));
		rightBox.add(southP);
//		rightBox.add(Box.createVerticalStrut(100));

		this.add(leftBox, BorderLayout.CENTER);
		this.add(rightBox, BorderLayout.EAST);

		btnTimSp.addActionListener(this);
		btnTimKh.addActionListener(this);
		btnXoaCTHD.addActionListener(this);
		btnLuu.addActionListener(this);
		btnThanhToan.addActionListener(this);
		tblCTHD.addMouseListener(this);
		txtTienKhachTra.addKeyListener((KeyListener) new KeyListener() {
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (hoaDon != null) {
					String tkt = txtTienKhachTra.getText();
					double t;
					if (isInt(tkt)) {
						t = Double.parseDouble(tkt);
						double s = t - Math.round(hoaDon.tongTienSauVAT());
						lblTienThua.setText("Tiền thừa: " + decimalFormat.format(s));
					}
				}
			}
		});

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

		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnTimSp) {
			if (txtTimSp.getText().length() != 0) {
//				sp = sp_DAO.timKiemSPTheoMa(txtTimSp.getText());
				dssp = sp_DAO.timKiemSPTheoMa(txtTimSp.getText());
				capNhatSanPham(dssp);
				if (dssp.size() == 0)
					JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm");
			}
		}
		for (int i = 0; i < dssp.size(); i++) {
			if (obj == btn[i]) {
				sp = dssp.get(i);
				if (khachHang != null) {
					String soLuong = JOptionPane.showInputDialog("Nhập số lượng");
					int sl;
					if (isInt(soLuong)) {
						sl = Integer.parseInt(soLuong);
						if (sl <= 0)
							JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0");
						else if (sl > sp.getSoLuong())
							JOptionPane.showMessageDialog(null, "Số lượng sản phẩm hiện không đủ");
						else {
							if (kiemtraSp() == false) {
								hoaDon.themCTHD(sp, sp.getDonGia(), sl);
								EnabledBtn(true);
								capNhatHoaDon();
								clearSanPham();
								sp = null;
							} else {
								for (ChiTietHoaDon c : hoaDon.getDsChiTiet()) {
									if (c.getSanPham().getMaSP().equals(sp.getMaSP())) {
										c.setSoLuong(c.getSoLuong() + sl);
									}
								}
								EnabledBtn(true);
								capNhatHoaDon();
								clearSanPham();
								sp = null;
							}
						}
					} else
						JOptionPane.showMessageDialog(null, "Số lượng phải là số");

				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin khách hàng");
					txtTimKh.requestFocus();
				}
			}
		}
		if (obj == btnTimKh) {
			if (txtTimKh.getText().length() != 0) {
				khachHang = kh_DAO.timKhachHangTheoSdt(txtTimKh.getText());
				if (khachHang != null) {
					capNhatKhachHang(khachHang);
					hoaDon = new HoaDon(soHD, ngayHienTai, caLap, nhanVien, khachHang);
				} else
					JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng");
			}
		}
		if (obj == btnXoaCTHD) {
			int index = tblCTHD.getSelectedRow();
			if (index != -1) {
				if (k == 1) {
					EnabledBtn(true);
				}
				hoaDon.xoaCTHD(index);
				capNhatHoaDon();
				if (hoaDon.getDsChiTiet().size() == 0) {
					EnabledBtn(false);
				}
			}
		}
		if (obj == btnThanhToan) {
			if (txtTienKhachTra.getText().length() == 0) {
				JOptionPane.showMessageDialog(this, "Chưa nhập tiền khách thanh toán");
				txtTienKhachTra.requestFocus();
			}else if(!isDbl(txtTienKhachTra.getText())) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập vào 1 số");
				txtTienKhachTra.requestFocus();
			}
			else {
				if (Double.parseDouble(txtTienKhachTra.getText())-hoaDon.tongTienSauVAT() >= 0) {
					if (k == 0) {
						try {
							hd_DAO.themHD(hoaDon, true);
							for (ChiTietHoaDon c : hoaDon.getDsChiTiet()) {
								hd_DAO.themCTHD(c, soHD);
								sp_DAO.capNhat_soLuong(c.getSanPham().getMaSP(),
										c.getSanPham().getSoLuong() - c.getSoLuong());
							}
							JOptionPane.showMessageDialog(null, "Đã thanh toán");
							int qes = JOptionPane.showConfirmDialog(null, "Có xuất hóa đơn không?");
							if (qes == JOptionPane.YES_OPTION) {
								GD_XuatHD f = new GD_XuatHD(hoaDon);
								f.setVisible(true);
								f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
							}
							parent.thayCenterP(new GD_LapHoaDon(parent));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						try {
							for (ChiTietHoaDon c : hoaDon.getDsChiTiet()) {
								if (c.getSanPham().getSoLuong() - c.getSoLuong() < 0) {
									JOptionPane.showMessageDialog(null,
											"Sản phẩm " + c.getSanPham().getTenSP() + " không đủ số lượng");
									return;
								}
							}
							hd_DAO.xoaHD(hoaDon.getMaHD());
							hd_DAO.themHD(hoaDon, true);
							for (ChiTietHoaDon c : hoaDon.getDsChiTiet()) {
								hd_DAO.themCTHD(c, soHD);
								sp_DAO.capNhat_soLuong(c.getSanPham().getMaSP(),
										c.getSanPham().getSoLuong() - c.getSoLuong());
							}
							JOptionPane.showMessageDialog(null, "Đã thanh toán");
							int qes = JOptionPane.showConfirmDialog(null, "Có xuất hóa đơn không?");
							if (qes == JOptionPane.YES_OPTION) {
								GD_XuatHD f = new GD_XuatHD(hoaDon);
								f.setVisible(true);
								f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
							}
							parent.thayCenterP(new GD_LapHoaDon(parent));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				else
					JOptionPane.showMessageDialog(this, "Khách thanh toán chưa đủ tiền");
			}
		}
		if (obj == btnLuu) {
			if (k == 0) {
				try {
					hd_DAO.themHD(hoaDon, false);
					for (ChiTietHoaDon c : hoaDon.getDsChiTiet()) {
						hd_DAO.themCTHD(c, soHD);
					}
					JOptionPane.showMessageDialog(null, "Đã lưu hóa đơn");
					parent.thayCenterP(new GD_LapHoaDon(parent));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				try {
					hd_DAO.xoaHD(hoaDon.getMaHD());
					hd_DAO.themHD(hoaDon, false);
					for (ChiTietHoaDon c : hoaDon.getDsChiTiet()) {
						hd_DAO.themCTHD(c, soHD);
					}
					JOptionPane.showMessageDialog(null, "Đã lưu hóa đơn");
					parent.thayCenterP(new GD_LapHoaDon(parent));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	private boolean kiemtraSp() {
		for (ChiTietHoaDon c : hoaDon.getDsChiTiet()) {
			if (c.getSanPham().getMaSP().equals(sp.getMaSP()))
				return true;
		}
		return false;
	}

	public void setTextTimKiemSP(String sdt) {
		txtTimKh.setText(sdt);
	}

	public void capNhatHoaDon() {
		tblModel.setRowCount(0);
		ArrayList<ChiTietHoaDon> dsCTHD = hoaDon.getDsChiTiet();
		int i = 1;
		for (ChiTietHoaDon c : dsCTHD) {
			String r = i + "," + c.getSanPham().getTenSP() + "," + decimalFormat.format(c.getGiaBan()) + "," + c.getSoLuong() + ","
					+ c.getSanPham().getVAT() + "," + decimalFormat.format(c.thanhTien());
			tblModel.addRow(r.split(","));
			i++;
		}
		lblTongTien.setText("Tổng: " + decimalFormat.format(hoaDon.tongTien()));
		lblTongVAT.setText("Tổng VAT: " + decimalFormat.format(hoaDon.tongVAT()));
		lblTienCanTra.setText("Tổng tiền (gồm VAT): " + decimalFormat.format(hoaDon.tongTienSauVAT()));
	}

	public void capNhatSanPham(ArrayList<SanPham> dssp) {

		sanPhamP.removeAll();
		sanPhamP.revalidate();
		sanPhamP.repaint();
		scrLP.removeAll();
		scrLP.revalidate();
		scrLP.repaint();
		clP1.removeAll();
		clP1.revalidate();
		clP1.repaint();

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input3 = classLoader.getResourceAsStream("plus.png");
		
		BufferedImage image3 = null;
		
		try {
		    image3 = ImageIO.read(input3);

		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		int r = dssp.size();
		sanPhamP.setLayout(new GridLayout(r, 1));
		btn = new JButton[dssp.size()];
		for (int i = 0; i < dssp.size(); i++) {
			btn[i] = new JButton(new ImageIcon(image3));
			btn[i].addActionListener(this);
			JPanel p = new JPanel();
			createSanPham(p, dssp.get(i), btn[i]);
			sanPhamP.add(p);
		}
		scrLP = new JScrollPane(sanPhamP);
		clP1.add(scrLP, BorderLayout.CENTER);
	}

	private void createSanPham(JPanel p, SanPham sanPham, JButton jButton) {
		Font font2 = new Font("Serif", Font.ITALIC, 17);
		p.setLayout(new GridBagLayout());
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc = new GridBagConstraints();
		lblImg = new JLabel();
		lblImg.setIcon(loadImg(".\\img\\" + sanPham.getHinhAnh(), 150, 150));
		JPanel imgP = new JPanel();
		imgP.setPreferredSize(new Dimension(150, 150));
		imgP.add(lblImg);
		lblTenSp = new JLabel();
		lblNCC = new JLabel();
		lblDonGia = new JLabel();
		lblDonVi = new JLabel();
		lblSoLuong = new JLabel();
		lblTenSp.setFont(font2);
		lblNCC.setFont(font2);
		lblDonGia.setFont(font2);
		lblDonVi.setFont(font2);
		lblSoLuong.setFont(font2);
		lblTenSp.setText("Tên sản phẩm: " + sanPham.getTenSP());
		lblNCC.setText("Nhà cung cấp: " + sanPham.getNhaCC().getTenNCC());
		lblDonGia.setText("Đơn giá: " + sanPham.getDonGia());
		lblDonVi.setText("Đơn vị tính: " + sanPham.getDonVi());
		lblSoLuong.setText("Số lượng: " + sanPham.getSoLuong());

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
		p.add(imgP, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		p.add(clb2Center, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 4;
		gbc.gridy = 0;
		p.add(jButton, gbc);
	}

	public void clearSanPham() {
		txtTimSp.selectAll();
		;
		txtTimSp.setRequestFocusEnabled(true);
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

	public boolean isInt(String s) {
		try {
			Integer.parseInt(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public boolean isDbl(String s) {
		try {
			Double.parseDouble(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void EnabledBtn(boolean b) {
		btnThanhToan.setEnabled(b);
		btnLuu.setEnabled(b);
	}

	public void loadTTHD() {
		ngayHienTai = hoaDon.getNgayLapHD();
		soHD = hoaDon.getMaHD();
		caLap = hoaDon.getCaLapHD();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == tblCTHD) {
			JTable table = (JTable) e.getSource();
			Point point = e.getPoint();
			int row = table.rowAtPoint(point);
			if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
				// your valueChanged overridden method
				int r = tblCTHD.getSelectedRow();
				if (r != -1) {
					String soLuong = JOptionPane.showInputDialog("Nhập số lượng");
					int sl;
					sp = sp_DAO.timKiemSPTheoMa((String) tblCTHD.getValueAt(r, 1)).get(0);
					if (isInt(soLuong)) {
						sl = Integer.parseInt(soLuong);
						if (sl <= 0)
							JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0");
						else if (sl > sp.getSoLuong())
							JOptionPane.showMessageDialog(null, "Số lượng sản phẩm hiện không đủ");
						else {
							hoaDon.getDsChiTiet().get(r).setSoLuong(sl);
							capNhatHoaDon();
							EnabledBtn(true);
						}
					} else {
						JOptionPane.showMessageDialog(this, "Số lượng phải là số");
					}
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
