package DAO;

import MODEL.Product;
import UTIL.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO Products (ProductName, Category, Size, Price, SupplierID)" +
                " VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getCategory());
            stmt.setString(3, product.getSize());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getSupplierId());
            stmt.executeUpdate();

        }
    }

    public List<Product> getAllProduct() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Product product = new Product();
                product.setProductName(rs.getNString("productName"));
                product.setCategory(rs.getNString("category"));
                product.setSize(rs.getNString("size"));
                product.setPrice(rs.getDouble("price"));
                product.setSupplierId(rs.getInt("supplier"));
                products.add(product);
            }
        }
        return products;
    }

public Product getProductID(int id) throws SQLException {
    String sql = "SELECT * FROM products WHERE id=?";
    Product product = null;

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                product = new Product();
                product.setProductName(rs.getNString("productName"));
                product.setCategory(rs.getNString("category"));
                product.setSize(rs.getNString("size"));
                product.setPrice(rs.getDouble("price"));
                product.setSupplierId(rs.getInt("supplier"));

            }
        }

        return product;
    }
}
    public void updateProduct(Product product) throws SQLException {
        String sql = "INSERT INTO Products (ProductName, Category, Size, Price, SupplierID)" +
                " VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getCategory());
            stmt.setString(3, product.getSize());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getSupplierId());

            stmt.executeUpdate();
        }
    }
    public void deleteProduct(int id) throws SQLException {
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }

    }
}

