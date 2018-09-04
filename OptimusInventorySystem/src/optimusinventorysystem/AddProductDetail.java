/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddProductDetail.java
 *
 * Created on Jan 31, 2014, 5:42:06 PM
 */

package optimusinventorysystem;
import optimusinventorysystem.bean.DBOperations;
import java.util.ArrayList;
import optimusinventorysystem.bean.ProductDetailBean;
import optimusinventorysystem.bean.ProductMasterBean;
/**
 *
 * @author Rajesh
 */
public class AddProductDetail extends javax.swing.JInternalFrame {
    int count = 0,count1=0;
    ArrayList alstProductDetail,alstProductCategoryDetail;
    DBOperations objDB = new DBOperations();
    String AddUpdateFlag;
    /** Creates new form LoanPlanDetail */
    public AddProductDetail() {
        initComponents();
        btnSave.setEnabled(false);
        btnSave1.setEnabled(false);
        disable(false);
        alstProductDetail = objDB.getAllProductDetailList();
        alstProductCategoryDetail = objDB.getAllProductCategoryDetailList();
        if (alstProductDetail.size() > 0) {
            ProductMasterBean objBean = (ProductMasterBean) alstProductDetail.get(count);
            showUserRecord(objBean);
        }
         if (alstProductCategoryDetail.size() > 0) {
            ProductDetailBean objBean = (ProductDetailBean) alstProductCategoryDetail.get(count1);
            showUserRecord1(objBean);
        }
        
    }
    public AddProductDetail(int count) {
        initComponents();
        btnSave.setEnabled(false);
        btnSave1.setEnabled(false);
        disable(false);
        alstProductDetail = objDB.getAllProductDetailList();
        alstProductCategoryDetail = objDB.getAllProductCategoryDetailList();
        this.count = count;
        this.count1 = count;
        if (alstProductDetail.size() > 0) {
            ProductMasterBean objBean = (ProductMasterBean) alstProductDetail.get(count);
            showUserRecord(objBean);
        }
         if (alstProductCategoryDetail.size() > 0) {
            ProductDetailBean objBean = (ProductDetailBean) alstProductCategoryDetail.get(count1);
            showUserRecord1(objBean);
        }
    }

    public AddProductDetail(String operationType) {
        initComponents();
        alstProductDetail = objDB.getAllProductDetailList();
        alstProductCategoryDetail = objDB.getAllProductCategoryDetailList();
        if (operationType.equals("add")) {
            AddUpdateFlag = "add";
            disable(true);
            clear();
            btnSave.setEnabled(true);
            btnCancel.setEnabled(true);
            btnAdd.setEnabled(false);

            btnUpdate.setEnabled(false);

            btnFirst.setEnabled(false);
            btnPrevious.setEnabled(false);
            btnNext.setEnabled(false);
            btnLast.setEnabled(false);

            int maxProductID = objDB.getMaxProductId();
            txtProductID.setText(String.valueOf(maxProductID + 1));
        }
         if (operationType.equals("add")) {
            AddUpdateFlag = "add";
            disable1(true);
            clear1();
            btnSave1.setEnabled(true);
            btnCancel1.setEnabled(true);
            btnAdd1.setEnabled(false);

            btnUpdate1.setEnabled(false);

            btnFirst1.setEnabled(false);
            btnPrevious1.setEnabled(false);
            btnNext1.setEnabled(false);
            btnLast1.setEnabled(false);

            int maxProductCategoryID = objDB.getMaxProductCategoryId();
            txtProductIDCategory.setText(String.valueOf(maxProductCategoryID + 1));
        }
    }

    public void disable(boolean val) {
        txtProductID.setEditable(val);
        txtProductName.setEditable(val);
        txtProductName.setEditable(val);
//        taDescription.setEditable(val);
    }
     public void disable1(boolean val) {
        txtProductID1.setEditable(val);
        txtProductIDCategory.setEditable(val);
        txtProductCategoryName.setEditable(val);
        txtQuantity.setEditable(val);
        txtPrice.setEditable(val);
//        taDescription.setEditable(val);
    }

    public void clear() {
        txtProductID.setText("");
        txtProductName.setText("");
        txtProductName.setText("");
  //      taDescription.setText("");
    }
     public void clear1() {
        txtProductID1.setText("");
        txtProductIDCategory.setText("");
        txtProductCategoryName.setText("");
        txtQuantity.setText("");
        txtPrice.setText("");
  //      taDescription.setText("");
    }

    public void showUserRecord(ProductMasterBean objBean) {
        txtProductID.setText(String.valueOf(objBean.getProduct_ID()));
        txtProductName.setText(objBean.getProduct_type());
       /* txtProductName.setText(objBean.getName());
        txtQuantity.setText(String.valueOf(objBean.getQuantity()));
        txtPrice.setText(String.valueOf(objBean.getPrice()));
       */ 
    }
    public void showUserRecord1(ProductDetailBean objBean) {
        txtProductID1.setText(String.valueOf(objBean.getProduct_ID()));
        txtProductIDCategory.setText(String.valueOf(objBean.getProduct_cat_ID()));
        txtProductCategoryName.setText(objBean.getName());
        txtQuantity.setText(String.valueOf(objBean.getQuantity()));
        txtPrice.setText(String.valueOf(objBean.getPrice()));
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtProductID = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        jOptionPane1 = new javax.swing.JOptionPane();
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
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtProductIDCategory = new javax.swing.JTextField();
        txtProductCategoryName = new javax.swing.JTextField();
        jOptionPane2 = new javax.swing.JOptionPane();
        txtQuantity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtProductID1 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnFirst1 = new javax.swing.JButton();
        btnPrevious1 = new javax.swing.JButton();
        btnNext1 = new javax.swing.JButton();
        btnLast1 = new javax.swing.JButton();
        btnCancel1 = new javax.swing.JButton();
        btnSave1 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        btnAdd1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Add Product Detail");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Product Name");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Product ID");

        txtProductID.setEditable(false);
        txtProductID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductIDActionPerformed(evt);
            }
        });

        txtProductName.setToolTipText("Enter Plan Name...!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jOptionPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(78, 78, 78)
                .addComponent(jOptionPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel15.setBackground(new java.awt.Color(153, 153, 153));
        jLabel15.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Add Product Detail");

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
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLast, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
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
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel16.setBackground(new java.awt.Color(153, 153, 153));
        jLabel16.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Add Product Category Detail");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Quantity");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Product Category Name");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Product Category ID");

        txtProductIDCategory.setEditable(false);

        txtProductCategoryName.setToolTipText("Enter Plan Name...!");
        txtProductCategoryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductCategoryNameActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Price");

        jLabel17.setText("Sq. mtr");

        jLabel18.setText("/sq.mtr");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Product ID");

        txtProductID1.setEditable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14))
                        .addGap(127, 127, 127)
                        .addComponent(jOptionPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProductID1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductIDCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(txtProductID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtProductIDCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProductCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jOptionPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel18))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btnFirst1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/first.jpg"))); // NOI18N
        btnFirst1.setText("First");
        btnFirst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirst1ActionPerformed(evt);
            }
        });

        btnPrevious1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/prev2.jpg"))); // NOI18N
        btnPrevious1.setText("Previous");
        btnPrevious1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevious1ActionPerformed(evt);
            }
        });

        btnNext1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next.jpg"))); // NOI18N
        btnNext1.setText("Next");
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });

        btnLast1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/last.jpg"))); // NOI18N
        btnLast1.setText("Last");
        btnLast1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast1ActionPerformed(evt);
            }
        });

        btnCancel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btnCancel1.setText("Cancel");
        btnCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel1ActionPerformed(evt);
            }
        });

        btnSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ok.jpg"))); // NOI18N
        btnSave1.setText("Save");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });

        btnUpdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.jpg"))); // NOI18N
        btnUpdate1.setText("Update");
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });

        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.jpg"))); // NOI18N
        btnAdd1.setText("Add");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFirst1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUpdate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrevious1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSave1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNext1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLast1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnLast1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPrevious1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFirst1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
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

        int maxProductID = objDB.getMaxProductId();
        txtProductID.setText(String.valueOf(maxProductID + 1));
}//GEN-LAST:event_btnAddActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        if (alstProductDetail.size() > 0) {
            count = 0;
            ProductMasterBean objBean = (ProductMasterBean) alstProductDetail.get(count);
            showUserRecord(objBean);
        }
}//GEN-LAST:event_btnFirstActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        AddUpdateFlag = "update";
        disable(true);
        txtProductID.setEditable(false);
        btnSave.setEnabled(true);
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(false);

        btnFirst.setEnabled(false);
        btnPrevious.setEnabled(false);
        btnNext.setEnabled(false);
        btnLast.setEnabled(false);

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        if (count > 0) {
            count--;
            ProductMasterBean objBean = (ProductMasterBean) alstProductDetail.get(count);
            showUserRecord(objBean);
        }
}//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if (count < alstProductDetail.size() - 1) {
            count++;
            ProductMasterBean objBean = (ProductMasterBean) alstProductDetail.get(count);
            showUserRecord(objBean);

        }
}//GEN-LAST:event_btnNextActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        String result = "";
        int flag = 0;
        ProductMasterBean objBean=new ProductMasterBean();
        
        if (txtProductID.getText().equals("")) {
            jOptionPane1.showMessageDialog(this, "Product ID is missing", "ERROR", jOptionPane1.ERROR_MESSAGE);
        } else if (txtProductName.getText().equals("")) {
            jOptionPane1.showMessageDialog(this, "Product Name is missing", "ERROR",  jOptionPane1.ERROR_MESSAGE);
        } else {
            try {

                objBean.setProduct_ID(Integer.parseInt(txtProductID.getText()));
                objBean.setProduct_type(txtProductName.getText());
                if (AddUpdateFlag.equalsIgnoreCase("Add")) {
                    result = objDB.addProductDetail(objBean);
                    if (result.equals("added")) {
                        flag = 1;
                        alstProductDetail = objDB.getAllProductDetailList();
                        count = alstProductDetail.size() - 1;
                        ProductMasterBean objBean1 = (ProductMasterBean) alstProductDetail.get(count);
                        showUserRecord(objBean1);
                         jOptionPane1.showMessageDialog(null, "Record has been successfully added", "Record Added", 1);
                    } else if (result.equals("failed")) {
                         jOptionPane1.showMessageDialog(null, "Record not Added", "ERROR", 2);
                    }

                }
                if (AddUpdateFlag.equalsIgnoreCase("Update")) {
                    result = objDB.updateProductDetail(objBean);
                    if (result.equals("updated")) {
                        flag = 1;
                        alstProductDetail = objDB.getAllProductDetailList();
                        ProductMasterBean objBean1 = (ProductMasterBean) alstProductDetail.get(count);
                        showUserRecord(objBean1);
                         jOptionPane1.showMessageDialog(null, "Record has been successfully updated", "Record Updated", 1);
                    } else if (result.equals("failed")) {
                         jOptionPane1.showMessageDialog(null, "Record not Added", "ERROR", 2);
                    }

                }

            } catch (Exception e) {
                System.out.println("Exception btnSaveAction : "+e);
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

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
       dispose();
}//GEN-LAST:event_btnCancelActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        if (alstProductDetail.size() > 0) {
            count = alstProductDetail.size() - 1;
            ProductMasterBean objBean = (ProductMasterBean) alstProductDetail.get(count);
            showUserRecord(objBean);
        }
}//GEN-LAST:event_btnLastActionPerformed

    private void btnFirst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst1ActionPerformed
        // TODO add your handling code here:
        if (alstProductCategoryDetail.size() > 0) {
            count1 = 0;
            ProductDetailBean objBean = (ProductDetailBean) alstProductCategoryDetail.get(count1);
            showUserRecord1(objBean);
        }
    }//GEN-LAST:event_btnFirst1ActionPerformed

    private void btnPrevious1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevious1ActionPerformed
        // TODO add your handling code here:
         if (count1 > 0) {
            count1--;
            ProductDetailBean objBean = (ProductDetailBean) alstProductCategoryDetail.get(count1);
            showUserRecord1(objBean);
        }
    }//GEN-LAST:event_btnPrevious1ActionPerformed

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        // TODO add your handling code here:
         if (count1 < alstProductCategoryDetail.size() - 1) {
            count1++;
            ProductDetailBean objBean = (ProductDetailBean) alstProductCategoryDetail.get(count1);
            showUserRecord1(objBean);

        }
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnLast1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast1ActionPerformed
        // TODO add your handling code here:
        if (alstProductCategoryDetail.size() > 0) {
            count1 = alstProductCategoryDetail.size() - 1;
            ProductDetailBean objBean = (ProductDetailBean) alstProductCategoryDetail.get(count1);
            showUserRecord1(objBean);
        }
    }//GEN-LAST:event_btnLast1ActionPerformed

    private void btnCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel1ActionPerformed
        // TODO add your handling code here:
         dispose();
    }//GEN-LAST:event_btnCancel1ActionPerformed

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        // TODO add your handling code here:
        String result = "";
        int flag = 0;
        ProductDetailBean objBean=new ProductDetailBean();
        
        if (txtProductID1.getText().equals("")) {
            jOptionPane1.showMessageDialog(this, "Product ID is missing", "ERROR", jOptionPane1.ERROR_MESSAGE);
        }else if (txtProductIDCategory.getText().equals("")) {
            jOptionPane1.showMessageDialog(this, "Product Category ID is missing", "ERROR",  jOptionPane1.ERROR_MESSAGE);
        } else if (txtProductCategoryName.getText().equals("")) {
            jOptionPane1.showMessageDialog(this, "Product Category name is missing", "ERROR",  jOptionPane1.ERROR_MESSAGE);
        } else if (txtQuantity.getText().equals("")) {
            jOptionPane1.showMessageDialog(this, "Product Quantity is missing", "ERROR",  jOptionPane1.ERROR_MESSAGE);
        }else if (txtPrice.getText().equals("")) {
            jOptionPane1.showMessageDialog(this, "Product Price is missing", "ERROR",  jOptionPane1.ERROR_MESSAGE);
        }  else {
            try {

                objBean.setProduct_ID(Integer.parseInt(txtProductID1.getText()));
                objBean.setProduct_cat_ID(Integer.parseInt(txtProductIDCategory.getText()));
                objBean.setName(txtProductCategoryName.getText());
                objBean.setQuantity(Integer.parseInt(txtQuantity.getText()));
                objBean.setPrice(Double.parseDouble(txtPrice.getText()));
//                objBean.setDescription(taDescription.getText());
                if (AddUpdateFlag.equalsIgnoreCase("Add")) {
                    System.out.println("hereeee "+txtProductCategoryName.getText());
                    result = objDB.addProductCategoryDetail(objBean);
                    if (result.equals("added")) {
                        flag = 1;
                        alstProductCategoryDetail = objDB.getAllProductCategoryDetailList();
                        count1 = alstProductCategoryDetail.size() - 1;
                        ProductDetailBean objBean1 = (ProductDetailBean) alstProductCategoryDetail.get(count1);
                        showUserRecord1(objBean1);
                         jOptionPane1.showMessageDialog(null, "Record has been successfully added", "Record Added", 1);
                    } else if (result.equals("failed")) {
                         jOptionPane1.showMessageDialog(null, "Record not Added", "ERROR", 2);
                    }

                }
                if (AddUpdateFlag.equalsIgnoreCase("Update")) {
                    result = objDB.updateProductCategoryDetail(objBean);
                    if (result.equals("updated")) {
                        flag = 1;
                        alstProductCategoryDetail = objDB.getAllProductCategoryDetailList();
                        ProductDetailBean objBean1 = (ProductDetailBean) alstProductCategoryDetail.get(count1);
                        showUserRecord1(objBean1);
                         jOptionPane1.showMessageDialog(null, "Record has been successfully updated", "Record Updated", 1);
                    } else if (result.equals("failed")) {
                         jOptionPane1.showMessageDialog(null, "Record not Added", "ERROR", 2);
                    }

                }

            } catch (Exception e) {
                System.out.println("Exception btnSaveAction : "+e);
                //  JOptionPane.showMessageDialog(this, "Record Cannot be Added", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }






        if (flag == 1) {
            disable1(false);
            btnSave1.setEnabled(false);
            btnAdd1.setEnabled(true);
            btnUpdate1.setEnabled(true);

            btnFirst1.setEnabled(true);
            btnPrevious1.setEnabled(true);
            btnNext1.setEnabled(true);
            btnLast1.setEnabled(true);

        }
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        // TODO add your handling code here:
          AddUpdateFlag = "update";
        disable1(true);
        txtProductIDCategory.setEditable(false);
        btnSave1.setEnabled(true);
        btnAdd1.setEnabled(false);
        btnUpdate1.setEnabled(false);

        btnFirst1.setEnabled(false);
        btnPrevious1.setEnabled(false);
        btnNext1.setEnabled(false);
        btnLast1.setEnabled(false);
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:
        AddUpdateFlag = "add";
        disable1(true);
        clear1();
        btnSave1.setEnabled(true);
        btnAdd1.setEnabled(false);

        btnUpdate1.setEnabled(false);

        btnFirst1.setEnabled(false);
        btnPrevious1.setEnabled(false);
        btnNext1.setEnabled(false);
        btnLast1.setEnabled(false);

        int maxProductCategoryID = objDB.getMaxProductCategoryId();
        txtProductIDCategory.setText(String.valueOf(maxProductCategoryID + 1));
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void txtProductIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductIDActionPerformed

    private void txtProductCategoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductCategoryNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductCategoryNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancel1;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnFirst1;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLast1;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnPrevious1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JOptionPane jOptionPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductCategoryName;
    private javax.swing.JTextField txtProductID;
    private javax.swing.JTextField txtProductID1;
    private javax.swing.JTextField txtProductIDCategory;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables

}
