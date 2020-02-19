package Informal.mybatis.Model;

import java.util.Date;

public class Friend {
    private Integer id;
    private Integer userId;
    private Integer friendId;
    private String userMark;
    private String friendMark;
    private String friendPhoto;
    private String friendCompany;
    private String friendSchool;
    private String friendUserName;
    private Date agreeAddingTime;

    public String getFriendUserName() {
        return friendUserName;
    }

    public void setFriendUserName(String friendUserName) {
        this.friendUserName = friendUserName;
    }

    public String getFriendCompany() {
        return friendCompany;
    }

    public void setFriendCompany(String friendCompany) {
        this.friendCompany = friendCompany;
    }

    public String getFriendSchool() {
        return friendSchool;
    }

    public void setFriendSchool(String friendSchool) {
        this.friendSchool = friendSchool;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public String getUserMark() {
        return userMark;
    }

    public void setUserMark(String userMark) {
        this.userMark = userMark;
    }

    public String getFriendMark() {
        return friendMark;
    }

    public void setFriendMark(String friendMark) {
        this.friendMark = friendMark;
    }

    public Date getAgreeAddingTime() {
        return agreeAddingTime;
    }

    public void setAgreeAddingTime(Date agreeAddingTime) {
        this.agreeAddingTime = agreeAddingTime;
    }

    public Friend(){

    }
    public Friend(int userId,int friendId){
        this.userId = userId;
        this.friendId = friendId;
    }

    public Friend(int userId,int friendId,String friendMark){
        this.userId = userId;
        this.friendId = friendId;
        this.friendMark = friendMark;
    }

    public Friend(int userId,int friendId,String userMark,String friendMark){
        this.userId=userId;
        this.friendId=friendId;
        this.userMark=userMark;
        this.friendMark=friendMark;
    }

    public void changePosition(){
        int bridge=this.userId;
        this.userId=friendId;
        this.friendId=bridge;
    }

    public String getFriendPhoto() {
        return friendPhoto;
    }

    public void setFriendPhoto(String friendPhoto) {
        this.friendPhoto = friendPhoto;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", userId=" + userId +
                ", friendId=" + friendId +
                ", userMark='" + userMark + '\'' +
                ", friendMark='" + friendMark + '\'' +
                ", friendPhoto='" + friendPhoto + '\'' +
                ", friendCompany='" + friendCompany + '\'' +
                ", friendSchool='" + friendSchool + '\'' +
                ", friendUserName='" + friendUserName + '\'' +
                ", agreeAddingTime=" + agreeAddingTime +
                '}';
    }
}
