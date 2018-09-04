/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package optimusinventorysystem.bean;

/**
 *
 * @author Rajesh
 */
public class OrderMasterBean {

    private int order_ID;
    private String creation_Date;
    private int client_ID;
    private int Product_ID;
    private int Product_Cat_ID;
    private int Quantity;
    private double Total_Price;
    private String clientName;
    private String productName;
    private String productCategoryName;

    public int getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(int order_ID) {
        this.order_ID = order_ID;
    }

    public String getCreation_Date() {
        return creation_Date;
    }

    public void setCreation_Date(String creation_Date) {
        this.creation_Date = creation_Date;
    }

    public int getClient_ID() {
        return client_ID;
    }

    public void setClient_ID(int client_ID) {
        this.client_ID = client_ID;
    }

    public int getProduct_ID() {
        return Product_ID;
    }

    public void setProduct_ID(int Product_ID) {
        this.Product_ID = Product_ID;
    }

    public int getProduct_Cat_ID() {
        return Product_Cat_ID;
    }

    public void setProduct_Cat_ID(int Product_Cat_ID) {
        this.Product_Cat_ID = Product_Cat_ID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getTotal_Price() {
        return Total_Price;
    }

    public void setTotal_Price(double Total_Price) {
        this.Total_Price = Total_Price;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }
   
}
