package som.cloud.make.well.user.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import som.cloud.make.well.user.feign.pojo.User;

@FeignClient("user-service")
public interface UserServiceFeign {

    @GetMapping("user/{id}")
    User findById(@PathVariable("id") Long id);

}
