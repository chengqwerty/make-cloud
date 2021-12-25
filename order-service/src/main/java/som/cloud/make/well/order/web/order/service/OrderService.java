package som.cloud.make.well.order.web.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import som.cloud.make.well.order.web.data.dao.OrderDao;
import som.cloud.make.well.order.web.data.pojo.Order;

@Service
public class OrderService {

    private OrderDao orderDao;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public Order queryOrderById(Long orderId) {
        return orderDao.findById(orderId);
    }

}
