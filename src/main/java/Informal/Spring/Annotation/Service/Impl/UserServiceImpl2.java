package Informal.Spring.Annotation.Service.Impl;

import Informal.Spring.Annotation.Dao.UserDao;
import Informal.Spring.Annotation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl2 implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public void insertsomething(int a) {
System.out.println("删除数据"+a);
    }
}
