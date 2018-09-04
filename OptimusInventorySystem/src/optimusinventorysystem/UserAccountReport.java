
package optimusinventorysystem;

import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JTable;
import optimusinventorysystem.bean.DBOperations;
import optimusinventorysystem.report.JasperReportGenerator;
import optimusinventorysystem.bean.UsermasterBean;
import java.io.InputStream;

 
public class UserAccountReport extends javax.swing.JFrame {

    DBOperations objDB;
    ArrayList alstUser;

    /** Creates new form UserAccountReport */
    public UserAccountReport() {
        initComponents();
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        objDB = new DBOperations();
        alstUser=objDB.getAllUserDetailList();
        generateTable();
        setTitle("User Account Detail Report");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    void generateTable() {


        Object data[][] = new Object[alstUser.size()][6];
        for (int i = 0; i < alstUser.size(); i++)
        {
            UsermasterBean objBean = (UsermasterBean) alstUser.get(i);
            data[i][0] = objBean.getUserId();
            data[i][1] = objBean.getUsername();
            data[i][2] = objBean.getUserType();
            data[i][3] = objBean.getUserStatus();
            data[i][4] = objBean.getSecurityQuestion();
            data[i][5] = objBean.getSecurityAnswer();

        }
        String header[] = {"User ID", "Username", "User Type", "User Status", "Security Question", "Security Answer"};
        tblUserAccount = new JTable(data, header);
        jScrollPane1.setViewportView(tblUserAccount);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUserAccount = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnPrint = new javax.swing.JMenuItem();
        btnExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblUserAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "User ID", "Username", "User Type", "User Status", "Security Question", "Security Answer"
            }
        ));
        jScrollPane1.setViewportView(tblUserAccount);

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Account Detail Report");

        jMenu1.setText("File");

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jMenu1.add(btnPrint);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jMenu1.add(btnExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        //String path = getClass().getResource("../optimusinventorysystem/report/UserAccountReport.jrxml").getPath();
         InputStream st = getClass().getResourceAsStream("/optimusinventorysystem/report/UserAccountReport.jrxml");
         JasperReportGenerator jrg=new JasperReportGenerator(st);
    }//GEN-LAST:event_btnPrintActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new UserAccountReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnExit;
    private javax.swing.JMenuItem btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUserAccount;
    // End of variables declaration//GEN-END:variables
}