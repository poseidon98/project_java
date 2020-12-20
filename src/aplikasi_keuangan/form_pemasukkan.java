/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_keuangan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import aplikasi_keuangan.koneksi;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author user
 */
public class form_pemasukkan extends javax.swing.JFrame {
private Statement stat;
private ResultSet res;
private DefaultTableModel model;
JasperReport JasRep;
JasperPrint JasPri;
Map param = new HashMap();
JasperDesign JasDes;
public String id2;

    /**
     * Creates new form form_pemasukkan
     */
    public form_pemasukkan() {
        initComponents();
        id_otomatis();
         model = new DefaultTableModel();
        tabel1.setModel(model);
        
        model.addColumn("ID Pemasukkan");
        model.addColumn("Tanggal");
        model.addColumn("Nama Pemasukkan");
        model.addColumn("Nominal");
        
        
        loadData();
    }

    public void id_otomatis(){
   
            
            try{
           
            Connection konek = koneksi.getKoneksi();
            String sql1 = "select max(right(id_kas, 5)) as id from arus_kas";
            Statement s = konek.createStatement();
            ResultSet r = s.executeQuery(sql1);
            PreparedStatement p = konek.prepareStatement(sql1);
            
            System.out.println("Dipilih");
 
            
            while(r.next()) {
                if(r.first()==false){
                    tid.setText("kas1");
                    
                } else{
                    r.last();
                    int autoid = r.getInt(1) + 1;
                    String nomor = String.valueOf(autoid);
                    int noLong = nomor.length();
                    
                    for(int a=0;a<5-noLong;a++){
                    nomor = "0" + nomor;
                }
                    
                    id2 = ("kas" + nomor);
                }
                
            }
            
            
             }
        catch(Exception e) {   
            JOptionPane.showMessageDialog(null, e);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        ttgl = new com.toedter.calendar.JDateChooser();
        tnama = new javax.swing.JTextField();
        tnominal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel1 = new javax.swing.JTable();
        tbulan = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        tcari = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        ttahun = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("id");

        jLabel2.setText("tgl");

        jLabel3.setText("nama masukkan ");

        jLabel4.setText("nominal");

        ttgl.setDateFormatString("yyyy-MM-dd");

        tnominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnominalActionPerformed(evt);
            }
        });

        jButton1.setText("add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel1);

        jButton4.setText("print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("refresh");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setText("bulan");

        jLabel6.setText("tahun");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tnominal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tbulan, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ttahun, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jButton4)))))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5)
                            .addComponent(jButton6))))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(tnominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton3)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jButton4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ttahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tnominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnominalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnominalActionPerformed
public void loadData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            Connection konek = koneksi.getKoneksi();   
            Statement s = konek.createStatement();
            
            String sql = "SELECT * FROM data_pemasukkan order by tanggal desc";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()) {
                Object[] o = new Object[8];
                o[0] = r.getString("id_pemasukkan");
                o[1] = r.getString("tanggal");
                o[2] = r.getString("nama_pemasukkan");
                o[3] = r.getString("nominal");
                
                model.addRow(o);
            }
            r.close();
            s.close();
            
        } 
        catch(SQLException e) {
            
        }
        
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int i = tabel1.getSelectedRow();
        if(i == -1) {
            return;
        }
        String id = (String) model.getValueAt(i,0);
        //String id = tid.getText();
        String nama = tnama.getText();
        String tgl = ((JTextField)ttgl.getDateEditor().getUiComponent()).getText();
        String nominal = tnominal.getText();
        
        try {
            Connection konek = koneksi.getKoneksi();
            String sql="UPDATE data_pemasukkan SET tanggal = ?, nama_pemasukkan = ?, nominal = ? WHERE id_pemasukkan = ? ";
            PreparedStatement p = konek.prepareStatement(sql);
            
            p.setString(1, tgl);
            p.setString(2, nama);
            p.setString(3, nominal);
            p.setString(4, id);
            
            
            p.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DI UBAH", "Success", JOptionPane.INFORMATION_MESSAGE);
            tid.setText(null);
            tnama.setText(null);
            tnominal.setText(null);
            ttgl.setDate(null);
        }
        catch(SQLException e) {   
            JOptionPane.showMessageDialog(null, "Data Gagal Di Ubah...", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println(e.getMessage());
        }
        finally {
            loadData();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel1MouseClicked
        // TODO add your handling code here:
         int i = tabel1.getSelectedRow();
        if(i == -1) {
            return;
        }
        
        String id = (String) model.getValueAt(i,0);
        tid.setText(id);
        
        String tgl = model.getValueAt(i,1).toString();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null;
        try{
            d1 = df.parse(tgl);
        } catch (ParseException ex){
            
        }
        
        ttgl.setDate(d1);
        
        String nama = (String) model.getValueAt(i,2);
        tnama.setText(nama);
        
         String nominal = (String) model.getValueAt(i,3);
        tnominal.setText(nominal);
        
        
    }//GEN-LAST:event_tabel1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String id = null;
        String nama = tnama.getText();
       
        String tgl = ((JTextField)ttgl.getDateEditor().getUiComponent()).getText();
        String nominal = tnominal.getText();
        
        //input data pemasukkan
        try {
            Connection konek = koneksi.getKoneksi();
            String sql = "INSERT INTO data_pemasukkan VALUES(?,?,?,?)";
            PreparedStatement p = konek.prepareStatement(sql);
            
            p.setString(1, id);
            p.setString(2, tgl);
            p.setString(3, nama);
            p.setString(4, nominal);
           
            
            p.executeUpdate();
            p.close();
            
            tid.setText(null);
            tnama.setText(null);
            ttgl.setDate(null);
            tnominal.setText(null);
            
            
        }
        catch(SQLException ex) {
            System.err.println();
        }
        finally {
            loadData();
        }
        
        //input data arus kas
        String jenis = "Pemasukkan";
        try {
            Connection konek = koneksi.getKoneksi();
            String sql = "INSERT INTO arus_kas VALUES(?,?,?,?,?)";
            PreparedStatement p = konek.prepareStatement(sql);
            
            p.setString(1, id2);
            p.setString(2, tgl);
            p.setString(3, nama);
            p.setString(4, jenis);
            p.setString(5, nominal);
           
            
            p.executeUpdate();
            p.close();
            
            tid.setText(null);
            tnama.setText(null);
            ttgl.setDate(null);
            tnominal.setText(null);
            //ttotal.setText(String.valueOf(z));
            
        }
        catch(SQLException ex) {
            System.err.println();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int i = tabel1.getSelectedRow();
        if(i == -1) {
            return;
        }
        String id = (String) model.getValueAt(i,0);
        try {
            Connection konek = koneksi.getKoneksi();
            String sql="DELETE FROM data_pemasukkan WHERE id_pemasukkan ="+"'"+id+"'"+";";
            PreparedStatement p = konek.prepareStatement(sql);
            p.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DI HAPUS", "Success", JOptionPane.ERROR_MESSAGE);
            tid.setText(null);
            tnama.setText(null);
            tnominal.setText(null);
            ttgl.setDate(null);
            
        }
        catch(SQLException e) {
            System.err.println("TERJADI ERROR");
            System.out.println(id);
        }
        finally {
            loadData();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            Connection konek = koneksi.getKoneksi();   
            Statement s = konek.createStatement();
            
            String sql = "SELECT * FROM data_pemasukkan where nama_pemasukkan like '%"+tcari.getText()+"%' order by tanggal desc ";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()) {
                
                String a = r.getString("id_pemasukkan");
                String b = r.getString("tanggal");
                String c = r.getString("nama_pemasukkan");
                String d = r.getString("nominal");
                
                String[] data={a,b,c,d};
                model.addRow(data);
            }
            r.close();
            s.close();
            
        } 
        catch(SQLException e) {
            
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String reportSource = null;
        String reportDest = null;
        
        try {
            Connection koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/data_keuangan", "root", "");
            com.mysql.jdbc.Connection c = (com.mysql.jdbc.Connection) koneksi;
            reportSource = System.getProperty("user.dir") + "/src/aplikasi_keuangan/laporan_pemasukkan.jrxml";
            reportDest = System.getProperty("user.dir") + "/src/aplikasi_keuangan/laporaran_pemasukkan.jasper";
            JasDes = JRXmlLoader.load(reportSource);
            param.put("pbulan", tbulan.getText());
            param.put("ptahun", ttahun.getText());
            JasRep = JasperCompileManager.compileReport(JasDes);
            JasPri = JasperFillManager.fillReport(JasRep, param, koneksi);
            JasperViewer.viewReport(JasPri,false);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(form_pemasukkan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_pemasukkan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_pemasukkan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_pemasukkan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_pemasukkan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel1;
    private javax.swing.JTextField tbulan;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tnominal;
    private javax.swing.JTextField ttahun;
    private com.toedter.calendar.JDateChooser ttgl;
    // End of variables declaration//GEN-END:variables
}
