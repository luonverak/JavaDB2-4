package Database;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Student extends javax.swing.JFrame {
    
    PreparedStatement ps;
    ResultSet r;
    String sql;
    
    Date date = new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MMM/YY");
   
    
    Connection connection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_java_2_4","root","");
            System.out.println("Completed.....");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Connection Error: "+e.getMessage());
            //JOptionPane.showMessageDialog(this, e);
        }
        return con;
    }
    
    public void getData(){
        DefaultTableModel model=(DefaultTableModel) table.getModel();
        sql = "SELECT * FROM `student` ORDER BY id DESC";
        try {
            ps=connection().prepareStatement(sql);
            r=ps.executeQuery();
            while(r.next()){
                Object [] objects={
                    r.getInt(1), // id
                    r.getString(2), // name
                    r.getString(3), // gender
                    r.getFloat(4),  // score
                    r.getString(5), // university
                    r.getString(6), // level
                    r.getString(7), // time
                    r.getString(8), // profile
                    r.getString(9), // create at
                    r.getString(10),// update at
                };
                model.addRow(objects);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void clearField(){
        txt_id.setText("");
        txt_name.setText("");
        txt_image.setText("");
        txt_score.setValue(0);
        bg_gender.clearSelection();
        bg_time.clearSelection();
        cb_unisity.setSelectedIndex(-1);
        cb_level.setSelectedIndex(-1);
        lb_image.setIcon(null);
    }

    
    public Student() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_gender = new javax.swing.ButtonGroup();
        bg_time = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rbfemale = new javax.swing.JRadioButton();
        rbmale = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txt_score = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        cb_level = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cb_unisity = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cb_evening = new javax.swing.JCheckBox();
        cb_morning = new javax.swing.JCheckBox();
        cb_afternoon = new javax.swing.JCheckBox();
        lb_image = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txt_image = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1287, 687));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Information");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 15, 1287, -1));

        jPanel1.setBackground(new java.awt.Color(129, 210, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 32, 28));
        jLabel2.setText("Time");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, -1, 50));

        txt_name.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        txt_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 300, 50));
        txt_name.getAccessibleContext().setAccessibleName("");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 32, 28));
        jLabel3.setText("Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 50));

        bg_gender.add(rbfemale);
        rbfemale.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        rbfemale.setForeground(new java.awt.Color(255, 32, 28));
        rbfemale.setText("Female");
        jPanel1.add(rbfemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, -1));

        bg_gender.add(rbmale);
        rbmale.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        rbmale.setForeground(new java.awt.Color(255, 32, 28));
        rbmale.setText("Male");
        jPanel1.add(rbmale, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 32, 28));
        jLabel4.setText("Gender");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 50));

        txt_score.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jPanel1.add(txt_score, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 300, 50));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 32, 28));
        jLabel5.setText("Score");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, 50));

        cb_level.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        cb_level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bachelor Degree", "Master Degree", "PH.D Degree" }));
        cb_level.setSelectedIndex(-1);
        jPanel1.add(cb_level, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 300, 50));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 32, 28));
        jLabel6.setText("University");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, 50));

        cb_unisity.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        cb_unisity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUPP", "CATD", "SETEC", "NORTON" }));
        cb_unisity.setSelectedIndex(-1);
        jPanel1.add(cb_unisity, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 300, 50));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 32, 28));
        jLabel7.setText("Level");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, -1, 50));

        bg_time.add(cb_evening);
        cb_evening.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        cb_evening.setForeground(new java.awt.Color(255, 32, 28));
        cb_evening.setText("Evening");
        jPanel1.add(cb_evening, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 250, -1, 50));

        bg_time.add(cb_morning);
        cb_morning.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        cb_morning.setForeground(new java.awt.Color(255, 32, 28));
        cb_morning.setText("Morning");
        jPanel1.add(cb_morning, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, -1, 50));

        bg_time.add(cb_afternoon);
        cb_afternoon.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        cb_afternoon.setForeground(new java.awt.Color(255, 32, 28));
        cb_afternoon.setText("Afternoon");
        jPanel1.add(cb_afternoon, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, -1, 50));

        lb_image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lb_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 100, 160, 180));

        table.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Gender", "Score", "University", "Level", "Time", "Profile", "Create At", "Update At"
            }
        ));
        table.setRowHeight(35);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setPreferredWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(7).setMinWidth(0);
            table.getColumnModel().getColumn(7).setPreferredWidth(0);
            table.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 1180, 220));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Choose Image");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 600, 180, 50));

        btn_save.setBackground(new java.awt.Color(51, 102, 255));
        btn_save.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel1.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 180, 50));

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 600, 180, 50));

        jButton4.setBackground(new java.awt.Color(255, 102, 0));
        jButton4.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Update");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 600, 180, 50));

        btnExit.setBackground(new java.awt.Color(0, 204, 102));
        btnExit.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 600, 180, 50));

        txt_image.setBackground(new java.awt.Color(129, 210, 255));
        txt_image.setFont(new java.awt.Font("Helvetica Neue", 0, 3)); // NOI18N
        txt_image.setForeground(new java.awt.Color(129, 210, 255));
        txt_image.setBorder(null);
        jPanel1.add(txt_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 240, -1, -1));

        txt_id.setBackground(new java.awt.Color(129, 210, 255));
        txt_id.setFont(new java.awt.Font("Helvetica Neue", 0, 3)); // NOI18N
        txt_id.setForeground(new java.awt.Color(129, 210, 255));
        txt_id.setToolTipText("");
        txt_id.setBorder(null);
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 690));

        setSize(new java.awt.Dimension(1287, 715));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int id = Integer.parseInt(txt_id.getText());
        String name = txt_name.getText();
        String gender=(rbmale.isSelected()==true) ? "Male" : "Female";
        float  score  = Float.parseFloat(txt_score.getValue().toString());
        String university = cb_unisity.getSelectedItem().toString();
        String level      = cb_level.getSelectedItem().toString();
        String time = (cb_morning.isSelected()==true) ? "Morning" :
                      (cb_afternoon.isSelected()==true) ? "Afternoon" : "Evening";
        String image = txt_image.getText();
        sql = "UPDATE `student` SET `name`=?,`gender`=?,`score`=?,`university`=?,`level`=?,`time`=?,`profile`=?,`update_at`=? WHERE id=?";
        try {
            ps=connection().prepareStatement(sql);
            ps = connection().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setFloat(3, score);
            ps.setString(4, university);
            ps.setString(5, level);
            ps.setString(6, time);
            ps.setString(7, image);
            ps.setString(8, sdf.format(date));
            ps.setInt(9, id);
            int i=ps.executeUpdate(); // insert data to db
            if(i>0){
                JOptionPane.showMessageDialog(this, "Data has been update");
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); // clear old data on table
                getData();
                clearField();
            }else{
                JOptionPane.showMessageDialog(this, "Error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        txt_image.setText(filename);
        Image getAbsolutePath=null;
        ImageIcon icon = new ImageIcon(filename);
        Image image = icon.getImage().getScaledInstance(lb_image.getWidth(), lb_image.getHeight(), Image.SCALE_SMOOTH);
        lb_image.setIcon(icon);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        String name = txt_name.getText();
        String gender=(rbmale.isSelected()==true) ? "Male" : "Female";
        float  score  = Float.parseFloat(txt_score.getValue().toString());
        String university = cb_unisity.getSelectedItem().toString();
        String level      = cb_level.getSelectedItem().toString();
        String time = (cb_morning.isSelected()==true) ? "Morning" :
                      (cb_afternoon.isSelected()==true) ? "Afternoon" : "Evening";
        String image = txt_image.getText();
        
        sql= "INSERT INTO `student`(`name`, `gender`, `score`, `university`, `level`, `time`, `profile`, `create_at`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            ps = connection().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setFloat(3, score);
            ps.setString(4, university);
            ps.setString(5, level);
            ps.setString(6, time);
            ps.setString(7, image);
            ps.setString(8, sdf.format(date));
            int i=ps.executeUpdate(); // insert data to db
            if(i>0){
                JOptionPane.showMessageDialog(this, "Data has been insert");
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); // clear old data on table
                getData();
                clearField();
            }else{
                JOptionPane.showMessageDialog(this, "Error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_saveActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getData();
    }//GEN-LAST:event_formWindowOpened

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int row = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        txt_id.setText(model.getValueAt(row, 0).toString());
        txt_name.setText(model.getValueAt(row, 1).toString());
        String gender=model.getValueAt(row, 2).toString();
        if(gender.equals("Male")){
            rbmale.setSelected(true);
        }else{
            rbfemale.setSelected(true);
        }
        txt_score.setValue(model.getValueAt(row, 3));
        cb_unisity.setSelectedItem(model.getValueAt(row, 4));
        cb_level.setSelectedItem(model.getValueAt(row, 5));
        String time = model.getValueAt(row, 6).toString();
        if(time.equals("Morning")){
            cb_morning.setSelected(true);
        }else if(time.equals("Afternoon")){
            cb_afternoon.setSelected(true);
        }else{
            cb_evening.setSelected(true);
        }
        txt_image.setText(model.getValueAt(row, 7).toString());
        lb_image.setIcon(new javax.swing.ImageIcon(model.getValueAt(row, 7).toString()));
    }//GEN-LAST:event_tableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int id = Integer.parseInt(txt_id.getText());
        sql = "DELETE FROM `student` WHERE id=?";
        try {
            ps=connection().prepareStatement(sql);
            ps.setInt(1, id);
            int i=ps.executeUpdate(); // insert data to db
            if(i>0){
                JOptionPane.showMessageDialog(this, "Data has been insert");
                model.setRowCount(0); // clear old data on table
                getData();
                clearField();
            }else{
                JOptionPane.showMessageDialog(this, "Error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg_gender;
    private javax.swing.ButtonGroup bg_time;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btn_save;
    private javax.swing.JCheckBox cb_afternoon;
    private javax.swing.JCheckBox cb_evening;
    private javax.swing.JComboBox<String> cb_level;
    private javax.swing.JCheckBox cb_morning;
    private javax.swing.JComboBox<String> cb_unisity;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_image;
    private javax.swing.JRadioButton rbfemale;
    private javax.swing.JRadioButton rbmale;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_image;
    private javax.swing.JTextField txt_name;
    private javax.swing.JSpinner txt_score;
    // End of variables declaration//GEN-END:variables
}
