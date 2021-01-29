
package javaCode;


public class ProductMemo {
    private String username;
    private String productName;
    private double productPrice;
    private double totalQuantity;
    private double totalPrice;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    @Override
    public String toString() {
        return "ProductMemo{" + "username=" + username + ", productName=" + productName + ", productPrice=" + productPrice + ", totalQuantity=" + totalQuantity + ", totalPrice=" + totalPrice + '}';
    }
    
    
    public static void main(String[] args) {
        
        int val = (int) (100000+Math.random()*85870);
        System.out.println("num : "+val);
    }
    
}
