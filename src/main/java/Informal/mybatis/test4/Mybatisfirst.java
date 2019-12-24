package Informal.mybatis.test4;
import Informal.mybatis.Model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Mybatisfirst {
    private SqlSession sqlSession;
    //公用代码，后面直接调用代码可以执行
    @Before
    public void setUp() throws IOException{
        String reource = "Informal/mybatis/SqlMapconfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(reource);
        //创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=sqlSessionFactory.openSession();
    }
    @Test
    public void FindUserByIdTest(){
        User user=sqlSession.selectOne("test.FindUserById",2);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void findAllUser(){
        List<User> user=sqlSession.selectList("test.selectAll");
        System.out.println(user);
    }

    @Test
    public void insertUser(){
        User user=new User();
        Calendar calendar=Calendar.getInstance();
//        月份减少一个，才能得到想要的结果4加一得到5
        calendar.set(1997,4,29);
        Date date=calendar.getTime();
        user.setId(53);
        user.setBirthday(date);
        user.setSex("男");
//        即使设置了也是不能生效
        user.setAddress("六安");
        user.setUsername("老张");
        sqlSession.insert("test.InsertUser",user);
//        System.out.println(user);
        //需要提交事务，否则不能修改
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertSelectiveUser(){
        User user=new User();
//        user.setId(44);
        user.setUsername("选择插入3");
        user.setSex("女");
        sqlSession.insert("test.insertSelective",user);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(user.getId());
    }

    @Test
    public void replaceInsert(){
        User user=new User();
        user.setId(52);
        user.setBirthday(new Date());
        user.setUsername("代替插入4");
        user.setAddress("代替插入地址");
        sqlSession.insert("test.replaceInsert",user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteUserbyId(){
        sqlSession.delete("test.deleteUserbyId",54);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteAllUser(){
        sqlSession.delete("test.deleteAllUser");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        User user=new User();
        user.setId(10);
        user.setUsername("更新曾庆威");
        Calendar calendar=Calendar.getInstance();
        calendar.set(1994,3,26);
        Date date=calendar.getTime();
//        下面的即使没有设置birthday，也会有空值出现
//        user.setBirthday(date);
//        由于mapper文件没有传入参数sex，因此不能对sex进行修改，只能修改birthday和username
        user.setSex("男");
        sqlSession.update("test.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    //选择更新，即使空值，也不会出现空值
    public void testUpdateBySelextiveKey(){
        User user=new User();
        user.setId(2);
        user.setUsername("选择改更新");
        user.setAddress("更新地址");
        sqlSession.update("test.updateBySelectiveKey",user);
        sqlSession.commit();
        sqlSession.close();
    }

}
