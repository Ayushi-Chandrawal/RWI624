package DAO;

import MODEL.Order;
import MODEL.OrderDetails;
import UTIL.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsDao {
    public void addOrderDetails(OrderDetails orderDetail) throws SQLException {
        String sql = "INSERT INTO orderdetails (CustomerID, OrderDate, TotalAmount)" +
                " VALUES (?, ?, ? , ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderDetail.getOrderId());
            stmt.setInt(2, orderDetail.getProductId());
            stmt.setInt(3, orderDetail.getQuantity());
            stmt.setDouble(4, orderDetail.getPrice());

            stmt.executeUpdate();
        }


    }
    public List<OrderDetails> getAllOrderDetails() throws SQLException {
        List<OrderDetails> orderDetails = new ArrayList<>();
        String sql = "SELECT * FROM orderdetails";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                OrderDetails orderDetail = new OrderDetails();
                orderDetail.setOrderId(rs.getInt("OrderId"));
                orderDetail.setProductId(rs.getInt("productId"));
                orderDetail.setQuantity(rs.getInt("quamtity"));
                orderDetail.setPrice(rs.getDouble("price"));
                orderDetails.add(orderDetail);
            }
        }
        return orderDetails;
    }
    public OrderDetails getOrderDetailsId(int id) throws SQLException {
        String sql = "SELECT * FROM orders WHERE id=?";
        OrderDetails orderDetails = null;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    orderDetails = new OrderDetails();
                    orderDetails.setOrderId(rs.getInt("OrderId"));
                    orderDetails.setProductId(rs.getInt("productId"));
                    orderDetails.setQuantity(rs.getInt("quamtity"));
                    orderDetails.setPrice(rs.getDouble("price"));
                }
            }

            return orderDetails;
        }
    }
        public void updateOrderDetails(OrderDetails orderDetail) throws SQLException {
            String sql = "INSERT INTO orderdetails (CustomerID, OrderDate, TotalAmount)" +
                    " VALUES (?, ?, ? , ?)";

            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, orderDetail.getOrderId());
                stmt.setInt(2, orderDetail.getProductId());
                stmt.setInt(3, orderDetail.getQuantity());
                stmt.setDouble(4, orderDetail.getPrice());

                stmt.executeUpdate();
            }
        }
        public void deleteOrderDetails(int id) throws SQLException {
            String sql = "DELETE FROM orderDetails WHERE id = ?";

            try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }

        }
}
