package Informal.mybatis.test4.Mappertest;

import Informal.mybatis.Dao.OrdersMapper;
import Informal.mybatis.Model.Orders;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class OdrdersMapperTest {
    private OrdersMapper ordersMapper;
    private Orders orders;
    @Before
    public void setUp() throws Exception{
        ApplicationContext ac=new ClassPathXmlApplicationContext("Informal/mybatis/Spring-mybatis_config/Application.xml");
        ordersMapper=(OrdersMapper)ac.getBean("ordersMapper");
        orders=new Orders();
    }

    @Test
    public void testselect(){
        /*orders=ordersMapper.selectByPrimaryKey(3);
        System.out.println(orders);
        List<Orders> orders=ordersMapper.selectAll();
        for(Orders orders1:orders){
            System.out.println(orders1);
        }
        List<Orders> orders=ordersMapper.selectLike("011");
        for(Orders orders1:orders){
            System.out.println(orders1);
            }

        */
    }
    @Test
    public void othertest(){
        /*orders.setId(9);
        orders.setNumber("10004");
        orders.setCreatetime(new Date());
        orders.setUserId(10);
        orders.setNote("说明2");
        ordersMapper.insertSelective(orders);
        ordersMapper.deleteByPrimaryKey(9);
        orders.setId(3);
        orders.setNote("shuoming");
        orders.setUserId(2);
        orders.setCreatetime(new Date());
        orders.setNumber("1234567");
        ordersMapper.updateByPrimaryKey(orders);
        orders.setId(3);
        orders.setNote("选择更新操作时候");
        ordersMapper.updateByPrimaryKeySelective(orders);
        */
        List<Orders> list=ordersMapper.selectByUserId(5);
        for(Orders orders:list){
            System.out.println(orders);
        }
    }
}
