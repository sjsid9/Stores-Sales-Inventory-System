/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Welcome.java
 *
 * Created on Apr 4, 2014, 2:04:43 PM
 */

package optimusinventorysystem;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Rajesh
 */
public class Welcome extends javax.swing.JFrame {
    private int i;
    Welcome f;
    /** Creates new form Welcome */
    public Welcome() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
      Runnable r = new Runnable()
        {
            public void run()
            {
                jProgressBar1.setMaximum(200);
                while(true)
                {
                    jProgressBar1.setValue(i++);
                    try
                    {
                        Thread.sleep(50);
                    }
                catch(Exception e)
                {}
                if(i==200)
                {
                    i=0;
                    dispose();
                    new Login_Form(f,false).setVisible(true);
                    break;
                }
            }
        }
    };
    new Thread (r).start();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jDesktopPane1.setBackground(new java.awt.Color(0, 0, 1));

        jProgressBar1.setForeground(new java.awt.Color(51, 255, 51));
        jProgressBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jDesktopPane1.add(jProgressBar1);
        jProgressBar1.setBounds(-20, 252, 660, 10);

        jLabel5.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("OPTIMUS INVENTORY MANAGEMENT SYSTEM");
        jDesktopPane1.add(jLabel5);
        jLabel5.setBounds(140, 10, 330, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img1.jpg"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        jDesktopPane1.add(jLabel3);
        jLabel3.setBounds(150, 50, 301, 170);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

}
