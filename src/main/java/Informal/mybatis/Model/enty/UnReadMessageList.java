package Informal.mybatis.Model.enty;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("unReadMessageList")
public class UnReadMessageList {
    private int id;
    private int countId;
    private int senderId;
    private int receiverId;
    private String friendMark;
    private String content;
    private Date sendTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountId() {
        return countId;
    }

    public void setCountId(int countId) {
        this.countId = countId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getFriendMark() {
        return friendMark;
    }

    public void setFriendMark(String friendMark) {
        this.friendMark = friendMark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "UnReadMessageList{" +
                "id=" + id +
                ", countId=" + countId +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", friendMark='" + friendMark + '\'' +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
