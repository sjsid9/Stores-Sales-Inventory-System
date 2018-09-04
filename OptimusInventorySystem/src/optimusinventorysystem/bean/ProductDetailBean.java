/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package optimusinventorysystem.bean;

/**
 *
 * @author Rajesh
 */
public class ProductDetailBean {

    private int product_cat_ID;
    private String Name;
    private int Quantity;
    private double Price;
    private int Product_ID;

    public int getProduct_cat_ID() {
        return product_cat_ID;
    }

    public void setProduct_cat_ID(int product_cat_ID) {
        this.product_cat_ID = product_cat_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getProduct_ID() {
        return Product_ID;
    }

    public void setProduct_ID(int Product_ID) {
        this.Product_ID = Product_ID;
    }
   
}
