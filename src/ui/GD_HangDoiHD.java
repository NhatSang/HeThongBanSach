package ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GD_HangDoiHD extends JPanel{
	private GD_NhanVienBanHang parent;
	private JTable tblHD;
	private DefaultTableModel tblModelHD;
	private JButton btnThanhToan, btnXoa, btnTim;
	private JTextField txtTim;
	
	
	public GD_HangDoiHD(GD_NhanVienBanHang parent) {
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
		
		this.add(northB,BorderLayout.NORTH);
		
		
		String[] header = "STT,Mã Hóa Đơn,Khách Hàng,Nhân Viên,Ca Lập, Ngày lập".split(",");
		tblModelHD = new DefaultTableModel(header, 0);
		tblHD = new JTable(tblModelHD);
		JScrollPane scrp = new JScrollPane(tblHD);
		
		this.add(scrp,BorderLayout.CENTER);
		
		JPanel southP = new JPanel();
		btnThanhToan = new JButton("Thanh toán");
		btnXoa = new JButton("Xóa");
		btnThanhToan.setFont(new Font("Serif", Font.PLAIN, 18));
		btnXoa.setFont(new Font("Serif", Font.PLAIN, 18));
		southP.add(btnThanhToan);
		southP.add(Box.createHorizontalStrut(20));
		southP.add(btnXoa);
		
		this.add(southP,BorderLayout.SOUTH);
	}
}
