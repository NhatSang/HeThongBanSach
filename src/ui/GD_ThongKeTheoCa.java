/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import dao.TKDT_DAO;
import entity.ThongKeDoanhThu;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI DESKTOP
 */
public class GD_ThongKeTheoCa extends javax.swing.JPanel {

    /**
     * Creates new form GD_ThongKeTheoCa
     */
    public GD_ThongKeTheoCa() throws ParseException {
        initComponents();
        MyinitComponents();
        VHH();
        loadThongKeTheoCa();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableThongKeTheoCa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbNgay = new javax.swing.JLabel();
        jdcNgay = new com.toedter.calendar.JDateChooser();
        lbCaLamViec = new javax.swing.JLabel();
        txtCaLamViec = new javax.swing.JTextField();
        lbTongSanPham = new javax.swing.JLabel();
        txtTongSanPham = new javax.swing.JTextField();
        lbTongHoaDon = new javax.swing.JLabel();
        txtTongHoaDon = new javax.swing.JTextField();
        lbDoanhThu = new javax.swing.JLabel();
        txtDoanhThu = new javax.swing.JTextField();
        btnKetCa = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(960, 540));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 476));

        tableThongKeTheoCa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Sản Phẩm", "Tổng Số Lượng"
            }
        ));
        jScrollPane1.setViewportView(tableThongKeTheoCa);
        if (tableThongKeTheoCa.getColumnModel().getColumnCount() > 0) {
            tableThongKeTheoCa.getColumnModel().getColumn(0).setMinWidth(100);
            tableThongKeTheoCa.getColumnModel().getColumn(0).setPreferredWidth(5);
            tableThongKeTheoCa.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thống Kê Doanh Thu Theo Ca");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(358, 496));

        lbNgay.setText("Ngày:");

        jdcNgay.setDateFormatString("yyyy-MM-dd");

        lbCaLamViec.setText("Ca làm việc");

        lbTongSanPham.setText("Tổng sản phẩm:");

        txtTongSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongSanPhamActionPerformed(evt);
            }
        });

        lbTongHoaDon.setText("Tổng hoá đơn:");

        lbDoanhThu.setText("Doanh thu:");

        btnKetCa.setText("Kết ca");
        btnKetCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTongSanPham)
                            .addComponent(lbTongHoaDon)
                            .addComponent(lbDoanhThu)
                            .addComponent(lbCaLamViec))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDoanhThu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTongHoaDon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTongSanPham, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCaLamViec, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnKetCa)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jdcNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdcNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lbNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCaLamViec, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lbCaLamViec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTongSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lbTongSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTongHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lbTongHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnKetCa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void MyinitComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableThongKeTheoCa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbNgay = new javax.swing.JLabel();
        jdcNgay = new com.toedter.calendar.JDateChooser();
        lbCaLamViec = new javax.swing.JLabel();
        txtCaLamViec = new javax.swing.JTextField();
        lbTongSanPham = new javax.swing.JLabel();
        txtTongSanPham = new javax.swing.JTextField();
        lbTongHoaDon = new javax.swing.JLabel();
        txtTongHoaDon = new javax.swing.JTextField();
        lbDoanhThu = new javax.swing.JLabel();
        txtDoanhThu = new javax.swing.JTextField();
        btnKetCa = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(960, 540));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 476));

        modelThongKeTheoCa = new DefaultTableModel(new Object [][]{
        },
        new String []{
            "STT", "Sản Phẩm", "Tổng Số Lượng"
        });
                tableThongKeTheoCa.setModel(modelThongKeTheoCa);

        jScrollPane1.setViewportView(tableThongKeTheoCa);
        if (tableThongKeTheoCa.getColumnModel().getColumnCount() > 0) {
            tableThongKeTheoCa.getColumnModel().getColumn(0).setMinWidth(100);
            tableThongKeTheoCa.getColumnModel().getColumn(0).setPreferredWidth(5);
            tableThongKeTheoCa.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thống Kê Doanh Thu Theo Ca");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(358, 496));

        lbNgay.setText("Ngày:");

        jdcNgay.setDateFormatString("yyyy-MM-dd");

        lbCaLamViec.setText("Ca làm việc");

        lbTongSanPham.setText("Tổng sản phẩm:");

        txtTongSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongSanPhamActionPerformed(evt);
            }
        });

        lbTongHoaDon.setText("Tổng hoá đơn:");

        lbDoanhThu.setText("Doanh thu:");

        btnKetCa.setText("Kết ca");
        btnKetCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTongSanPham)
                            .addComponent(lbTongHoaDon)
                            .addComponent(lbDoanhThu)
                            .addComponent(lbCaLamViec))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDoanhThu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTongHoaDon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTongSanPham, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCaLamViec, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnKetCa)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jdcNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdcNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lbNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCaLamViec, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lbCaLamViec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTongSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lbTongSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTongHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lbTongHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnKetCa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );
    }
    private void btnKetCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetCaActionPerformed
        // TODO add your handling code here:
//        System.exit(0);
    }//GEN-LAST:event_btnKetCaActionPerformed

    private void txtTongSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongSanPhamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKetCa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcNgay;
    private javax.swing.JLabel lbCaLamViec;
    private javax.swing.JLabel lbDoanhThu;
    private javax.swing.JLabel lbNgay;
    private javax.swing.JLabel lbTongHoaDon;
    private javax.swing.JLabel lbTongSanPham;
    private javax.swing.JTable tableThongKeTheoCa;
    private javax.swing.JTextField txtCaLamViec;
    private javax.swing.JTextField txtDoanhThu;
    private javax.swing.JTextField txtTongHoaDon;
    private javax.swing.JTextField txtTongSanPham;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel modelThongKeTheoCa;
    private TKDT_DAO tkdt_dao = new TKDT_DAO();
    private int stt = 0;
    private int nam = 0;
     String today = Date.valueOf(LocalDate.now()).toString();
    private int CaHT(){
        int caLap;
        int gioHT = LocalDateTime.now().getHour();
		if (gioHT >= 8 && gioHT <= 15)
			caLap = 1;
		else
			caLap = 2;
        return caLap;
    }
    
    private void loadThongKeTheoCa() throws ParseException{
        while(tableThongKeTheoCa.getRowCount()!=0) {
			modelThongKeTheoCa.removeRow(0);
		}
        int tongsp = 0;
        int shd = 0;
        double doanhthu = 0;
        String check ="" ;
        String bnn = "";
        int checkbnn = 0;
        double vat;
        int calv = CaHT();
        TKDT_DAO tkdt = new TKDT_DAO(); 
        java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(today);
        jdcNgay.setDate(date2);
        ArrayList<ThongKeDoanhThu> dsTKDT = tkdt.ThongKeTheoCa(today,calv);
        for (ThongKeDoanhThu tk : dsTKDT){
            Object row[] = {++stt, tk.getTenSP(), tk.getTongSoLuong()};
            modelThongKeTheoCa.addRow(row);
            tongsp = tongsp + tk.getTongSoLuong();   
            ArrayList<ThongKeDoanhThu> v = tkdt.VAT(tk.getMaSP());
            for (ThongKeDoanhThu tk1 : v) {
            	System.out.println(tk1.getVat());
            	doanhthu =doanhthu + Double.valueOf(tk.getTongSoLuong())*tk.getGiaBan()+ tk.getGiaBan()*tk.getTongSoLuong()*tk1.getVat()/100;
            }
            
            if(tk.getTongSoLuong() > checkbnn){
//                bnn = tk.getTenSP();
                checkbnn = tk.getTongSoLuong();
            }
        }
        for(ThongKeDoanhThu tk : dsTKDT){
            if(checkbnn == tk.getTongSoLuong()){
               bnn = bnn + tk.getTenSP() + "\n";  
            }
        }
        ArrayList<ThongKeDoanhThu> Dem = tkdt.DemTKTheoCa(today, calv);
        for(ThongKeDoanhThu tk : Dem){
            if (!check.equals(tk.getMaHD())) {
                shd++;
                check = tk.getMaHD();
            } else {
                check = tk.getMaHD();
            }
        }
        String tongSL = String.valueOf(tongsp);
        String tongHD = String.valueOf(shd);
        String tongDoanhThu = String.valueOf(doanhthu);
        txtTongSanPham.setText(tongSL);
        txtTongHoaDon.setText(tongHD);
        txtDoanhThu.setText(tongDoanhThu);
        txtCaLamViec.setText(String.valueOf(calv));
    }
    public void VHH(){
        txtTongSanPham.setEditable(false);
        txtTongHoaDon.setEditable(false);
        txtDoanhThu.setEditable(false);
        txtCaLamViec.setEditable(false);
        jdcNgay.setEnabled(false);
    }
    
    public void KetCa(){
        
    }
}
