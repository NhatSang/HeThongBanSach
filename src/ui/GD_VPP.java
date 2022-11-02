
package ui;

import java.awt.Font;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import dao.SanPham_DAO;
import entity.LoaiSanPham;
import entity.MauSac;
import entity.NhaCungCap;
import entity.Sach;
import entity.ThuongHieu;
import entity.VanPhongPham;

/**
 *
 * @author Admin
 */
public class GD_VPP extends javax.swing.JPanel {

	/**
	 * Creates new form VPP
	 */
	public GD_VPP() {
		initComponents();
		loadVPP();
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		txtTimKiem = new javax.swing.JTextField();
		btnTimKiem = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		tableVPP = new javax.swing.JTable();
		jPanel2 = new javax.swing.JPanel();
		lbMa = new javax.swing.JLabel();
		txtMa = new javax.swing.JTextField();
		lbTen = new javax.swing.JLabel();
		txtTen = new javax.swing.JTextField();
		lbLoai = new javax.swing.JLabel();
		cbLoai = new javax.swing.JComboBox<>();
		lbSoLuong = new javax.swing.JLabel();
		txtSoLuong = new javax.swing.JTextField();
		lbDonGia = new javax.swing.JLabel();
		txtDonGia = new javax.swing.JTextField();
		lbNCC = new javax.swing.JLabel();
		lbMoTa = new javax.swing.JLabel();
		txtMoTa = new javax.swing.JTextField();
		lbThuongHieu = new javax.swing.JLabel();
		lbMauSac = new javax.swing.JLabel();
		cbMauSac = new javax.swing.JComboBox<>();
		lbChatLieu = new javax.swing.JLabel();
		txtChatLieu = new javax.swing.JTextField();
		lbXuatXu = new javax.swing.JLabel();
		txtHinhAnh = new javax.swing.JTextField();
		lbDonVi = new javax.swing.JLabel();
		lbVAT = new javax.swing.JLabel();
		txtVAT = new javax.swing.JTextField();
		btnThem = new javax.swing.JButton();
		btnXoa = new javax.swing.JButton();
		cbThuongHieu = new javax.swing.JComboBox<>();
		cbDonViVPP = new javax.swing.JComboBox<>();
		cbNCC = new javax.swing.JComboBox<>();
		btnSua = new javax.swing.JButton();
		lbHinhAnh = new javax.swing.JLabel();
		txtXuatXu = new javax.swing.JTextField();
		lbMes = new javax.swing.JLabel();
		btnChonFile = new javax.swing.JButton();

		modelCboLoai = new DefaultComboBoxModel<LoaiSanPham>();
		modelCboMauSac = new DefaultComboBoxModel<MauSac>();
		modelCboThuongHieu = new DefaultComboBoxModel<ThuongHieu>();
		modelCboNCC = new DefaultComboBoxModel<NhaCungCap>();

		cbLoai.setEditable(true);
		cbNCC.setEditable(true);
		cbDonViVPP.setEditable(true);
		cbThuongHieu.setEditable(true);
		cbMauSac.setEditable(true);

		setPreferredSize(new java.awt.Dimension(1899, 1087));

		lbMes.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		lbMes.setForeground(new java.awt.Color(225, 0, 0));

		jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		jPanel1.setPreferredSize(new java.awt.Dimension(1284, 1027));

		btnTimKiem.setText("Tìm kiếm");
//		btnTimKiem.setFont(new java.awt.Font("Serif",Font.PLAIN , 18));
		btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTimKiemActionPerformed(evt);
			}
		});

		modelVPP = new DefaultTableModel(new Object[][] {

		}, new String[] { "STT", "Mã", "Tên", "Loại", "Số lượng", "Đơn giá", "Đơn vị ", "VAT", "Nhà cung cấp", "Mô tả",
				"Thương hiệu", "Màu sắc", "Chất liệu", "Xuất xứ", "Hình ảnh" });
		tableVPP.setModel(modelVPP);
		tableVPP.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableVPPMouseClicked(evt);
			}
		});

		jScrollPane1.setViewportView(tableVPP);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addComponent(txtTimKiem).addGap(18, 18, 18)
								.addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(148, 148, 148))
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
								.addContainerGap()))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(32, 32, 32)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18).addComponent(jScrollPane1).addContainerGap()));

		jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		jPanel2.setPreferredSize(new java.awt.Dimension(560, 944));

		lbMa.setText("Mã:");

		txtMa.setBackground(new java.awt.Color(204, 204, 204));

		lbTen.setText("Tên:");

		lbLoai.setText("Loại");

		//
		cbLoai.setModel(modelCboLoai);
		cbLoai.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbLoaiActionPerformed(evt);
			}
		});

		lbSoLuong.setText("Số lượng:");

		lbDonGia.setText("Đơn giá:");

		lbNCC.setText("Nhà cung cấp:");

		lbMoTa.setText("Mô tả:");

		lbThuongHieu.setText("Thương hiệu:");

		lbMauSac.setText("Màu sắc:");

		//
		cbMauSac.setModel(modelCboMauSac);
		cbMauSac.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbMauSacActionPerformed(evt);
			}
		});
		lbChatLieu.setText("Chất liệu:");

		lbXuatXu.setText("Xuất xứ:");

		lbDonVi.setText("Đơn vị:");

		lbVAT.setText("VAT:");

		btnThem.setText("THÊM");
//		btnThem.setFont(new java.awt.Font("Serif",Font.PLAIN , 18));
		btnThem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemActionPerformed(evt);
			}
		});

		btnXoa.setText("XÓA");
//		btnXoa.setFont(new java.awt.Font("Serif",Font.PLAIN , 18));
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaActionPerformed(evt);
			}
		});
		//
		cbThuongHieu.setModel(modelCboThuongHieu);
		cbThuongHieu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbThuongHieuActionPerformed(evt);
			}
		});

		//
		cbDonViVPP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Quyển", "Lóc", "Cây", "Vỉ", "Hộp", "Bộ", "Tờ", "Xấp", "Cục", "Cái"}));
		cbDonViVPP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbDonViActionPerformed(evt);
			}
		});

		//
		cbNCC.setModel(modelCboNCC);
		cbNCC.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbNCCActionPerformed(evt);
			}
		});

		btnSua.setText("SỬA");
//		btnSua.setFont(new java.awt.Font("Serif",Font.PLAIN , 18));
		btnSua.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSuaActionPerformed(evt);
			}
		});

		lbHinhAnh.setText("Hình ảnh:");

		btnChonFile.setText("Chọn File ");
		btnChonFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChonFileActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(lbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 453,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										jPanel2Layout.createSequentialGroup().addGap(14, 14, 14).addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lbSoLuong).addComponent(lbDonGia)
														.addComponent(lbMoTa).addComponent(lbThuongHieu)
														.addComponent(lbNCC)).addGap(46, 46, 46)
														.addGroup(jPanel2Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING)
																.addComponent(cbLoai,
																		javax.swing.GroupLayout.Alignment.LEADING, 0,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(txtTen,
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
																		jPanel2Layout.createSequentialGroup().addGroup(
																				jPanel2Layout.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(txtSoLuong,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								131, Short.MAX_VALUE)
																						.addComponent(txtDonGia))
																				.addGap(33, 33, 33)
																				.addGroup(jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(lbDonVi)
																						.addComponent(lbVAT))
																				.addGap(18, 18, 18)
																				.addGroup(jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(cbDonViVPP, 0, 139,
																								Short.MAX_VALUE)
																						.addComponent(txtVAT)))
																.addComponent(txtMa,
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(txtMoTa)
																.addComponent(cbNCC, 0,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(cbThuongHieu, 0,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))
												.addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lbMauSac).addComponent(lbMa).addComponent(lbTen)
														.addComponent(lbLoai).addComponent(lbChatLieu)
														.addComponent(lbHinhAnh)).addGap(69, 69, 69)
														.addGroup(jPanel2Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(cbMauSac, 0,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addGroup(jPanel2Layout.createSequentialGroup()
																		.addComponent(txtChatLieu,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				141,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(33, 33, 33).addComponent(lbXuatXu)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(txtXuatXu))
																.addGroup(jPanel2Layout.createSequentialGroup()
																		.addComponent(txtHinhAnh)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(btnChonFile))))))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										jPanel2Layout.createSequentialGroup().addContainerGap()
												.addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(66, 66, 66)
												.addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(63, 63, 63).addComponent(btnSua,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(16, 16, 16)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbMa).addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(20, 20, 20)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbTen).addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(20, 20, 20)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbLoai).addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(20, 20, 20)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbSoLuong)
								.addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbDonVi).addComponent(cbDonViVPP, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(20, 20, 20)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbDonGia)
								.addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbVAT).addComponent(txtVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(20, 20, 20)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbNCC).addComponent(cbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(20, 20, 20)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbMoTa).addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(20, 20, 20)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbThuongHieu).addComponent(cbThuongHieu,
										javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(20, 20, 20)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbMauSac))
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(20, 20, 20)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lbXuatXu)))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
										.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(txtChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lbChatLieu))))
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbHinhAnh).addComponent(btnChonFile,
										javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(lbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(26, 26, 26)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
						.addGap(18, 18, 18).addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 503,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(16, 16, 16)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(21, 21, 21)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}// </editor-fold>

	private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		timKiemVPP();
	}

	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		themVPP();
	}

	private void cbNCCActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		xoaVPP();
	}

	private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		suaVPP();
	}

	private void cbLoaiActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void tableVPPMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int row = tableVPP.getSelectedRow();
		loadTbltoForm(row);
	}

	private void cbDonViActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void cbThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void cbMauSacActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void btnChonFileActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		JFileChooser file = new JFileChooser();
		FileNameExtensionFilter img = new FileNameExtensionFilter("hinh anh", "jpg", "png");
		file.setFileFilter(img);

		file.setMultiSelectionEnabled(false);
		int x = file.showDialog(this, "Chọn file");
		if (x == JFileChooser.APPROVE_OPTION) {
			File f = file.getSelectedFile();
			String filename = f.getAbsolutePath();
			// lbMes.setIcon(new ImageIcon(f.getAbsolutePath()));
			// lbMes.setText(filename);
			txtHinhAnh.setText(filename);
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JButton btnChonFile;
	private javax.swing.JButton btnSua;
	private javax.swing.JButton btnThem;
	private javax.swing.JButton btnTimKiem;
	private javax.swing.JButton btnXoa;
	private javax.swing.JComboBox<String> cbDonViVPP;
	private javax.swing.JComboBox<LoaiSanPham> cbLoai;
	private DefaultComboBoxModel<LoaiSanPham> modelCboLoai;
	private javax.swing.JComboBox<MauSac> cbMauSac;
	private DefaultComboBoxModel<MauSac> modelCboMauSac;
	private javax.swing.JComboBox<NhaCungCap> cbNCC;
	private DefaultComboBoxModel<NhaCungCap> modelCboNCC;
	private javax.swing.JComboBox<ThuongHieu> cbThuongHieu;
	private DefaultComboBoxModel<ThuongHieu> modelCboThuongHieu;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lbChatLieu;
	private javax.swing.JLabel lbDonGia;
	private javax.swing.JLabel lbDonVi;
	private javax.swing.JLabel lbHinhAnh;
	private javax.swing.JLabel lbLoai;
	private javax.swing.JLabel lbMa;
	private javax.swing.JLabel lbMauSac;
	private javax.swing.JLabel lbMes;
	private javax.swing.JLabel lbMoTa;
	private javax.swing.JLabel lbNCC;
	private javax.swing.JLabel lbSoLuong;
	private javax.swing.JLabel lbTen;
	private javax.swing.JLabel lbThuongHieu;
	private javax.swing.JLabel lbVAT;
	private javax.swing.JLabel lbXuatXu;
	private javax.swing.JTable tableVPP;
	private javax.swing.JTextField txtChatLieu;
	private javax.swing.JTextField txtDonGia;
	private javax.swing.JTextField txtHinhAnh;
	private javax.swing.JTextField txtMa;
	private javax.swing.JTextField txtMoTa;
	private javax.swing.JTextField txtSoLuong;
	private javax.swing.JTextField txtTen;
	private javax.swing.JTextField txtTimKiem;
	private javax.swing.JTextField txtVAT;
	private javax.swing.JTextField txtXuatXu;
	// End of variables declaration
	private DefaultTableModel modelVPP;
	private SanPham_DAO sp_dao = new SanPham_DAO();
	private int stt = 0;
	private int check = 0;
	private ArrayList<VanPhongPham> dsvpp = new ArrayList<VanPhongPham>();

	public void loadVPP() {
//		while (tableVPP.getRowCount() != 0) {
//			modelVPP.removeRow(0);
//		}
		modelVPP.setRowCount(0);

		dsvpp = sp_dao.getAllVPP1();
		for (VanPhongPham vpp : dsvpp) {
			Object row[] = { tableVPP.getRowCount(), vpp.getMaSP(), vpp.getTenSP(), vpp.getLoaiSP(), vpp.getSoLuong(),
					vpp.getDonGia(), vpp.getDonVi(), vpp.getVAT(), vpp.getNhaCC(), vpp.getMoTa(), vpp.getThuongHieu(),
					vpp.getMauSac(), vpp.getChatLieu(), vpp.getXuatXu(), vpp.getHinhAnh() };
			modelVPP.addRow(row);
		}

		loadData();
	}

	private void loadVPP(ArrayList<VanPhongPham> dsVPP) {
		modelVPP.setRowCount(0);
		for (VanPhongPham vpp : dsVPP) {
			Object row[] = { tableVPP.getRowCount(), vpp.getMaSP(), vpp.getTenSP(), vpp.getLoaiSP(), vpp.getSoLuong(),
					vpp.getDonGia(), vpp.getDonVi(), vpp.getVAT(), vpp.getNhaCC(), vpp.getMoTa(), vpp.getThuongHieu(),
					vpp.getMauSac(), vpp.getChatLieu(), vpp.getXuatXu(), vpp.getHinhAnh() };
			modelVPP.addRow(row);
		}

		loadData();
	}

	public void loadData() {
		modelCboLoai.removeAllElements();
		modelCboNCC.removeAllElements();
		modelCboMauSac.removeAllElements();
		modelCboThuongHieu.removeAllElements();

		modelCboLoai.addAll(sp_dao.getLoaiVPP());
		modelCboMauSac.addAll(sp_dao.getMauSac());
		modelCboNCC.addAll(sp_dao.getNCC());
		modelCboThuongHieu.addAll(sp_dao.getTH());

	}

	public void loadTbltoForm(int row) {
		System.out.println(row);
		VanPhongPham vpp = dsvpp.get(row);
		txtMa.setText(vpp.getMaSP());
		txtTen.setText(vpp.getTenSP());
		txtSoLuong.setText(vpp.getSoLuong() + "");
		txtDonGia.setText(vpp.getDonGia() + "");
		txtVAT.setText(vpp.getVAT() + "");
		txtMoTa.setText(vpp.getMoTa());
		txtChatLieu.setText(vpp.getChatLieu());
		txtXuatXu.setText(vpp.getXuatXu());
		txtHinhAnh.setText(vpp.getHinhAnh());

		cbLoai.setSelectedItem(vpp.getLoaiSP());
		cbNCC.setSelectedItem(vpp.getNhaCC());
		cbMauSac.setSelectedItem(vpp.getMauSac());
		cbThuongHieu.setSelectedItem(vpp.getThuongHieu());
		cbDonViVPP.setSelectedItem(vpp.getDonVi());
		setEditableForm(true);

	}

	public void setEditableForm(boolean st) {
		txtMa.setEditable(false);
		txtTen.setEditable(st);
		txtSoLuong.setEditable(st);
		txtDonGia.setEditable(st);
		txtVAT.setEditable(st);
		txtMoTa.setEditable(st);
		txtChatLieu.setEditable(st);
		txtXuatXu.setEditable(st);
	}

	public void xoaVPP() {
		if (btnXoa.getText().equals("Huỷ") && check == 1) {
			xoaTrang();
			setEditableForm(false);
			lbMes.setText("");
			btnXoa.setText("Xóa");
			btnSua.setEnabled(true);
			check = 0;
		} else if (btnXoa.getText().equals("Huỷ") && check == 2) {
			xoaTrang();
			setEditableForm(false);
			lbMes.setText("");
			btnXoa.setText("Xóa");
			btnThem.setEnabled(true);
			check = 0;
		} else {
			int row = tableVPP.getSelectedRowCount();
//		row = tableVPP.getSelectedRow();
			if (JOptionPane.showConfirmDialog(null, "Xác nhận xóa") == JOptionPane.YES_OPTION) {
				try {
					sp_dao.xoa_SP(txtMa.getText());
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Xóa thành công");
				loadVPP();
			}
		}
	}

	public void xoaTrang() {
		txtMa.setText("");
		txtTen.setText("");
		txtSoLuong.setText("");
		txtDonGia.setText("");
		txtVAT.setText("");
		txtMoTa.setText("");
		txtChatLieu.setText("");
		txtXuatXu.setText("");
		txtHinhAnh.setText("");

		cbLoai.setSelectedItem(null);
		cbNCC.setSelectedItem(null);
		cbMauSac.setSelectedItem(null);
		cbThuongHieu.setSelectedItem(null);
		cbDonViVPP.setSelectedItem(null);
	}

	public void themVPP() {
		if (check != 1) {
			btnXoa.setText("Huỷ");
			btnSua.setEnabled(false);
			txtMa.setEditable(false);
			xoaTrang();
			check = 1;
		} else {
			checkThongTin();
			if (checkThongTin()) {
				SanPham_DAO sanPham_DAO = new SanPham_DAO();
				String tenVPP = txtTen.getText();
				int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
				Double donGia = Double.parseDouble(txtDonGia.getText().trim());
				int vat = Integer.parseInt(txtVAT.getText().trim());
				String moTa = txtMoTa.getText();
				String chatLieu = txtChatLieu.getText();
				String xuatXu = txtXuatXu.getText();
				String hinhAnh = txtHinhAnh.getText();

//				LoaiSanPham loaiVPP = (LoaiSanPham) cbLoai.getSelectedItem();
				LoaiSanPham loaiVPP = null;
				if (cbLoai.getSelectedItem() instanceof LoaiSanPham) {
					loaiVPP = (LoaiSanPham) cbLoai.getSelectedItem();

				} else {
					String newVPP = ((JTextComponent) cbLoai.getEditor().getEditorComponent()).getText();

					loaiVPP = sanPham_DAO.timLoaiSP(newVPP);
					if (loaiVPP == null)
						try {
							sanPham_DAO.themLoaiSP(new LoaiSanPham(null, newVPP));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					loaiVPP = sanPham_DAO.timLoaiSP(newVPP);
				}
				NhaCungCap ncc = (NhaCungCap) cbNCC.getSelectedItem();
//		MauSac mauSac = (MauSac) cbMauSac.getSelectedItem();
				ThuongHieu thuongHieu = null;
				if (cbThuongHieu.getSelectedItem() instanceof ThuongHieu) {
					thuongHieu = (ThuongHieu) cbThuongHieu.getSelectedItem();

				} else {
					String newTH = ((JTextComponent) cbThuongHieu.getEditor().getEditorComponent()).getText();

					thuongHieu = sanPham_DAO.timThuongHieu(newTH);
					if (thuongHieu == null)
						try {
							sanPham_DAO.themThuongHieu(new ThuongHieu(null, newTH));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					thuongHieu = sanPham_DAO.timThuongHieu(newTH);
				}
				MauSac mauSac = null;
				if (cbMauSac.getSelectedItem() instanceof MauSac) {
					mauSac = (MauSac) cbMauSac.getSelectedItem();

				} else {
					String newMS = ((JTextComponent) cbMauSac.getEditor().getEditorComponent()).getText();

					mauSac = sanPham_DAO.timMauSac(newMS);
					if (mauSac == null)
						try {
							sanPham_DAO.themMauSac(new MauSac(null, newMS));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					mauSac = sanPham_DAO.timMauSac(newMS);
				}
				String donvi = (String) cbDonViVPP.getSelectedItem();

				VanPhongPham vpp = new VanPhongPham(donvi, tenVPP, donvi, moTa, hinhAnh, soLuong, vat, donGia, loaiVPP,
						ncc, xuatXu, chatLieu, thuongHieu, mauSac);
				if (sanPham_DAO.timKiemSPTheoMa(vpp.getTenSP()) == null) {
					try {
						sanPham_DAO.themVPP(vpp);
						JOptionPane.showMessageDialog(null, "Thêm thành công");
						loadVPP();
						lbMes.setText("");
						stt = 0;
					} catch (Exception e) {
						// TODO: handle exception
//				e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "sản phẩm đã tồn tại");
				}
			}
		}
	}

	public void suaVPP() {
		lbMes.setText("");
		if (check != 2) {
			setEditableForm(true);
			btnXoa.setText("Huỷ");
			btnThem.setEnabled(false);
			check = 2;
			System.out.println(check);
		} else {
			SanPham_DAO sanPham_DAO = new SanPham_DAO();
			String maVPP = txtMa.getText();
			String tenVPP = txtTen.getText();
			int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
			Double donGia = Double.parseDouble(txtDonGia.getText().trim());
			int vat = Integer.parseInt(txtVAT.getText().trim());
			String moTa = txtMoTa.getText();
			String chatLieu = txtChatLieu.getText();
			String xuatXu = txtXuatXu.getText();
			String hinhAnh = txtHinhAnh.getText();

//			LoaiSanPham loaiVPP = (LoaiSanPham) cbLoai.getSelectedItem();
			LoaiSanPham loaiVPP = null;
			if (cbLoai.getSelectedItem() instanceof LoaiSanPham) {
				loaiVPP = (LoaiSanPham) cbLoai.getSelectedItem();

			} else {
				String newVPP = ((JTextComponent) cbLoai.getEditor().getEditorComponent()).getText();

				loaiVPP = sanPham_DAO.timLoaiSP(newVPP);
				if (loaiVPP == null)
					try {
						sanPham_DAO.themLoaiSP(new LoaiSanPham(null, newVPP));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				loaiVPP = sanPham_DAO.timLoaiSP(newVPP);
			}
			NhaCungCap ncc = (NhaCungCap) cbNCC.getSelectedItem();
//		MauSac mauSac = (MauSac) cbMauSac.getSelectedItem();
			ThuongHieu thuongHieu = null;
			if (cbThuongHieu.getSelectedItem() instanceof ThuongHieu) {
				thuongHieu = (ThuongHieu) cbThuongHieu.getSelectedItem();
			} else {
				String newTH = ((JTextComponent) cbThuongHieu.getEditor().getEditorComponent()).getText();
				thuongHieu = sanPham_DAO.timThuongHieu(newTH);
				if (thuongHieu == null)
					try {
						sanPham_DAO.themThuongHieu(new ThuongHieu(null, newTH));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				thuongHieu = sanPham_DAO.timThuongHieu(newTH);
			}
			MauSac mauSac = null;
			if (cbMauSac.getSelectedItem() instanceof MauSac) {
				mauSac = (MauSac) cbMauSac.getSelectedItem();
			} else {
				String newMS = ((JTextComponent) cbMauSac.getEditor().getEditorComponent()).getText();
				mauSac = sanPham_DAO.timMauSac(newMS);
				if (mauSac == null)
					try {
						sanPham_DAO.themMauSac(new MauSac(null, newMS));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				mauSac = sanPham_DAO.timMauSac(newMS);
			}
			String donvi = (String) cbDonViVPP.getSelectedItem();

			VanPhongPham vpp = new VanPhongPham(maVPP, tenVPP, donvi, moTa, hinhAnh, soLuong, vat, donGia, loaiVPP, ncc,
					xuatXu, chatLieu, thuongHieu, mauSac);
			try {
				sanPham_DAO.suaVPP(vpp);
				JOptionPane.showMessageDialog(null, "Sửa thành công");
				lbMes.setText("");
				loadVPP();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	private void timKiemVPP() {
		// TODO Auto-generated method stu
		String txt = txtTimKiem.getText();
		SanPham_DAO sp_dao = new SanPham_DAO();
//		if (txt.equals("")) {
//			JOptionPane.showMessageDialog(null, "Nhập thông tin cần tìm kiếm");
//		} else {
			ArrayList<VanPhongPham> dsVPP = sp_dao.timKiemVPP(txt);
			loadVPP(dsVPP);
//		}
	}

	public boolean checkThongTin() {
		String tenVPP = txtTen.getText();
		String soLuong = txtSoLuong.getText();
		String donGia = txtDonGia.getText();
		String vat = txtVAT.getText();
		String moTa = txtMoTa.getText();
		String chatLieu = txtChatLieu.getText();
		String xuatXu = txtXuatXu.getText();
		String hinhAnh = txtHinhAnh.getText();

		if (tenVPP.equals("")) {
			lbMes.setText("Nhập tên văn phòng phẩm");
			return false;
		}
		if (cbLoai.getSelectedItem() == null) {
			lbMes.setText("Chọn loại sản phẩm");
			return false;
		}
		try {
			Integer.parseInt(soLuong);
		} catch (Exception e) {
			// TODO: handle exception
			lbMes.setText("Số lượng không được để trống và phải viết dưới dạng số");
			txtSoLuong.requestFocus();
			return false;
		}
		if (Integer.parseInt(soLuong) <= 0) {
			lbMes.setText("Số lượng phải lớn hơn 0");
			txtSoLuong.requestFocus();
			return false;
		}
		if (cbDonViVPP.getSelectedItem() == null) {
			lbMes.setText("Chọn đơn vị");
			return false;
		}
		try {
			Double.parseDouble(donGia);
		} catch (Exception e) {
			// TODO: handle exception
			lbMes.setText("Đơn giá không được để trống và phải viết dưới dạng số");
			txtDonGia.requestFocus();
			return false;
		}
		if (Double.parseDouble(donGia) <= 0) {
			lbMes.setText("Đơn giá phải lớn hơn 0");
			txtDonGia.requestFocus();
			return false;
		}
		try {
			Integer.parseInt(vat);
		} catch (Exception e) {
			// TODO: handle exception
			lbMes.setText("VAT không được để trống và phải viết dưới dạng số");
			txtVAT.requestFocus();
			return false;
		}
		if (Integer.parseInt(vat) <= 0) {
			lbMes.setText("VAT phải lớn hơn 0");
			txtVAT.requestFocus();
			return false;
		}
		if (cbNCC.getSelectedItem() == null) {
			lbMes.setText("Chọn nhà cung cấp");
			return false;
		}
		if (moTa.equals("")) {
			lbMes.setText("Nhập mô tả");
			return false;
		}
		if (cbThuongHieu.getSelectedItem() == null) {
			lbMes.setText("Chọn thương hiệu");
			return false;
		}
		if (cbMauSac.getSelectedItem() == null) {
			lbMes.setText("Chọn màu sắc");
			return false;
		}
		if (chatLieu.equals("")) {
			lbMes.setText("Nhập chất liệu");
			return false;
		}
		if (xuatXu.equals("")) {
			lbMes.setText("Nhập xuất xứ");
			return false;
		}
		if (hinhAnh.equals("")) {
			lbMes.setText("Nhập hình ảnh");
			return false;
		}
		return true;
	}

	public void reload() {
		btnThem.setText("Thêm");
		btnXoa.setText("Xoá");
		btnSua.setText("Sửa");
		btnThem.setEnabled(true);
		btnXoa.setEnabled(true);
		btnSua.setEnabled(true);
		check = 0;
	}

}
