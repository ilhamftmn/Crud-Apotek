package form;

/**
 *
 * @author HP
 */

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import koneksi.KoneksiDatabase;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;




public class frmDataObat extends javax.swing.JFrame {

    /**
     * Creates new form frmDataObat
     */
    public Statement st;
    public ResultSet rs;
    Connection cn = koneksi.KoneksiDatabase.BukaKoneksi();
   
    public frmDataObat() {
        initComponents();
        TampilData();
        
        addPlaceholderStyle(txtTanggalProduksi);
        addPlaceholderStyle(txtTanggalExpired);
        }
    
    public void addPlaceholderStyle(JTextField textField){
        Font font =  textField.getFont();
        font = font.deriveFont(Font.BOLD);
        textField.setFont(font);
        textField.setForeground(Color.gray);
    }
    public void removePlaceholderStyle(JTextField textField){
        Font font =  textField.getFont();
        font = font.deriveFont(Font.BOLD);
        textField.setFont(font);
        textField.setForeground(Color.gray);
    }
    
    private void bersih(){
        txtKodeObat.setText("");
        txtNamaObat.setText("");
        txtStokObat.setText("");
        txtTanggalProduksi.setText("");
        txtTanggalExpired.setText("");
        txtHarga.setText("");
        txtCariData.setText("");
        cmbJenisObat.setSelectedItem("");
        
        
        btnSimpan.setText("Simpan");
        txtKodeObat.setEditable(true);
    }
    
    private void CariData(){
       try {
             
            rs = st.executeQuery("SELECT * FROM data_obat WHERE " + cmbCariData.getSelectedItem().toString() 
                    + " LIKE '%" + txtCariData.getText()+ "%'");
            st = cn.createStatement();
            
            DefaultTableModel modeldatatable = new DefaultTableModel();
            modeldatatable.addColumn("No");
            modeldatatable.addColumn("Kode Obat");
            modeldatatable.addColumn("Nama Obat");
            modeldatatable.addColumn("Jenis Obat");
            modeldatatable.addColumn("Stok Obat"); 
            modeldatatable.addColumn("Tanggal Produksi"); 
            modeldatatable.addColumn("Tanggal Expired"); 
            modeldatatable.addColumn("Harga"); 
            
            int nomor = 1;
            
            
            modeldatatable.getDataVector().removeAllElements();
            modeldatatable.fireTableDataChanged();
            modeldatatable.setRowCount(0);
            
            while(rs.next()) {
                Object[] data = {
                    nomor++,
                    rs.getString("kode_obat"),
                    rs.getString("nama_obat"),
                    rs.getString("jenis_obat"),
                    rs.getString("stok_obat"),
                    rs.getString("tanggal_produksi"),
                    rs.getString("tanggal_expired"),
                    rs.getString("harga_obat") 
                }; 
                 modeldatatable.addRow(data);
                 tblData.setModel(modeldatatable);
            }
        }catch (Exception e) {     
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void TampilData(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM data_obat");
            
            DefaultTableModel model = new DefaultTableModel();
           
            model.addColumn("No");
            model.addColumn("Kode Obat");
            model.addColumn("Nama Obat");
            model.addColumn("Jenis Obat");
            model.addColumn("Stok Obat");
            model.addColumn("Tanggal Produksi");
            model.addColumn("Stok Expired");
            model.addColumn("Harga");
                     
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            int no = 1;
            while (rs.next()) {
                Object[] data = {
                    no++,
                    rs.getString("kode_obat"),
                    rs.getString("nama_obat"),
                    rs.getString("jenis_obat"),
                    rs.getString("stok_obat"),
                    rs.getString("tanggal_produksi"),
                    rs.getString("tanggal_expired"),
                    rs.getString("harga_obat")
                                
                };
               model.addRow(data);
               tblData.setModel(model); 
            }
                        
        } catch (Exception e) {
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbJenisObat = new javax.swing.JComboBox<>();
        txtKodeObat = new javax.swing.JTextField();
        txtNamaObat = new javax.swing.JTextField();
        txtStokObat = new javax.swing.JTextField();
        txtTanggalProduksi = new javax.swing.JTextField();
        txtTanggalExpired = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        cmbCariData = new javax.swing.JComboBox<>();
        txtCariData = new javax.swing.JTextField();
        btnCetak = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APOTEK SAHABAT");
        setBackground(new java.awt.Color(136, 235, 168));
        setMinimumSize(new java.awt.Dimension(785, 670));
        setPreferredSize(new java.awt.Dimension(610, 495));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA OBAT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Kode Obat");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 80, 140, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Nama Obat");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 120, 140, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Jenis Obat");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 160, 140, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Stok Obat");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 200, 140, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Tanggal Produksi");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 240, 140, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Tanggal Expired");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 280, 140, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Harga");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 320, 140, 30));

        cmbJenisObat.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbJenisObat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CAIR", "KAPSUL", "TABLET" }));
        getContentPane().add(cmbJenisObat, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, -1, 35));

        txtKodeObat.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(txtKodeObat, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 210, 35));

        txtNamaObat.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(txtNamaObat, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 210, 35));

        txtStokObat.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(txtStokObat, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 210, 35));

        txtTanggalProduksi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTanggalProduksi.setText("DD/MM/YYYY");
        txtTanggalProduksi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTanggalProduksiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTanggalProduksiFocusLost(evt);
            }
        });
        getContentPane().add(txtTanggalProduksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 210, 35));

        txtTanggalExpired.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTanggalExpired.setText("DD/MM/YYYY");
        txtTanggalExpired.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTanggalExpiredFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTanggalExpiredFocusLost(evt);
            }
        });
        getContentPane().add(txtTanggalExpired, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 210, 35));

        txtHarga.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });
        getContentPane().add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 210, 35));

        tblData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblData.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode Obat", "Nama Obat", "Jenis Obat", "Stok Obat", "Tanggal Produksi", "Tanggal Expired", "Harga"
            }
        ));
        tblData.setMinimumSize(new java.awt.Dimension(200, 80));
        tblData.setRowHeight(30);
        tblData.setRowMargin(4);
        tblData.setShowHorizontalLines(true);
        tblData.setShowVerticalLines(true);
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);
        if (tblData.getColumnModel().getColumnCount() > 0) {
            tblData.getColumnModel().getColumn(0).setMinWidth(30);
            tblData.getColumnModel().getColumn(0).setMaxWidth(30);
            tblData.getColumnModel().getColumn(1).setMaxWidth(100);
            tblData.getColumnModel().getColumn(2).setMinWidth(200);
            tblData.getColumnModel().getColumn(2).setMaxWidth(200);
            tblData.getColumnModel().getColumn(3).setMaxWidth(100);
            tblData.getColumnModel().getColumn(4).setMaxWidth(100);
            tblData.getColumnModel().getColumn(7).setMaxWidth(100);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 750, 178));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Cari Data");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 380, 140, 30));

        cmbCariData.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbCariData.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kode_obat", "nama_obat", "jenis_obat", "stok_obat", "tanggal_produksi", "tanggal_expired" }));
        getContentPane().add(cmbCariData, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 116, 35));

        txtCariData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariDataKeyPressed(evt);
            }
        });
        getContentPane().add(txtCariData, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 150, 35));

        btnCetak.setBackground(new java.awt.Color(0, 153, 255));
        btnCetak.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCetak.setText("Cetak Data");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });
        getContentPane().add(btnCetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 150, 40));

        btnSimpan.setBackground(new java.awt.Color(153, 255, 0));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 150, 40));

        btnHapus.setBackground(new java.awt.Color(255, 0, 51));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 150, 40));

        btnBatal.setBackground(new java.awt.Color(255, 204, 0));
        btnBatal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        getContentPane().add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 150, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Downloads\\istockphoto-1205354578-1024x1024.jpg")); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1060, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // TODO add your handling code here:
        txtKodeObat.setText(tblData.getValueAt(tblData.getSelectedRow(), 1).toString());
        txtNamaObat.setText(tblData.getValueAt(tblData.getSelectedRow(), 2).toString());
        cmbJenisObat.setSelectedItem(tblData.getValueAt(tblData.getSelectedRow(), 3).toString());
        txtStokObat.setText(tblData.getValueAt(tblData.getSelectedRow(), 4).toString());
        txtTanggalProduksi.setText(tblData.getValueAt(tblData.getSelectedRow(),5).toString());
        txtTanggalExpired.setText(tblData.getValueAt(tblData.getSelectedRow(), 6).toString());
        txtHarga.setText(tblData.getValueAt(tblData.getSelectedRow(), 7).toString());
        
        btnSimpan.setText("Ubah");
        txtKodeObat.setEditable(false);
    }//GEN-LAST:event_tblDataMouseClicked

    private void txtCariDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariDataKeyPressed
        // TODO add your handling code here:
       CariData();
    }//GEN-LAST:event_txtCariDataKeyPressed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        try {
            String reportPath = "src/form/report.jasper";
            Connection conn = KoneksiDatabase.BukaKoneksi();

            HashMap<String, Object> parameters = new HashMap<>();
            JasperPrint print;
            print = JasperFillManager.fillReport(reportPath, parameters, conn);
            JasperViewer  viewer = new JasperViewer(print, false);
            viewer.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        bersih();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if (txtKodeObat.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Silahkan pilih data yang ingin dihapus !!");
        } else {
            int jawab = JOptionPane.showConfirmDialog(null, "Data ini akan dihapus, lanjutkan?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (jawab == 0) {
                try {
                    st = cn.createStatement();
                    String sql = "DELETE FROM data_obat WHERE kode_obat = '" + txtKodeObat.getText() + "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                    TampilData();
                    bersih();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  e);
                }
            }
        }
        TampilData();
        bersih();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            st = cn.createStatement();
            if (txtKodeObat.getText().equals("") ||
                txtNamaObat.getText().equals("") ||
                cmbJenisObat.getSelectedItem().toString().equals("")||
                txtStokObat.getText().equals("") ||
                txtTanggalProduksi.getText().equals("")||
                txtTanggalExpired.getText().equals("") ||
                txtHarga.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            // Aksi Simpan
            if (btnSimpan.getText() == "Simpan") {
                String cek;
                cek = "SELECT * FROM data_obat WHERE kode_obat = '" + txtKodeObat.getText() + "'";
                rs = st.executeQuery(cek);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Kode Obat Sudah Ada", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    String ins;
                    ins = "INSERT INTO data_obat VALUES('" + txtKodeObat.getText() +
                    "', '" + txtNamaObat.getText() +
                    "', '" + cmbJenisObat.getSelectedItem().toString() +
                    "', '" + txtStokObat.getText() +
                    "', '" + txtTanggalProduksi.getText() +
                    "', '" + txtTanggalExpired.getText() +
                    "', '" + txtHarga.getText() + "')";
                    st.executeUpdate(ins);
                    JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan", "Pesan",JOptionPane.INFORMATION_MESSAGE);
                    bersih();
                    TampilData();
                }
            }else{
                //Aksi ubah data
                String update = "UPDATE data_obat SET nama_obat = '" + txtNamaObat.getText() +
                "', jenis_obat = '" + cmbJenisObat.getSelectedItem().toString() +
                "', stok_obat = '" + txtStokObat.getText() +
                "', tanggal_produksi = '" + txtTanggalProduksi.getText() +
                "', tanggal_expired = '" + txtTanggalExpired.getText() +
                "', harga_obat = '" + txtHarga.getText() +
                "' WHERE kode_obat = '" + txtKodeObat.getText() + "'";
                st.executeUpdate(update);
                JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
                bersih();
                TampilData();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtTanggalProduksiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTanggalProduksiFocusGained
        // TODO add your handling code here:
        if (txtTanggalProduksi.getText().equals("DD/MM/YYYY")) {
            txtTanggalProduksi.setText(null);
            txtTanggalProduksi.requestFocus();
            
            removePlaceholderStyle(txtTanggalProduksi);
        }
    }//GEN-LAST:event_txtTanggalProduksiFocusGained

    private void txtTanggalExpiredFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTanggalExpiredFocusGained
        // TODO add your handling code here:
        if (txtTanggalExpired.getText().equals("DD/MM/YYYY")) {
            txtTanggalExpired.setText(null);
            txtTanggalExpired.requestFocus();
            
            removePlaceholderStyle(txtTanggalProduksi);
        }
    }//GEN-LAST:event_txtTanggalExpiredFocusGained

    private void txtTanggalProduksiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTanggalProduksiFocusLost
        // TODO add your handling code here:
        if (txtTanggalProduksi.getText().length()==0) {
            addPlaceholderStyle(txtTanggalProduksi);
            txtTanggalProduksi.setText("DD/MM/YYYY");
        }
    }//GEN-LAST:event_txtTanggalProduksiFocusLost

    private void txtTanggalExpiredFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTanggalExpiredFocusLost
        // TODO add your handling code here:
        if (txtTanggalExpired.getText().length()==0) {
            addPlaceholderStyle(txtTanggalExpired);
            txtTanggalExpired.setText("DD/MM/YYYY");
        }
    }//GEN-LAST:event_txtTanggalExpiredFocusLost

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDataObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDataObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDataObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDataObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDataObat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbCariData;
    private javax.swing.JComboBox<String> cmbJenisObat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtCariData;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtKodeObat;
    private javax.swing.JTextField txtNamaObat;
    private javax.swing.JTextField txtStokObat;
    private javax.swing.JTextField txtTanggalExpired;
    private javax.swing.JTextField txtTanggalProduksi;
    // End of variables declaration//GEN-END:variables
}
