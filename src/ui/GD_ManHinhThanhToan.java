package ui;

import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GD_ManHinhThanhToan extends JFrame{
	private JLabel lblma,lbltma,lblngaylap,
	lbltngaylap,lblcalap,lbltcalap,lblnhanvien,
	lbltnhanvien,lblkhachhang,lbltkhachhang
	,lbltongtien,lblttongtien,lblvat,lbltvat,lbltientra,
	lblttientra,lblthanhtoan,lbltthanhtoan,lbltienthua,
	lblttienthua,lblsdt,lbltsdt;
	private DefaultTableModel tableModel;
	private JTable table; 
	private JButton btnxacnhan,btnxuathd;
	public GD_ManHinhThanhToan() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\icon\\logobook.png"));
		setTitle("Hệ thống quản lý hiệu sách Chí Tâm");
		setSize(500,800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		createGui();
	}
	public void createGui() {
		Container con = getContentPane();
		Box btGD = Box.createVerticalBox();
		lblma = new JLabel("Mã:");
		lbltma = new JLabel();
		lblngaylap = new JLabel("Ngày Lập:");
		lbltngaylap = new JLabel();
		lblcalap = new JLabel("Ca lập");
		lbltcalap = new JLabel();
		lblnhanvien = new JLabel("Nhân viên:");
		lbltnhanvien = new JLabel();
		lblkhachhang = new JLabel("Khách hàng:");
		lbltkhachhang = new JLabel();
		lblsdt = new JLabel("SĐT");
		lbltsdt = new JLabel();
		
		String[] header = "STT;Sản phẩm;Số lượng;Đơn giá".split(";");
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		JScrollPane DSNV = new JScrollPane(table);
		lbltongtien = new JLabel("Tổng tiền");
		lblttongtien = new JLabel();
		lblvat = new JLabel("VAT");
		lbltvat = new JLabel();
		lbltientra = new JLabel("Khách cần trả");
		lblttientra = new JLabel();
		lblthanhtoan = new JLabel("Khách thanh toán");
		lbltthanhtoan = new JLabel();
		lbltienthua = new JLabel("Tiền thừa");
		lblttienthua = new JLabel();
		
		btnxacnhan = new JButton("Xác nhận");
		btnxuathd = new JButton("Xuất hóa đơn");
		
		
		Box bma = Box.createHorizontalBox();
		bma.add(lblma);
		bma.add(lbltma);
		Box bngaylap = Box.createHorizontalBox();
		bngaylap.add(lblngaylap);
		bngaylap.add(lbltngaylap);
		
		btGD.add(bma);
		btGD.add(bngaylap);
		con.add(btGD);
		
	}
	public static void main(String[] args) {
		new GD_ManHinhThanhToan().setVisible(true);
	}

}
