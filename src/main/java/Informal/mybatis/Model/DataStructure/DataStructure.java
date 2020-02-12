package Informal.mybatis.Model.DataStructure;

import Informal.mybatis.Model.Friend;
import Informal.mybatis.Model.enty.UnReadMessageList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Component
public class DataStructure {
//      对数组求交集
        public static void mixArraySort(int[] a,int[] b){
        int A=a.length,B=b.length;
        if(A>B){
            System.out.println("错误不能求值");
        }else {
            int i = 0, j = 0;
            List<Integer> list = new ArrayList<>();
            while (i < A && j < B) {
                if (a[i] < b[j]) {
                    i++;
                } else if (a[i] > b[j]) {
                    j++;
                } else {
                    list.add(a[i]);
                    i++;
                    j++;
                }

            }
            Iterator t=list.iterator();
            while(t.hasNext()){
                System.out.println(t.next());
            }
        }

    }

    public List<UnReadMessageList> createRandomInteger(List<UnReadMessageList> message, List<Friend> friendList){
            int mLength=message.size();
            int fLength=friendList.size();
            int i=0,j=0;
            if(message.size()==0){
                return null;
            }else {
                while (i < mLength && j < fLength) {
                    if (message.get(i).getFriendId() < friendList.get(j).getFriendId()) {
                        i++;
                    } else if (message.get(i).getFriendId() > friendList.get(j).getFriendId()) {
                        j++;
                    } else {
                        message.get(i).setFriendMark(friendList.get(j).getFriendMark());
                        i++;
                        j++;
                    }
                }
                for (UnReadMessageList unReadMessageList : message) {
                    System.out.println(unReadMessageList.getFriendMark());
                }
                return message;
            }
    }

}
