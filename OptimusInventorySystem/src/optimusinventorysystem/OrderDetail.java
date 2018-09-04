/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * OrderDetail.java
 *
 * 
 */

package optimusinventorysystem;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import optimusinventorysystem.bean.DBOperations;
import java.util.ArrayList;
import javax.swing.JTable;
import optimusinventorysystem.bean.DBConnection;
import optimusinventorysystem.bean.OrderMasterBean;
import optimusinventorysystem.bean.ProductMasterBean;
import optimusinventorysystem.report.JasperReportGenerator;
/**
 *
 * @author Rajesh
 */
public class OrderDetail extends javax.swing.JInternalFrame {
   int count = 0, statusFlag = 0;
    ArrayList alstOrderFile, alstClientName, alstProductName,alstProductCatName,alstOptions;
    DBOperations objDB = new DBOperations();
    String AddUpdateFlag,strEMI;

    Double totalPrice = 0.0;
    public OrderDetail() {
        initComponents();
      btnSave.setEnabled(false);
        //btnIssue.setEnabled(false);
        disable(false);
        addComboBoxItems();
        alstOrderFile = objDB.getAllOrderFileDetailList();
        if (alstOrderFile.size() > 0) {
            OrderMasterBean objBean = (OrderMasterBean) alstOrderFile.get(count);
            showUserRecord(objBean);
            generateTable();
        }
    }
    public OrderDetail(int count) {
        initComponents();
        btnSave.setEnabled(false);
        disable(false);
        this.count = count;
        addComboBoxItems();
        alstOrderFile = objDB.getAllOrderFileDetailList();
        if (alstOrderFile.size() > 0) {
            OrderMasterBean objBean = (OrderMasterBean) alstOrderFile.get(count);
            showUserRecord(objBean);
             generateTable();
        }
    }

    public OrderDetail(String operationType) {
        initComponents();
        addComboBoxItems();
        if (operationType.equals("add")) {
            add();
            alstOrderFile = objDB.getAllOrderFileDetailList();
             if (alstOrderFile.size() > 0) {
            OrderMasterBean objBean = (OrderMasterBean) alstOrderFile.get(count);
             generateTable();
             }
        }
    }
void addComboBoxItems() {
        alstClientName = objDB.getAllClientNameList();
        if (alstClientName.size() > 0) {
            for (int i = 0; i < alstClientName.size(); i++) {
                txtClientID.addItem(alstClientName.get(i));
            }
        }

        alstProductName = objDB.getAllProductNameList();
        if (alstProductName.size() > 0) {
            for (int i = 0; i < alstProductName.size(); i++) {
                txtProductID.addItem(alstProductName.get(i));
            }
        }
       alstProductCatName = objDB.getAllProductCategoryNameList();
        if (alstProductCatName.size() > 0) {
            for (int i = 0; i < alstProductCatName.size(); i++) {
                txtProductCategoryID.addItem(alstProductCatName.get(i));
            }
        }

    }
    public void disable(boolean val) {
        txtOrderID.setEditable(val);
        txtClientID.setEditable(val);

        txtProductID.setEditable(val);

        txtProductCategoryID.setEditable(val);
        txtQuantity.setEnabled(val);
        txtPrice.setEnabled(val);
    }
public void showUserRecord(OrderMasterBean objBean) {
        txtOrderID.setText(String.valueOf(objBean.getOrder_ID()));
        txtClientID.setSelectedItem(objBean.getClientName());
        txtProductID.setSelectedItem(objBean.getProductName());
        txtProductCategoryID.setSelectedItem(objBean.getProductCategoryName());
        txtQuantity.setText(String.valueOf(objBean.getQuantity()));
        txtPrice.setText(String.valueOf(objBean.getTotal_Price()));
    }

    public void clear() {
       txtOrderID.setText("");
        txtQuantity.setText("");
        txtPrice.setText("");
    }

     public void add() {
        AddUpdateFlag = "Add";
        disable(true);
        clear();
        btnSave.setEnabled(true);
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(false);

        btnFirst.setEnabled(false);
        btnPrevious.setEnabled(false);
        btnNext.setEnabled(false);
        btnLast.setEnabled(false);
        //btnEvaluate.setEnabled(false);
        //btnIssue.setEnabled(false);
        txtOrderID.setEditable(false);
        txtOrderID.setText(String.valueOf(objDB.getMaxOrderID() + 1));
    }
public void generateTable() {

        alstOptions=new ArrayList();
       
        alstOptions=objDB.getAllOrderFileDetailList();
        Object data[][] = new Object[alstOptions.size()][7];
        for (int i = 0; i < alstOptions.size(); i++) {
            OrderMasterBean objOrderBean = (OrderMasterBean) alstOptions.get(i);
            data[i][0] = objOrderBean.getOrder_ID();
            data[i][1] = objOrderBean.getCreation_Date();
            data[i][2] = objOrderBean.getClientName();
            data[i][3] = objOrderBean.getProductName();
            data[i][4] = objOrderBean.getProductCategoryName();
            data[i][5] = objOrderBean.getQuantity();
            data[i][6] = objOrderBean.getTotal_Price();

        }

        String header[] = {"Order ID", "Order Creation Date", "Client Name","Product Name","Product Category Name","Quantity","Total Amount"};

        tblOrder= new JTable(data, header);
        jScrollPane1.setViewportView(tblOrder);

    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtOrderID = new javax.swing.JTextField();
        jOptionPane1 = new javax.swing.JOptionPane();
        txtQuantity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtProductID = new javax.swing.JComboBox();
        txtProductCategoryID = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtClientID = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Order Detail");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Quantity");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Sub Category");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Product Category");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Order ID");

        txtOrderID.setEditable(false);

        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Price");

        txtProductID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select..." }));

        txtProductCategoryID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select..." }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Client ID");

        txtClientID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select..." }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jOptionPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtProductCategoryID, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtProductID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(49, 49, 49))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(106, 106, 106)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClientID, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jOptionPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtClientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductCategoryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel15.setBackground(new java.awt.Color(153, 153, 153));
        jLabel15.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Product Order Detail");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/first.jpg"))); // NOI18N
        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/prev2.jpg"))); // NOI18N
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next.jpg"))); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/last.jpg"))); // NOI18N
        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ok.jpg"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.jpg"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.jpg"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFirst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblOrder);

        jLabel16.setBackground(new java.awt.Color(153, 153, 153));
        jLabel16.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Order History");

        jButton1.setText("Generate Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(297, 297, 297))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        AddUpdateFlag = "add";
        disable(true);
        clear();
        btnSave.setEnabled(true);
        btnAdd.setEnabled(false);

        btnUpdate.setEnabled(false);

        btnFirst.setEnabled(false);
        btnPrevious.setEnabled(false);
        btnNext.setEnabled(false);
        btnLast.setEnabled(false);

        int maxOrderID = objDB.getMaxOrderID();
        txtOrderID.setText(String.valueOf(maxOrderID + 1));
}//GEN-LAST:event_btnAddActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        if (alstOrderFile.size() > 0) {
            count = 0;
            OrderMasterBean objBean = (OrderMasterBean) alstOrderFile.get(count);
            showUserRecord(objBean);
        }
}//GEN-LAST:event_btnFirstActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
         AddUpdateFlag = "Update";
        disable(true);
        btnSave.setEnabled(true);
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(false);

        btnFirst.setEnabled(false);
        btnPrevious.setEnabled(false);
        btnNext.setEnabled(false);
        btnLast.setEnabled(false);
       // btnEvaluate1.setEnabled(false);
        txtOrderID.setEditable(false);

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
       if (count > 0) {
            count--;
            OrderMasterBean objBean = (OrderMasterBean) alstOrderFile.get(count);
            showUserRecord(objBean);
        }
}//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
       if (count < alstOrderFile.size() - 1) {
            count++;
            OrderMasterBean objBean = (OrderMasterBean) alstOrderFile.get(count);
            showUserRecord(objBean);
       }
}//GEN-LAST:event_btnNextActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

         String result = "";
        int flag = 0;
        OrderMasterBean objBean = new OrderMasterBean();

        if (txtOrderID.getText().equals("")) {
            jOptionPane1.showMessageDialog(this, "Order ID is missing", "ERROR", jOptionPane1.ERROR_MESSAGE);
        } else if (txtClientID.getSelectedItem().toString().equalsIgnoreCase("Select...")) {
            jOptionPane1.showMessageDialog(this, "Select Client", "ERROR", jOptionPane1.ERROR_MESSAGE);
        } else if (txtProductID.getSelectedItem().toString().equalsIgnoreCase("Select...")) {
            jOptionPane1.showMessageDialog(this, "Select Product", "ERROR", jOptionPane1.ERROR_MESSAGE);
        } else if (txtProductCategoryID.getSelectedItem().toString().equalsIgnoreCase("Select...")) {
            jOptionPane1.showMessageDialog(this, "Select Product Category", "ERROR", jOptionPane1.ERROR_MESSAGE);
        } else if (txtQuantity.getText().equals("")) {
            jOptionPane1.showMessageDialog(this, "Quantity is missing", "ERROR", jOptionPane1.ERROR_MESSAGE);
        } else {
            try {

                objBean.setOrder_ID(Integer.parseInt(txtOrderID.getText()));
                
                String clientId_Name[] = (txtClientID.getSelectedItem().toString()).split(". ");
                int clientId = Integer.parseInt(clientId_Name[0]);
                objBean.setClient_ID(clientId);

                String productId_Name[] = (txtProductID.getSelectedItem().toString()).split(". ");
                int productId = Integer.parseInt(productId_Name[0]);
                objBean.setProduct_ID(productId);
                
                String productCategoryId_Name[] = (txtProductCategoryID.getSelectedItem().toString()).split(". ");
                int productCategoryId = Integer.parseInt(productCategoryId_Name[0]);
                objBean.setProduct_Cat_ID(productCategoryId);
                
                objBean.setQuantity(Integer.parseInt(txtQuantity.getText()));
                objBean.setTotal_Price(Double.parseDouble(txtPrice.getText()));
                objBean.setCreation_Date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));


                if (AddUpdateFlag.equalsIgnoreCase("Add")) {
                    result = objDB.addOrderFileDetail(objBean);
                    if (result.equals("added")) {
                        flag = 1;
                        alstOrderFile = objDB.getAllOrderFileDetailList();
                        count = alstOrderFile.size() - 1;
                        OrderMasterBean objBean1 = (OrderMasterBean) alstOrderFile.get(count);
                        showUserRecord(objBean1);
                        jOptionPane1.showMessageDialog(null, "Record has been successfully added", "Record Added", 1);
                        generateTable();
                    } else if (result.equals("failed")) {
                        jOptionPane1.showMessageDialog(null, "Record not Added", "ERROR", 2);
                    }

                }
                if (AddUpdateFlag.equalsIgnoreCase("Update")) {
                    result = objDB.updateOrderFileDetail(objBean);
                    if (result.equals("updated")) {
                        flag = 1;
                        alstOrderFile = objDB.getAllOrderFileDetailList();
                        OrderMasterBean objBean1 = (OrderMasterBean) alstOrderFile.get(count);
                        showUserRecord(objBean1);
                        jOptionPane1.showMessageDialog(null, "Record has been successfully updated", "Record Updated", 1);
                         generateTable();
                    } else if (result.equals("failed")) {
                        jOptionPane1.showMessageDialog(null, "Record not Updated", "ERROR", 2);
                    }

                }

            } catch (Exception e) {
                System.out.println("Exception btnSaveAction : " + e);
                //  JOptionPane.showMessageDialog(this, "Record Cannot be Added", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (flag == 1) {
            disable(false);
            btnSave.setEnabled(false);
            btnAdd.setEnabled(true);
            btnUpdate.setEnabled(true);

            btnFirst.setEnabled(true);
            btnPrevious.setEnabled(true);
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
            //btnEvaluate1.setEnabled(true);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
       dispose();
}//GEN-LAST:event_btnCancelActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
       if (alstOrderFile.size() > 0) {
            count = alstOrderFile.size() - 1;
            OrderMasterBean objBean = (OrderMasterBean) alstOrderFile.get(count);
            showUserRecord(objBean);
        }
}//GEN-LAST:event_btnLastActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        double pr=0;
        String productCategoryId_Name[] = (txtProductCategoryID.getSelectedItem().toString()).split(". ");
                int productCategoryId = Integer.parseInt(productCategoryId_Name[0]);
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select Price from productdetails where product_cat_ID=?");
            pstmt.setInt(1, productCategoryId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
               pr= rs.getDouble("Price");
            }
            pr=pr*Integer.parseInt(txtQuantity.getText());
            txtPrice.setText(String.valueOf(pr));
        } catch (Exception e) {
            System.out.println("Exception in getting Price : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getting Price : " + e);
            }
        }
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println("here");
         InputStream st = getClass().getResourceAsStream("/optimusinventorysystem/report/BillGeneration.jrxml");
         JasperReportGenerator jrg=new JasperReportGenerator(st);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrder;
    private javax.swing.JComboBox txtClientID;
    private javax.swing.JTextField txtOrderID;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JComboBox txtProductCategoryID;
    private javax.swing.JComboBox txtProductID;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables

}
