package som.cloud.make.well.user.web.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import som.cloud.make.well.user.web.data.pojo.User;
import som.cloud.make.well.user.web.user.config.DateTimeProperties;
import som.cloud.make.well.user.web.user.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("user")
//@RefreshScope
public class UserController {

//    @Value("${user-service.date.time.formatter}")
//    public String timeFormatter;

    private DateTimeProperties dateTimeProperties;

    private UserService userService;

    @Autowired
    public void setDateTimeProperties(DateTimeProperties dateTimeProperties) {
        this.dateTimeProperties = dateTimeProperties;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    @RequestMapping("getNow")
    public String getNow() {
        return DateTimeFormatter.ofPattern(dateTimeProperties.getFormatter()).format(LocalDateTime.now());
    }

    @GetMapping("getProp")
    public DateTimeProperties getProp() {
        return dateTimeProperties;
    }
}
