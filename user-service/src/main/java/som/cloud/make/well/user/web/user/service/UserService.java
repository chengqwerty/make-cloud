package som.cloud.make.well.user.web.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import som.cloud.make.well.user.web.data.dao.UserDao;
import som.cloud.make.well.user.web.data.pojo.User;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User queryById(Long id) {
        return userDao.findById(id);
    }

}
