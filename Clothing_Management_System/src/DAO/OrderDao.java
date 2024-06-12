package DAO;

import MODEL.Customer;
import MODEL.Order;
import UTIL.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public void addOrder(Order order) throws SQLException {
        String sql = "INSERT INTO order (CustomerID, OrderDate, TotalAmount)" +
                " VALUES (?, ?, ? )";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, order.getCustomerId());
            stmt.setDate(2, order.getOrderDate());
            stmt.setDouble(3, order.getTotalAmount());

            stmt.executeUpdate();
        }
    }
    public List<Order> getAllOrder() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("id"));
                order.setCustomerId(rs.getInt("customerid"));
                order.setOrderDate(rs.getDate("date"));
                order.setTotalAmount(rs.getDouble("totalAmount"));
                orders.add(order);
            }
        }
        return orders;
        }

    public Order getOrderId(int id) throws SQLException {
        String sql = "SELECT * FROM orders WHERE id=?";
        Order order = null;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    order = new Order ();
                    order.setOrderId(rs.getInt("id"));
                    order.setCustomerId(rs.getInt("customerId"));
                    order.setOrderDate(rs.getDate("date"));
                    order.setTotalAmount(rs.getDouble("totalAmount"));
                }
            }

            return order;
        }
    }
    public void updateOrder(Order order) throws SQLException {
        String sql = "UPDATE INTO order (CustomerID, OrderDate, TotalAmount)" +
                " VALUES (?, ?, ? )";

        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, order.getCustomerId());
            stmt.setDate(2, order.getOrderDate());
            stmt.setDouble(3, order.getTotalAmount());
            stmt.executeUpdate();
        }
    }
    public void deleteOrder(int id) throws SQLException {
        String sql = "DELETE FROM orders WHERE id = ?";

        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }

    }
}
