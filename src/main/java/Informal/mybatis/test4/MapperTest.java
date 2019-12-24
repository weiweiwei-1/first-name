package Informal.mybatis.test4;

import Informal.mybatis.Dao.UserMapper;
import Informal.mybatis.Model.Orders;
import Informal.mybatis.Model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.InputStream;
import java.util.*;

/*注意，持久层的参数可以包装类型，但是业务层的方法不要包装类型，不利于业务层的可扩展
mybatis的一级缓存和二级缓存，第一次查询，将数据传到一级缓存中，第二次重新执行查询操作时，
直接从缓存中读取数据，利于系统的运行，但是执行其他操作时，更新插入和删除时，为了保证下一次
查询的时候数据库是最新的，将会清空一级缓存
但是如果sqlSession close了，缓存会清空，重新查询还要加载系统资源
 对于二级缓存，跟一级差不多，但是二级缓存是多个sqlSession共享的，一级缓存只能同一个sqlSession*/
public class MapperTest {
    private UserMapper userMapper;
    private User user;
    private SqlSession sqlSession;
    private Calendar calendar;
    private Date date;
    private Orders orders;
    @Before
    public void setUp() throws Exception{
        String resource="Informal/mybatis/SqlMapconfig.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=sqlSessionFactory.openSession();
        userMapper =sqlSession.getMapper(UserMapper.class);
        user=new User();
        calendar=Calendar.getInstance();
        date=new Date();
//        ordersMapper=sqlSession.getMapper(OrdersMapper.class);
        orders=new Orders();
    }

    @Test
    public void selectByPrimaryKey(){
        user= userMapper.selectByPrimaryKey(56);
        System.out.println(user);
        User user2=userMapper.selectByPrimaryKey(56);
        System.out.println(user2);
    }
    @Test
    public void Insert(){
         user.setId(12);
         Calendar calendar=Calendar.getInstance();
         calendar.set(1996,4,29);
         Date date=calendar.getTime();
         user.setBirthday(date);
         user.setUsername("kingvi");
         user.setSex("男");
         userMapper.insert(user);
         sqlSession.commit();
         sqlSession.close();
    }

    @Test
    public void InsertSelective(){
        user.setId(63);
        /*如果加了IGNORE,将忽视username的not null,username空也能插入*/
        Calendar calendar=Calendar.getInstance();
        calendar.set(1997,1,29);
        Date date=calendar.getTime();
        user.setUsername("老张");
        user.setSex("男");
        user.setBirthday(date);
        user.setAddress("六安");
        userMapper.insertSelective(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void ReplaceInsert(){
        user.setId(56);
        calendar.set(1996,3,26);
        date=calendar.getTime();
        user.setUsername("曾晓丹");
        user.setBirthday(date);
        user.setSex("女");
        userMapper.insertReplace(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void foreachInsertMany(){
        List<User> usero=new ArrayList<User>();
        usero.add(new User(63,"曾涛",null,"男","汕尾"));
        usero.add(new User(64,"小夏",null,"女","虎门"));
        userMapper.InsertManyforeach(usero);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void DeleteByData(){
        userMapper.deleteByData(63,76);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateByPrimaryKey(){
        user.setId(12);
        user.setUsername("全部更新");
        user.setSex("n");
        user.setAddress("地址也更新，其他不空的变为空");
        userMapper.updateByPrimaryKey(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateByPrimaryKeySelective(){
        user.setId(10);
        user.setSex("");
        user.setAddress("Meizhou");
        user.setUsername("ZengqingWei");
        userMapper.updateByPrimarykeySelective(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByObject(){
//        当两个数与数据库的不同时，不能查询
        user.setAddress("更新地址");
        user.setSex("2");
//        user.setAddress("更新地址");
        user= userMapper.selectByObject(user);
        System.out.println(user);
    }

//    @Test
//    public void TypeAlias(){
//        orders=ordersMapper.SelectByPrimayrKey(3);
//        System.out.println(orders);
//    }

    @Test
    public void selectLike(){
        Map<String,String> map=new HashMap<String,String>();
        map.put("username","曾");
//        map.put("sex",);
        List<User> user=userMapper.selectLike(map);
        System.out.println(user);
    }

    @Test
    public void selectLikeObject(){
        Map<String,String> map=new HashMap<String,String>();
        map.put("username","曾");
        map.put("sex","");
        List<User> user=userMapper.selectLikeObject(map);
        for(User user1:user)
        System.out.println(user1);
    }

    @Test
    public void selectLikeParam(){
        List<User> user=userMapper.selectLikeParam("ZENG");
            for(User usero:user){
            System.out.println(usero);
        }
    }

    @Test
    public void selectTwoProperties(){
//        任何一个为空，那么查询结果为空
        user.setSex("女");
        user.setUsername("曾晓丹");
        user=userMapper.selectTwoproperties(user);
        System.out.println(user);
    }

    @Test
    public void selectForeach() {
        List<Integer> id = new ArrayList<Integer>();
        id.add(46);
        id.add(48);
        id.add(49);
        id.add(51);
        id.add(52);
        id.add(53);
        List<User> usero = userMapper.selectForeachList(id);
        System.out.println(usero);
    }
    @Test
    public void selectForeachArray(){
        String names[]={"曾庆威","曾晓丹","曾qingwe","曾xiaodan"};
        List<User> user=userMapper.selectForeachArray(names);
        for(User usero:user){
            System.out.println(usero);
        }
    }

    @Test
    public void selectForeachMap(){
        Map<String,Object> map=new HashMap<String,Object>();
        Integer []array={12,23,51,52,53,54,56,61,62};
        map.put("arrays",array);
        List<String> list=new ArrayList<String>();
        list.add("男");
        list.add("女");
        list.add("男女");
        map.put("lists",list);
        map.put("username","曾");
        List<User> user=userMapper.selectForeachMap(map);
        for(User usero:user){
            System.out.println(usero);
        }
    }
    @Test
    public void selectChoose(){
//        user.setId(56);
//        user.setUsername("曾庆威");
        List<User> usero=userMapper.selectChoose(user);
        for(User user:usero){
            System.out.println(user);
        }
    }
}
