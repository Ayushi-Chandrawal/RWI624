package MODEL;

public class Product {


    private int productId;
    private String productName;
    private String category;
    private String size;
    private double price;
    private int supplierId;

    public Product(int productId, String productName, String category, String size, double price, int supplierId) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.size = size;
        this.price = price;
        this.supplierId = supplierId;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", supplierId=" + supplierId +
                '}';
    }
}
