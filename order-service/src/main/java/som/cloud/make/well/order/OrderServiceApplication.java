package som.cloud.make.well.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import som.cloud.make.well.user.feign.client.UserServiceFeign;

@EnableFeignClients(clients = {UserServiceFeign.class})
@SpringBootApplication
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
