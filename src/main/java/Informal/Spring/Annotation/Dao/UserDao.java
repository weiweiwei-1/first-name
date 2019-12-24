package Informal.Spring.Annotation.Dao;

import org.springframework.stereotype.Repository;

@Repository
//用于持久层的注解
public class UserDao {
    public void insert(int a){
        System.out.println("插入数据"+a);
    }
    public void delete(int a){
        System.out.println("删除数据"+a);
    }
}
