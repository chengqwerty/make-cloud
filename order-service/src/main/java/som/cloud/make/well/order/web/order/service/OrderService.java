package som.cloud.make.well.order.web.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import som.cloud.make.well.order.web.data.dao.OrderDao;
import som.cloud.make.well.order.web.data.pojo.Order;
import som.cloud.make.well.order.web.data.pojo.User;

@Service
public class OrderService {

    private OrderDao orderDao;
    private RestTemplate restTemplate;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Order queryOrderById(Long orderId) {
        Order order = orderDao.findById(orderId);
        String url = "http://user-service/user/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);
        return order;
    }

}
