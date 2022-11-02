package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.HoaDon_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;

public class GD_HangDoiHD extends JPanel implements ActionListener {
	private GD_NhanVienBanHang parent;
	private JTable tblHD;
	private DefaultTableModel tblModelHD;
	private JButton btnThanhToan, btnXoa, btnTim;
	private JTextField txtTim;
	private HoaDon_DAO hd_DAO;

	public GD_HangDoiHD(GD_NhanVienBanHang parent) {
		this.parent = parent;
		hd_DAO = new HoaDon_DAO();
		createGui();

	}

	private void createGui() {
		this.setLayout(new BorderLayout());

		Box northB = Box.createVerticalBox();
		Box nb1 = Box.createHorizontalBox();
		txtTim = new JTextField();
		btnTim = new JButton("Tìm kiếm");
		btnTim.setFont(new Font("Serif", Font.PLAIN, 18));

		nb1.add(Box.createHorizontalStrut(100));
		nb1.add(txtTim);
		nb1.add(Box.createHorizontalStrut(20));
		nb1.add(btnTim);
		nb1.add(Box.createHorizontalStrut(100));

		northB.add(Box.createVerticalStrut(30));
		northB.add(nb1);
		northB.add(Box.createVerticalStrut(30));

		this.add(northB, BorderLayout.NORTH);

		String[] header = "STT,Mã Hóa Đơn,Khách Hàng,Nhân Viên,Ca Lập, Ngày lập".split(",");
		tblModelHD = new DefaultTableModel(header, 0);
		tblHD = new JTable(tblModelHD);
		JScrollPane scrp = new JScrollPane(tblHD);

		this.add(scrp, BorderLayout.CENTER);

		JPanel southP = new JPanel();
		btnThanhToan = new JButton("Thanh toán");
		btnXoa = new JButton("Xóa");
		btnThanhToan.setFont(new Font("Serif", Font.PLAIN, 18));
		btnXoa.setFont(new Font("Serif", Font.PLAIN, 18));
		southP.add(btnThanhToan);
		southP.add(Box.createHorizontalStrut(20));
		southP.add(btnXoa);

		loadData();
		this.add(southP, BorderLayout.SOUTH);

		btnThanhToan.addActionListener(this);
		btnXoa.addActionListener(this);
	}

	private void loadData() {
		tblModelHD.setRowCount(0);
		ArrayList<HoaDon> dsHD = hd_DAO.getDSHD0();
		int i = 1;
		for (HoaDon x : dsHD) {
			String r = i + "," + x.getMaHD() + "," + x.getKhachHang().getHoTen() + "," + x.getNhanVien().getHoTen()
					+ "," + x.getCaLapHD() + "," + x.getNgayLapHD();
			tblModelHD.addRow(r.split(","));
			i++;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnThanhToan) {
			int r = tblHD.getSelectedRow();
			if (r != -1) {
				HoaDon hd = hd_DAO.getDSHD0().get(r);
				for (ChiTietHoaDon c : hd_DAO.getDSCT(hd.getMaHD())) {
					hd.themCTHD(c.getSanPham(), c.getGiaBan(), c.getSoLuong());
				}
				parent.thayCenterP(new GD_LapHoaDon(parent, hd));
			}
		} else if (obj == btnXoa) {
			int r = tblHD.getSelectedRow();
			if (r != -1) {
				int qes = JOptionPane.showConfirmDialog(null,
						"Hóa đơn sẽ không thể khôi phục sau khi xóa! Bạn có chắc xóa không?");
				if (qes == JOptionPane.YES_OPTION) {
					HoaDon hd = hd_DAO.getDSHD0().get(r);
					try {
						hd_DAO.xoaHD(hd.getMaHD());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					loadData();
				}
			}
		}
	}
}
