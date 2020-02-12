package Informal.mybatis.Service.Impl;

import Informal.mybatis.Convert.DateTransform;
import Informal.mybatis.Convert.IntegerToString;
import Informal.mybatis.Dao.UserMapper;
import Informal.mybatis.Model.User;
import Informal.mybatis.Service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimarykeySelective(user);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int insertMap(Map<String, Object> map) {
        return userMapper.insertMap(map);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    //    @Override
    @Transactional
    public List<User> selectLike(String object) {
        List<User> user = userMapper.selectLikeParam(object);
        return user;
    }

    @Override
    public List<User> selectPhotoByList(List<Integer> list) {
        return userMapper.selectFriendPhoto(list);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public String addUser(Map<String, String> map) throws Exception {
        String id1 = map.get("id").trim();
        String sex = map.get("sex").trim();   //这两句可以自由选择，如果字符串左右两边有空格，去掉空格
        String username = map.get("username").trim();
        String birth = map.get("birthday").trim();
        String address = map.get("address").trim();
        User user = new User();
        IntegerToString integerToString = new IntegerToString();
        List<User> list = userMapper.selectAll();
        if (!integerToString.Stringforint(id1) || StringUtils.isBlank(username) || username.length() <= 1) {//先将id类型转换为String类型，如果空或者不是整数类型，返回错误页面
            return "info";
        }
        if (!sex.equals("")) {
            if (!"男".equals(sex) && !"女".equals(sex)) {//这里用到短路与，sex不等于男并且不等于女才返回错误页面，否则跳过
                return "info";
            }
        }
        if (!birth.equals("")) {
            DateTransform dateTransform = new DateTransform();
            if (!dateTransform.isDate(birth)) {
                return "info";
            } else {
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                fmt.setLenient(false);
                Date birthday = fmt.parse(birth);
                user.setBirthday(birthday);//birthday不能设置为空，因为当birthday为空时，mybatis不能执行相应的语句
            }
        }
        int id = Integer.parseInt(id1);//对id类型进行判断，如果不是Int类型，那么将返回错误界面，直到类型符合要求
        for (User usero : list) {
            if (id == usero.getId()) {
                return "info";
            }
        }
        user.setId(id);
        user.setUsername(username);
        user.setSex(sex);
        user.setAddress(address);
        userMapper.insertSelective(user);
        return "success";
    }

    @Override
    public String submitUser(Map<String, String> map, Integer id) throws Exception {
        User user = new User();
        String sex = map.get("sex").trim();   //这两句可以自由选择，如果字符串左右两边有空格，去掉空格
        String username = map.get("username").trim();
        String address = map.get("address").trim();
        String birth = map.get("birthday").trim();
//        List<User> list = userService.selectAll();
        if (StringUtils.isBlank(username) || username.length() <= 1) {//先将id类型转换为String类型，如果空或者不是整数类型，返回错误页面
            return "info";
        }
        if (!"".equals(sex)) {
            if (!"男".equals(sex) && !"女".equals(sex)) {//这里用到短路与，sex不等于男并且不等于女才返回错误页面，否则跳过
                return "info";
            }
        }
        if (!"".equals(birth)) {
            DateTransform dateTransform = new DateTransform();
            if (!dateTransform.isDate(birth)) {
                return "info";
            } else {
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                fmt.setLenient(false);
                Date birthday = fmt.parse(birth);
                user.setBirthday(birthday);//birthday不能设置为空，因为当birthday为空时，mybatis不能执行相应的语句
            }
        } else {
            user.setBirthday(null);
        }

        user.setId(id);
        user.setUsername(username);
        user.setSex(sex);
        user.setAddress(address);
        User user2 = (User) SecurityUtils.getSubject().getPrincipal();
        if (user2 == null) {
            return "login";
        }
        userMapper.updateByPrimarykeySelective(user);
        User user1 = userMapper.selectByPrimaryKey(id);
        if (user2.getId().equals(user1.getId())) {
            if (!user2.getUsername().equals(user1.getUsername())) {
                /*Subject subject=SecurityUtils.getSubject();
                Session session=subject.getSession();
                subject.logout();
                session.stop();*/
                return "relogin";
            }
            return "success";
        }
        /*if(!user1.getUsername().equals(username)){
            Subject subject=SecurityUtils.getSubject();
            Session session=subject.getSession();
            subject.logout();
            session.stop();
            return "relogin";
        }*/
        return "success";
    }

    @Override
    public User selectByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public User selectByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    @Override
    public Map<String, String> reupdate(String birthday, String sex, String address) throws Exception {
        Map<String, String> map = new HashMap<>();
        String birthdayError = "";
        String sexError = "";
        String addressError = "";
        boolean flag=true;
        String right;
        DateTransform dateTransform = new DateTransform();
        if (!dateTransform.isDate(birthday)) {
            birthdayError = "生日格式错误";     //生日格式判定
            flag=false;
        }
        if (!"男".equals(sex) && !"女".equals(sex)) {
            sexError = "性别错误";//性别选择判定
            flag=false;
        }
        if (address.length() < 4) {
            addressError = "地址长度不符合要求";  //地址选择判定
            flag=false;
        }
        if(flag){
            User user=(User)SecurityUtils.getSubject().getPrincipal();
            DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            Date date=dateFormat.parse(birthday);
            user.setBirthday(date);
            user.setAddress(address);
            user.setSex(sex);
            user.setId(user.getId());
            userMapper.updateByPrimarykeySelective(user);
            right="修改成功";
            map.put("result3",right);
        }
        map.put("result0", birthdayError);
        map.put("result1", sexError);
        map.put("result2", addressError);
        return map;
    }
}
