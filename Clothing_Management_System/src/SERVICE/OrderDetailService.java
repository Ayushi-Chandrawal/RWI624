package SERVICE;

import DAO.CustomerDao;
import DAO.OrderDetailsDao;
import MODEL.Customer;
import MODEL.OrderDetails;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailService {
    private OrderDetailsDao orderDetailsDao;

    public OrderDetailService() {
        orderDetailsDao = new OrderDetailsDao();
    }

    public void addOrderDetails(OrderDetails orderDetails) throws SQLException {
        orderDetailsDao.addOrderDetails(orderDetails);
    }
    public OrderDetails getOrderDetailsById(int id) throws SQLException {
        return orderDetailsDao.getOrderDetailsId(id);
    }

    public List<OrderDetails> getAllOrderDetails() throws SQLException {
        return orderDetailsDao.getAllOrderDetails();
    }

    public void updateOrderDetails(OrderDetails orderDetails) throws SQLException {
        orderDetailsDao.updateOrderDetails(orderDetails);
    }

    public void deleteOrder(int id) throws SQLException {
        orderDetailsDao.deleteOrderDetails(id);
    }
}
