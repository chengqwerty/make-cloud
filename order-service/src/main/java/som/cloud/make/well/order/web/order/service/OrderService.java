package som.cloud.make.well.order.web.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import som.cloud.make.well.order.web.data.dao.OrderDao;
import som.cloud.make.well.order.web.data.pojo.Order;
import som.cloud.make.well.user.feign.client.UserServiceFeign;

@Service
public class OrderService {

    private OrderDao orderDao;
    private RestTemplate restTemplate;

    private UserServiceFeign userServiceFeign;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setUserServiceFeign(UserServiceFeign userServiceFeign) {
        this.userServiceFeign = userServiceFeign;
    }

    public Order queryOrderById(Long orderId) {
        Order order = orderDao.findById(orderId);
        order.setUser(userServiceFeign.findById(order.getUserId()));
        return order;
    }

}
