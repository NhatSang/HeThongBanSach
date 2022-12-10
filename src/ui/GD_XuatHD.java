package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.HoaDon_DAO;
import entity.HoaDon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.text.DecimalFormat;

public class GD_XuatHD extends JFrame implements Printable{

    private JPanel contentPane;
    private DefaultTableModel modelDSSP;
    private JTable tblDSSP;
    private HoaDon hd;
    private HoaDon_DAO hd_DAO;
    private JLabel lblMaHD;
    private JLabel lblNhanVien;
    private JLabel lblTenKH;
    private JLabel lblSDT;
    private JLabel lblDiaChi;
    private JLabel lblNgayLap;
    private JLabel lblTongTien;
    private double tongTien;
    private JButton btnInHoaDon;
    private JPanel pnFoot;

    public GD_XuatHD(HoaDon hoaDon) {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        this.hd_DAO = new HoaDon_DAO();
        this.hd = hoaDon;
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("HÓA ĐƠN");
        lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 25));
        panel.add(lblNewLabel);

        JPanel pnMain = new JPanel();
        contentPane.add(pnMain, BorderLayout.CENTER);
        pnMain.setLayout(new BorderLayout(0, 0));

        JPanel pnMain2 = new JPanel();
        pnMain.add(pnMain2);
        pnMain2.setLayout(new BorderLayout(0, 0));

        JPanel pnThongTinChung = new JPanel();
        pnMain2.add(pnThongTinChung, BorderLayout.NORTH);
        pnThongTinChung.setLayout(new BoxLayout(pnThongTinChung, BoxLayout.Y_AXIS));

        JPanel pbMaHD = new JPanel();
        pbMaHD.setBackground(Color.WHITE);
        FlowLayout fl_pbMaHD = (FlowLayout) pbMaHD.getLayout();
        fl_pbMaHD.setAlignment(FlowLayout.LEFT);
        pnThongTinChung.add(pbMaHD);

        JLabel lbllMaHD = new JLabel("Mã hóa đơn: ");
        lbllMaHD.setFont(new Font("Serif", Font.PLAIN, 15));
        lbllMaHD.setPreferredSize(new Dimension(200, 25));
        pbMaHD.add(lbllMaHD);

        lblMaHD = new JLabel();
        lblMaHD.setFont(new Font("Serif", Font.PLAIN, 15));
        pbMaHD.add(lblMaHD);

        JPanel pnNV = new JPanel();
        pnNV.setBackground(Color.WHITE);
        FlowLayout fl_pnNV = (FlowLayout) pnNV.getLayout();
        fl_pnNV.setAlignment(FlowLayout.LEFT);
        pnThongTinChung.add(pnNV);

        JLabel lblNhnVinBn = new JLabel("Nhân viên bán: ");
        lblNhnVinBn.setPreferredSize(new Dimension(200, 25));
        lblNhnVinBn.setFont(new Font("Serif", Font.PLAIN, 15));
        pnNV.add(lblNhnVinBn);

        lblNhanVien = new JLabel();
        lblNhanVien.setFont(new Font("Serif", Font.PLAIN, 15));
        pnNV.add(lblNhanVien);

        JPanel pnKH = new JPanel();
        pnKH.setBackground(Color.WHITE);
        FlowLayout fl_pnKH = (FlowLayout) pnKH.getLayout();
        fl_pnKH.setAlignment(FlowLayout.LEFT);
        pnThongTinChung.add(pnKH);

        JLabel lblTnKhchHng = new JLabel("Tên khách hàng:");
        lblTnKhchHng.setPreferredSize(new Dimension(200, 25));
        lblTnKhchHng.setFont(new Font("Serif", Font.PLAIN, 15));
        pnKH.add(lblTnKhchHng);

        lblTenKH = new JLabel();
        lblTenKH.setFont(new Font("Serif", Font.PLAIN, 15));
        pnKH.add(lblTenKH);

        JPanel pnSDT = new JPanel();
        pnSDT.setBackground(Color.WHITE);
        FlowLayout fl_pnSDT = (FlowLayout) pnSDT.getLayout();
        fl_pnSDT.setAlignment(FlowLayout.LEFT);
        pnThongTinChung.add(pnSDT);

        JLabel lblSinThoi = new JLabel("Số điện thoại: ");
        lblSinThoi.setPreferredSize(new Dimension(200, 25));
        lblSinThoi.setFont(new Font("Serif", Font.PLAIN, 15));
        pnSDT.add(lblSinThoi);

        lblSDT = new JLabel();
        lblSDT.setFont(new Font("Serif", Font.PLAIN, 15));
        pnSDT.add(lblSDT);

        JPanel pnNgayDat = new JPanel();
        pnNgayDat.setBackground(Color.WHITE);
        FlowLayout fl_pnNgayDat = (FlowLayout) pnNgayDat.getLayout();
        fl_pnNgayDat.setAlignment(FlowLayout.LEFT);
        pnThongTinChung.add(pnNgayDat);

        JLabel lblNgyt = new JLabel("Ngày lập hóa đơn:");
        lblNgyt.setPreferredSize(new Dimension(200, 25));
        lblNgyt.setFont(new Font("Serif", Font.PLAIN, 15));
        pnNgayDat.add(lblNgyt);

        lblNgayLap = new JLabel();
        lblNgayLap.setFont(new Font("Serif", Font.PLAIN, 15));
        pnNgayDat.add(lblNgayLap);

        JPanel pnDSSP = new JPanel();
        pnMain2.add(pnDSSP);

        String[] cols = {"Tên sản phẩm", "Đơn giá", "Số lượng", "VAT", "Thành tiền"};
        modelDSSP = new DefaultTableModel(cols, 0);
        pnDSSP.setLayout(new BorderLayout(0, 0));
        tblDSSP = new JTable(modelDSSP);
        tblDSSP.setGridColor(Color.WHITE);
        tblDSSP.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(tblDSSP);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBackground(Color.WHITE);
        pnDSSP.add(scrollPane);

        pnFoot = new JPanel();
        pnFoot.setBackground(Color.WHITE);
        pnMain2.add(pnFoot, BorderLayout.SOUTH);

        JPanel pnTongTien = new JPanel();
        pnTongTien.setBackground(Color.WHITE);
        pnFoot.add(pnTongTien);

        JLabel lbllMaHD_6 = new JLabel("Tổng tiền");
        lbllMaHD_6.setPreferredSize(new Dimension(200, 25));
        lbllMaHD_6.setFont(new Font("Serif", Font.PLAIN, 15));
        pnTongTien.add(lbllMaHD_6);

        lblTongTien = new JLabel();
        lblTongTien.setPreferredSize(new Dimension(120, 25));
        lblTongTien.setFont(new Font("Serif", Font.PLAIN, 15));
        pnTongTien.add(lblTongTien);

        btnInHoaDon = new JButton("In hóa đơn");
        btnInHoaDon.setBackground(Color.WHITE);
        pnFoot.add(btnInHoaDon);

        btnInHoaDon.addActionListener(e -> {
            pnFoot.remove(btnInHoaDon);
            try {
				printFrame();
			} catch (PrinterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            pnFoot.add(btnInHoaDon);
            pnFoot.revalidate();
            pnFoot.repaint();
        });
        renderData();
    }

    public void renderData() {
        lblMaHD.setText(String.valueOf(hd.getMaHD()));
        lblNhanVien.setText(hd.getNhanVien().getHoTen());
        lblTenKH.setText(hd.getKhachHang().getHoTen());
        lblSDT.setText(hd.getKhachHang().getsDT());
        lblNgayLap.setText(hd.getNgayLapHD().toString());

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tongTien = hd.tongTienSauVAT();
        modelDSSP.getDataVector().removeAllElements();
        hd_DAO.getDSCT(hd.getMaHD()).forEach(cthd -> {

            String giaBan = decimalFormat.format(cthd.getGiaBan()) + " VND ";
            String thanhTien = decimalFormat.format(cthd.thanhTien()) + " VND ";
            modelDSSP.addRow(new Object[] {
                    cthd.getSanPham().getTenSP(),
                    giaBan,
                    cthd.getSoLuong(),
                    cthd.getSanPham().getVAT(),
                    thanhTien

            });
        });
        lblTongTien.setText(decimalFormat.format(tongTien) + " VND ");
    }

    private void printFrame() throws PrinterException{
    	PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        
        printerJob.setPrintable(this);
        printerJob.setPrintService(printService);
        // pop up a dialog box for the end user to fine tune the options.
        if (printerJob.printDialog()) {
            try {
                // render the component onto the printer or print queue.
                printerJob.print();
            } catch ( PrinterException e ) {
                //System.out.println( "Error printing: " + e );
            }
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if ( pageIndex > 0 ){
            return Printable.NO_SUCH_PAGE;
        }
        graphics.translate(50, 0);
        print(graphics);
        return Printable.PAGE_EXISTS;
    }

}
