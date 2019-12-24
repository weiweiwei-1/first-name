package Informal.Spring.Annotation.Service.Impl;

import Informal.Spring.Annotation.Dao.UserDao;
import Informal.Spring.Annotation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//用于业务层的注解
public class UserServiceImpl implements UserService {
    //用autowired时，set方法可以省略，不省略也可以
    @Autowired
    UserDao userDao;
    @Override
    public void insertsomething(int a) {
        userDao.insert(a);
    }
}
