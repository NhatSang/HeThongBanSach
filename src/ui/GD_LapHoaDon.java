package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class GD_LapHoaDon extends JPanel {
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private HoaDon hoaDon;
	private JLabel lblTenKh, lblSdt, lblDiaChi,lblTenKh1,lblSdt1, lblDiaChi1,
	lblImg,lblTenSp,lblNCC,lblDonGia,lblDonVi,lblSoLuong,lblTenSp1,lblNCC1,lblDonGia1,lblDonVi1,lblSoLuong1;
	private JTextField txtTimKh,txtTimSp;
	private JButton btnTimKh, btnThemKh, btnTimSp, btnThemCTHD;
	private Box leftBox,rightBox, northLB, centerLB;
	private JPanel thongTinKhP;
	public GD_LapHoaDon(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
		createGui();
	}


	private void createGui() {
		this.setLayout(new BorderLayout());
		
		Font font1 = new Font("Serif", Font.PLAIN, 18);
		Font font2 = new Font("Serif", Font.ITALIC, 18);
		
		leftBox = Box.createVerticalBox();
		northLB = Box.createVerticalBox();
		northLB.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
		thongTinKhP = new JPanel();
		thongTinKhP.setLayout(new GridLayout(4, 2,20,20));
		
		
		txtTimKh = new JTextField();
		btnTimKh = new JButton(new ImageIcon(".\\icon\\search.png"));
		btnThemKh = new JButton(new ImageIcon(".\\icon\\addkh.png"));
		
		lblTenKh = new JLabel("Họ tên:");
		lblTenKh1 = new JLabel("Nguyễn Nhật Sang");
		lblSdt = new JLabel("Số điện thoại:");
		lblSdt1 = new JLabel();
		lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi1 = new JLabel("adjkfhjkadhfujkhasdkhfgjhjkhadsdfjkhgasdjkifgjhkadsdgfjhk");
		lblTenKh.setFont(font1);
		lblSdt.setFont(font1);
		lblDiaChi.setFont(font1);
		lblTenKh1.setFont(font2);
		lblSdt1.setFont(font2);
		lblDiaChi1.setFont(font2);
		
		thongTinKhP.add(lblTenKh);
		thongTinKhP.add(lblTenKh1);
		thongTinKhP.add(lblSdt);
		thongTinKhP.add(lblSdt1);
		thongTinKhP.add(lblDiaChi);
		thongTinKhP.add(lblDiaChi1);
		
		Box nlb1 = Box.createHorizontalBox();
		nlb1.add(Box.createHorizontalStrut(20));
		nlb1.add(txtTimKh);
		nlb1.add(btnTimKh);
		nlb1.add(Box.createHorizontalStrut(20));
		nlb1.add(btnThemKh);
		nlb1.add(Box.createHorizontalStrut(20));
		
		northLB.add(Box.createVerticalStrut(30));
		northLB.add(nlb1);
		northLB.add(Box.createVerticalStrut(20));
		northLB.add(thongTinKhP);
		
		centerLB = Box.createVerticalBox();
		centerLB.setBorder(BorderFactory.createTitledBorder("Thông tin sản phẩm"));
		txtTimSp = new JTextField();
		btnTimSp = new JButton(new ImageIcon(".\\icon\\search.png"));
		btnThemCTHD = new JButton(new ImageIcon(".\\icon\\plus.png"));
		
		Box clb1 = Box.createHorizontalBox();
		Box clb2 = Box.createHorizontalBox();
		clb2.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel clP1 = new JPanel();
		clP1.setLayout(new GridLayout(5,2,0,20));
		
		
		
		clb1.add(Box.createHorizontalStrut(20));
		clb1.add(txtTimSp);
		clb1.add(btnTimSp);
		clb1.add(Box.createHorizontalStrut(20));
		
		lblImg = new JLabel();
		lblImg.setPreferredSize(new Dimension(150, 150));
		lblTenSp = new JLabel("Tên sản phẩm:");
		lblTenSp1 = new JLabel("nnnnnnnnnnnnnnnnn");
		lblNCC = new JLabel("Nhà cung cấp:");
		lblNCC1 = new JLabel();
		lblDonGia = new JLabel("Đơn giá:");
		lblDonGia1 = new JLabel();
		lblDonVi = new JLabel("Đơn vị tính:");
		lblDonVi1 = new JLabel();
		lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong1 = new JLabel();
		lblTenSp.setFont(font1);
		lblNCC.setFont(font1);
		lblDonGia.setFont(font1);
		lblDonVi.setFont(font1);
		lblSoLuong.setFont(font1);
		lblTenSp1.setFont(font2);
		lblNCC1.setFont(font2);
		lblDonGia1.setFont(font2);
		lblDonVi1.setFont(font2);
		lblSoLuong1.setFont(font2);
		
		clP1.add(lblTenSp);
		clP1.add(lblTenSp1);
		clP1.add(lblNCC);
		clP1.add(lblNCC1);
		clP1.add(lblDonGia);
		clP1.add(lblDonGia1);
		clP1.add(lblDonVi);
		clP1.add(lblDonVi1);
		clP1.add(lblSoLuong);
		clP1.add(lblSoLuong1);
		
		clb2.add(lblImg);
		clb2.add(clP1);
		clb2.add(btnThemCTHD);
		
		centerLB.add(Box.createVerticalStrut(30));
		centerLB.add(clb1);
		centerLB.add(Box.createVerticalStrut(20));
		centerLB.add(clb2);
		centerLB.add(Box.createVerticalStrut(20));
		
		leftBox.add(northLB);
		leftBox.add(centerLB);
		
		rightBox = Box.createVerticalBox();
		rightBox.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
		rightBox.setPreferredSize(new Dimension(500, HEIGHT));
		
		this.add(leftBox,BorderLayout.CENTER);
		this.add(rightBox,BorderLayout.EAST);
		
	}
}
