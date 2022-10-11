package ui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import entity.NhanVien;

//Sang
public class GD_LapHoaDon extends JPanel {
	private NhanVien nhanVien;
	private JLabel lblTenKh, lblSdt, lblEmail, lblDiaChi, lblMaHd, lblNgayLap, lblCaLap, lblTenNv, lblTongTien,
			lblTongVAT, lblTienCanTra, lblTienKhachTra, lblTienThua;
	private JTextField txtTimKh, txtTenKh, txtSdt, txtEmail, txtDiaChi, txtTimSp, txtMaHd, txtNgayLap, txtCaLap,
			txtTenNv, txtTongTien, txtTongVat, txtTienCanTra, txtTienKhachTra, txtTienThua;
	private JButton btnThanhToan, btnTimKh, btnTimSp, btnThemKh, btnThemCTHD;

	public GD_LapHoaDon(NhanVien nhanVien) {
		createGui();
	}

	private void createGui() {
		this.setLayout(new BorderLayout());

		// tạo box thôn tin khách hàng
		Box khBox = Box.createVerticalBox();
		khBox.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));

		Box khb1 = Box.createHorizontalBox();
		Box khb2 = Box.createHorizontalBox();
		Box khb3 = Box.createHorizontalBox();
		Box khb4 = Box.createHorizontalBox();

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
	}
}
