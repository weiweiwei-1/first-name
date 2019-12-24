package Informal.mybatis.Model;

import java.util.Date;
import java.util.List;

public class AddUser {
    private Integer id;
    private Integer beAddId;
    private Integer addId;
    private Date addTime;
    private String addName;

    public AddUser(){}

    public AddUser(int beAddId,int addId,String addName){
        this.beAddId=beAddId;
        this.addId=addId;
        this.addName=addName;
    }

    public AddUser(int beAddId,int addId){
        this.beAddId=beAddId;
        this.addId=addId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBeAddId() {
        return beAddId;
    }

    public void setBeAddId(Integer beAddId) {
        this.beAddId = beAddId;
    }

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    @Override
    public String toString() {
        return "AddUser{" +
                "id=" + id +
                ", beAddId=" + beAddId +
                ", addId=" + addId +
                ", addTime=" + addTime +
                ", addName='" + addName + '\'' +
                '}';
    }
}
