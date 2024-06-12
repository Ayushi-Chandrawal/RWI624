package SERVICE;

import DAO.ProductDao;
import MODEL.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductDao productDao;

    public ProductService() {
        productDao = new ProductDao();
    }

    public void addProduct(Product product) throws SQLException {
        productDao.addProduct(product);
    }

    public Product getProductById(int id) throws SQLException {
        return productDao.getProductID(id);
    }

    public List<Product> getAllProduct() throws SQLException {
        return productDao.getAllProduct();
    }

    public void updateProduct(Product product) throws SQLException {
        productDao.addProduct(product);
    }

    public void deleteProduct(int id) throws SQLException {
        productDao.deleteProduct(id);
    }
}
