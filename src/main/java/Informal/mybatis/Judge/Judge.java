package Informal.mybatis.Judge;

import Informal.mybatis.Model.AddUser;
import Informal.mybatis.Model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//注意:由于对象user和user1不同，因此比较属性时候，由于地址不同，因此用==会出错，但是用equals不会出错
public class Judge {
    public boolean isContain(User user,List<User> user1){
        for(User user2:user1){
            if(user.getId().equals(user2.getId())&&user.getUsername().equals(user2.getUsername())){
                return true;
            }
        }
        return false;
    }

    public boolean addUserIdContain(int id,List<AddUser> lists){
        for(AddUser list:lists){
            if(id==list.getId()){
                return true;
            }
        }
        return false;
    }

    public boolean addUserAddIdContain(int addId,List<AddUser> lists){
        for(AddUser addUser:lists){
            if(addUser.getAddId()==addId){
                return true;
            }
        }
        return false;
    }
}
