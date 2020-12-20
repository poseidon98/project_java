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
//report
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
public class form_arus_kas extends javax.swing.JInternalFrame {
private Statement stat;
private ResultSet res;
private DefaultTableModel model;
JasperReport JasRep;
JasperPrint JasPri;
Map param = new HashMap();
JasperDesign JasDes;

    /**
     * Creates new form form_arus_kas
     */
    public form_arus_kas() {
        initComponents();
        id_otomatis();
       
        
        model = new DefaultTableModel();
        tabel.setModel(model);
        
        model.addColumn("ID Kas");
        model.addColumn("Tanggal");
        model.addColumn("Keterangan");
        model.addColumn("Jenis");
        model.addColumn("Nominal");
        
        
        loadHitung();
        loadData();
        
    }

    public void loadData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            Connection konek = koneksi.getKoneksi();   
            Statement s = konek.createStatement();
            
            String sql = "SELECT * FROM arus_kas order by tanggal desc";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()) {
                Object[] o = new Object[8];
                o[0] = r.getString("id_kas");
                o[1] = r.getString("tanggal");
                o[2] = r.getString("nama_arus");
                o[3] = r.getString("jenis");
                o[4] = r.getString("nominal");
                
                model.addRow(o);
            }
            r.close();
            s.close();
            
        } 
        catch(SQLException e) {
            
        }
        
    }
    

     private void id_otomatis(){
   
            
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
                    
                    tid.setText("kas" + nomor);
                }
                
            }
            
            
             }
        catch(Exception e) {   
            JOptionPane.showMessageDialog(null, e);
        }
        
        
}
    
    public void loadHitung() {
        int x = 0;
        int y = 0;
        int z = 0;
        try{
            Connection konek = koneksi.getKoneksi();   
            Statement s = konek.createStatement();
            String sql= "SELECT * FROM arus_kas where jenis = 'Pemasukkan'";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                Object[] o = new Object[5];
                o[0] = r.getString("nominal");
                //o[4] = r.getString("nominal");
                
                model.addRow(o);
                int total = Integer.parseInt(r.getString("nominal"));
                x = total +x;
                
            }
            r.close();
            s.close();
        }catch(SQLException e){
            
        }
        
        try{
            Connection konek = koneksi.getKoneksi();   
            Statement s = konek.createStatement();
            String sql= "SELECT * FROM arus_kas where jenis = 'Pengeluaran'";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                Object[] o = new Object[5];
                o[0] = r.getString("nominal");
                
                model.addRow(o);
                int total = Integer.parseInt(r.getString("nominal"));
                y = total + y;
            }
            r.close();
            s.close();
            z = x - y;
            ttotal.setText(String.valueOf(z));
        }catch(SQLException e){
            
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
        tabel = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        tcari = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        ttotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cjenis = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        ttahun = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tbulan = new javax.swing.JTextField();

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

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

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

        ttotal.setText("NOMINAL");

        jLabel5.setText("JUMLAH");

        jLabel7.setText("jenis");

        cjenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pemasukkan", "Pengeluaran" }));

        jButton6.setText("refresh");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setText("bulan");

        jLabel8.setText("tahun");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(82, 82, 82)
                            .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton5)
                            .addGap(18, 18, 18)
                            .addComponent(jButton6))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(75, 75, 75)
                                    .addComponent(cjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)
                                    .addComponent(tnominal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addGap(12, 12, 12)
                                    .addComponent(jButton2)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton3)))
                            .addGap(81, 81, 81)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(180, 180, 180)
                            .addComponent(jLabel6)
                            .addGap(14, 14, 14)
                            .addComponent(tbulan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jLabel8)
                            .addGap(12, 12, 12)
                            .addComponent(ttahun, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(jButton4)
                            .addGap(86, 86, 86)
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(ttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton5)
                        .addComponent(jButton6))
                    .addGap(9, 9, 9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabel2))
                                .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel3))
                                .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(11, 11, 11)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(cjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(17, 17, 17)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(jLabel4))
                                .addComponent(tnominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(79, 79, 79)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1)
                                .addComponent(jButton2)
                                .addComponent(jButton3)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(jLabel6))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(tbulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(jLabel8))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(ttahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(jButton4))
                        .addComponent(jLabel5)
                        .addComponent(ttotal))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tnominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnominalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnominalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String id = tid.getText();
        String nama = tnama.getText();
        String jenis = cjenis.getSelectedItem().toString();
        String tgl = ((JTextField)ttgl.getDateEditor().getUiComponent()).getText();
        String nominal = tnominal.getText();
        String id2 = null;

        //id otomatis

        //input data kas
        if(jenis == "Pengeluaran"){
            try {
                Connection konek = koneksi.getKoneksi();
                String sql = "INSERT INTO arus_kas VALUES(?,?,?,?,?)";
                PreparedStatement p = konek.prepareStatement(sql);

                p.setString(1, id);
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
            finally {
                loadHitung();
                loadData();
            }

            try {
                Connection konek = koneksi.getKoneksi();
                String sql = "INSERT INTO data_pengeluaran VALUES(?,?,?,?)";
                PreparedStatement p = konek.prepareStatement(sql);

                p.setString(1, id2);
                p.setString(2, tgl);
                p.setString(3, nama);
                p.setString(4, nominal);

                p.executeUpdate();
                p.close();

            }
            catch(SQLException ex) {
                System.err.println();
            }
            finally {

            }

        }
        else{

            /*try {
                Connection konek = koneksi.getKoneksi();
                String sql = "INSERT INTO arus_kas VALUES(?,?,?,?,?)";
                PreparedStatement p = konek.prepareStatement(sql);

                p.setString(1, id);
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
            finally {
                loadHitung();
                loadData();
            }*/
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int i = tabel.getSelectedRow();
        if(i == -1) {
            return;
        }
        String id = (String) model.getValueAt(i,0);
        //String id = tid.getText();
        String nama = tnama.getText();
        String jenis = cjenis.getSelectedItem().toString();
        String tgl = ((JTextField)ttgl.getDateEditor().getUiComponent()).getText();
        String nominal = tnominal.getText();

        try {
            Connection konek = koneksi.getKoneksi();
            String sql="UPDATE arus_kas SET tanggal = ?, nama_arus = ?, jenis = ?, nominal = ? WHERE id_kas = ? ";
            PreparedStatement p = konek.prepareStatement(sql);

            p.setString(1, tgl);
            p.setString(2, nama);
            p.setString(3, jenis);
            p.setString(4, nominal);

            p.setString(5, id);

            p.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DI UBAH", "Success", JOptionPane.INFORMATION_MESSAGE);
            tid.setText(null);
            tnama.setText(null);
            tnominal.setText(null);
            ttgl.setDate(null);
            //ttotal.setText(String.valueOf(z));

        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Di Ubah...", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println(e.getMessage());
        }
        finally {
            loadHitung();
            loadData();

            //ttotal.setText(String.valueOf(z));
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int i = tabel.getSelectedRow();
        if(i == -1) {
            return;
        }
        String id = (String) model.getValueAt(i,0);
        try {
            Connection konek = koneksi.getKoneksi();
            String sql="DELETE FROM arus_kas WHERE id_kas ="+"'"+id+"'"+";";
            PreparedStatement p = konek.prepareStatement(sql);
            p.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DI HAPUS", "Success", JOptionPane.ERROR_MESSAGE);
            tid.setText(null);
            tnama.setText(null);
            tnominal.setText(null);
            ttgl.setDate(null);
            //ttotal.setText(String.valueOf(z));
        }
        catch(SQLException e) {
            System.err.println("TERJADI ERROR");
            System.out.println(id);
        }
        finally {
            loadHitung();
            loadData();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        int i = tabel.getSelectedRow();
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

        String jenis = (String) model.getValueAt(i,3);
        cjenis.setSelectedItem(jenis);

        String nominal = (String) model.getValueAt(i,4);
        tnominal.setText(nominal);

    }//GEN-LAST:event_tabelMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String reportSource = null;
        String reportDest = null;

        try {
            Connection koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/data_keuangan", "root", "");
            com.mysql.jdbc.Connection c = (com.mysql.jdbc.Connection) koneksi;
            reportSource = System.getProperty("user.dir") + "/src/aplikasi_keuangan/laporan_arus_kas.jrxml";
            reportDest = System.getProperty("user.dir") + "/src/aplikasi_keuangan/laporaran_arus_kas.jasper";
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection konek = koneksi.getKoneksi();
            Statement s = konek.createStatement();

            String sql = "SELECT * FROM arus_kas where nama_arus like '%"+tcari.getText()+"%' order by tanggal desc ";
            ResultSet r = s.executeQuery(sql);

            while(r.next()) {

                String a = r.getString("id_kas");
                String b = r.getString("tanggal");
                String c = r.getString("nama_arus");
                String d = r.getString("jenis");
                String e = r.getString("nominal");

                String[] data={a,b,c,d,e};
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cjenis;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField tbulan;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tnominal;
    private javax.swing.JTextField ttahun;
    private com.toedter.calendar.JDateChooser ttgl;
    private javax.swing.JLabel ttotal;
    // End of variables declaration//GEN-END:variables
}
