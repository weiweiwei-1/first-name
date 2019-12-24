package Informal.mybatis.test4.Mappertest;

import Informal.mybatis.Dao.ItemsMapper;
import Informal.mybatis.Model.Items;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class ItemsMapperTest {
    private ItemsMapper itemsMapper;
    private Items items;
    @Before
    public void setUp(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("Informal/mybatis/Spring-mybatis_config/Application.xml");
        itemsMapper=(ItemsMapper)ac.getBean("itemsMapper");
        items=new Items();
    }
    @Test
    public void testSelct(){
        /*List<Items> items=itemsMapper.selectAll();
        for(Items items1:items){
            System.out.println(items1);
        }
        items=itemsMapper.selectByPrimaryKey(1);
            System.out.println(items);
            List<Items> items=itemsMapper.selectLike("电脑");
        for(Items items1:items){
            System.out.println(items1); }
            */

    }

    @Test
    public void otherTest(){
        /*items.setId(4);
        items.setCreatetime(new Date());
        items.setName("联想电脑");
        float price=300;
        items.setPrice(price);
        itemsMapper.insertSelective(items);
        items.setId(4);
        items.setName("苹果电脑");
        float price=4000;
        items.setPrice(price);
        itemsMapper.updateByPrimaryKey(items);
        items.setId(4);
        items.setName("苹果电脑");
        float price=4000;
        items.setPrice(price);
        itemsMapper.updateByPrimaryKeySelective(items);
        itemsMapper.deleteByPrimaryKey(4);
        */


    }
}
