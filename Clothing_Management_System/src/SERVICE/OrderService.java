package SERVICE;

import DAO.OrderDao;
import MODEL.Order;
import MODEL.OrderDetails;

import java.sql.SQLException;
import java.util.List;

public class OrderService {
    private OrderDao orderDao;

    public OrderService() {
        orderDao = new OrderDao();
    }

    public void addOrder(Order order) throws SQLException {
        orderDao.addOrder(order);
    }

    public Order getOrderById(int id) throws SQLException {
        return orderDao.getOrderId(id);
    }

    public List<Order> getAllOrder() throws SQLException {
        return orderDao.getAllOrder();
    }

    public void updateOrder(Order order) throws SQLException {
        orderDao.updateOrder(order);
    }

    public void deleteOrder(int id) throws SQLException {
        orderDao.deleteOrder(id);
    }
}
